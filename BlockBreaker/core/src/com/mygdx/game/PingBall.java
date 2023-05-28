package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

//Clase implementada de la interfaz ChangeSpeed

public class PingBall implements ChangeSpeed{
	    private int x;
	    private int y;
	    private int size;
	    private int xSpeed;
	    private int ySpeed;
	    private Color color = Color.WHITE;
	    private int puntaje;
	    private boolean estaQuieto;
	    private boolean poderActivado = false;
	    public PingBall(int x, int y, int size, int xSpeed, int ySpeed, boolean iniciaQuieto) {
	        this.x = x;
	        this.y = y;
	        this.size = size;
	        this.xSpeed = xSpeed;
	        this.ySpeed = ySpeed;
	        estaQuieto = iniciaQuieto;
	        puntaje = 0;
	    }
	    public void setPuntaje(int puntos) {
	    	puntaje = puntos;
	    }	    
	    public boolean estaQuieto() {	    	return estaQuieto;
	    }
	    public void setEstaQuieto(boolean bb) {
	    	estaQuieto=bb;
	    }
	    public void setXY(int x, int y) {
	    	this.x = x;
	        this.y = y;
	    }	   
	    
	    //getter y setters necesarios
	    public int getX() {return x;}	  
	    
	    public int getY() {return y;}	 
	    
	    public int getSize() {return size;}	  
	    
	    public void setSize(int size) {this.size = size;}	  
	    
	    public int getXSpeed() {return xSpeed;}	    
	    
	    public int getYSpeed() {return ySpeed;}	    
	    
	    public void setPoderAcivado(boolean poderActivado) {this.poderActivado = poderActivado;}	
	    
	    public boolean getPoderActivado() {return poderActivado;}	   
	    
	    public void draw(ShapeRenderer shape){
	        shape.setColor(color);
	        shape.circle(x, y, size);
	    }	    
	    public void update() {
	    	if (estaQuieto) return;
	        x += xSpeed;
	        y += ySpeed;
	        if (x-size < 0 || x+size > Gdx.graphics.getWidth()) {
	            xSpeed = -xSpeed;
	        }
	        if (y+size > Gdx.graphics.getHeight()) {
	            ySpeed = -ySpeed;
	        }
	    }
	    public void checkCollision(Paddle paddle) {
	            ySpeed = -ySpeed;
	    }
	    public void checkCollision(Block block) {
	            ySpeed = - ySpeed;
	            puntaje++;
	    }
	    public int getPuntaje() {
	    	return puntaje;
	    }
	    
	    @Override //Método para manejar la aceleración de la bola
        public void acelerar() {
            if(xSpeed > 0) { xSpeed += 2;}
            else { xSpeed -= 2; }
            if(ySpeed >0) { ySpeed += 2; }
            else { ySpeed -=2; }
        }
        @Override //Método para ralentizar la aceleración de la bola
        public void ralentizar() {
        	if (!poderActivado) {
	            if(xSpeed > 0) { xSpeed -= 2;}
	            else { xSpeed += 2; }
	            if(ySpeed >0) { ySpeed -= 2; }
	            else { ySpeed +=2; }
	            poderActivado = true;
        	}
        }
	    
	}
