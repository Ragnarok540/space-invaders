package edu.patrones.imagen;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import edu.patrones.intefaces.IModeloFlyweight;

public class BalaFlyweight implements IModeloFlyweight {

	private BufferedImage imagenA;
	private BufferedImage imagenB;
	
	public BalaFlyweight() {
		try {
			imagenA = ImageIO.read(new File("res/missile.png"));
			imagenB = ImageIO.read(new File("res/laser.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	
	@Override
	public BufferedImage getImagenA() {
		return imagenA;
	}

	@Override
	public BufferedImage getImagenB() {
		return imagenB;
	}

}