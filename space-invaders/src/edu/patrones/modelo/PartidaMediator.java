package edu.patrones.modelo;

import java.util.ArrayList;

public class PartidaMediator {

	private ArrayList<Entidad> entidades;
	private NaveJugadorSingleton naveJugador;
	
	public PartidaMediator() {
		entidades = new ArrayList<>();
		naveJugador = NaveJugadorSingleton.instancia();
		entidades.add(naveJugador);
		crearEnemigos();
	}

	private void crearEnemigos() {
		EnemigoFactoryMethod fabrica = new EnemigoFactoryMethod();
		
		Enemigo enemigo;
		
		int posX = 30;
		int posY = 30;
		
		// Crear Pulpos
		for(int i = 0; i < 10; i++) {
			enemigo = fabrica.crearEnemigo(1);
			enemigo.setPosX(posX);
			enemigo.setPosY(posY);
			entidades.add(enemigo);
			posX += 35;
		}
		
	}
	
	public ArrayList<Entidad> getEntidades() {
		return entidades;
	}

	public NaveJugadorSingleton getNaveJugador() {
		return naveJugador;
	}
	
}
