/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package killer_game;

import java.awt.Font;
import java.awt.image.BufferedImage;

/**
 *
 * @author Andres
 */
public class Accesorios {
    
    
    
    //Fonts
    public static Font fuenteGrande;
    public static Font FuenteMediana;
    
    // ui
    public static BufferedImage btnRojo;
    public static BufferedImage btnAmarillo;
    
    public static void init()
    {
       
        fuenteGrande = Loader.loadFont("/fonts/futureFont.ttf", 42);
        FuenteMediana = Loader.loadFont("/fonts/futureFont.ttf", 20);
        
        btnAmarillo = Loader.ImageLoader("/sw/btnAmarillo.png");
        btnRojo = Loader.ImageLoader("/sw/btnRojo.png");
    }
    
}
