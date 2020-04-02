package edu.patrones.modelo;

import java.awt.Color;
import java.awt.Graphics;

import edu.patrones.intefaces.IBalaPrototype;

public class BalaPrototype extends Entidad implements IBalaPrototype {

	private boolean tipo;
	private ModeloFlyweightBala modelo;
	
	public BalaPrototype() {
		ancho = 2;
		alto = 20;
	}

	public boolean isTipo() {
		return tipo;
	}

	public void setTipo(boolean tipo) {
		this.tipo = tipo;
	}

	public ModeloFlyweightBala getModelo() {
		return modelo;
	}

	public void setModelo(ModeloFlyweightBala modelo) {
		this.modelo = modelo;
	}
	
	@Override
	public void instante() {
		mover(null);
	}

	@Override
	public void dibujar(Graphics g) {
		g.setColor(Color.GRAY);
		g.fillRect(posX, posY, ancho, alto);
	}

	@Override
	public void mover(String direccion) {
		if (tipo) {
			posY--;
		} else {
			posY++;
		}
	}

	@Override
	public IBalaPrototype clonar() {

		BalaPrototype bala = null;

		try {
			bala = (BalaPrototype) clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}

		return bala;

	}
	
}
