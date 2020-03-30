package edu.patrones.modelo;

public abstract class Nave extends Entidad {
	int posX;
	int posY;
	int alto;
	int ancho;
	String ruta;
	boolean vida;
	
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

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public boolean isVida() {
		return vida;
	}

	public void setVida(boolean vida) {
		this.vida = vida;
	}
	

	@Override
	public abstract void instante();

	@Override
	public abstract void dibujar();

	@Override
	public abstract void mover(String direccion);

	public void destruir() {
		super.eliminar();
	}
	
}
