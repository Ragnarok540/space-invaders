package edu.patterns.model;

import java.awt.Graphics;
import java.awt.Rectangle;

import edu.patterns.image.FlyweightModel;

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

    public void setPosX(final int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(final int posY) {
        this.posY = posY;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(final int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(final int height) {
        this.height = height;
    }

    public FlyweightModel getModel() {
        return model;
    }

    public void setModel(final FlyweightModel model) {
        this.model = model;
    }

    public boolean isEliminated() {
        return eliminated;
    }

    public Rectangle getRectangle() {
        return new Rectangle(posX, posY, width, height);
    }
}
