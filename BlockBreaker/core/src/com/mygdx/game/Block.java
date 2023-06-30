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
  //Sett de posicion y tamaño
  public void setPosition(int x, int y){
      this.x = x;
      this.y = y;
  }
  public void setTamano(int width, int height){
      this.width = width;
      this.height = height;
  }
  //Color
  public abstract void selectColor();
  //Método plantilla aplica el poder de los bloques especiales o normales (template method)
  public void checkCollition(PingBall ball) {
      if(! isDestroyed() ) {
          setDestroyed(true);
          if(tienePoder()) {
              applyPower(ball);
          }
      }
  }
  //Aplicar poder (ralentizar pelota , acelerar pelota)
  public abstract void applyPower(PingBall ball);
  //Si tiene poder lo aplica
  public abstract boolean tienePoder();
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