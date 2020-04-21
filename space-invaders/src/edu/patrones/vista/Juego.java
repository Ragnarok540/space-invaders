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

import edu.patrones.modelo.Enemigo;
import edu.patrones.modelo.Entidad;
import edu.patrones.modelo.PartidaFachada;
import edu.patrones.teclado.TecladoReceiver;
import edu.patrones.intefaces.IJugadorNullObject;
import edu.patrones.jugador.ArchivoJugador;
import edu.patrones.jugador.Jugador;
import edu.patrones.jugador.JugadorMemento;
import edu.patrones.jugador.JugadorNull;

public class Juego extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;
	private static final int ANCHO = 480;
	private static final int ALTO = 360;
	private static BarraDeEstado barraEstado;
	private boolean corriendo = false;
	private PartidaFachada partida;
	private IJugadorNullObject jugador = new JugadorNull();
	private TecladoReceiver teclado;
	private boolean disparando = false;
	private int disparos = 60;
	private int acumuladorDisparos = 0;
	private int nivel = 10;

	private BufferedImage image;

	public Juego() {
		super();
		image = new BufferedImage(ANCHO, ALTO, BufferedImage.TYPE_INT_RGB);
		teclado = new TecladoReceiver(this);
		setFocusable(true);
	}

	private void inicializar() {
		partida = new PartidaFachada();
	}
	
	private void finalizar() {
		List<Entidad> entidades = partida.getEntidades().stream()
				.filter(x -> x instanceof Enemigo)
				.filter(x -> x.isEliminada() == false)
				.collect(Collectors.toList()); 
		
		boolean gameOver = false;
		
		for (Entidad entidad: entidades) {
			Enemigo enemigo = (Enemigo) entidad;
			if (enemigo.isGameOver()) {
				gameOver = true;
				break;
			}
		}
		
		if (partida.getNaveJugador().isEliminada() || gameOver) {
			this.parar();
			this.actualizarPuntaje();
			barraEstado.setEstado(Const.GAME_OVER[0] + 
					partida.getPuntaje() + 
					Const.GAME_OVER[1]);
		}
	}
	
	private void siguienteNivel() {
		nivel -= 3;
		
		int puntajeActual = partida.getPuntaje();
		
		partida = new PartidaFachada();
		partida.setPuntaje(puntajeActual);
		partida.getNaveJugador().restaurar();
		
		List<Entidad> entidades = partida.getEntidades().stream()
			.filter(x -> x instanceof Enemigo)
			.collect(Collectors.toList());
		
		for (Entidad entidad: entidades) {
			Enemigo enemigo = (Enemigo) entidad;
			enemigo.setVelocidad(nivel);
		}
		
	}
	
	private void actualizarPuntaje() {
		if (!jugador.isNull()) {
			jugador.setPuntuacionMaxima(partida.getPuntaje());
			JugadorMemento jm = jugador.guardarJugador();
			ArchivoJugador aj = new ArchivoJugador();
			aj.guardar(jm);
			try {
				aj.escribirArchivo();
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
	}

	private void instante() {
		
		manejarTeclado();
		
		for (Entidad entidad: partida.getEntidades()) {
			if (entidad.isEliminada()) {
				continue;
			} else {
				entidad.instante();
			}
		}
		
		partida.disparoEnemigo();
		partida.verificarColisionesEnemigos();
		partida.verificarColisionesJugador();
		
		barraEstado.setEstado(jugador.getNickName(),
				partida.getPuntaje(), 
				partida.getNaveJugador().getVidas(),
				disparando);
		
		finalizar();
		
		if (partida.isUltimoEnemigo()) {
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
		if (teclado.getPau().isDown()) {
			// TODO
		}
		
		if (teclado.getDer().isDown()) {
			partida.getNaveJugador().mover("D");
		}
		
		if (teclado.getIzq().isDown()) {
			partida.getNaveJugador().mover("I");
		} 
		
		if (teclado.getDis().isDown() && !disparando) {
			partida.disparoJugador();
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

		g.drawImage(image, 0, 0, ANCHO, ALTO, null);
				
		for (Entidad entidad: partida.getEntidades()) {
			if (entidad.isEliminada()) {
				continue;
			} else {
				entidad.dibujar(g);
			}
		}
		
		Toolkit.getDefaultToolkit().sync();
		
		g.dispose();
		bs.show();
	}
	
	public void setJugador(JugadorMemento jugadorMemento) {
		this.jugador = new Jugador();
		this.jugador.abrirJugador(jugadorMemento);
	}
	
	public static void main(String[] args) {
		Dimension dimension = new Dimension(ANCHO, ALTO);
		
		Juego juego = new Juego();
		juego.setMinimumSize(dimension);
		juego.setMaximumSize(dimension);
		juego.setPreferredSize(dimension);

		JFrame ventana = new JFrame(Const.TITULO);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setJMenuBar(new BarraDeMenu(ventana, juego));
		ventana.setLayout(new BorderLayout());
		barraEstado = new BarraDeEstado();
		ventana.add(barraEstado, BorderLayout.SOUTH);
		ventana.add(juego, BorderLayout.CENTER);
		ventana.pack();

		ventana.setResizable(false);
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);
	}

	public void iniciar() {
		corriendo = true;
		new Thread(this).start();
	}

	public void parar() {
		corriendo = false;
	}
	
	@Override
	public void run() {
		long ultimoTiempo = System.nanoTime();
		long ahora = 0;
		double noProcesado = 0;
		double nsPorInstante = 1000000000.0 / 60;
		boolean debeDibujar = false;

		inicializar();

		while (corriendo) {
			
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
