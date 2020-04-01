package edu.patrones.modelo;

import java.awt.Graphics;

public abstract class Enemigo extends Nave {
	
	protected int velocidad;
	protected int puntaje;
	
	@Override
	public abstract void instante();

	@Override
	public abstract void dibujar(Graphics g);

	@Override
	public abstract void mover(String direccion);

	public int getPuntaje() {
		return puntaje;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

}
