package edu.patrones.modelo;

public abstract class Nave extends Entidad {
	
	@Override
	public abstract void instante();

	@Override
	public abstract void dibujar();

	@Override
	public abstract void mover(String direccion);

	public void destruir() {
		super.eliminar();
	}
	
}
