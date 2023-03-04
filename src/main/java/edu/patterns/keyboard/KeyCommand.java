package edu.patterns.keyboard;

public final class KeyCommand {
    private boolean down = false;

    public void execute(final boolean pressed) {
        if (pressed != down) {
            down = pressed;
        }
    }

    public boolean isDown() {
        return down;
    }
}
