package edu.patrones.modelo;

import java.awt.Graphics;

public class Pulpo extends Enemigo {
	
	public Pulpo() {
		super();
		super.puntaje = 10;
	}

	@Override
	public void dibujar(Graphics g) {
		if (estado) {
			g.drawImage(modelo.getImagenA(), posX, posY, null);
		} else {
			g.drawImage(modelo.getImagenB(), posX, posY, null);
		}
	}

}
