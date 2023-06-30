package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

//Clase implementada de la interfaz ChangeSpeed
public class Paddle implements ChangeSpeed {
    private static Paddle instance;
    private int x;
    private int y;
    private int width;
    private int height;
    private boolean poderActivadoA;
    private boolean poderActivadoR;
    private int paddleSpeed;
    private Paddle() {
        // Constructor privado para evitar la creación de instancias directamente.
    	reset();
    }
    public static Paddle getInstance() { //Singleton
        if (instance == null) {
            instance = new Paddle();
        }
        return instance;
    }
    public void reset(){ // Reset creado para que se cree el Paddle al pasar de nivel
    	this.x = Gdx.graphics.getWidth() / 2 - 50;
        this.y = 40;
        width = 100;
        height = 10;
        poderActivadoA = false;
        poderActivadoR = false;
        paddleSpeed = 15;
    }
    //Métodos de la interfaz
    @Override
	public void acelerar() {
		poderActivadoA = true;
	}
	@Override
	public void ralentizar() {
		poderActivadoR = true;
	}
	//getters de las dimensiones
    public int getX() {return x;}
    
	public int getY() {return y;}
	
	public int getWidth() {return width;}
	
	public int getHeight() {return height;}
	
	public void setTamano(int height,int width) {
		this.height = height;
		this.width = width;
	}
	public void setPosicion(int x, int y) {
		this.x=x;
		this.y=y;
	}
	public void setPoderes(boolean a, boolean r) {
		poderActivadoA = a;
		poderActivadoR = r;
	}
	public void setVelocity(int Speed) {
		this.paddleSpeed=Speed;
	}
	public int getVelocity() {
		return paddleSpeed;
	}
	
	//Dibuja en la pantalla el paddle a partir del movimiento de las flechas
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


    

}
