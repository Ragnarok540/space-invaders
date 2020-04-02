package edu.patrones.vista;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import edu.patrones.modelo.Entidad;
import edu.patrones.modelo.PartidaMediator;


public class Juego extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;
	private static final int ANCHO = 480;
	private static final int ALTO = 360;
	private static BarraDeEstado barraEstado;
	private boolean corriendo = false;
	private PartidaMediator partida;

	private BufferedImage image;

	public Juego() {
		super();
		image = new BufferedImage(ANCHO, ALTO, BufferedImage.TYPE_INT_RGB);
	}

	public void inicializar() {
		partida = new PartidaMediator();
		partida.disparoJugador();
	}
	
	public void instante() {
		for (Entidad entidad: partida.getEntidades()) {
			if (entidad.isEliminada()) {
				continue;
			} else {
				entidad.instante();
			}
		}
		partida.verificarColisionesEnemigos();
		partida.verificarColisionesJugador();
	}
	
	public void dibujar() {
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
	
	public static void main(String[] args) {
		Dimension dimension = new Dimension(ANCHO, ALTO);
		
		Juego juego = new Juego();
		juego.setMinimumSize(dimension);
		juego.setMaximumSize(dimension);
		juego.setPreferredSize(dimension);

		JFrame ventana = new JFrame("Space Invaders");
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setJMenuBar(new BarraDeMenu(ventana));
		ventana.setLayout(new BorderLayout());
		barraEstado = new BarraDeEstado();
		ventana.add(barraEstado, BorderLayout.SOUTH);
		ventana.add(juego, BorderLayout.CENTER);
		ventana.pack();

		ventana.setResizable(false);
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);

		juego.iniciar();
	}

	private void iniciar() {
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
		int frames = 0;
		int instantes = 0;
		long ultimoTimer = System.currentTimeMillis();

		inicializar();

		while (corriendo) {
			ahora = System.nanoTime();
			noProcesado += (ahora - ultimoTiempo) / nsPorInstante;
			ultimoTiempo = ahora;
			debeDibujar = true;
			
			while (noProcesado >= 1) {
				instantes++;
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
				frames++;
				dibujar();
			}

			if (System.currentTimeMillis() - ultimoTimer > 1000) {
				ultimoTimer += 1000;
				System.out.println(instantes + " ticks, " + frames + " fps");
				frames = 0;
				instantes = 0;
			}
		}
	}
	
}
