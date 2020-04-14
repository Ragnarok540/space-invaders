package edu.patrones.jugador;

import edu.patrones.intefaces.*;

public class JugadorNull implements IJugadorNullObject{

	@Override
	public boolean isNull() {
		
		return true;
	}

	@Override
	public String getNombre() {
		
		return "El jugador no existe";
	}

	@Override
	public String getNickName() {
		
		return "El jugador no existe";
	}

	@Override
	public int getPuntajeMaximo() {
		
		return -1;
	}

	@Override
	public void abrirJugador(JugadorMemento jugadorMemento) {
		// TODO Auto-generated method stub
		
	}

}
