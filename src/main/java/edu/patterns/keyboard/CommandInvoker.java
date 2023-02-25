package edu.patterns.keyboard;

import java.awt.event.KeyEvent;

public class CommandInvoker {

	private KeyCommand left = new KeyCommand();
	private KeyCommand right = new KeyCommand();
	private KeyCommand shoot = new KeyCommand();
	private KeyCommand pause = new KeyCommand();

	public void invoke(KeyEvent ke, boolean pressed) {
		if (ke.getKeyCode() == KeyEvent.VK_NUMPAD4) left.execute(pressed);
		if (ke.getKeyCode() == KeyEvent.VK_A) left.execute(pressed);
		if (ke.getKeyCode() == KeyEvent.VK_LEFT) left.execute(pressed);
		if (ke.getKeyCode() == KeyEvent.VK_NUMPAD6) right.execute(pressed);
		if (ke.getKeyCode() == KeyEvent.VK_D) right.execute(pressed);
		if (ke.getKeyCode() == KeyEvent.VK_RIGHT) right.execute(pressed);
		if (ke.getKeyCode() == KeyEvent.VK_SPACE) shoot.execute(pressed);
		if (ke.getKeyCode() == KeyEvent.VK_ENTER) pause.execute(pressed);
		if (ke.getKeyCode() == KeyEvent.VK_P) pause.execute(pressed);
	}

	public KeyCommand getLeft() {
		return left;
	}

	public KeyCommand getRight() {
		return right;
	}

	public KeyCommand getShoot() {
		return shoot;
	}

	public KeyCommand getPause() {
		return pause;
	}

}
