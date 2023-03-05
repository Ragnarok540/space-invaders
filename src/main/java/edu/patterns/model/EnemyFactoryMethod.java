package edu.patterns.model;

import edu.patterns.interfaces.IEnemyFactoryMethod;

public final class EnemyFactoryMethod implements IEnemyFactoryMethod {
    @Override
    public Enemy createEnemy(final String type) {
        switch (type) {
            case "octopus":
                return new Octopus();
            case "crab":
                return new Crab();
            case "squid":
                return new Squid();
            default:
                return null;
        }
    }
}
