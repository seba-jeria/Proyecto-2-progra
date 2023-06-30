package com.mygdx.game;
//Clase que implementa la interfaz BallStrategy para aplicar el patrón Strategy
public class PelotaGrande implements BallStrategy{
	@Override
	//Cambia el tamaño de la pelota
	public int selectSize() {
		return (25);
	}
}
