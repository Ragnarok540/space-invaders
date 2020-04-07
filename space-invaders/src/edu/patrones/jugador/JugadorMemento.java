package edu.patrones.jugador;

public class JugadorMemento {

	private String nickname;
	private String nombre;
	private String puntuacionMaxima;

	public JugadorMemento(String nickname, String nombre, String puntuacionMaxima) {
		super();
		this.nickname = nickname;
		this.nombre = nombre;
		this.puntuacionMaxima = puntuacionMaxima;
	}

	public String getNickname() {
		return nickname;
	}

	public String getNombre() {
		return nombre;
	}

	public String getPuntuacionMaxima() {
		return puntuacionMaxima;
	}
	
}
