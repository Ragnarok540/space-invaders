package edu.patrones.modelo;

import java.awt.Graphics;

public abstract class Enemigo extends Nave {
	
	protected int velocidad = 10;
	protected int puntaje;
	private int acumulador = 0;
	private boolean dir = true;
	private int acumuladorVelocidad = 0;
	private boolean gameOver = false;
	protected boolean estado = true; 
	
	public Enemigo() {
		ancho = 32;
		alto = 22;
	}
	
	@Override
	public void instante() {
		acumuladorVelocidad++;
		
		if (acumuladorVelocidad < velocidad) {
			return;
		}
		
		mover(null);
		estado = !estado;
		
		acumuladorVelocidad = 0;
	}

	@Override
	public void dibujar(Graphics g) {
		if (estado) {
			g.drawImage(model.getSprites()[0], posX, posY, null);
		} else {
			g.drawImage(model.getSprites()[1], posX, posY, null);
		}
	}

	@Override
	public void mover(String direccion)	{
		if (dir) {
			acumulador++;
			
			posX += 5;
			
			if (acumulador > 15) {
				posY += 5;
				acumulador = 0;
				dir = false;
			}
			
		} else {
			acumulador--;
			
			posX -= 5;
			
			if (acumulador < -15) {
				posY += 5;
				acumulador = 0;
				dir = true;
			}
			
		}
		
		if (posY > (330 - alto)) {
			gameOver = true;
		}
	}

	public int getPuntaje() {
		return puntaje;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}
	
	public boolean isGameOver() {
		return gameOver;
	}
	
}
