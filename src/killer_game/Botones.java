package killer_game;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;



public class Botones {
	
	private BufferedImage mouseOutBtn;
	private BufferedImage mouseInBtn;
	private boolean mouseIn; //false o true si el mouse está colocado encima del botón
	private Rectangle recuadro;
	private Action action;
	private String texto;
	
	public Botones(
			BufferedImage mouseOutBtn,
			BufferedImage mouseInBtn,
			int x, int y,
			String texto,
			Action action
			) {
		this.mouseInBtn = mouseInBtn;
		this.mouseOutBtn = mouseOutBtn;
		this.texto = texto;
		recuadro = new Rectangle(x, y, mouseInBtn.getWidth(), mouseInBtn.getHeight());
		this.action = action;
	}
	
	public void update() {
		
		if(recuadro.contains(Mouse.X, Mouse.Y)) {
			mouseIn = true;
		}else {
			mouseIn = false;
		}
		
		if(mouseIn && Mouse.mouse) {
			action.doAction();
		}
	}
	
	public void draw(Graphics g) {
		
		if(mouseIn) {
			g.drawImage(mouseInBtn, recuadro.x, recuadro.y, null);
		}else {
			g.drawImage(mouseOutBtn, recuadro.x, recuadro.y, null);
		}
		
		Texto.drawText(g,texto,new Vector2D(
						recuadro.getX() + recuadro.getWidth() / 2,
						recuadro.getY() + recuadro.getHeight()),
				true,
				Color.BLACK,
				Accesorios.FuenteMediana);
		
		
	}
	
}