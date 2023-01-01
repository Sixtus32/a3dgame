/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gamdaw.a3dgame.graphics;

/**
 *
 * @author sixtu
 */
public class Render {
    public final int width;
    public final int height;
    public final int [] pixeles;

    public Render(int w, int h) {
        this.width = w;
        this.height = h;
        pixeles=new int[width*height];
    }
    
    
    public void draw(Render render, int xOffset, int yOffset){
        for(int y=0; y<render.height; y++){
            int yPix=y+yOffset;
            if(yPix < 0 || yPix >= 600){
                continue;
            }
            for (int x = 0; x < render.width; x++) {
                int xPix=x+xOffset;
                if(xPix < 0 || xPix >= 800){
                    continue;
                }    
                pixeles[xPix+yPix*width]=render.pixeles[x + y* render.width];
                System.out.println("X : " + x + "\nY : " + y);
            }
            
        }
    }
    
}
