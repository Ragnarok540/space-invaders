package edu.patrones.modelo;

import javax.swing.ImageIcon;

import edu.patrones.intefaces.IModeloFlyweight;

public class CangrejoFlyweight implements IModeloFlyweight {

	private ImageIcon imagenA;
	private ImageIcon imagenB;
	
	@Override
	public ImageIcon getImagenA() {
		return imagenA;
	}

	@Override
	public ImageIcon getImagenB() {
		return imagenB;
	}

	@Override
	public void setImagenA(ImageIcon imagenA) {
		this.imagenA = imagenA;
	}

	@Override
	public void setImagenB(ImageIcon imagenB) {
		this.imagenB = imagenB;
	}

}
