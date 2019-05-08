/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package killer_game;


import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;


/**
 *
 * @author Andres
 */

/*
Clase principal
*/
public class Ventana extends JFrame implements Runnable {
    
    
  
    private Canvas canvas;
    private Thread thread;
    private boolean running = false;
    
    private BufferStrategy bs;
    private Graphics g;
    
    private final int FPS = 60;
    private double TARGETTIME = 1000000000/FPS;
    private double delta = 0;
    private int AVERAGEFPS = FPS;//ESTA VARIABLE NOS PERMITE SABER A CUANTO ESTÁ CORRIENDO EL JUEGO
           
    
   private Mouse mouseInput;
            
    public Ventana(){
        
        setTitle("Killer Game");
        setSize(Constantes.WIDTH, Constantes.HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        
        
        canvas = new Canvas();
        mouseInput = new Mouse();
                
        
        canvas.setPreferredSize(new Dimension(Constantes.WIDTH, Constantes.HEIGHT));
        canvas.setMaximumSize(new Dimension(Constantes.WIDTH, Constantes.HEIGHT));
        canvas.setMinimumSize(new Dimension(Constantes.WIDTH, Constantes.HEIGHT));
        canvas.setFocusable(true); //nos permite recibir entrada por teclado
        add(canvas);
        canvas.addMouseListener(mouseInput);
        canvas.addMouseMotionListener(mouseInput);
        setVisible(true);
    }
    
 
    public static void main(String [] args){
        new Ventana().start();
    }
    
    //metodo de actualizar
    private void update(){
        Estado.getCurrentState().update();
    }
    
    //metodo dibujar
    private void draw(){
        bs = canvas.getBufferStrategy();
        
        if(bs == null){
            canvas.createBufferStrategy(3); //3 es el numero de buffer que usa el canvas
            return;
        }
        
        g = bs.getDrawGraphics();
        
        //------------Aquí dibujamos------------------
        g.setColor(Color.BLACK);
        g.fillRect(0,0, Constantes.WIDTH, Constantes.HEIGHT);
       
        
        Estado.getCurrentState().draw(g);
        
    
        g.drawString(""+AVERAGEFPS, 10, 10);
        
        
         //g.clearRect(0, 0, WIDTH, HEIGHT); //REDIBUJAMOS EL CUADRADO
        //g.drawRect(x, 0, 200, 100);
        //------------------------------
        g.dispose();
        bs.show();
       
    }
    
    private void init(){
        
        Accesorios.init();
        Estado.changeState(new MenuEstado());
    }

    @Override
    public void run() {
        
        long now = 0;
        long lastTime = System.nanoTime();
        
        int frames = 0;
        long time = 0;
        
        init();
        
        while(running){
            
            now = System.nanoTime();
            delta+= (now-lastTime)/TARGETTIME;
            time += (now -lastTime);
            lastTime = now;
            
            if(delta >= 1){
              update();
              draw();
              delta--;
              frames++;
              
            }
            if(time >= 1000000000){
                AVERAGEFPS = frames;
                frames=0;
                time = 0;
            }
            
        }
        
        stop();
    }
    
    private void start(){
        
        thread = new Thread(this);
        thread.start();
        running = true;
        
    }
    
    private void stop(){
        try {
            thread.join();
            running = false;
        } catch (InterruptedException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
