package com.mygdx.game;
import com.badlogic.gdx.graphics.Color;

public class BallBuilder {
	   private int size;
       private int x;
       private int y;
       private int xSpeed;
       private int ySpeed;
       private boolean iniciaQuieto;
       private Color color;
       
       public int getSize() {
           return size;
       }
      
       public int getX() {
           return x;
       }
      
       public int getY() {
           return y;
       }
      
       public int getXSpeed() {
           return xSpeed;
       }
      
       public int getYSpeed() {
           return ySpeed;
       }
      
       public boolean getIniciaQuieto() {
           return iniciaQuieto;
       }
       
       public Color getColor() {
       	return color;
       }
       
       public BallBuilder color(Color c) {
           color = c;
           return this;
       }
       
       public BallBuilder size(int tamaño) {
           size = tamaño;
           return this;
       }
      
       public BallBuilder x(int posicionX) {
           x = posicionX;
           return this;
       }
      
       public BallBuilder y(int posicionY) {
           y = posicionY;
           return this;
       }
      
       public BallBuilder xSpeed(int velocidadX) {
           xSpeed = velocidadX;
           return this;
       }
      
       public BallBuilder ySpeed(int velocidadY) {
           ySpeed = velocidadY;
           return this;
       }
      
       public BallBuilder iniciaQuieto(boolean quieto) {
           iniciaQuieto = quieto;
           return this;
       }
      
       public PingBall build() {
           return new PingBall(this);
       }
}
