package edu.patrones.vista;

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

import edu.patrones.modelo.Enemy;
import edu.patrones.modelo.Entity;
import edu.patrones.modelo.ModelFacade;
import edu.patrones.teclado.KeyboardReceiver;
import edu.patrones.intefaces.IPlayerNullObject;
import edu.patrones.jugador.PlayerFile;
import edu.patrones.jugador.Player;
import edu.patrones.jugador.MementoPlayer;
import edu.patrones.jugador.NullPlayer;

public class Juego extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;
	private static final int WIDTH = 480;
	private static final int HEIGHT = 360;
	private static BarraDeEstado statusBar;
	private boolean running = false;
	private ModelFacade model;
	private IPlayerNullObject player = new NullPlayer();
	private KeyboardReceiver keyboard;
	private boolean disparando = false;
	private int disparos = 60;
	private int acumuladorDisparos = 0;
	private int nivel = 10;

	private BufferedImage image;

	public Juego() {
		super();
		image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		keyboard = new KeyboardReceiver(this);
		setFocusable(true);
	}

	private void inicializar() {
		model = new ModelFacade();
	}
	
	private void finalizar() {
		List<Entity> entidades = model.getEntities().stream()
				.filter(x -> x instanceof Enemy)
				.filter(x -> x.isEliminated() == false)
				.collect(Collectors.toList()); 
		
		boolean gameOver = false;
		
		for (Entity entidad: entidades) {
			Enemy enemigo = (Enemy) entidad;
			if (enemigo.isGameOver()) {
				gameOver = true;
				break;
			}
		}
		
		if (model.getPlayerShip().isEliminated() || gameOver) {
			this.parar();
			this.actualizarPuntaje();
			statusBar.setEstado(Const.GAME_OVER[0] + 
					model.getScore() + 
					Const.GAME_OVER[1]);
		}
	}
	
	private void siguienteNivel() {
		nivel -= 3;
		
		int puntajeActual = model.getScore();
		
		model = new ModelFacade();
		model.setScore(puntajeActual);
		model.getPlayerShip().restore();
		
		List<Entity> entidades = model.getEntities().stream()
			.filter(x -> x instanceof Enemy)
			.collect(Collectors.toList());
		
		for (Entity entidad: entidades) {
			Enemy enemigo = (Enemy) entidad;
			enemigo.setVelocity(nivel);
		}
		
	}
	
	private void actualizarPuntaje() {
		if (!player.isNull()) {
			player.setMaxScore(model.getScore());
			MementoPlayer jm = player.savePlayer();
			PlayerFile aj = new PlayerFile();
			aj.save(jm);
			try {
				aj.writeFile();
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
	}

	private void instante() {
		
		manejarTeclado();
		
		for (Entity entidad: model.getEntities()) {
			if (entidad.isEliminated()) {
				continue;
			} else {
				entidad.instant();
			}
		}
		
		model.enemyShooting();
		model.verifyEnemyCollisions();
		model.verifyPlayerCollisions();
		
		statusBar.setEstado(player.getNickName(),
				model.getScore(), 
				model.getPlayerShip().getLives(),
				disparando);
		
		finalizar();
		
		if (model.isLastEnemy()) {
			siguienteNivel();
		}
		
		acumuladorDisparos++;
		
		if (acumuladorDisparos < disparos) {	
			return;
		}
		
		disparando = false;
		acumuladorDisparos = 0;
	}
	
	private void manejarTeclado() {
		if (keyboard.getPause().isDown()) {
			// TODO
		}
		
		if (keyboard.getRight().isDown()) {
			model.getPlayerShip().move("D");
		}
		
		if (keyboard.getLeft().isDown()) {
			model.getPlayerShip().move("I");
		} 
		
		if (keyboard.getShoot().isDown() && !disparando) {
			model.playerShooting();
			disparando = true;
		}
	}
	
	private void dibujar() {
		BufferStrategy bs = getBufferStrategy();
		
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();

		g.drawImage(image, 0, 0, WIDTH, HEIGHT, null);
				
		for (Entity entidad: model.getEntities()) {
			if (entidad.isEliminated()) {
				continue;
			} else {
				entidad.draw(g);
			}
		}
		
		Toolkit.getDefaultToolkit().sync();
		
		g.dispose();
		bs.show();
	}
	
	public void setJugador(MementoPlayer jugadorMemento) {
		player = new Player();
		player.openPlayer(jugadorMemento);
	}
	
	public static void main(String[] args) {
		Dimension dimension = new Dimension(WIDTH, HEIGHT);
		
		Juego juego = new Juego();
		juego.setMinimumSize(dimension);
		juego.setMaximumSize(dimension);
		juego.setPreferredSize(dimension);

		JFrame ventana = new JFrame(Const.TITULO);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setJMenuBar(new BarraDeMenu(ventana, juego));
		ventana.setLayout(new BorderLayout());
		statusBar = new BarraDeEstado();
		ventana.add(statusBar, BorderLayout.SOUTH);
		ventana.add(juego, BorderLayout.CENTER);
		ventana.pack();

		ventana.setResizable(false);
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);
	}

	public void iniciar() {
		running = true;
		new Thread(this).start();
	}

	public void parar() {
		running = false;
	}
	
	@Override
	public void run() {
		long ultimoTiempo = System.nanoTime();
		long ahora = 0;
		double noProcesado = 0;
		double nsPorInstante = 1000000000.0 / 60;
		boolean debeDibujar = false;

		inicializar();

		while (running) {
			
			ahora = System.nanoTime();
			noProcesado += (ahora - ultimoTiempo) / nsPorInstante;
			ultimoTiempo = ahora;
			debeDibujar = false;
			
			while (noProcesado >= 1) {
				instante();
				noProcesado -= 1;
				debeDibujar = true;				
			}

			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			if (debeDibujar) {
				dibujar();
			}

		}

	}
	
}
