package edu.patterns.model;

import java.awt.Graphics;

public abstract class Ship extends Entity {

    @Override
    public abstract void instant();

    @Override
    public abstract void draw(Graphics g);

    @Override
    public abstract void move(String direccion);

    public void destroy() {
        super.eliminate();
    }

}
