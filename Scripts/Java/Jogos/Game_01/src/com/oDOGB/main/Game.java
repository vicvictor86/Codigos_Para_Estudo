package com.oDOGB.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;

import com.oDOGB.entities.BulletShoot;
import com.oDOGB.entities.Enemy;
import com.oDOGB.entities.Entity;
import com.oDOGB.entities.Player;
import com.oDOGB.graficos.Spritesheet;
import com.oDOGB.graficos.UI;
import com.oDOGB.world.Camera;
import com.oDOGB.world.WallTile;
import com.oDOGB.world.World;

public class Game extends Canvas implements Runnable, KeyListener, MouseListener{
	
	private static final long serialVersionUID = 1L;
	public static JFrame frame;
	private Thread thread;
	
	private boolean isRunning = true;
	public static final int WIDTH = 240;
	public static final int HEIGHT = 160;
	
	public static final int SCALE = 3;
	private BufferedImage image;
	private int CUR_LEVEL = 1, MAX_LEVEL = 2;
	public static int levelAtual = 1;
	
	//Criação de listas
	public static List<Entity> entities;
	public static List<Enemy> enemies;
	public static List<BulletShoot> bullet;

	
	public static Spritesheet spritesheet;
	public static World world;
	public static Player player;
	
	public static Random rand;
	public UI ui;
	
	//Game Over
	public static String gameState = "MENU";
	private boolean showMessageGameOver = true;
	private int framesGameOver = 0;
	private boolean restartGame = false;
	
	public Menu menu;
	
	
	
	
	public Game() 
	{
		Sound.musicBackground.loop();
		rand =  new Random();
		addKeyListener(this);
		addMouseListener(this);
		setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		initFrame();
		//Inicializando objetos:
		ui = new UI();
		image = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
		entities = new ArrayList<Entity>();
		enemies = new ArrayList<Enemy>();
		bullet = new ArrayList<BulletShoot>();
		spritesheet = new Spritesheet("src/res/spritesheet.png");
		player = new Player(0,0,16,16,spritesheet.getSprite(32, 0, 16, 16));
		entities.add(player);
		world = new World("/level1.png");
		menu = new Menu();
		
	}
	
	public void initFrame(){
		frame = new JFrame("Game #1");
		frame.add(this);
		frame.setResizable(false);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public synchronized void start() {
		thread = new Thread(this);
		isRunning = true;
		thread.start();
	}
	
	
	
	public synchronized void stop() {
		isRunning = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public static void main(String[] args) {
		 Game game = new Game();
		 game.start();
	}
	
	//Local onde toda a lógica vai está pois é aqui que ocorre o looping das verificações
	//Toda a lógica deve está no tick para evitar qualquer conflito e facilitar a manutenção de bugs
	public void tick() 
	{
		//Estado de em jogo
		if(gameState == "NORMAL")
		{
			this.restartGame = false;
			for(int i = 0; i < entities.size();i++) {
				Entity e = entities.get(i);
				e.tick();
			}
			
			for(int i = 0;i < bullet.size();i++)
			{
				bullet.get(i).tick();
			}
			
			if(enemies.size() == 0)
			{
				//Avança para o próximo level, verificando se todos os inimigos morreram
				CUR_LEVEL++;
				levelAtual++;
				if(CUR_LEVEL > MAX_LEVEL)
				{
					CUR_LEVEL = 1;
				}
				//Local onde vai decidir qual a proxima fase
				String newWorld = "level" + CUR_LEVEL +".png";
				World.restartGame(newWorld);
				
			}
		}
		//Estado de Game Over
		else if(gameState == "GAME_OVER")
		{
			//System.out.println("Game Over");
			framesGameOver++;
			if(framesGameOver == 35)
			{
				
				framesGameOver = 0;
				if(showMessageGameOver)
					showMessageGameOver = false;
				else
					showMessageGameOver = true;
				
			}
			
			//Logica de reiniciar o game
			if(restartGame)
			{
				Game.gameState = "NORMAL";
				this.restartGame = false;
				CUR_LEVEL = 1;
				levelAtual = 1;
				String newWorld = "level" + CUR_LEVEL +".png";
				World.restartGame(newWorld);
				//System.out.println("Reiniciou");
			}
		}
		
		//Lógica do menu
		else if(Game.gameState == "MENU")
		{
			menu.tick();
		}
		
		
		
	}
	
	public void render() {		
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = image.getGraphics();
		g.setColor(new Color(0,0,0));
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		// renderização do jogo //
		//Graphics2D g2 =(Graphics2D) g; 
		world.render(g);
		for(int i = 0; i < entities.size();i++) {
			Entity e = entities.get(i);
			e.render(g);
		}
		for(int i = 0;i < bullet.size();i++)
		{
			bullet.get(i).render(g);
			
		}
		ui.render(g);
		
		g.dispose();
		g = bs.getDrawGraphics();
		g.drawImage(image, 0, 0, WIDTH * SCALE,HEIGHT * SCALE,null);
		g.setFont(new Font("Arial",Font.BOLD,26));
		g.setColor(Color.yellow);
		g.drawString("Munição: " + Player.ammo, 560, 40);
		if(gameState == "GAME_OVER")
		{
			Graphics2D g2 = (Graphics2D) g;
			g2.setColor(new Color(0,0,0,100));
			g2.fillRect(0, 0, WIDTH * SCALE, HEIGHT * SCALE);
			g.setFont(new Font("Arial",Font.BOLD,40));
			g.setColor(Color.yellow);
			g.drawString("GAME OVER", (WIDTH * SCALE) / 2 - 105, (HEIGHT * SCALE)/ 2 + 10);
			g.setFont(new Font("Arial",Font.BOLD,30));
			if(showMessageGameOver)
				g.drawString(">PRESSIONE ENTER PARA REINICIAR<", (WIDTH * SCALE) / 2 - 270, (HEIGHT * SCALE)/ 2 + 70 );
		}
		else if(gameState == "MENU")
		{
			menu.render(g);
		}
		bs.show();
		
	}
	
	public void run() {
		//Looping do game
		requestFocus();
		long lastTime = System.nanoTime();
		double amountsOfTicks = 60.0;
		double ns = 1000000000 / amountsOfTicks;
		double delta = 0;
		int frames = 0;
		double timer = System.currentTimeMillis();
		while(isRunning) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			if(delta >= 1) {
				tick();
				render();
				frames++;
				delta--;
			}
			if(System.currentTimeMillis() - timer >= 1000) {
				System.out.println("FPS: "+frames);
				frames = 0;
				timer += 1000;
			}
			
		}
		
		stop();
	}

	//Mapeamento de teclas
	public void keyPressed(KeyEvent e) 
	{
		//Definição das teclas de movimentação do personagem
		//Pressionamento da tecla
		if(e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) 
		{
			player.right = true;
		}
		else if(e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) 
		{
			player.left = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) 
		{
			//Movimentação do personagem
			player.up = true;
			//Navegação do menu
			if(gameState == "MENU")
			{
				menu.up = true;
			}
		}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) 
		{
			//Movimentação do personagem
			player.down = true;
			//Navegação do menu 
			if(gameState == "MENU")
			{
				menu.down = true;
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_X && Player.ammo > 0)
		{
			player.shoot = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_ENTER)
		{
			restartGame = true;
			if(gameState == "MENU")
			{
				menu.enter = true;
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_ESCAPE)
		{
			if(menu.alreadyStarted == true)
			{
				gameState = "MENU";
				menu.pause = true;
			}
				
		}
	}

	//Mapeamento de teclas
	public void keyReleased(KeyEvent e) 
	{	
		//Definição das teclas de movimentação do personagem
		//Soltamento da tecla
		if(e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) 
		{
			player.right = false;
		}
		else if(e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) 
		{
			player.left = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) 
		{
			player.up = false;
		}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) 
		{
			player.down = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_ENTER)
		{
			restartGame = true;
		}
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		player.mouseShoot = true;
		player.mx = (e.getX() / 3);
		player.my = (e.getY() / 3);
		//System.out.println(player.mx);
		//System.out.println(player.my);
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
