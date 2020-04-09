package edu.patrones.imagen;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import edu.patrones.intefaces.IModeloFlyweight;

public class PulpoFlyweight implements IModeloFlyweight {

	private BufferedImage imagenA;
	private BufferedImage imagenB;
	
	public PulpoFlyweight() {
		try {
			imagenA = ImageIO.read(new File("res/pul0.png"));
			imagenB = ImageIO.read(new File("res/pul1.png"));
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
