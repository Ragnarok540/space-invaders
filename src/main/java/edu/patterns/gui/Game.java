package edu.patterns.gui;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JFrame;

import edu.patterns.model.Enemy;
import edu.patterns.model.Entity;
import edu.patterns.model.ModelFacade;
import edu.patterns.keyboard.KeyboardReceiver;
import edu.patterns.interfaces.IPlayerNullObject;
import edu.patterns.player.PlayerFile;
import edu.patterns.player.Player;
import edu.patterns.player.MementoPlayer;
import edu.patterns.player.NullPlayer;

public final class Game extends Canvas implements Runnable {
    private static final long serialVersionUID = 1L;
    private static final int WIDTH = 480;
    private static final int HEIGHT = 360;
    private static StatusBar statusBar;
    private boolean running = false;
    private ModelFacade model;
    private IPlayerNullObject player = new NullPlayer();
    private KeyboardReceiver keyboard;
    private boolean launchingMissile = false;
    private int missileDelay = 60;
    private int missileAccumulator = 0;
    private int level = 10;
    private BufferedImage image;

    public Game() {
        super();
        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        keyboard = new KeyboardReceiver(this);
        setFocusable(true);
    }

    private void initialize() {
        model = new ModelFacade();
    }

    private void end() {
        List<Entity> entities = model.getEntities().stream()
            .filter(x -> x instanceof Enemy)
            .filter(x -> !x.isEliminated())
            .collect(Collectors.toList());
        boolean gameOver = false;

        for (Entity entity: entities) {
            Enemy enemy = (Enemy) entity;
            if (enemy.isGameOver()) {
                gameOver = true;
                break;
            }
        }

        if (model.getPlayerShip().isEliminated() || gameOver) {
            this.stop();
            this.updateScore();
            statusBar.setStatus(Const.GAME_OVER[0]
                + model.getScore()
                + Const.GAME_OVER[1]);
        }
    }

    private void nextLevel() {
        level -= 3;
        int currentScore = model.getScore();
        model = new ModelFacade();
        model.setScore(currentScore);
        model.getPlayerShip().restore();
        List<Entity> entities = model.getEntities().stream()
            .filter(x -> x instanceof Enemy)
            .collect(Collectors.toList());

        for (Entity entity: entities) {
            Enemy enemy = (Enemy) entity;
            enemy.setVelocity(level);
        }
    }

    private void updateScore() {
        if (!player.isNull()) {
            player.setMaxScore(model.getScore());
            MementoPlayer mp = player.savePlayer();
            PlayerFile pf = new PlayerFile();
            pf.save(mp);
            try {
                pf.writeFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void instant() {
        handleKeyboard();

        for (Entity entity: model.getEntities()) {
            if (entity.isEliminated()) {
                continue;
            } else {
                entity.instant();
            }
        }

        model.enemyShooting();
        model.verifyEnemyCollisions();
        model.verifyPlayerCollisions();
        statusBar.setStatus(player.getNickName(),
            model.getScore(),
            model.getPlayerShip().getLives(),
            launchingMissile);

        end();

        if (model.isLastEnemy()) {
            nextLevel();
        }

        missileAccumulator++;

        if (missileAccumulator < missileDelay) {
            return;
        }

        launchingMissile = false;
        missileAccumulator = 0;
    }

    private void handleKeyboard() {
        if (keyboard.getPause().isDown()) {
            // TODO
        }

        if (keyboard.getRight().isDown()) {
            model.getPlayerShip().move("D");
        }

        if (keyboard.getLeft().isDown()) {
            model.getPlayerShip().move("I");
        }

        if (keyboard.getShoot().isDown() && !launchingMissile) {
            model.playerShooting();
            launchingMissile = true;
        }
    }

    private void draw() {
        BufferStrategy bs = getBufferStrategy();

        if (bs == null) {
            createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();
        g.drawImage(image, 0, 0, WIDTH, HEIGHT, null);

        for (Entity entity: model.getEntities()) {
            if (entity.isEliminated()) {
                continue;
            } else {
                entity.draw(g);
            }
        }

        Toolkit.getDefaultToolkit().sync();
        g.dispose();
        bs.show();
    }

    public void setPlayer(final MementoPlayer mementoPlayer) {
        player = new Player();
        player.openPlayer(mementoPlayer);
    }

    public static void main(final String[] args) {
        Dimension dimension = new Dimension(WIDTH, HEIGHT);

        Game game = new Game();
        game.setMinimumSize(dimension);
        game.setMaximumSize(dimension);
        game.setPreferredSize(dimension);

        JFrame window = new JFrame(Const.TITULO);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setJMenuBar(new MenuBar(window, game));
        window.setLayout(new BorderLayout());
        statusBar = new StatusBar();
        window.add(statusBar, BorderLayout.SOUTH);
        window.add(game, BorderLayout.CENTER);
        window.pack();

        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }

    public void startGame() {
        running = true;
        new Thread(this).start();
    }

    public void stop() {
        running = false;
    }

    @Override
    public void run() {
        long lastTime = System.nanoTime();
        long now = 0;
        double notProcessed = 0;
        double nsPerInstant = 1000000000.0 / 60;
        boolean shouldDraw = false;

        initialize();

        while (running) {
            now = System.nanoTime();
            notProcessed += (now - lastTime) / nsPerInstant;
            lastTime = now;
            shouldDraw = false;

            while (notProcessed >= 1) {
                instant();
                notProcessed -= 1;
                shouldDraw = true;
            }

            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (shouldDraw) {
                draw();
            }
        }
    }
}
