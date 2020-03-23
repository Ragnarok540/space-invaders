package edu.patrones.interfaz;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class DialogoMejoresPuntajes extends JOptionPane {

	private static final long serialVersionUID = 1L;

	public DialogoMejoresPuntajes() {
		Object[][] datos = {
			    {"", "", "", ""}
		};
		JTable tabla = new JTable(datos, Const.COL_NAMES);
		JScrollPane scroll = new JScrollPane(tabla);
		this.setMessage(scroll);
	}
	
}
