package edu.patrones.modelo;

public class Calamar extends Enemigo {
		
	private ModeloFlyweightCalamar modelo;
	
	public Calamar() {
		super.puntaje = 30;
	}
	
	@Override
	public void instante() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dibujar() {
		// TODO Auto-generated method stub

	}

	@Override
	public void mover(String direccion) {
		// TODO Auto-generated method stub

	}

	public ModeloFlyweightCalamar getModelo() {
		return modelo;
	}

	public void setModelo(ModeloFlyweightCalamar modelo) {
		this.modelo = modelo;
	}

}
