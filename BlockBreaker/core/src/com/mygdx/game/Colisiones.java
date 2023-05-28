package com.mygdx.game;

public class Colisiones {
    public boolean paddleBall(Paddle pp, PingBall bb) {
    	boolean intersectaX = (pp.getX() + pp.getWidth() >= (bb.getX()-bb.getSize())) && (pp.getX() <= (bb.getX()+bb.getSize()));
        boolean intersectaY = (pp.getY() + pp.getHeight() >= (bb.getY()-bb.getSize())) && (pp.getY() <= (bb.getY()+bb.getSize()));		
    	return intersectaX && intersectaY;
    }
    public boolean blockBall(Block bb, PingBall pp) {
    	boolean intersectaX = (bb.getX() + bb.getWidth() >= (pp.getX()-pp.getSize())) && (bb.getX() <= (pp.getX()+pp.getSize()));
        boolean intersectaY = (bb.getY() + bb.getHeight() >= (pp.getY()-pp.getSize())) && (bb.getY() <= (pp.getY()+pp.getSize()));		
    	return intersectaX && intersectaY;
    }
}
