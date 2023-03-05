package edu.patterns.interfaces;

import edu.patterns.model.Enemy;

public interface IEnemyFactoryMethod {
    Enemy createEnemy(String type);
}
