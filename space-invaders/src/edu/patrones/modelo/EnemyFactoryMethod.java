package edu.patrones.modelo;

import edu.patrones.intefaces.IEnemyFactoryMethod;

public class EnemyFactoryMethod implements IEnemyFactoryMethod {

	@Override
	public Enemy createEnemy(int type) {
		if(type == 1) {
			return new Octopus();
		} else if(type == 2) {
			return new Crab();
		} else if(type == 3) {
			return new Squid();
		} else {
			return null;
		}
	}

}
