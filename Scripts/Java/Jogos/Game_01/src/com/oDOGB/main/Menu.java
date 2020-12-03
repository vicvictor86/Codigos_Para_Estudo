package com.oDOGB.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class Menu {

	public String[] options = {"Novo Jogo", "Carregar Jogo", "Sair"};
	public int currentOption = 0;
	public int maxOption = options.length - 1;
	
	public boolean up,down,enter;
	public boolean pause = false;
	//Testa se o jogo já foi iniciado alguma vez para evitar que no menu apareça continue
	public boolean alreadyStarted = false;
	
	//Tela menu
	private BufferedImage telaMenu;
	
	//Método cosntrutor utilizado para colocar a imagem do menu
	public Menu() 
	{
		try 
		{
			telaMenu = ImageIO.read(getClass().getResource("/EdnaldoPereira.jpg"));
		}catch(IOException e)
		{
			e.printStackTrace();
		}
	}

	public void tick()
	{
		//Navegação no menu
		if(up)
		{
			up = false;
			currentOption--;
			//Faz com que o selecionador fique em um looping de escolha
			if(currentOption < 0)
			{
				currentOption = maxOption;
			}
		}
		//Navegação no menu
		if(down)
		{
			down = false;
			currentOption++;
			if(currentOption > maxOption)
			{
				currentOption = 0;
			}
			
		}
		//Enter só será verdadeiro caso o jogo esteja no state menu
		if(enter)
		{
			enter = false;
			if(options[currentOption] == "Novo Jogo" || options[currentOption] == "Continuar")
			{
				Game.gameState = "NORMAL";
				pause = false;
				alreadyStarted = true;
			}
			else if(options[currentOption] == "Sair")
			{
					System.exit(1);
			}
			
			else if(options[currentOption] == "Carregar Jogo")
			{
				//Carregar Jogo
			}
		}
	}
	
	//Renderização do menu
	public void render(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		//Permite que o jogo diferencie quando esta no pause do menu e quando esta no pause do jogo em andamento
		if(!pause) 
		{
			//Render da imagem do ednaldo pereira
			g.drawImage(telaMenu, (Game.WIDTH * Game.SCALE) / 2 - 490, (Game.HEIGHT * Game.SCALE) / 2 - 250, null);
		}
		//Pause do jogo em andamento a tela fica transparente
		else
		{
			g.setColor(new Color(0,0,0,100));
			g.fillRect(0, 0, Game.WIDTH * Game.SCALE, Game.HEIGHT * Game.SCALE);
		}
		g.setColor(Color.yellow);
		g.setFont(new Font("arial", Font.BOLD, 33));
		g.drawString(">Zelda de Chernobyl com armas<", (Game.WIDTH * Game.SCALE) / 2 - 270, (Game.HEIGHT * Game.SCALE) / 2  - 180);
		
		//Opções do Menu
		g.setColor(Color.white);
		g.setFont(new Font("Arial", Font.BOLD, 26));
		if(pause == false)
			g.drawString("Novo Jogo", (Game.WIDTH * Game.SCALE) / 2 - 80, (Game.HEIGHT * Game.SCALE) / 2  + 30);
		else if(pause == true && alreadyStarted == true)
			g.drawString("Continuar", (Game.WIDTH * Game.SCALE) / 2 - 80, (Game.HEIGHT * Game.SCALE) / 2  + 30);
		
		g.drawString("Carregar Jogo", (Game.WIDTH * Game.SCALE) / 2 - 100, (Game.HEIGHT * Game.SCALE) / 2  + 65);
		g.drawString("Sair", (Game.WIDTH * Game.SCALE) / 2 - 38, (Game.HEIGHT * Game.SCALE) / 2  + 100);
		
		if(options[currentOption] == "Novo Jogo")
		{
			g.drawString(">", (Game.WIDTH * Game.SCALE) / 2 - 110, (Game.HEIGHT * Game.SCALE) / 2  + 30);
		}
		else if(options[currentOption] == "Carregar Jogo")
		{
			g.drawString(">", (Game.WIDTH * Game.SCALE) / 2 - 130, (Game.HEIGHT * Game.SCALE) / 2  + 65);
		}
		else if(options[currentOption] == "Sair")
		{
			g.drawString(">", (Game.WIDTH * Game.SCALE) / 2 - 68, (Game.HEIGHT * Game.SCALE) / 2  + 100);
		}
		
		
		
		
	}
	
}
