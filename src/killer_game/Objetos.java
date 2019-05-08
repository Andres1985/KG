/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package killer_game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;


/**
 *
 * @author Andres
 */
public abstract class Objetos {
    protected  BufferedImage img;
    protected Vector2D posicion;
    
    public Objetos(Vector2D position, BufferedImage img){
        this.posicion = position;
        this.img = img;
        
    }
    
    public abstract void update();
    
    public abstract void draw(Graphics g);

    
    public Vector2D getPosition() {
        return posicion;
    }

    public void setPosition(Vector2D position) {
        this.posicion = position;
    }
    
    
    
}
