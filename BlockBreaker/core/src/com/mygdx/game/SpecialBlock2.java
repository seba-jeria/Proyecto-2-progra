package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;

//Clase concreta que extiende de Block
public class SpecialBlock2 extends Block {
 public SpecialBlock2(int x, int y, int width, int height) {
     super(x, y, width, height);
 }
 @Override
 public void selectColor() {
     setColor(new Color(1, 0, 0, 1)); // Establece el color del bloque
 }
 @Override
 //Aplicar poder (ralentizar pelota , acelerar pelota)
 public void applyPower(PingBall ball) {
     ball.achicar();
     if (ball.getPoderActivado()) {
         ball.acelerar();
     }
 }
 @Override
//Para verificar si tiene poder
 public boolean tienePoder() {
     return true;
 }
}


