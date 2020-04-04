package edu.patrones.modelo;

import java.awt.Color;
import java.awt.Graphics;

public class Pulpo extends Enemigo {

	private PulpoFlyweight modelo;
	
	public Pulpo() {
		super();
		super.puntaje = 10;
	}

	@Override
	public void dibujar(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(posX, posY, ancho, alto);
	}

	public PulpoFlyweight getModelo() {
		return modelo;
	}

	public void setModelo(PulpoFlyweight modelo) {
		this.modelo = modelo;
	}

}
