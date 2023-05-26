package com.mygdx.game;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.Random;

import com.badlogic.gdx.graphics.Color;

public class Block {
    private int x;
    private int y;
    private int width;
    private int height;
    Color cc;
    boolean destroyed;
    
    public Block(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        destroyed = false;
        Random r = new Random(x+y);
        
       cc = new Color(0.1f+r.nextFloat(1), r.nextFloat(1), r.nextFloat(1), 10);
  
    }
    public void draw(ShapeRenderer shape){
    	shape.setColor(cc);
        shape.rect(x, y, width, height);
    }
    public boolean isDestroyed() {
    	return destroyed;
    }
    public int getX() {return x;}
    
    public int getY() {return y;}
    
    public int getWidth() {return width;}
    
    public int getHeight() {return height;}
}
