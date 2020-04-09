package edu.patrones.vista;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import edu.patrones.jugador.ArchivoJugadorProxy;

public class DialogoMejoresPuntajes extends JOptionPane {

	private static final long serialVersionUID = 1L;
	private ArchivoJugadorProxy ajp;

	public DialogoMejoresPuntajes() {
		ajp = new ArchivoJugadorProxy();
		Object[][] datos = ajp.datosOrdenados();
		JTable tabla = new JTable(datos, Const.COL_NAMES);
		JScrollPane scroll = new JScrollPane(tabla);
		this.setMessage(scroll);
	}
	
}
