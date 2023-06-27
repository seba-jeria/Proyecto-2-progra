package com.mygdx.game;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;


import com.badlogic.gdx.graphics.Color;
//Clase abstracta
public abstract class Block {
    private int x;
    private int y;
    private int width;
    private int height;
    private Color cc;
    private boolean destroyed;
    
    //Metodo con las dimensiones de la pantalla
    public Block (int x, int y, int width, int height) {
    	setPosition(x,y);
    	setTamano(width, height);
    	selectColor();    	
        destroyed = false;       
    }
    
 
    public void setPosition(int x, int y){
    	this.x = x;
    	this.y = y;
    }
    public void setTamano(int width, int height){
    	this.width = width;
        this.height = height;
    }
    public abstract void selectColor();
    //Método abstracto usado en NormalBlock y SpecialBlock
    public abstract void checkCollition(PingBall ball);
    
    
    
    //Dibujo del bloque en la ventana
    public void draw(ShapeRenderer shape){
    	shape.setColor(cc);
        shape.rect(x, y, width, height);
    }
    //Si es true destruye bloque
    public boolean isDestroyed() {
    	return destroyed;
    }
    //getters de las dimensiones
    public int getX() {return x;}
    
    public int getY() {return y;}
    
    public int getWidth() {return width;}
    
    public int getHeight() {return height;}
    
    public void setColor(Color c) {
    	cc = c;
    }
    
    public void setDestroyed(boolean b) {
    	destroyed = b;
    }
}
