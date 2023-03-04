package edu.patterns.keyboard;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import edu.patterns.gui.Game;

public final class KeyboardReceiver implements KeyListener {
    private CommandInvoker invoker = new CommandInvoker();

    public KeyboardReceiver(final Game juego) {
        juego.addKeyListener(this);
    }

    @Override
    public void keyPressed(final KeyEvent ke) {
        invoker.invoke(ke, true);
    }

    @Override
    public void keyReleased(final KeyEvent ke) {
        invoker.invoke(ke, false);
    }

    @Override
    public void keyTyped(final KeyEvent ke) {

    }

    public KeyCommand getLeft() {
        return invoker.getLeft();
    }

    public KeyCommand getRight() {
        return invoker.getRight();
    }

    public KeyCommand getShoot() {
        return invoker.getShoot();
    }

    public KeyCommand getPause() {
        return invoker.getPause();
    }
}
