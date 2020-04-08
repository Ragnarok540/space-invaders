package edu.patrones.jugador;

public class JugadorEdgar {
	
	private String nickname;
	private String nombre;
	private int puntuacionMaxima;

	public JugadorEdgar(String nickname, String nombre) {
		super();
		this.nickname = nickname;
		this.nombre = nombre;
		this.puntuacionMaxima = 0;
	}

	public JugadorEdgar() {

	}

	public String getNickname() {
		return nickname;
	}

	public String getNombre() {
		return nombre;
	}

	public int getPuntuacionMaxima() {
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
	
}