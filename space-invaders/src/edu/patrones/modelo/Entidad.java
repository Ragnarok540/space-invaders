package edu.patrones.modelo;

import java.awt.Graphics;
import java.awt.Rectangle;

import edu.patrones.intefaces.IModeloFlyweight;

public abstract class Entidad {

	protected int posX, posY, alto, ancho;
	
	protected IModeloFlyweight modelo;
	
	protected boolean eliminada = false;
	
	public abstract void instante();
	
	public abstract void dibujar(Graphics g);
	
	public abstract void mover(String direccion);
	
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

	public IModeloFlyweight getModelo() {
		return modelo;
	}
	
	public void setModelo(IModeloFlyweight modelo) {
		this.modelo = modelo;
	}
	
	public boolean isEliminada() {
		return eliminada;
	}
	
    public Rectangle getRectangulo() {
        return new Rectangle(posX, posY, ancho, alto);
    }
	
}
