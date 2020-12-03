package com.oDOGB.entities;


import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.oDOGB.main.Game;
import com.oDOGB.world.Camera;

public class Entity {
	
	public static BufferedImage LIFEPACK_EN = Game.spritesheet.getSprite(96, 0, 16, 16);
	public static BufferedImage WEAPON_EN = Game.spritesheet.getSprite(112, 0, 16, 16);
	public static BufferedImage BULLET_EN = Game.spritesheet.getSprite(96, 16, 16, 16);
	public static BufferedImage ENEMY_EN = Game.spritesheet.getSprite(112, 16, 16, 16);
	public static BufferedImage ENEMY_FEEDBACK = Game.spritesheet.getSprite(128, 32, 16, 16);
	public static BufferedImage GUN_LEFT = Game.spritesheet.getSprite(144, 0, 16,16);
	public static BufferedImage GUN_RIGHT = Game.spritesheet.getSprite(128, 0, 16,16);
	public static BufferedImage GUNFEED_LEFT = Game.spritesheet.getSprite(144, 16, 16, 16);
	public static BufferedImage GUNFEED_RIGHT = Game.spritesheet.getSprite(144, 32, 16, 16);
	
	
	protected double x;
	protected double y;
	protected int width;
	protected int height;
	
	private BufferedImage sprite;
	
	private int maskx, masky, mwidth,mheight;
	
	public Entity(int x, int y, int width, int height, BufferedImage sprite) 
	{
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
		this.sprite = sprite;
		
		this.maskx = 0;
		this.masky = 0;
		this.mwidth = width;
		this.mheight = height;
	}
	
	//Cria as mascaras de colisão dando capacidade de altera-las
	public void setMask(int maskx, int masky, int mwidth, int mheight)
	{
		this.maskx = maskx;
		this.masky = masky;
		this.mheight = mheight;
		this.mwidth = mwidth;
		
	}
	
	
	public void setX(int newX) 
	{
		this.x = newX;
	}
	
	public void setY(int newY) 
	{
		this.y = newY;
	}
	
	public int getX() {
		return (int)this.x;
	}
	
	public int getY() {
		return (int)this.y;
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public int getHeight() {
		return this.height;
	}
	
	
	public void tick() 
	 {
		
	}
	
	//Testa a colisão com as entitys
	public static boolean isColliding(Entity e1, Entity e2)
	{
		Rectangle e1Mask = new Rectangle(e1.getX() + e1.maskx, e1.getY() + e1.masky, e1.mwidth,e1.mheight);
		Rectangle e2Mask = new Rectangle(e2.getX() + e2.maskx, e2.getY() + e2.masky, e2.mwidth,e2.mheight);
		
		return e1Mask.intersects(e2Mask);
	}
	
	
	
	public void render(Graphics g) {
		g.drawImage(sprite, this.getX() - Camera.x, this.getY() - Camera.y, null);
		//Debugação a frente
		//g.setColor(Color.red);
		//g.fillRect(this.getX() + maskx - Camera.x, this.getY() + masky - Camera.y, mwidth, height);
		//Debuação terminada
		
	}
	
	
}
