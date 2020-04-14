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
	
	@Override
	public String getNickName() {
		return nickname;
	}

	@Override
	public String getNombre() {
		return nombre;
	}

	@Override
	public int getPuntajeMaximo() {
		return puntuacionMaxima;
	}

	@Override
	public void setPuntuacionMaxima(int puntuacionMaxima) {
		if (puntuacionMaxima > this.puntuacionMaxima) {
			this.puntuacionMaxima = puntuacionMaxima;
		}
	}

	@Override
    public JugadorMemento guardarJugador() {
        return new JugadorMemento(nickname, nombre, puntuacionMaxima + "");
    }

    @Override
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
