package com.mygdx.game;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;


import com.badlogic.gdx.graphics.Color;
//Clase abstracta
public abstract class Block {
    private int x;
    private int y;
    private int width;
    private int height;
    Color cc;
    boolean destroyed;
    //Metodo con las dimensiones de la pantalla
    public Block (int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        destroyed = false;       
    }
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
}
