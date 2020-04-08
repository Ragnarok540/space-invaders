package edu.patrones.teclado;

import java.awt.event.KeyEvent;

public class MovimientoInvoker {
	
	private MoverIzquierdaCommand izq = new MoverIzquierdaCommand();
	private MoverDerechaCommand der = new MoverDerechaCommand();
	private DispararCommand dis = new DispararCommand();
	private PausarCommand pau = new PausarCommand();
	
	public void invoke(KeyEvent ke, boolean pressed) {
		if (ke.getKeyCode() == KeyEvent.VK_NUMPAD4) izq.execute(pressed);
		if (ke.getKeyCode() == KeyEvent.VK_A) izq.execute(pressed);
		if (ke.getKeyCode() == KeyEvent.VK_LEFT) izq.execute(pressed);
		if (ke.getKeyCode() == KeyEvent.VK_NUMPAD6) der.execute(pressed);
		if (ke.getKeyCode() == KeyEvent.VK_D) der.execute(pressed);
		if (ke.getKeyCode() == KeyEvent.VK_RIGHT) der.execute(pressed);
	    if (ke.getKeyCode() == KeyEvent.VK_SPACE) dis.execute(pressed);
		if (ke.getKeyCode() == KeyEvent.VK_ENTER) pau.execute(pressed);
		if (ke.getKeyCode() == KeyEvent.VK_P) pau.execute(pressed);
	}

	public MoverIzquierdaCommand getIzq() {
		return izq;
	}

	public MoverDerechaCommand getDer() {
		return der;
	}

	public DispararCommand getDis() {
		return dis;
	}
	
	public PausarCommand getPau() {
		return pau;
	}
	
}
