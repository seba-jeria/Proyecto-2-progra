package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
//Clase abstracta extendida de Block
public  class SpecialBlock2 extends Block{
	
	private int x;
    private int y;
    private int width;
    private int height;
    private Color cc;
    private boolean destroyed;
    
    //Metodo con las dimensiones de la pantalla
    public SpecialBlock2(int x, int y, int width, int height) {
    	super(x, y, width, height); //necesario para la extensión de Block
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        destroyed = false;
        //cc = new Color(1, 0, 0, 10); //color del bloque
    } 
    //Si colisiona con el bloque especial, destruye el bloque. La pelota se achica y acelera
    public void checkCollition(PingBall ball) {
    	ball.achicar();
    	if(ball.getPoderActivado()) {
    		ball.acelerar();
    	}
    	
    	
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
	@Override
	public void selectColor() {
		// TODO Auto-generated method stub
		this.cc = new Color(0, 1, 0, 10); //color del bloque
		
	}
}
