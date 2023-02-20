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

import edu.patrones.jugador.PlayerFile;
import edu.patrones.jugador.PlayerFileProxy;
import edu.patrones.jugador.MementoPlayer;

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
		
		Object[] msg = {Const.SELECC_J, combo};
		Object[] options = {Const.SELECC, Const.CANCELAR};

		optionPane = new JOptionPane(msg,
				JOptionPane.QUESTION_MESSAGE,
				JOptionPane.OK_CANCEL_OPTION,
				null,
				options,
				options[0]);

		setContentPane(optionPane);

		addComponentListener(new ComponentAdapter() {
			
			public void componentShown(ComponentEvent ce) {
				PlayerFileProxy ajp = new PlayerFileProxy();
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

			if (value.equals(Const.SELECC)) {
				
				String seleccion = (String) combo.getSelectedItem();
				cargarJugador(seleccion);
				cerrarDialogo();
				
			} else {
				cerrarDialogo();
			}
		}
		
	}
	
	private void cerrarDialogo() {
		setVisible(false);
	}

	private void cargarJugador(String seleccion) {
		PlayerFile aj = new PlayerFile();
		MementoPlayer jm = aj.open(seleccion);
		juego.setJugador(jm);
		juego.iniciar();
	}
	
}
