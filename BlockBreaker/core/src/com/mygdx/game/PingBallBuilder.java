package com.mygdx.game;

import com.badlogic.gdx.Gdx;

public class PingBallBuilder implements Builder {
	private PingBall ball;
	public PingBallBuilder() {
		this.reset();
	}
	public void reset() {
		this.ball = new PingBall();
	}
	public void setTamano() {
		ball.setSize(10);
	}
	@Override
	public void setPosicion() {
		ball.setXY(Gdx.graphics.getWidth()/2-10, 41);
	}
	@Override
	public void setExtras() {
		ball.setEstaQuieto(true);
	}
	@Override
	public Object getProducto() {
		return (PingBall) ball;
	}
	public void setVelocity() {
		ball.setVelocity(5, 7);
	}
}
