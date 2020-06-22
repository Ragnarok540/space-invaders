package edu.patrones.modelo;

import java.awt.Graphics;

public class NaveJugadorSingleton extends Nave {

	private int vidas = 3;
	private static NaveJugadorSingleton naveJugador = null;
	
	private NaveJugadorSingleton() {
		posX = 230;
		posY = 330;
		ancho = 35;
		alto = 19;
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
		
	}

	@Override
	public void dibujar(Graphics g) {
		g.drawImage(model.getSprites()[0], posX, posY, null);
	}

	@Override
	public void mover(String direccion) {
		
		switch (direccion) {
		case "D":
			if (posX < 440) {
				posX += 1;
			}
			break;
		case "I":
			if (posX > 5) {
				posX -= 1;
			}
			break;
		default:
		}

	}

	public void herir() {
		if (vidas > 1) {
			vidas--;
		} else {
			super.destruir();
		}
	}
	
	public void restaurar() {
		vidas = 3;
		eliminada = false;
	}

	public int getVidas() {
		return vidas;
	}
	
}
