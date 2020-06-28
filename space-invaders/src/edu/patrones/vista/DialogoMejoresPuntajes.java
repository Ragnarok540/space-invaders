package edu.patrones.vista;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import edu.patrones.jugador.PlayerFileProxy;

public class DialogoMejoresPuntajes extends JOptionPane {

	private static final long serialVersionUID = 1L;
	private PlayerFileProxy ajp;

	public DialogoMejoresPuntajes() {
		ajp = new PlayerFileProxy();
		List<String[]> data = ajp.getData();
		Object[][] datos = ajp.convert(data);
		JTable tabla = new JTable(datos, Const.COL_NAMES);
		JScrollPane scroll = new JScrollPane(tabla);
		this.setMessage(scroll);
	}
	
}
