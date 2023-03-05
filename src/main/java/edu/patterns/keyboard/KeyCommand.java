package edu.patterns.keyboard;

public final class KeyCommand {
    /**
    * The state of the command. By default, a key is not pressed.
    */
    private boolean down = false;

    /**
    * Executes the command, if the key is pressed it remanins pressed until it
    * is released.
    * @param pressed True if the key was pressed, False if it was released.
    */
    public void execute(final boolean pressed) {
        if (pressed != down) {
            down = pressed;
        }
    }

    /**
    * The state of the command. By default, a key is not pressed.
    * @return True if the key is pressed, False if it is released.
    */
    public boolean isDown() {
        return down;
    }
}
