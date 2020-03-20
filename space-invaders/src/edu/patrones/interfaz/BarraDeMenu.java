package edu.patrones.interfaz;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class BarraDeMenu extends JMenuBar implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JMenu menuJuego = new JMenu("Juego");
	private JMenuItem itemNuevoJugador = new JMenuItem("Nuevo Jugador");  
	private JMenuItem itemSeleccionarJugador = new JMenuItem("Seleccionar Jugador");
	private JMenuItem itemIngresoRapido = new JMenuItem("Ingreso Rápido");
	private JMenuItem itemCrearPartida = new JMenuItem("Crear Partida");  
	private JMenuItem itemCargarPartida = new JMenuItem("Cargar Partida");
	private JMenuItem itemMejoresPuntajes = new JMenuItem("Mejores Puntajes");
	private JMenu menuAyuda = new JMenu("Ayuda");
	private JMenuItem itemInstrucciones = new JMenuItem(Constantes.TITULO_INSTRUCCIONES);  
	private JMenuItem itemAcercaDe = new JMenuItem("Acerca de...");

	private DialogoInstrucciones dialogoInstrucciones = new DialogoInstrucciones();
	private JDialog dialogo;
	private JFrame ventana;

	public BarraDeMenu(JFrame ventana) throws HeadlessException {
		this.ventana = ventana;
		menuJuego.add(itemNuevoJugador);
		menuJuego.add(itemSeleccionarJugador);
		menuJuego.add(itemIngresoRapido);
		menuJuego.add(itemCrearPartida);  
		menuJuego.add(itemCargarPartida); 
		menuJuego.add(itemMejoresPuntajes); 
		this.add(menuJuego); 
		menuAyuda.add(itemInstrucciones);
		itemInstrucciones.addActionListener(this);
		menuAyuda.add(itemAcercaDe);
		this.add(menuAyuda); 
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case Constantes.TITULO_INSTRUCCIONES:
			dialogo = dialogoInstrucciones.createDialog(this, Constantes.TITULO_INSTRUCCIONES);
			dialogo.setLocationRelativeTo(this.ventana);
			dialogo.setVisible(true);
			break;
		default:
			System.out.println("nada");
		}
	}

}
