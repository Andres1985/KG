/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package killer_game;



import java.awt.Graphics;
import java.util.ArrayList;



/**
 *
 * @author Andres
 */
public class MenuEstado extends Estado {
    
    private ArrayList<Botones> botones;

    public MenuEstado(){
        botones = new ArrayList<Botones>();
        
        botones.add(new Botones(
				Accesorios.btnAmarillo,
				Accesorios.btnRojo,
				Constantes.WIDTH / 2 - Accesorios.btnAmarillo.getWidth()/2,
				Constantes.HEIGHT / 2  - Accesorios.btnAmarillo.getHeight()*3,
				Constantes.JUGAR,
				new Action() {
					@Override
					public void doAction() {
						Estado.changeState(new EstadoJuego());
					}
				}
				));
                botones.add(new Botones(
				Accesorios.btnAmarillo,
				Accesorios.btnRojo,
				Constantes.WIDTH / 2 - Accesorios.btnAmarillo.getWidth()/2,
				Constantes.HEIGHT / 2 - Accesorios.btnAmarillo.getHeight()*2 ,
				Constantes.NAVE,
				new Action() {
					@Override
					public void doAction() {
						System.exit(0);
					}
				}
				));
                
                botones.add(new Botones(
				Accesorios.btnAmarillo,
				Accesorios.btnRojo,
				Constantes.WIDTH / 2 - Accesorios.btnAmarillo.getWidth()/2,
				Constantes.HEIGHT / 2 - Accesorios.btnAmarillo.getHeight() ,
				Constantes.RECORD,
				new Action() {
					@Override
					public void doAction() {
						System.exit(0);
					}
				}
				));
		
		botones.add(new Botones(
				Accesorios.btnAmarillo,
				Accesorios.btnRojo,
				Constantes.WIDTH / 2 - Accesorios.btnAmarillo.getWidth()/2,
				Constantes.HEIGHT / 2 + Accesorios.btnAmarillo.getHeight()/25 ,
				Constantes.SALIR,
				new Action() {
					@Override
					public void doAction() {
						System.exit(0);
					}
				}
				));
    }
    
    @Override
    public void update() {
        for(Botones b: botones) {
			b.update();
		}
    }

    @Override
    public void draw(Graphics g) {
        for(Botones b: botones) {
			b.draw(g);
		}
    }
    
}
