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
	private JMenu menuJuego = new JMenu(Const.JUEGO);
	private JMenuItem itemNuevoJugador = new JMenuItem(Const.T_NUEVO);  
	private JMenuItem itemSeleccJugador = new JMenuItem(Const.T_SELECC);
	private JMenuItem itemIngresoRapido = new JMenuItem(Const.T_INGR);
	private JMenuItem itemIniciarJuego = new JMenuItem(Const.T_INIC);  
	private JMenuItem itemMejPuntajes = new JMenuItem(Const.T_PUNT);
	private JMenu menuAyuda = new JMenu(Const.AYUDA);
	private JMenuItem itemInstrucc = new JMenuItem(Const.T_INSTRUCC);  
	private JMenuItem itemAcercaDe = new JMenuItem(Const.T_ACERCA);
	private DialogoNuevoJugador dnj;
	private DialogoSeleccionarJugador dsj;
	private DialogoMejoresPuntajes dmp;
	private DialogoIngresoRapido dir;
	private JOptionPane dialogoInstrucc = new JOptionPane(Const.INSTRUCC);
	private JOptionPane dialogoAcercaDe = new JOptionPane(Const.ACERCA);
	private JDialog dialogo;
	private JFrame ventana;
	private Juego juego;

	public BarraDeMenu(JFrame ventana, Juego juego) throws HeadlessException {
		this.ventana = ventana;
		this.juego = juego;
		menuJuego.add(itemNuevoJugador);
		itemNuevoJugador.addActionListener(this);
		menuJuego.add(itemSeleccJugador);
		itemSeleccJugador.addActionListener(this);
		menuJuego.add(itemIngresoRapido);
		itemIngresoRapido.addActionListener(this);
		menuJuego.add(itemIniciarJuego);   
		itemIniciarJuego.addActionListener(this);
		menuJuego.add(itemMejPuntajes);
		itemMejPuntajes.addActionListener(this);
		this.add(menuJuego); 
		menuAyuda.add(itemInstrucc);
		itemInstrucc.addActionListener(this);
		menuAyuda.add(itemAcercaDe);
		itemAcercaDe.addActionListener(this);
		this.add(menuAyuda);
		
		dnj = new DialogoNuevoJugador(this.ventana);
		dsj = new DialogoSeleccionarJugador(this.ventana, this.juego);
		dir = new DialogoIngresoRapido(this.ventana, this.juego);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case Const.T_NUEVO:
			dnj.setVisible(true);
			dialogo = null;
			break;
		case Const.T_INIC:
			juego.iniciar();
			dialogo = null;
			break;
		case Const.T_SELECC:
			dsj.setVisible(true);
			dialogo = null;
			break;
		case Const.T_PUNT:
			dmp = new DialogoMejoresPuntajes();
			dialogo = dmp.createDialog(this, Const.T_PUNT);
			break;
		case Const.T_INSTRUCC:
			dialogo = dialogoInstrucc.createDialog(this, Const.T_INSTRUCC);
			break;
		case Const.T_ACERCA:
			dialogo = dialogoAcercaDe.createDialog(this, Const.T_ACERCA);
			break;
		case Const.T_INGR:
			dir.setVisible(true);
			
			dialogo = null;
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
