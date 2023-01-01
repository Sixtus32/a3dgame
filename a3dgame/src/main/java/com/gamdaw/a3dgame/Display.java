/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gamdaw.a3dgame;

import com.gamdaw.a3dgame.graphics.Render;
import com.gamdaw.a3dgame.graphics.Screen;
/****************************************/
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import javax.swing.JFrame;
/**
 *
 * @author sixtu
 */
public class Display extends Canvas implements Runnable{   
    private static final long serialVersionUID = 1L;
    
    private static final int WIDTH=800;
    private static final int HEIGHT=600;
    private static final String TITLE="Minefront Pre-Alpha";
    
    private Thread thread;
    private volatile boolean running=false;
    private BufferedImage bufferImage;
    private Render render;
    private Screen screen;
    private int[] pixels;
    
    public Display(){
        screen=new Screen(WIDTH,HEIGHT);
        bufferImage=new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
        pixels=((DataBufferInt)bufferImage.getRaster().getDataBuffer()).getData();
    }

    @Override
    public void run() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        while(running){
            //handing time fps 
            tick();
            //handing render
            render();
        }
    }
    
    private void start(){
        if(running) {
            return;
        }
        running=true;
        thread=new Thread();
        thread.start();
        run();
//        System.out.println("Game is working...");
    }
   
    private void stop(){
        if(!running) {
            return;
        }
        running=false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            System.exit(0);
        }      
    }
      
    private void tick(){
        
    }
     
    private void render(){
        BufferStrategy bs= this.getBufferStrategy();
        if(bs == null){
            createBufferStrategy(3);
            return;
        }
        
        screen.render();
        
        System.arraycopy(screen.pixeles, 0, pixels, 0, this.WIDTH * this.HEIGHT);
        
        Graphics g=bs.getDrawGraphics();
        g.drawImage(bufferImage, 0, 0, null);
        g.dispose();
        bs.show();
    }
            
    public static void main(String[] args) {
        Display game=new Display();
        JFrame frame=new JFrame();
        frame.add(game);
        frame.setTitle(TITLE);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH,HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
        
        System.out.println("Running...");
        game.start();
    }


}
