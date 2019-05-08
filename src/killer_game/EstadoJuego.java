/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package killer_game;




import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;




/**
 *
 * @author Andres
 */
public class EstadoJuego extends Estado {
    
     
    
   
    
    public EstadoJuego(){
        
    }
    
    
    
    public void draw(Graphics g){
       
        
        Graphics2D g2d = (Graphics2D)g;
        
       
        //g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        
        
        
    }


    @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
