package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;

//Clase concreta que extiende de Block
public class SpecialBlock extends Block {
 public SpecialBlock(int x, int y, int width, int height) {
     super(x, y, width, height);
 }
 @Override
 public void checkCollition(PingBall ball) {
     ball.agrandar();
     ball.ralentizar();
     setDestroyed(true);
 }
 @Override
 public void selectColor() {
     setColor(new Color(1, 0, 0, 1)); // Establece el color del bloque
 }
 @Override
 public void applyPower(PingBall ball) {
     // TODO Auto-generated method stub
     ball.agrandar();
     ball.ralentizar();
 }
 @Override
 public boolean tienePoder() {
     // TODO Auto-generated method stub
     return true;
 }
}

