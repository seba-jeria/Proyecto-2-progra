package com.mygdx.game;



import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class PingBall implements ChangeSpeed{
	    private int x;
	    private int y;
	    private int size;
	    private int xSpeed;
	    private int ySpeed;
	    private Color color = Color.WHITE;
	    private int puntaje;
	    private boolean estaQuieto;
	    
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
	    
	    public boolean estaQuieto() {
	    	return estaQuieto;
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
	    /*private boolean collidesWith(Paddle pp) {

	    	boolean intersectaX = (pp.getX() + pp.getWidth() >= x-size) && (pp.getX() <= x+size);
	        boolean intersectaY = (pp.getY() + pp.getHeight() >= y-size) && (pp.getY() <= y+size);		
	    	return intersectaX && intersectaY;
	    }*/
	    
	    public void checkCollision(Block block) {
	            ySpeed = - ySpeed;
	            puntaje++;
	    }
	    /*private boolean collidesWith(Block bb) {

	    	boolean intersectaX = (bb.x + bb.width >= x-size) && (bb.x <= x+size);
	        boolean intersectaY = (bb.y + bb.height >= y-size) && (bb.y <= y+size);		
	    	return intersectaX && intersectaY;
	    }*/
	    
	    public int getPuntaje() {
	    	return puntaje;
	    }


		@Override
		public void acelerar() {
			// TODO Auto-generated method stub
			xSpeed += 10;
			ySpeed += 10;
		}


		@Override
		public void realentizar() {
			// TODO Auto-generated method stub
			xSpeed -= 2;
			ySpeed -= 2;
		}
	    
	}
