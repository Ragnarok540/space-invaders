package edu.patrones.modelo;

import java.awt.Graphics;

public class Cangrejo extends Enemigo {

	private ModeloFlyweightCangrejo modelo;
	
	public Cangrejo() {
		super.puntaje = 20;
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

	public ModeloFlyweightCangrejo getModelo() {
		return modelo;
	}

	public void setModelo(ModeloFlyweightCangrejo modelo) {
		this.modelo = modelo;
	}

}
