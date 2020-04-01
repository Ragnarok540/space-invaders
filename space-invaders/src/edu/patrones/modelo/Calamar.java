package edu.patrones.modelo;

import java.awt.Graphics;

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
	public void dibujar(Graphics g) {
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
