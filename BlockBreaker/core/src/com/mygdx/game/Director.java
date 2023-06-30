package com.mygdx.game;

public class Director {
	private Builder builder;
	public void makingPingBall(Builder builder) {
		this.builder = builder;
		builder.reset();
		builder.setTamano();
		builder.setPosicion();
		builder.setExtras();
		builder.setVelocity();
	}
	public void makingPaddle(Builder builder) {
		this.builder = builder;
		builder.reset();
		builder.setTamano();
		builder.setPosicion();
		builder.setExtras();
		builder.setVelocity();
	}
	public Object getResult() {
		return builder.getProducto();
	}
}
