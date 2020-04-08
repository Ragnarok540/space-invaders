package edu.patrones.teclado;

import edu.patrones.intefaces.IMovimientoCommand;

public class MoverDerechaCommand implements IMovimientoCommand {

	private boolean down = false;

	@Override
	public void execute(boolean pressed) {
		if (pressed != down) {
			down = pressed;
		}
	}

	@Override
	public boolean isDown() {
		return down;
	}

}
