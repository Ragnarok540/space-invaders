package edu.patrones.modelo;

import edu.patrones.intefaces.IBala;

public class Bala extends Entidad implements IBala {

	boolean tipo;
	int posX;
	int posY;
	private ModeloFlyweightBala modelo;
	
	public Bala(boolean tipo, int posX, int posY) {
		super();
		this.tipo = tipo;
		this.posX = posX;
		this.posY = posY;
	}

	public boolean isTipo() {
		return tipo;
	}

	public void setTipo(boolean tipo) {
		this.tipo = tipo;
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

	public ModeloFlyweightBala getModelo() {
		return modelo;
	}

	public void setModelo(ModeloFlyweightBala modelo) {
		this.modelo = modelo;
	}
	
	@Override
	public void instante() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dibujar() {
		// TODO Auto-generated method stub

	}

	@Override
	public void mover(String direccion) {
		// TODO Auto-generated method stub

	}

	@Override
	public IBala clonar() {
		// TODO Auto-generated method stub
		Bala bala = null;

		try {
			bala = (Bala) clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}

		return bala;

	}
	
}
