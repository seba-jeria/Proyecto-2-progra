package com.mygdx.game;
// Clase contexto que se utiliza para tener las distintas estrategias encapsuladas de la clase PingBall
public class BallSize { 
	private BallStrategy str;
	
	public void setSize(BallStrategy estrategia) {
		str = estrategia;
	}
	public int changeSize() {
		return(str.selectSize());
	}
}
