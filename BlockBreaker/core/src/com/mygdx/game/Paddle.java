package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Paddle implements ChangeSpeed{
    private int x = 20;
    private int y = 20;
    private int width = 100;
    private int height = 10;
    private boolean poderActivadoA;
    private boolean poderActivadoR;
    
    public Paddle(int x, int y, int ancho, int alto) {
    	this.x = x;
    	this.y= y;
    	width = ancho;
    	height = alto;
    	poderActivadoA = false;
    	poderActivadoR = false;
    }
     
    public int getX() {return x;}
	public int getY() {return y;}
	public int getWidth() {return width;}
	public int getHeight() {return height;}

	public void draw(ShapeRenderer shape){
		int velocidad = 15;
        shape.setColor(Color.GREEN);
        int x2 = x; //= Gdx.input.getX();
        if (poderActivadoA) {
        	velocidad += 5;
        }
        if (poderActivadoR) {
        	velocidad -= 5;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) x2 =x-velocidad;
    	if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) x2=x+velocidad; 
       // y = Gdx.graphics.getHeight() - Gdx.input.getY(); 
        if (x2 > 0 && x2+width < Gdx.graphics.getWidth()) {
            x = x2;
        }
        shape.rect(x, y, width, height);
    }
	

	@Override
	public void acelerar() {
		// TODO Auto-generated method stub
		poderActivadoA = true;
	}

	@Override
	public void realentizar() {
		// TODO Auto-generated method stub
		poderActivadoR = true;
	}
    
    
}
