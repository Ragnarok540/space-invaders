package edu.patrones.modelo;

import java.awt.Graphics;

import edu.patrones.intefaces.IBalaPrototype;

public class BalaPrototype extends Entidad implements IBalaPrototype {

	private boolean tipo;
	
	public BalaPrototype() {
		ancho = 11;
		alto = 17;
	}

	public boolean isTipo() {
		return tipo;
	}

	public void setTipo(boolean tipo) {
		this.tipo = tipo;
	}
	
	@Override
	public void instante() {
		mover(null);
	}

	@Override
	public void dibujar(Graphics g) {
		if (tipo) {
			g.drawImage(modelo.getImagenA(), posX, posY, null);
		} else {
			g.drawImage(modelo.getImagenB(), posX, posY, null);
		}
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
