package edu.patrones.modelo;

public class NaveJugador extends Nave {

	private int vidas = 3;
	private NaveJugador navejugador = null;
	
	private NaveJugador() {
		
	}
	
	public NaveJugador instancia() {
		if (navejugador != null) {
			return navejugador;
		} else {
			navejugador = new NaveJugador();
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
