package edu.patrones.modelo;

import java.awt.Color;
import java.awt.Graphics;

public class NaveJugadorSingleton extends Nave {

	private int vidas = 3;
	private static NaveJugadorSingleton naveJugador = null;
	
	private NaveJugadorSingleton() {
		posX = 240;
		posY = 300;
		ancho = 30;
		alto = 15;
	}
	
	public static NaveJugadorSingleton instancia() {
		if (naveJugador != null) {
			return naveJugador;
		} else {
			naveJugador = new NaveJugadorSingleton();
			return naveJugador;
		}
	}
	
	@Override
	public void instante() {
		
		mover("E");

	}

	@Override
	public void dibujar(Graphics g) {
		
		g.setColor(Color.GREEN);
		
		g.fillRect(posX, posY, ancho, alto);

	}

	@Override
	public void mover(String direccion) {
		
		switch (direccion) {
		case "E":
			posX += 1;
			break;
		case "W":
			posX -= 1;
			break;
		default:
			
		}

	}

	public void herir() {
		if (vidas > 0) {
			vidas--;
		} else {
			super.destruir();
		}
	}
	
	public void restaurar() {
		vidas = 3;
	}

	public int getVidas() {
		return vidas;
	}
	
}
