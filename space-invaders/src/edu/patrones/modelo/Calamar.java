package edu.patrones.modelo;

import java.awt.Color;
import java.awt.Graphics;

public class Calamar extends Enemigo {
		
	private ModeloFlyweightCalamar modelo;
	
	public Calamar() {
		super();
		super.puntaje = 30;
	}

	@Override
	public void dibujar(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillRect(posX, posY, ancho, alto);
	}

	public ModeloFlyweightCalamar getModelo() {
		return modelo;
	}

	public void setModelo(ModeloFlyweightCalamar modelo) {
		this.modelo = modelo;
	}

}
