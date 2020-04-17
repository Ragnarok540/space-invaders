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
		g.drawImage(modelo.getImagenA(), posX, posY, null);
	}

	@Override
	public void mover(String direccion) {
		
		switch (direccion) {
		case "D":
			posX += 1;
			break;
		case "I":
			posX -= 1;
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
