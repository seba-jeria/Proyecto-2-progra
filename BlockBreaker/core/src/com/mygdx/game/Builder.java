package com.mygdx.game;
//Interfaz builder usada para el patrón
public interface Builder {
	public void setTamano();
	public void setPosicion();
	public void setExtras();
	public void reset();
	public Object getProducto();
	public void setVelocity();
}
