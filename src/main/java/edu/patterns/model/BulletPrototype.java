package edu.patterns.model;

import java.awt.Graphics;

import edu.patterns.interfaces.IBulletPrototype;

public class BulletPrototype extends Entity implements IBulletPrototype {

    private boolean type;

    public BulletPrototype() {
        width = 11;
        height = 17;
    }

    public boolean isType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }

    @Override
    public void instant() {
        move(null);
    }

    @Override
    public void draw(Graphics g) {
        if (type) {
            g.drawImage(model.getSprites()[0], posX, posY, null);
        } else {
            g.drawImage(model.getSprites()[1], posX, posY, null);
        }
    }

    @Override
    public void move(String d) {
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
