package edu.patrones.vista;

import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;
import java.util.SortedSet;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import edu.patrones.jugador.ArchivoJugador;
import edu.patrones.jugador.ArchivoJugadorProxy;
import edu.patrones.jugador.JugadorMemento;

public class DialogoSeleccionarJugador extends JDialog implements PropertyChangeListener {

	private static final long serialVersionUID = 1L;
	
	private JOptionPane optionPane;
	private JComboBox<String> combo;
	private Juego juego;
	
	public DialogoSeleccionarJugador(JFrame ventana, Juego juego) {
		super(ventana, true);
		setTitle(Const.T_SELECC);

		this.juego = juego;
		
		combo = new JComboBox<>();
		
		Object[] msg = {"Seleccione el Jugador", combo};
		Object[] options = {"Seleccionar", Const.CANCELAR};

		optionPane = new JOptionPane(msg,
				JOptionPane.QUESTION_MESSAGE,
				JOptionPane.OK_CANCEL_OPTION,
				null,
				options,
				options[0]);

		setContentPane(optionPane);

		addComponentListener(new ComponentAdapter() {
			public void componentShown(ComponentEvent ce) {
				ArchivoJugadorProxy ajp = new ArchivoJugadorProxy();
				List<String[]> data = ajp.getData();
				SortedSet<String> nickNames = ajp.nickNames(data);
				
				combo.removeAllItems();
				
				for (String nick: nickNames) {
					combo.addItem(nick);
				}
				
				combo.setSelectedIndex(0);
				combo.requestFocusInWindow();
			}
		});

		optionPane.addPropertyChangeListener(this);

		setSize(new Dimension(320, 160));
		setResizable(false);
		setLocationRelativeTo(ventana);
	}
	
	@Override
	public void propertyChange(PropertyChangeEvent pce) {
		String prop = pce.getPropertyName();
		boolean source = pce.getSource() == optionPane;
		boolean vp = JOptionPane.VALUE_PROPERTY.equals(prop);
		boolean ivp = JOptionPane.INPUT_VALUE_PROPERTY.equals(prop);

		if (isVisible() && source && (vp || ivp)) {
			Object value = optionPane.getValue();

			if (value == JOptionPane.UNINITIALIZED_VALUE) {
				return;
			}

			optionPane.setValue(JOptionPane.UNINITIALIZED_VALUE);

			if (value.equals("Seleccionar")) {
				
				String seleccion = (String) combo.getSelectedItem();
				ArchivoJugador aj = new ArchivoJugador();
				JugadorMemento jm = aj.abrir(seleccion);
				juego.setJugador(jm);
				cerrarDialogo();
				
			} else {
				cerrarDialogo();
			}
		}
		
	}
	
	private void cerrarDialogo() {
		setVisible(false);
	}

}
