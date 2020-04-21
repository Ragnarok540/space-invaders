package edu.patrones.modelo;

import edu.patrones.intefaces.IEnemigoFactoryMethod;

public class EnemigoFactoryMethod implements IEnemigoFactoryMethod {

	@Override
	public Enemigo crearEnemigo(int tipo) {
		
		if(tipo == 1) {
			
			return new Pulpo();
			
		} else if(tipo == 2) {
			
			return new Cangrejo();
			
		} else if(tipo == 3) {
			
			return new Calamar();
			
		} else {
			
			return null;
			
		}
		
	}

}
