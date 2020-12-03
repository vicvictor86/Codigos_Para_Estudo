package com.oDOGB.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import com.oDOGB.graficos.Spritesheet;
import com.oDOGB.main.Game;
import com.oDOGB.world.Camera;
import com.oDOGB.world.World;

public class Player extends Entity{
	
	public boolean right,up,left,down;
	public int right_dir = 0, left_dir = 1;
	public int dir = right_dir;
	
	public double speed = 1;
	private int frames = 0, maxFrames = 10, index = 0, maxIndex = 3;
	private boolean moved = false;
	
	private BufferedImage[] rightPlayer;
	private BufferedImage[] leftPlayer;
	private BufferedImage playerDamage_LEFT;
	private BufferedImage playerDamage_RIGHT;
	
	public static int ammo = 0;
	public double life = 100,maxlife = 100;
	public boolean isDamage = false;

	public boolean hasGun = false;
	public boolean shoot = false, mouseShoot = false;
	public int mx,my;
	
	private int damageFrames = 0;

	public Player(int x, int y, int width, int height, BufferedImage sprite) 
	{
		super(x, y, width, height, sprite);
		//Anima��o do personagem
		rightPlayer = new BufferedImage[4];
		leftPlayer = new BufferedImage[4];
		playerDamage_RIGHT = Game.spritesheet.getSprite(0, 16, 16, 16);
		playerDamage_LEFT = Game.spritesheet.getSprite(16, 16, 16, 16);
		
		for(int i = 0; i < 4; i++) 
		{
			rightPlayer[i] = Game.spritesheet.getSprite(32 + (i * 16), 0, 16, 16);
		}
		for(int i = 0; i < 4; i++) 
		{
			leftPlayer[i] = Game.spritesheet.getSprite(32 + (i * 16), 16, 16, 16);
		}
		
	}
	
	public void tick() 
	{
		//Ir� gerar a movimenta��o do personagem
		//A vari�vel right � definida na classe Game
		moved = false;
		if(right && World.isFree((int)(x + speed),this.getY())) 
		{
			moved = true;
			dir = right_dir;
			x += speed;
		}
		else if (left && World.isFree((int)(x - speed),this.getY())) 
		{
			moved = true;
			dir = left_dir;
			x -= speed;
		}
		if(up && World.isFree(this.getX(),(int)(y - speed))) 
		{
			moved = true;
			y -= speed;
		}
		else if(down && World.isFree(this.getX(),(int) (y + speed))) 
		{
			moved = true;
			y += speed;
		}
		//mudan�a do frame da anima��o 
		if(moved) 
		{
			frames++;
			if(frames == maxFrames) 
			{
				frames = 0;
				index++;
				if(index > maxIndex)
					index = 0;
			}
		}
		
		checkCollisionLifePack();
	    checkCollisionAmmo();
	    checkCollisionGun();
	    
	    if(shoot && hasGun && ammo > 0)
	    {
	    	ammo--;
	    	int dx = 0;
	    	int px = 0;
	    	int py = 5;
	    	//Criar bala e atirar
	    	shoot = false;
	    	if(dir == right_dir)
	    	{
	    		px = 20;
	    		dx = 1;
	    	}
	    	else 
	    	{
	    		px = -8;
	    		dx = -1;
	    	}
	    	//Local onde se altera tudo acerca das balas
	    	BulletShoot bullet = new BulletShoot(this.getX() + px, this.getY() + py, 3, 3, null, dx, 0); 
	    	Game.bullet.add(bullet);	    	
	    	//System.out.println("atirando");
	    }
	    
	    //Verifica se o tiro foi dado pelo mouse
	    if(mouseShoot)
	    {
	    	mouseShoot = false;
	    	if(hasGun && ammo > 0)
	    	{
		    	ammo--;
		    	//px e py s�o os offsets para que as coordenadas em que a bala seja criada der a ilus�o
		    	//de que o tiro est� saindo da arma
		    	int px = 0, py = 5;
		    	double angle = 0;
		    	//Offsets para que o tiro saia na coordenada do cano da arma
		    	if(dir == right_dir)
		    	{
		    		px = 20;
		    		//calculo do angulo que o mouse est� em rela��o a arma
		    		//direita
		    	    angle = Math.atan2(my - (this.getY() + py - Camera.y), mx - (this.getX() + px - Camera.x));
		    	}
		    	else 
		    	{
		    		//calculo do angulo que o mouse est� em rela��o a arma
		    		//esquerda
		    		px = -8;
		    		angle = Math.atan2(my - (this.getY() + py - Camera.y), mx - (this.getX() + px - Camera.x));
		    	}
		    	double dx = Math.cos(angle);
		    	double dy = Math.sin(angle) ;
		    	//Criar bala e atirar
		    	//Local onde se altera tudo acerca das balas e como elas surgem
		    	BulletShoot bullet = new BulletShoot(this.getX() + px, this.getY() + py, 3, 3, null, dx, dy); 
		    	Game.bullet.add(bullet);
	    	}
	    	
	    }
	    
	    //controla a anima��o do piscar do personagem
	    if(isDamage)
	    {
	    	this.damageFrames++;
	    	if(this.damageFrames == 8)
	    	{
	    		this.damageFrames = 0;
	    		isDamage = false;
	    	}
	    }
	    
	    //Morte do Player
	    if(life <= 0)
	    {
	    	//Game Over
	    	life = 0;
	    	Game.gameState = "GAME_OVER";
	    }
		
		//Evita que apare�a o fundo preto na tela
		Camera.x = Camera.clamp(this.getX() - (Game.WIDTH / 2), 0, World.WIDTH *16 - Game.WIDTH);
		Camera.y = Camera.clamp(this.getY() - (Game.HEIGHT / 2),0, World.HEIGHT *16 - Game.HEIGHT);
		
	}
	
	//fun��o que ir� coletar a muni��o
	public void checkCollisionAmmo()
	{
		for(int i = 0; i < Game.entities.size(); i++)
		{
			Entity atual = Game.entities.get(i);
			if(atual instanceof Bullet)
			{
				if(Entity.isColliding(this, atual))
				{
					ammo+= 5;
					Game.entities.remove(atual);
					//System.out.println("Ammo: " + ammo);
				}
			}
		}
	}
	
	//fun��o que ir� coletar a arma
	public void checkCollisionGun()
	{
		for(int i = 0; i < Game.entities.size(); i++)
		{
			Entity atual = Game.entities.get(i);
			if(atual instanceof Weapon)
			{
				if(Entity.isColliding(this, atual))
				{
					hasGun = true; 
					//System.out.println("Pegou a arma");
					Game.entities.remove(atual);
					
				}
			}
		}
	}
	
	//fun��o que ir� coletar o lifepack
	public void checkCollisionLifePack() 
	{
		//dps tentar fazer uma lista apenas para os packs de life
		for(int i = 0; i < Game.entities.size(); i++)
		{
			Entity atual = Game.entities.get(i);
			if(atual instanceof LifePack)
			{
				if(Entity.isColliding(this, atual))
				{
					life += 25;
					Game.entities.remove(atual);
					if(life >= 100)
					{
						life = 100;
					}
					
				}
			}
		}
	}
	
	
	public void render(Graphics g) 
	{	
		if(!isDamage) 
		{
			//Controla a anima��o do personagem para o lado direito
			if(dir == right_dir)
			{	
				//renderiza a anima��o do jogador
				g.drawImage(rightPlayer[index], this.getX() - Camera.x, this.getY() - Camera.y, null);
				//Testa se o jogador esta com a arma
				if(hasGun)
				{
					//Desenhar arma para esquerda
					g.drawImage(Entity.GUN_RIGHT, this.getX() + 9 - Camera.x, this.getY() - Camera.y, null);
				}
			}
			//Controla a anima��o do personagem para o lado esquerdo
			else if(dir == left_dir)
			{
		
				g.drawImage(leftPlayer[index], this.getX() - Camera.x, this.getY() - Camera.y, null);
				if(hasGun)
				{
					//Desenhar arma para esquerda
					g.drawImage(Entity.GUN_LEFT, this.getX() - 9 - Camera.x, this.getY() - Camera.y, null);
				}
			}
		}
		else 
		{	
			//ir� renderizar a anima��o do personagem piscando para a esquerda
			if(dir == left_dir) 
			{
				g.drawImage(playerDamage_LEFT, this.getX() - Camera.x, this.getY() - Camera.y, null);
			}
			//ir� renderizar a anima��o do personagem piscando para a direita
			else if(dir == right_dir) 
			{
				g.drawImage(playerDamage_RIGHT, this.getX() - Camera.x, this.getY() - Camera.y, null);
			}
			//ir� renderizar a imagem da arma na m�o do personagem para a esquerda
			if(dir ==  left_dir && hasGun == true) 
			{
				g.drawImage(GUNFEED_LEFT, this.getX() - 9 - Camera.x, this.getY() - Camera.y, null);
			}
			//ir� renderizar a imagem da arma na m�o do personagem para a direita
			else if(dir == right_dir && hasGun == true) 
			{
				g.drawImage(GUNFEED_RIGHT, this.getX() + 9 - Camera.x, this.getY() - Camera.y, null);
			}
			
		}
	}	

}
