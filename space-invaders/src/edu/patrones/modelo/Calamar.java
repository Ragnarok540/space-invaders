package edu.patrones.modelo;

import java.awt.Graphics;

public class Calamar extends Enemigo {
	
	public Calamar() {
		super();
		super.puntaje = 30;
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
