package com.mygdx.game;

import java.util.Random;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class SpecialBlock extends Block{
	private int x;
    private int y;
    private int width;
    private int height;
    Color cc;
    private boolean destroyed;
    
    
    public SpecialBlock(int x, int y, int width, int height) {
    	super(x, y, width, height);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        destroyed = false;
        Random r = new Random(x+y);
        
       cc = new Color(1, 0, 0, 10);
  
    }
    public void draw(ShapeRenderer shape){
    	shape.setColor(cc);
        shape.rect(x, y, width, height);
    }
    public boolean isDestroyed() {
    	return destroyed;
    }
    public void checkCollition(PingBall ball) {
    	ball.setSize(25);
    	ball.realentizar();
    	destroyed = true;
    }
    public int getX() {return x;}
    
    public int getY() {return y;}
    
    public int getWidth() {return width;}
    
    public int getHeight() {return height;}
}
