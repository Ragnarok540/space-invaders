package edu.patrones.modelo;

import edu.patrones.intefaces.IBalaPrototype;

public class BalaPrototype extends Entidad implements IBalaPrototype {

	private boolean tipo;
	private ModeloFlyweightBala modelo;
	

	public boolean isTipo() {
		return tipo;
	}

	public void setTipo(boolean tipo) {
		this.tipo = tipo;
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
	public IBalaPrototype clonar() {

		BalaPrototype bala = null;

		try {
			bala = (BalaPrototype) clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}

		return bala;

	}
	
}
