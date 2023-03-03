package edu.patterns.interfaces;

import edu.patterns.model.Ship;

public interface IEnemyFactoryMethod {
    Ship createEnemy(int type);
}
