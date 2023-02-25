package edu.patterns.model;

import java.awt.Graphics;

public abstract class Enemy extends Ship {

    protected int velocity = 10;
    protected int score;
    private int acumulator = 0;
    private boolean direction = true;
    private int velocityAcumulator = 0;
    private boolean gameOver = false;
    protected boolean state = true; 

    public Enemy() {
        width = 32;
        height = 22;
    }

    @Override
    public void instant() {
        velocityAcumulator++;

        if (velocityAcumulator < velocity) {
            return;
        }

        move(null);
        state = !state;

        velocityAcumulator = 0;
    }

    @Override
    public void draw(Graphics g) {
        if (state) {
            g.drawImage(model.getSprites()[0], posX, posY, null);
        } else {
            g.drawImage(model.getSprites()[1], posX, posY, null);
        }
    }

    @Override
    public void move(String d)    {
        if (direction) {
            acumulator++;

            posX += 5;

            if (acumulator > 15) {
                posY += 5;
                acumulator = 0;
                direction = false;
            }

        } else {
            acumulator--;

            posX -= 5;

            if (acumulator < -15) {
                posY += 5;
                acumulator = 0;
                direction = true;
            }

        }

        if (posY > (330 - height)) {
            gameOver = true;
        }
    }

    public int getScore() {
        return score;
    }

    public int getVelocity() {
        return velocity;
    }

    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }

    public boolean isGameOver() {
        return gameOver;
    }

}
