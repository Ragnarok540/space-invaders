package edu.patrones.teclado;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import edu.patrones.vista.Game;

public class KeyboardReceiver implements KeyListener {

	private CommandInvoker invoker = new CommandInvoker();

	public KeyboardReceiver(Game juego) {
		juego.addKeyListener(this);
	}

	@Override
	public void keyPressed(KeyEvent ke) {
		invoker.invoke(ke, true);
	}

	@Override
	public void keyReleased(KeyEvent ke) {
		invoker.invoke(ke, false);
	}

	@Override
	public void keyTyped(KeyEvent ke) {

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
