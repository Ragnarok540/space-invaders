package edu.patrones.modelo;

public abstract class Enemigo extends Nave {
	
	int velocidad;
	protected int puntaje;
	
	@Override
	public abstract void instante();

	@Override
	public abstract void dibujar();

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
