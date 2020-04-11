package edu.patrones.vista;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import edu.patrones.jugador.ArchivoJugadorProxy;

public class DialogoMejoresPuntajes extends JOptionPane {

	private static final long serialVersionUID = 1L;
	private ArchivoJugadorProxy ajp;

	public DialogoMejoresPuntajes() {
		ajp = new ArchivoJugadorProxy();
		List<String[]> data = ajp.getData();
		Object[][] datos = ajp.convertir(data);
		JTable tabla = new JTable(datos, Const.COL_NAMES);
		JScrollPane scroll = new JScrollPane(tabla);
		this.setMessage(scroll);
	}
	
}
