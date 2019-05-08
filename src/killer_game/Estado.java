/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package killer_game;

import java.awt.Graphics;

/**
 *
 * @author Andres
 */
public abstract class Estado {
    
    public static Estado currentState= null;
    
    public static Estado getCurrentState(){
        return currentState;
    }
    
    public static void changeState(Estado newState){
       currentState = newState;
    }
    
    
    public abstract void update();
    public abstract void draw(Graphics g);
    
    
    
}
