package edu.patrones.intefaces;

import edu.patrones.jugador.JugadorMemento;

public interface IJugadorNullObject {

	public abstract boolean isNull();
	
	public abstract String getNombre();
	
	public abstract String getNickName();
	
	public abstract int getPuntajeMaximo();
	
	public abstract void abrirJugador(JugadorMemento jugadorMemento);
	
}
