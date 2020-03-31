package edu.patrones.modelo;

public abstract class Entidad {

	protected int posX, posY, alto, ancho;
	
	protected boolean eliminada = false;
	
	public abstract void instante();
	
	public abstract void dibujar();
	
	public abstract void mover(String direccion);
	
	public boolean colision(int x0, int y0, int x1, int y1) {
		return !(posX + ancho < x0 || 
				 posY + alto  < y0 || 
				 posX - ancho > x1 || 
				 posY - alto  > y1);
	}
	
	public void eliminar() {
		eliminada = true;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}
	
	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		this.alto = alto;
	}

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public boolean isEliminada() {
		return eliminada;
	}
	
}
