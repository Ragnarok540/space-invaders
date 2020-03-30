package edu.patrones.modelo;

import edu.patrones.intefaces.INaveFactoryMethod;

public class NaveFactoryMethod implements INaveFactoryMethod{

	@Override
	public Nave crearNave(int tipo) {
		// TODO Auto-generated method stub
		if(tipo == 1) {
			return new Pulpo();
		}
		else if(tipo == 2) {
			return new Cangrejo();
		}
		else if(tipo == 3) {
			return new Calamar();
		}
		else {
			return null;
		}
	}

}
