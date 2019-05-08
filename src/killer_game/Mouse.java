/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package killer_game;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.event.MouseInputListener;

/**
 *
 * @author Andres
 */
public class Mouse extends MouseAdapter {

    public static int X, Y;
    public static boolean mouse;

    @Override
    public void mousePressed(MouseEvent e) {
       if(e.getButton()== MouseEvent.BUTTON1){
           mouse = true;
       }
    }

    @Override
    public void mouseReleased(MouseEvent e) {//cuando soltamos el boton del mouse
        if(e.getButton()== MouseEvent.BUTTON1){
           mouse = false;
       }
    }

    
    @Override
    public void mouseDragged(MouseEvent e) {
      X= e.getX();
      Y=e.getY();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
      X=e.getX();
      Y=e.getY();
    }
    
}
