package com.oDOGB.graficos;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import com.oDOGB.main.Game;


public class UI {

	public void render(Graphics g) 
	{
		g.setColor(Color.red);
		g.fillRect(4, 11, 50, 8);
		g.setColor(Color.green);
		g.fillRect(4, 11, (int)(Game.player.life/Game.player.maxlife*50), 8);
		g.setColor(Color.white);
		g.setFont(new Font("Arial", Font.BOLD,12));
		g.drawString((int)Game.player.life + "/" + (int)Game.player.maxlife, 4, 10);
		g.drawString("Level " + Game.levelAtual, 100, 12);
	}
	
}
