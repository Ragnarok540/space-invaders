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
		
		int posX = 5;
		int posY = 5;
		int tipo = 0;
		
		for (int i = 5; i > 0; i--) {
			for (int j = 0; j < 10; j++) {
				if (i == 5) {
					tipo = 3;
				} else if (i == 4 || i == 3) {
					tipo = 2;
				} else if (i == 2 || i == 1) {
					tipo = 1;
				}
				enemigo = fabrica.crearEnemigo(tipo);
				enemigo.setPosX(posX);
				enemigo.setPosY(posY);
				entidades.add(enemigo);
				posX += 40;
			} 
			posX = 5;
			posY += 30;
		}
		
	}
	
	public ArrayList<Entidad> getEntidades() {
		return entidades;
	}

	public NaveJugadorSingleton getNaveJugador() {
		return naveJugador;
	}
	
}
