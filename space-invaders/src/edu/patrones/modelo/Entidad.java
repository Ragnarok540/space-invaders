package edu.patrones.modelo;

public abstract class Entidad {

	protected int posX, posY, radio, velocidad;
	
	protected boolean eliminada = false;
	
	public abstract void instante();
	
	public abstract void dibujar();
	
	public abstract void mover(String direccion);
	
	public boolean colision(int x0, int y0, int x1, int y1) {
		return !(posX + radio < x0 || 
				 posY + radio < y0 || 
				 posX - radio > x1 || 
				 posY - radio > y1);
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

	public int getRadio() {
		return radio;
	}

	public void setRadio(int radio) {
		this.radio = radio;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	public boolean isEliminada() {
		return eliminada;
	}
	
}
