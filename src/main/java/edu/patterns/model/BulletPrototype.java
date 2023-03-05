package edu.patterns.model;

import java.awt.Graphics;

import java.util.ArrayList;

import edu.patterns.interfaces.IBulletPrototype;

public final class BulletPrototype extends Entity implements IBulletPrototype {
    private boolean type;

    public BulletPrototype() {
        super();
        super.width = 11;
        super.height = 17;
        super.name = "bullet";
        ArrayList<String> pathsArray = new ArrayList<>();
        pathsArray.add("res/sprites/missile.png");
        pathsArray.add("res/sprites/laser.png");
        super.paths = pathsArray;
    }

    public boolean isType() {
        return type;
    }

    public void setType(final boolean type) {
        this.type = type;
    }

    @Override
    public void instant() {
        move(null);
    }

    @Override
    public void draw(final Graphics g) {
        if (type) {
            g.drawImage(model.getSprites()[0], posX, posY, null);
        } else {
            g.drawImage(model.getSprites()[1], posX, posY, null);
        }
    }

    @Override
    public void move(final String d) {
        if (type) {
            posY--;
        } else {
            posY++;
        }
    }

    @Override
    public IBulletPrototype cloneBullet() {
        BulletPrototype bullet = null;

        try {
            bullet = (BulletPrototype) clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return bullet;
    }
}
