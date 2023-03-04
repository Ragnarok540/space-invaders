package edu.patterns.model;

import java.awt.Rectangle;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import edu.patterns.image.FlyweightFactory;
import edu.patterns.image.FlyweightModel;


public final class ModelFacade {
    private static final int ENEMY_SHOOTING_DELAY = 60;
    private ArrayList<Entity> entities;
    private PlayerShipSingleton playerShip;
    private BulletPrototype bullet;
    private FlyweightFactory fFactory;
    private int enemyShootingAcumulator = 0;
    private int score;
    private boolean lastEnemy = false;

    public ModelFacade() {
        fFactory = new FlyweightFactory();

        FlyweightModel model = null;

        entities = new ArrayList<>();

        playerShip = PlayerShipSingleton.instance();
        model = fFactory.getModel("playerShip");
        playerShip.setModel(model);
        entities.add(playerShip);

        bullet = new BulletPrototype();
        model = fFactory.getModel("bullet");
        bullet.setModel(model);

        createEnemies();
    }

    private void createEnemies() {
        EnemyFactoryMethod eFactory = new EnemyFactoryMethod();

        Enemy enemy;
        FlyweightModel model = null;

        int posX = 5;
        int posY = 5;
        int type = 0;

        for (int i = 5; i > 0; i--) {
            for (int j = 0; j < 10; j++) {
                if (i == 5) {
                    type = 3;
                    model = fFactory.getModel("squid");
                } else if (i == 4 || i == 3) {
                    type = 2;
                    model = fFactory.getModel("crab");
                } else if (i == 2 || i == 1) {
                    type = 1;
                    model = fFactory.getModel("octopus");
                }

                enemy = eFactory.createEnemy(type);
                enemy.setPosX(posX);
                enemy.setPosY(posY);

                if (model != null) {
                    enemy.setModel(model);
                }

                entities.add(enemy);
                posX += 40;
                model = null;
            }

            posX = 5;
            posY += 30;
        }
    }

    public ArrayList<Entity> getEntities() {
        return entities;
    }

    public PlayerShipSingleton getPlayerShip() {
        return playerShip;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean isLastEnemy() {
        return lastEnemy;
    }

    public void playerShooting() {
        BulletPrototype clonedBullet = (BulletPrototype) bullet.cloneBullet();
        clonedBullet.setPosX(playerShip.getPosX() + (playerShip.getWidth() / 2) - 5);
        clonedBullet.setPosY(playerShip.getPosY() - bullet.getHeight() - 5);
        clonedBullet.setType(true);
        entities.add(clonedBullet);
    }

    private Enemy randomEnemy() {
        List<Entity> enemies = entities.stream()
                .filter(x -> x instanceof Enemy)
                .filter(x -> x.isEliminated() == false)
                .collect(Collectors.toList());

        SecureRandom rand = new SecureRandom();
        return (Enemy) enemies.get(rand.nextInt(enemies.size()));
    }

    public void enemyShooting() {
        enemyShootingAcumulator++;

        if (enemyShootingAcumulator < ENEMY_SHOOTING_DELAY) {
            return;
        }

        Enemy enemy = randomEnemy();
        BulletPrototype clonedBullet = (BulletPrototype) bullet.cloneBullet();
        clonedBullet.setPosX(enemy.getPosX() + (enemy.getWidth() / 2) - 5);
        clonedBullet.setPosY(enemy.getPosY() + bullet.getHeight() + 5);
        clonedBullet.setType(false);
        entities.add(clonedBullet);

        enemyShootingAcumulator = 0;
    }

    public void verifyEnemyCollisions() {
        List<Entity> bullets = entities.stream()
                .filter(x -> x instanceof BulletPrototype)
                .filter(x -> !x.isEliminated())
                .collect(Collectors.toList()); 

        List<Entity> enemies = entities.stream()
                .filter(x -> x instanceof Enemy)
                .filter(x -> !x.isEliminated())
                .collect(Collectors.toList());

        Rectangle r1;
        Rectangle r2;

        for (Entity bullet: bullets) {
            BulletPrototype b = (BulletPrototype) bullet;

            if (b.isType() == false) {
                continue;
            }

            r1 = b.getRectangle();

            for (Entity enemy: enemies) {
                Enemy e = (Enemy) enemy;
                r2 = e.getRectangle();

                if (r1.intersects(r2)) {
                    b.eliminate();
                    e.destroy();
                    score += e.getScore();

                    if (enemies.size() == 1) {
                        lastEnemy = true;
                    }

                    System.out.println("enemy collision !!!");
                }
            }
        }
    }

    public void verifyPlayerCollisions() {
        List<Entity> bullets = entities.stream()
                .filter(x -> x instanceof BulletPrototype)
                .filter(x -> !x.isEliminated())
                .collect(Collectors.toList());

        Rectangle r1;
        Rectangle r2;

        for (Entity bullet: bullets) {
            BulletPrototype b = (BulletPrototype) bullet;

            if (b.isType() == true) {
                continue;
            }

            r1 = b.getRectangle();
            r2 = playerShip.getRectangle();

            if (r1.intersects(r2)) {
                b.eliminate();
                playerShip.hurt();
                System.out.println("player collision!!!");
            }
        }
    }
}
