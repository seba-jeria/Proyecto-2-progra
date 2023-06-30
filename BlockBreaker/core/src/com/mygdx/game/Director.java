package com.mygdx.game;
//Clase director, que trata directamente con la interfaz builder 
public class Director {
	private Builder builder;
	//Método que usará el director hacer la creación del PingBall
	public void makingPingBall(Builder builder) {
		this.builder = builder;
		builder.reset();
		builder.setTamano();
		builder.setPosicion();
		builder.setExtras();
		builder.setVelocity();
	}
	//Método que usará el director hacer la creación del Paddle
	public void makingPaddle(Builder builder) {
		this.builder = builder;
		builder.reset();
		builder.setTamano();
		builder.setPosicion();
		builder.setExtras();
		builder.setVelocity();
	}
	//getter de resultado de la clase builder
	public Object getResult() {
		return builder.getProducto();
	}
}
