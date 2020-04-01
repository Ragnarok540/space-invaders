package edu.patrones.modelo;

import java.awt.Color;
import java.awt.Graphics;

public class Pulpo extends Enemigo {

	private ModeloFlyweightPulpo modelo;
	
	public Pulpo() {
		super.puntaje = 10;
		ancho = 20;
		alto = 20;
	}

	@Override
	public void dibujar(Graphics g) {
		g.setColor(Color.RED);
		
		g.fillRect(posX, posY, ancho, alto);

	}

	public ModeloFlyweightPulpo getModelo() {
		return modelo;
	}

	public void setModelo(ModeloFlyweightPulpo modelo) {
		this.modelo = modelo;
	}

}
