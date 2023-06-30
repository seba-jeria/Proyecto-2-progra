package com.mygdx.game;


import com.badlogic.gdx.graphics.Color;

// Clase concreta que extiende de Block
public class NormalBlock extends Block {
 public NormalBlock(int x, int y, int width, int height) {
     super(x, y, width, height);
 }
 @Override
 public void checkCollition(PingBall ball) {
     setDestroyed(true);
 }
 @Override
 public void selectColor() {
     setColor(new Color(0, 0, 1, 1)); // Establece el color del bloque
 }
 @Override
 public void applyPower(PingBall ball) {
     // TODO Auto-generated method stub
 }
 @Override
 public boolean tienePoder() {
     // TODO Auto-generated method stub
     return false;
 }
}


