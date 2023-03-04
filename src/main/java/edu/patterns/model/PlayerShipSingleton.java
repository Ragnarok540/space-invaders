package edu.patterns.model;

import java.awt.Graphics;

public final class PlayerShipSingleton extends Ship {
    private int lives = 3;
    private static PlayerShipSingleton playerShip = null;

    private PlayerShipSingleton() {
        posX = 230;
        posY = 330;
        width = 35;
        height = 19;
    }

    public static PlayerShipSingleton instance() {
        if (playerShip != null) {
            return playerShip;
        } else {
            playerShip = new PlayerShipSingleton();
            return playerShip;
        }
    }

    @Override
    public void instant() {

    }

    @Override
    public void draw(final Graphics g) {
        g.drawImage(model.getSprites()[0], posX, posY, null);
    }

    @Override
    public void move(final String d) {
        switch (d) {
        case "D":
            if (posX < 440) {
                posX += 1;
            }
            break;
        case "I":
            if (posX > 5) {
                posX -= 1;
            }
            break;
        default:
        }
    }

    public void hurt() {
        if (lives > 1) {
            lives--;
        } else {
            super.destroy();
        }
    }

    public void restore() {
        lives = 3;
        eliminated = false;
    }

    public int getLives() {
        return lives;
    }
}
