package edu.patrones.modelo;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class PartidaMediator {

	private ArrayList<Entidad> entidades;
	private NaveJugadorSingleton naveJugador;
	private BalaPrototype bala;
	
	public PartidaMediator() {
		entidades = new ArrayList<>();
		naveJugador = NaveJugadorSingleton.instancia();
		entidades.add(naveJugador);
		bala = new BalaPrototype();
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
	
	public void disparoJugador() {
		BalaPrototype balaClonada = (BalaPrototype) bala.clonar();
		balaClonada.setPosX(naveJugador.getPosX() + naveJugador.getAncho() / 2);
		balaClonada.setPosY(naveJugador.getPosY() - bala.getAlto() - 5);
		balaClonada.setTipo(true);
		entidades.add(balaClonada);
	}
	
	public void verificarColisionesEnemigos() {
		
		List<Entidad> balas = entidades.stream()
				.filter(x -> x instanceof BalaPrototype)
				.collect(Collectors.toList()); 
		
		List<Entidad> enemigos = entidades.stream()
				.filter(x -> x instanceof Enemigo)
				.collect(Collectors.toList()); 
		
		Rectangle r1;
		Rectangle r2;
		
		for (Entidad bala: balas) {
			
			BalaPrototype b = (BalaPrototype) bala;
			
			if (b.isEliminada() || b.isTipo() == false) continue;
			
			r1 = b.getRectangulo();
			
			for (Entidad enemigo: enemigos) {
				
				Enemigo e = (Enemigo) enemigo;
				
				if (e.isEliminada()) continue;
				
				r2 = e.getRectangulo();
				
				if (r1.intersects(r2)) {
					b.eliminar();
					e.destruir();
					System.out.println("colision enemigo!!!");
				}
				
			}
			
		}

	}
	
	public void verificarColisionesJugador() {
		
		List<Entidad> balas = entidades.stream()
				.filter(x -> x instanceof BalaPrototype)
				.collect(Collectors.toList()); 
		
		Rectangle r1;
		Rectangle r2;
		
		for (Entidad bala: balas) {
			
			BalaPrototype b = (BalaPrototype) bala;
			
			if (b.isEliminada() || b.isTipo() == true) continue;
			
			r1 = b.getRectangulo();
			
			r2 = naveJugador.getRectangulo();
			
			if (r1.intersects(r2)) {
				b.eliminar();
				naveJugador.herir();
				System.out.println("colision jugador!!!");
			}
			
		}
		
	}
	
}
