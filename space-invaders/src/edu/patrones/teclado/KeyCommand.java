package edu.patrones.teclado;

public class KeyCommand {

	private boolean down = false;

	public void execute(boolean pressed) {
		if (pressed != down) {
			down = pressed;
		}
	}

	public boolean isDown() {
		return down;
	}

}
