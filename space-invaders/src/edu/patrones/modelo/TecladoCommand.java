package edu.patrones.modelo;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

public class TecladoCommand implements KeyListener{

	
	public class Key {
		public int presses, absorbs;
		public boolean down, clicked;

		public Key() {
			keys.add(this);
		}

		public void toggle(boolean pressed) {
			if (pressed != down) {
				down = pressed;
			}
			if (pressed) {
				presses++;
			}
		}

		public void tick() {
			if (absorbs < presses) {
				absorbs++;
				clicked = true;
			} else {
				clicked = false;
			}
		}
	}

	public List<Key> keys = new ArrayList<Key>();


	public Key left = new Key();
	public Key right = new Key();
	public Key attack = new Key();
	public Key pause = new Key();

	public void releaseAll() {
		for (int i = 0; i < keys.size(); i++) {
			keys.get(i).down = false;
		}
	}

	public void tick() {
		for (int i = 0; i < keys.size(); i++) {
			keys.get(i).tick();
		}
	}

	/*public TecladoCommand(Game game) {
		game.addKeyListener(this);
	}*///Pendiente de implementación

	public void keyPressed(KeyEvent ke) {
		toggle(ke, true);
	}

	public void keyReleased(KeyEvent ke) {
		toggle(ke, false);
	}
	
	
	public void moverDerecha() {
		
	}
	
	public void moverIzquierda() {
		
	}
	
	public void disparar() {
		
	}
	
	public void pausar() {
		
	}

	private void toggle(KeyEvent ke, boolean pressed) {
	
		if (ke.getKeyCode() == KeyEvent.VK_NUMPAD4) left.toggle(pressed);
		if (ke.getKeyCode() == KeyEvent.VK_NUMPAD6) right.toggle(pressed);
		if (ke.getKeyCode() == KeyEvent.VK_A) left.toggle(pressed);
		if (ke.getKeyCode() == KeyEvent.VK_D) right.toggle(pressed);
		if (ke.getKeyCode() == KeyEvent.VK_LEFT) left.toggle(pressed);
		if (ke.getKeyCode() == KeyEvent.VK_RIGHT) right.toggle(pressed);
	    if (ke.getKeyCode() == KeyEvent.VK_SPACE) attack.toggle(pressed);
		if (ke.getKeyCode() == KeyEvent.VK_ENTER) pause.toggle(pressed);
		if (ke.getKeyCode() == KeyEvent.VK_C) attack.toggle(pressed);
	}



	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
