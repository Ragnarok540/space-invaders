package edu.patrones.jugador;

import edu.patrones.intefaces.IJugadorNullObject;

public class Jugador implements IJugadorNullObject {
	
	private String nickname;
	private String nombre;
	private int puntuacionMaxima;

	public Jugador(String nickname, String nombre) {
		super();
		this.nickname = nickname;
		this.nombre = nombre;
		this.puntuacionMaxima = 0;
	}

	public Jugador() {

	}

	public String getNickName() {
		return nickname;
	}

	public String getNombre() {
		return nombre;
	}

	public int getPuntajeMaximo() {
		return puntuacionMaxima;
	}

	public void setPuntuacionMaxima(int puntuacionMaxima) {
		if (puntuacionMaxima > this.puntuacionMaxima) {
			this.puntuacionMaxima = puntuacionMaxima;
		}
	}

    public JugadorMemento guardarJugador() {
        return new JugadorMemento(nickname, nombre, puntuacionMaxima + "");
    }

    public void abrirJugador(JugadorMemento jugadorMemento) {
		this.nickname = jugadorMemento.getNickname();
		this.nombre = jugadorMemento.getNombre();
		this.puntuacionMaxima = Integer.parseInt(jugadorMemento.getPuntuacionMaxima());
    }

	@Override
	public boolean isNull() {
		
		return false;
	}

	
	
}
