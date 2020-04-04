package edu.patrones.modelo;

import java.awt.Color;
import java.awt.Graphics;

public class Calamar extends Enemigo {
		
	private CalamarFlyweight modelo;
	
	public Calamar() {
		super();
		super.puntaje = 30;
	}

	@Override
	public void dibujar(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillRect(posX, posY, ancho, alto);
	}

	public CalamarFlyweight getModelo() {
		return modelo;
	}

	public void setModelo(CalamarFlyweight modelo) {
		this.modelo = modelo;
	}

}
