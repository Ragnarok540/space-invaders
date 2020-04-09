package edu.patrones.modelo;

import java.awt.Graphics;

public class Cangrejo extends Enemigo {
	
	public Cangrejo() {
		super();
		super.puntaje = 20;
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
