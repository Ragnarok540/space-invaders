package edu.patrones.vista;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class BarraDeMenu extends JMenuBar implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JMenu menuJuego = new JMenu("Juego");
	private JMenuItem itemNuevoJugador = new JMenuItem("Nuevo Jugador");  
	private JMenuItem itemSeleccJugador = new JMenuItem("Seleccionar Jugador");
	private JMenuItem itemIngresoRapido = new JMenuItem("Ingreso Rapido");
	private JMenuItem itemIniciarJuego = new JMenuItem("Iniciar Juego");  
	private JMenuItem itemMejPuntajes = new JMenuItem(Const.T_PUNT);
	private JMenu menuAyuda = new JMenu("Ayuda");
	private JMenuItem itemInstrucc = new JMenuItem(Const.T_INSTRUCC);  
	private JMenuItem itemAcercaDe = new JMenuItem(Const.T_ACERCA);
	private DialogoMejoresPuntajes dmp = new DialogoMejoresPuntajes();
	private JOptionPane dialogoInstrucc = new JOptionPane(Const.INSTRUCC);
	private JOptionPane dialogoAcercaDe = new JOptionPane(Const.ACERCA);
	private JDialog dialogo;
	private JFrame ventana;

	public BarraDeMenu(JFrame ventana) throws HeadlessException {
		this.ventana = ventana;
		menuJuego.add(itemNuevoJugador);
		menuJuego.add(itemSeleccJugador);
		menuJuego.add(itemIngresoRapido);
		menuJuego.add(itemIniciarJuego);   
		menuJuego.add(itemMejPuntajes);
		itemMejPuntajes.addActionListener(this);
		this.add(menuJuego); 
		menuAyuda.add(itemInstrucc);
		itemInstrucc.addActionListener(this);
		menuAyuda.add(itemAcercaDe);
		itemAcercaDe.addActionListener(this);
		this.add(menuAyuda); 
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case Const.T_PUNT:
			dialogo = dmp.createDialog(this, Const.T_PUNT);
			break;
		case Const.T_INSTRUCC:
			dialogo = dialogoInstrucc.createDialog(this, Const.T_INSTRUCC);
			break;
		case Const.T_ACERCA:
			dialogo = dialogoAcercaDe.createDialog(this, Const.T_ACERCA);
			break;
		default:
			dialogo = null;
		}

		if (dialogo != null) {
			dialogo.setLocationRelativeTo(this.ventana);
			dialogo.setVisible(true);
		}
		
	}

}
