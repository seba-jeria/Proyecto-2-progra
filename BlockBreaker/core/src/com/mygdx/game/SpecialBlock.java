package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
//Clase abstracta extendida de Block
public class SpecialBlock extends Block{
	private int x;
    private int y;
    private int width;
    private int height;
    Color cc;
    private boolean destroyed;   
    //Metodo con las dimensiones de la pantalla
    public SpecialBlock(int x, int y, int width, int height) {
    	super(x, y, width, height); //necesario para la extensión de Block
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        destroyed = false;
        cc = new Color(1, 0, 0, 10); //color del bloque
    }   
    //Si colisiona con el bloque especial, destruye el bloque. La pelota se agranda y se hace mas lenta 
    public void checkCollition(PingBall ball) {
    	ball.setSize(25);
    	ball.ralentizar();
    	destroyed = true;
    }
  //Para que se dibuje el bloque
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
