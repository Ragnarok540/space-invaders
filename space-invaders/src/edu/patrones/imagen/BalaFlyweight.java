package edu.patrones.imagen;

import java.awt.image.BufferedImage;

import edu.patrones.intefaces.IModeloFlyweight;

public class BalaFlyweight implements IModeloFlyweight {

	private BufferedImage imagenA;
	private BufferedImage imagenB;
	
	@Override
	public BufferedImage getImagenA() {
		return imagenA;
	}

	@Override
	public BufferedImage getImagenB() {
		return imagenB;
	}

}
