package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

//Clase implementada de la interfaz ChangeSpeed

public class Paddle implements ChangeSpeed{
    private int x = 20;
    private int y = 20;
    private int width = 100;
    private int height = 10;
    private boolean poderActivadoA;
    private boolean poderActivadoR;
    private int paddleSpeed;
    public Paddle(int x, int y, int ancho, int alto) {
    	this.x = x;
    	this.y= y;
    	width = ancho;
    	height = alto;
    	poderActivadoA = false;
    	poderActivadoR = false;
    	paddleSpeed = 15;
    }
    //getters de las dimensiones
    public int getX() {return x;}
    
	public int getY() {return y;}
	
	public int getWidth() {return width;}
	
	public int getHeight() {return height;}
	
	public void draw(ShapeRenderer shape){
        shape.setColor(Color.GREEN);
        int x2 = x; //= Gdx.input.getX();
        if (poderActivadoA) {
        	paddleSpeed += 1;
        	poderActivadoA = false;
        }
        if (poderActivadoR) {
        	paddleSpeed -= 2;
        	poderActivadoR = false;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) x2 =x-paddleSpeed;
    	if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) x2=x+paddleSpeed; 
        if (x2 > 0 && x2+width < Gdx.graphics.getWidth()) {
            x = x2;
        }
        shape.rect(x, y, width, height);
    }
	@Override
	public void acelerar() {
		poderActivadoA = true;
	}
	@Override
	public void ralentizar() {
		poderActivadoR = true;
	}
}
