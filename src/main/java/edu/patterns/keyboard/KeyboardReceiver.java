package edu.patterns.keyboard;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import edu.patterns.gui.Game;

public final class KeyboardReceiver implements KeyListener {
    /**
    * The Command Invoker contains the possible commands the game supports.
    */
    private CommandInvoker invoker = new CommandInvoker();

    /**
    * Constructor for the Keyboard Receiver, adds the Key Listener to the
    * Canvas object.
    * @param game The Canvas object that represents the game.
    */
    public KeyboardReceiver(final Game game) {
        game.addKeyListener(this);
    }

    /**
    * Invoked when a key has been pressed.
    * @param ke An event which indicates that a keystroke occurred.
    */
    @Override
    public void keyPressed(final KeyEvent ke) {
        invoker.invoke(ke, true);
    }

    /**
    * Invoked when a key has been released.
    * @param ke An event which indicates that a keystroke occurred.
    */
    @Override
    public void keyReleased(final KeyEvent ke) {
        invoker.invoke(ke, false);
    }

    /**
    * Invoked when a key has been typed.
    * @param ke An event which indicates that a keystroke occurred.
    */
    @Override
    public void keyTyped(final KeyEvent ke) {

    }

    /**
    * Obtains the Left command.
    * @return Left command.
    */
    public KeyCommand getLeft() {
        return invoker.getLeft();
    }

    /**
    * Obtains the Right command.
    * @return Right command.
    */
    public KeyCommand getRight() {
        return invoker.getRight();
    }

    /**
    * Obtains the Shoot command.
    * @return Shoot command.
    */
    public KeyCommand getShoot() {
        return invoker.getShoot();
    }

    /**
    * Obtains the Pause command.
    * @return Pause command.
    */
    public KeyCommand getPause() {
        return invoker.getPause();
    }
}
