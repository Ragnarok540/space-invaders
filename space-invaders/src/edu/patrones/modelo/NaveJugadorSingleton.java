package edu.patrones.modelo;

public class NaveJugadorSingleton extends Nave {

	private int vidas = 3;
	private NaveJugadorSingleton navejugador = null;
	
	private NaveJugadorSingleton() {
		
	}
	
	public NaveJugadorSingleton instancia() {
		if (navejugador != null) {
			return navejugador;
		} else {
			navejugador = new NaveJugadorSingleton();
			return navejugador;
		}
	}
	
	@Override
	public void instante() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dibujar() {
		// TODO Auto-generated method stub

	}

	@Override
	public void mover(String direccion) {
		// TODO Auto-generated method stub

	}

	public void herir() {
		if (vidas > 0) {
			vidas--;
		} else {
			super.destruir();
		}
	}
	
	public void restaurar() {
		vidas = 3;
	}

	public int getVidas() {
		return vidas;
	}
	
}
