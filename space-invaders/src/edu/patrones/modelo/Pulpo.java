package edu.patrones.modelo;

import java.awt.Graphics;

public class Pulpo extends Enemigo {

	private ModeloFlyweightPulpo modelo;
	
	public Pulpo() {
		super.puntaje = 10;
	}
	
	@Override
	public void instante() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dibujar(Graphics g) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mover(String direccion) {
		// TODO Auto-generated method stub

	}

	public ModeloFlyweightPulpo getModelo() {
		return modelo;
	}

	public void setModelo(ModeloFlyweightPulpo modelo) {
		this.modelo = modelo;
	}

}
