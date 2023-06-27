package com.mygdx.game;

public class BallSize {
	private BallStrategy str;
	
	public void setSize(BallStrategy estrategia) {
		str = estrategia;
		
	}
	public void changeSize() {
		str.selectSize();
	}
}
