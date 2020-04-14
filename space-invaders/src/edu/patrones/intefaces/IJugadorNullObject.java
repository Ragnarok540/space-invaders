package edu.patrones.intefaces;

import edu.patrones.jugador.JugadorMemento;

public interface IJugadorNullObject {

	public boolean isNull();
	
	public String getNombre();
	
	public String getNickName();
	
	public int getPuntajeMaximo();
	
	public void abrirJugador(JugadorMemento jugadorMemento);
	
	public JugadorMemento guardarJugador();
	
	public void setPuntuacionMaxima(int puntuacionMaxima);
	
}
