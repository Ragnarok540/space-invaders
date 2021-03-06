package edu.patrones.modelo;

import java.awt.Graphics;
import java.awt.Rectangle;

import edu.patrones.imagen.FlyweightModel;

public abstract class Entity {

	protected int posX, posY, width, height;

	protected FlyweightModel model;

	protected boolean eliminated = false;

	public abstract void instant();

	public abstract void draw(Graphics g);

	public abstract void move(String d);

	public void eliminate() {
		eliminated = true;
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

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public FlyweightModel getModel() {
		return model;
	}

	public void setModel(FlyweightModel model) {
		this.model = model;
	}

	public boolean isEliminated() {
		return eliminated;
	}

	public Rectangle getRectangle() {
		return new Rectangle(posX, posY, width, height);
	}

}
