/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gamdaw.a3dgame.graphics;

import java.util.Random;

/**
 *
 * @author sixtu
 */
public class Screen extends Render{
    
    private final Render render;
    
    public Screen(int width, int height) {
        super(width, height);
        Random random=new Random();
        render=new Render(256,256);
        for (int i = 0; i < render.width * render.height; i++) {
            render.pixeles[i]=random.nextInt();
        }
    }
       
    public void render(){
        for(int i = 0; i < width * height; i++){
            pixeles[i] = 0;
        }
        
        for (int  i = 0;  i < 20;  i++) {
            int anim=(int)(Math.sin((System.currentTimeMillis() + 1 )%20000.0/20000 * Math.PI * 2) * 200);
            int anim2=(int)(Math.cos((System.currentTimeMillis() + 1)%20000.0/20000 * Math.PI * 2) * 200);
            draw(render, (width - 256) / 2 + anim, (height - 256) / 2 + anim2);
        }        
    }
}
