package edu.patrones.interfaz;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class VentanaPrincipal {
	
	private static JFrame ventana = new JFrame("Space Invaders");
	private static JPanel panel = new JPanel();
	private static JMenuBar menuBar = new JMenuBar();
	private static JMenu menuJuego = new JMenu("Juego");
	private static JMenuItem itemNuevoJugador = new JMenuItem("Nuevo Jugador");  
	private static JMenuItem itemSeleccionarJugador = new JMenuItem("Seleccionar Jugador");
	private static JMenuItem itemIngresoRapido = new JMenuItem("Ingreso Rápido");
	private static JMenuItem itemMejoresPuntajes = new JMenuItem("Mejores Puntajes");
	private static JMenuItem itemCrearPartida = new JMenuItem("Crear Partida");  
	private static JMenuItem itemCargarPartida = new JMenuItem("Cargar Partida");
	private static JMenu menuAyuda = new JMenu("Ayuda");
	private static JMenuItem itemInstrucciones = new JMenuItem("Instrucciones");  
	private static JMenuItem itemAcercaDe = new JMenuItem("Acerca de...");
	private static BarraDeEstado barraEstado = new BarraDeEstado();

	public VentanaPrincipal() {
		
	}

	public static void main(String[] args) {
		ventana.add(panel);

		menuJuego.add(itemNuevoJugador);
		menuJuego.add(itemSeleccionarJugador); 
		menuJuego.add(itemCrearPartida);  
		menuJuego.add(itemCargarPartida); 
		menuJuego.add(itemIngresoRapido); 
		menuJuego.add(itemMejoresPuntajes); 
		menuBar.add(menuJuego); 
		menuAyuda.add(itemInstrucciones);
		menuAyuda.add(itemAcercaDe);
	    menuBar.add(menuAyuda); 
	      
		
	    ventana.setLayout(new BorderLayout());
	    
	    ventana.setJMenuBar(menuBar);
	    ventana.add(barraEstado, BorderLayout.SOUTH);
	    
		ventana.setSize(400, 300);
		ventana.setVisible(true);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	

	}

}
