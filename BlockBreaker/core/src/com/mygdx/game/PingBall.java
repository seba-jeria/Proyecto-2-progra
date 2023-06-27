package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

//Clase implementada de la interfaz ChangeSpeed

public class PingBall implements ChangeSpeed{
	    private int x;
	    private int y;
	    private int size;
	    public BallStrategy str;
	    private BallSize tamano = new BallSize();
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
	    @Override //Método para manejar la aceleración de la bola
        public void acelerar() {
	    	
            if(xSpeed > 0) { xSpeed += 2;}
            else { xSpeed -= 2; }
            if(ySpeed >0) { ySpeed += 2; }
            else { ySpeed -=2; }
            poderActivado = false;
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
        //getter y setters necesarios
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
	    public int getX() {return x;}	  
	    
	    public int getY() {return y;}	 
	    
	    public int getSize() {return size;}	  
	    
	    public void setSize(int size) {this.size = size;}	  
	    
	    public int getXSpeed() {return xSpeed;}	    
	    
	    public int getYSpeed() {return ySpeed;}	    
	    
	    public void setPoderAcivado(boolean poderActivado) {this.poderActivado = poderActivado;}	
	    
	    public boolean getPoderActivado() {return poderActivado;}	
	    
	    public int getPuntaje() {
	    	return puntaje;
	    }
	    
	    //Dibuja la pelota en la ventana
	    public void draw(ShapeRenderer shape){
	        shape.setColor(color);
	        shape.circle(x, y, size);
	    }	    
	    //Actualiza el movimiento según la velocidad de la pelota
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
	    //Cambian la velocidad de la pelota cuando hay colisión
	    public void checkCollision(Paddle paddle) {
	            ySpeed = -ySpeed;
	    }
	    public void checkCollision(Block block) {
	            ySpeed = - ySpeed;
	            puntaje++;
	    }
	   
	    public void agrandar() {
	    	str = new PelotaGrande();
	    	tamano.setSize(str);
	    	size = tamano.changeSize();
	    }
	    public void achicar() {
	    	str = new PelotaChica();
	    	tamano.setSize(str);
	    	size = tamano.changeSize();
	    }
	}
