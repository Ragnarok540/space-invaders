package edu.patrones.modelo;

import java.awt.Color;
import java.awt.Graphics;

public class Cangrejo extends Enemigo {

	private CangrejoFlyweight modelo;
	
	public Cangrejo() {
		super();
		super.puntaje = 20;
	}

	@Override
	public void dibujar(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(posX, posY, ancho, alto);
	}

	public CangrejoFlyweight getModelo() {
		return modelo;
	}

	public void setModelo(CangrejoFlyweight modelo) {
		this.modelo = modelo;
	}

}
