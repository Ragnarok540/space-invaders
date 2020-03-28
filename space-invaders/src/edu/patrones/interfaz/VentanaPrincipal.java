package edu.patrones.interfaz;

import java.awt.BorderLayout;
import javax.swing.JFrame;
//import javax.swing.JPanel;

public class VentanaPrincipal {

	private static JFrame ventana = new JFrame("Space Invaders");
	//private static JPanel panel = new JPanel();
	private static BarraDeMenu barraMenu = new BarraDeMenu(ventana);
	private static BarraDeEstado barraEstado = new BarraDeEstado();

	public VentanaPrincipal() {

	}

	public static void main(String[] args) {
		//ventana.add(panel);
		
		ventana.setLayout(new BorderLayout());
		ventana.setJMenuBar(barraMenu);
		ventana.add(barraEstado, BorderLayout.SOUTH);
		ventana.setSize(400, 300);
		ventana.setVisible(true);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setLocationRelativeTo(null);


	}

}
