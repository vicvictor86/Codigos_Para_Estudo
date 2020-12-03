package com.oDOGB.entities;


import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.oDOGB.main.Game;
import com.oDOGB.main.Sound;
import com.oDOGB.world.Camera;
import com.oDOGB.world.World;

public class Enemy extends Entity {

	private double speed = 0.6; 
	private int frames = 0, maxFrames = 10, index = 0, maxIndex = 1;
	private BufferedImage[] sprites;
	
	private int life = 10;
	private boolean isDamaged = false;
	private int damageFrames = 10, damageCurrent = 0;
	
	public Enemy(int x, int y, int width, int height, BufferedImage sprite) 
	{
		super(x, y, width, height, null);
		sprites = new BufferedImage[2];
		sprites[0] = Game.spritesheet.getSprite(112, 16, 16, 16);
		sprites[1] = Game.spritesheet.getSprite(112 + 16, 16, 16, 16);
	}

	public void tick()
	{
		
		if(isCollidingWithPlayer() == false) 
		{
			if((int)x < Game.player.getX() && World.isFree((int)(x+speed), this.getY()) && !isColliding((int)(x+speed), this.getY())) 
			{
				x += speed;
			}
			else if((int)x > Game.player.getX() && World.isFree((int)(x-speed), this.getY()) && !isColliding((int)(x-speed), this.getY()))
			{
				x -= speed;
			}
			
			if((int)y < Game.player.getY() && World.isFree(this.getX(), (int)(y+speed)) && !isColliding(this.getX(), (int)(y+speed))) 
			{
				y += speed;
			}
			else if((int)y > Game.player.getY() && World.isFree(this.getX(), (int)(y-speed)) && !isColliding(this.getX(), (int)(y-speed)))
			{
				y -= speed;
			}
		}
		else 
		{
			if(Game.rand.nextInt(100) < 10)
			{
				Sound.hurtEffect.play();
				Game.player.life--; 
				Game.player.isDamage = true;
				//System.out.println("Vida: " + Game.player.life);
			}
			
			
		}
			frames++;
			if(frames == maxFrames) 
			{
				frames = 0;
				index++;
				if(index > maxIndex)
					index = 0;
				}
			
			collidingBullet();
			
			if(life <= 0)
			{
				destroySelf();
				return;
			}
			
			if(isDamaged)
			{
				this.damageCurrent++;
				if(damageCurrent == damageFrames)
				{
					damageCurrent = 0;
					isDamaged = false;
				}
			}
			
			
	}
	
	public void destroySelf()
	{
		Game.enemies.remove(this);
		Game.entities.remove(this);
	}
	
	public void collidingBullet()
	{
		for(int i = 0; i < Game.bullet.size(); i++)
		{
			Entity e = Game.bullet.get(i);
			if(e instanceof BulletShoot)
			{
				if(Entity.isColliding(this, e))
				{
					isDamaged = true;
					life--;
					Sound.hurtEffect.play();
					Game.bullet.remove(i);
					return;
				}
			}
		}
		
	}
	
	
	public boolean isCollidingWithPlayer()
	{
		Rectangle enemyCurrent = new Rectangle(this.getX(),this.getY(),World.TILE_SIZE,World.TILE_SIZE);
		Rectangle player = new Rectangle(Game.player.getX(), Game.player.getY(),16,16);
		
		return enemyCurrent.intersects(player);
	}
	
	
	
	
	public boolean isColliding(int xnext,int ynext) 
	{
		Rectangle enemyCurrent = new Rectangle(xnext,ynext,World.TILE_SIZE,World.TILE_SIZE);
		for(int i = 0; i < Game.enemies.size(); i++)
		{
			Enemy e = Game.enemies.get(i);
			if(e == this)
				continue;
			Rectangle targetEnemy = new Rectangle(e.getX(),e.getY(),World.TILE_SIZE,World.TILE_SIZE);
			if(enemyCurrent.intersects(targetEnemy))
				return true;
		}
		
		return false;
		
	}
	
	public void render(Graphics g)
	{
		if(!isDamaged)
			g.drawImage(sprites[index], this.getX() - Camera.x, this.getY() - Camera.y, null);
		else
			g.drawImage(Entity.ENEMY_FEEDBACK, this.getX() - Camera.x, this.getY() - Camera.y, null);
		//Irá mostrar a máscara da colisão
		//Serve para debuggar
		//g.setColor(Color.blue);
		//g.fillRect(this.getX() - Camera.x, this.getY() - Camera.y, 16, 16);
		
		
	}
	
}
