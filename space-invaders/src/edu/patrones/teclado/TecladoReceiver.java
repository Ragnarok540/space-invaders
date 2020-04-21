package edu.patrones.teclado;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import edu.patrones.vista.Juego;

public class TecladoReceiver implements KeyListener {

	private MovimientoInvoker invocador = new MovimientoInvoker();
	
	public TecladoReceiver(Juego juego) {
		juego.addKeyListener(this);
	}

	public void keyPressed(KeyEvent ke) {
		invocador.invoke(ke, true);
	}

	public void keyReleased(KeyEvent ke) {
		invocador.invoke(ke, false);
	}

	@Override
	public void keyTyped(KeyEvent ke) {

	}

	public MoverIzquierdaCommand getIzq() {
		return invocador.getIzq();
	}

	public MoverDerechaCommand getDer() {
		return invocador.getDer();
	}

	public DispararCommand getDis() {
		return invocador.getDis();
	}
	
	public PausarCommand getPau() {
		return invocador.getPau();
	}
	
}
