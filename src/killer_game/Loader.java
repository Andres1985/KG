/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package killer_game;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Andres
 */
public class Loader {
    
    public static BufferedImage ImageLoader(String path){
        

        try {
            return ImageIO.read(Loader.class.getResource(path));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        return null;
    }
    
    public static Font loadFont(String path, int size){
        try {
            return Font.createFont(Font.TRUETYPE_FONT, Loader.class.getResourceAsStream(path)).deriveFont(Font.PLAIN, size);
        } catch (FontFormatException ex) {
            Logger.getLogger(Loader.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (IOException ex) {
            Logger.getLogger(Loader.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
