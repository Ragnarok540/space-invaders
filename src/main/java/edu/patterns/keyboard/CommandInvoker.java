package edu.patterns.keyboard;

import java.awt.event.KeyEvent;

public final class CommandInvoker {
    /**
    * Left command.
    */
    private KeyCommand left = new KeyCommand();
    /**
    * Right command.
    */
    private KeyCommand right = new KeyCommand();
    /**
    * Shoot command.
    */
    private KeyCommand shoot = new KeyCommand();
    /**
    * Pause command.
    */
    private KeyCommand pause = new KeyCommand();

    /**
    * The Invoke method, executes the corresponding command depending on what
    * button was pressed or released.
    * @param ke An event which indicates that a keystroke occurred.
    * @param pressed True if the key was pressed, False if it was released.
    */
    public void invoke(final KeyEvent ke, final boolean pressed) {
        if (ke.getKeyCode() == KeyEvent.VK_NUMPAD4) {
            left.execute(pressed);
        }

        if (ke.getKeyCode() == KeyEvent.VK_A) {
            left.execute(pressed);
        }

        if (ke.getKeyCode() == KeyEvent.VK_LEFT) {
            left.execute(pressed);
        }

        if (ke.getKeyCode() == KeyEvent.VK_NUMPAD6) {
            right.execute(pressed);
        }

        if (ke.getKeyCode() == KeyEvent.VK_D) {
            right.execute(pressed);
        }

        if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
            right.execute(pressed);
        }

        if (ke.getKeyCode() == KeyEvent.VK_SPACE) {
            shoot.execute(pressed);
        }

        if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
            pause.execute(pressed);
        }

        if (ke.getKeyCode() == KeyEvent.VK_P) {
            pause.execute(pressed);
        }
    }

    /**
    * Obtains the Left command.
    * @return Left command.
    */
    public KeyCommand getLeft() {
        return left;
    }

    /**
    * Obtains the Right command.
    * @return Right command.
    */
    public KeyCommand getRight() {
        return right;
    }

    /**
    * Obtains the Shoot command.
    * @return Shoot command.
    */
    public KeyCommand getShoot() {
        return shoot;
    }

    /**
    * Obtains the Pause command.
    * @return Pause command.
    */
    public KeyCommand getPause() {
        return pause;
    }
}
