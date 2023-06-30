package com.mygdx.game;

import com.badlogic.gdx.Gdx;

public class PaddleBuilder implements Builder{
	private Paddle paddle;
	public PaddleBuilder() {
		this.reset();
	}
	public void reset() {
		this.paddle = Paddle.getInstance();
	}
	public void setTamano() {
		paddle.setTamano(10, 100);
	}
	@Override
	public void setPosicion() {
		paddle.setPosicion(Gdx.graphics.getWidth() / 2 - 50, 40);
	}
	@Override
	public void setExtras() {
		paddle.setPoderes(false, false);
	}
	@Override
	public Object getProducto() {
		return (Paddle) paddle;
	}
	public void setVelocity() {
		paddle.setVelocity(15);
	}
}
