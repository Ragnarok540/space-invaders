package edu.patterns.model;

import java.awt.Graphics;
import java.awt.Rectangle;

import java.util.ArrayList;

import edu.patterns.image.FlyweightModel;

public abstract class Entity {

    /*
    * The position in the X axis of the Entity in the 2D plane.
    */
    protected int posX;

    /*
    * The position in the Y axis of the Entity in the 2D plane.
    */
    protected int posY;

    /*
    * The size in the X axis of the Entity in the 2D plane.
    */
    protected int width;

    /*
    * The size in the Y axis of the Entity in the 2D plane.
    */
    protected int height;

    /*
    * The Flyweight Model of the Entity, contains its sprites.
    */
    protected FlyweightModel model;

    /*
    * True if the entity is marked for deletion, False by default.
    */
    protected boolean eliminated = false;

    /*
    * The name of the Entity.
    */
    protected String name;

    /*
    * The paths to the sprites of the Entity.
    */
    protected ArrayList<String> paths;

    /*
    * Method that gets called every instant for the Entity.
    */
    public abstract void instant();

    /*
    * Method that draws the Entity in the 2D plane.
    */
    public abstract void draw(Graphics g);

    /*
    * Method that describes the movement of the Entity in the 2D plane.
    */
    public abstract void move(String d);

    /*
    * Method that marks the Entity for deletion.
    */
    public void eliminate() {
        eliminated = true;
    }

    /*
    * Method to obtain the position in the X axis of the Entity in the 2D plane.
    */
    public int getPosX() {
        return posX;
    }

    /*
    * Method to set the position in the X axis of the Entity in the 2D plane.
    */
    public void setPosX(final int posX) {
        this.posX = posX;
    }

    /*
    * Method to obtain the position in the Y axis of the Entity in the 2D plane.
    */
    public int getPosY() {
        return posY;
    }

    /*
    * Method to set the position in the Y axis of the Entity in the 2D plane.
    */
    public void setPosY(final int posY) {
        this.posY = posY;
    }

    /*
    * Method to obtain the size in the X axis of the Entity in the 2D plane.
    */
    public int getWidth() {
        return width;
    }

    /*
    * Method to set the size in the X axis of the Entity in the 2D plane.
    */
    public void setWidth(final int width) {
        this.width = width;
    }

    /*
    * Method to obtain the size in the Y axis of the Entity in the 2D plane.
    */
    public int getHeight() {
        return height;
    }

    /*
    * Method to set the size in the Y axis of the Entity in the 2D plane.
    */
    public void setHeight(final int height) {
        this.height = height;
    }

    /*
    * Method to obtain the Flyweight Model of the Entity.
    */
    public FlyweightModel getModel() {
        return model;
    }

    /*
    * Method to set the Flyweight Model of the Entity.
    */
    public void setModel(final FlyweightModel model) {
        this.model = model;
    }

    /*
    * Method to obtain the name of the Entity.
    */
    public String getName() {
        return name;
    }

    /*
    * Method to set the name of the Entity.
    */
    public void setName(final String name) {
        this.name = name;
    }

    /*
    * Method to obtain the paths to the sprites of the Entity.
    */
    public ArrayList<String> getPaths() {
        return paths;
    }

    /*
    * Method to set the paths to the sprites of the Entity.
    */
    public void setPaths(final ArrayList<String> paths) {
        this.paths = paths;
    }

   /*
    * Method to check if the Entity is marked for deletion.
    */
    public boolean isEliminated() {
        return eliminated;
    }

    /*
    * Method to obtain the rectangle that contains the Entity.
    */
    public Rectangle getRectangle() {
        return new Rectangle(posX, posY, width, height);
    }
}
