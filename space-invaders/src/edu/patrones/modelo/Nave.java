package edu.patrones.modelo;

import java.awt.Graphics;

public abstract class Nave extends Entidad {
	
	@Override
	public abstract void instante();

	@Override
	public abstract void dibujar(Graphics g);

	@Override
	public abstract void mover(String direccion);

	public void destruir() {
		super.eliminar();
	}
	
}
