package edu.patrones.vista;

import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import edu.patrones.jugador.PlayerFile;
import edu.patrones.jugador.Player;
import edu.patrones.jugador.MementoPlayer;

public class DialogoNuevoJugador extends JDialog implements PropertyChangeListener {

	private static final long serialVersionUID = 1L;

	private JOptionPane optionPane;
	private JTextField tfNombre, tfNickName;
	private String nombre, nickName;

	public DialogoNuevoJugador(JFrame ventana) {
		super(ventana, true);
		setTitle(Const.T_NUEVO);

		tfNombre = new JTextField(10);
		tfNickName = new JTextField(10);

		Object[] msg = {Const.M_NOMBRE, tfNombre, Const.M_NICK, tfNickName};
		Object[] options = {Const.CREAR, Const.CANCELAR};

		optionPane = new JOptionPane(msg,
				JOptionPane.QUESTION_MESSAGE,
				JOptionPane.OK_CANCEL_OPTION,
				null,
				options,
				options[0]);

		setContentPane(optionPane);

		addComponentListener(new ComponentAdapter() {
			public void componentShown(ComponentEvent ce) {
				tfNombre.requestFocusInWindow();
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

			if (value.equals(Const.CREAR)) {
				nombre = tfNombre.getText();
				boolean nombOk = nombre.matches(Const.NAME_REGEX);
				boolean lNombOk = nombre.length() < 25;

				nickName = tfNickName.getText();
				boolean nickOk = nickName.matches(Const.NICK_REGEX);
				boolean lnickOk = nickName.length() < 6;

				if (nombOk && lNombOk && nickOk && lnickOk) {
					guardarJugador();
					cerrarDialogo();
				} else {
					errorNombreNick();
				}
			} else {
				cerrarDialogo();
			}
		}

	}

	private void errorNombreNick() {
		tfNombre.selectAll();
		JOptionPane.showMessageDialog(
				this,
				Const.E_NUEVO_JUG,
				Const.INTENTAR,
				JOptionPane.WARNING_MESSAGE);
		nombre = null;
		nickName = null;
		tfNombre.requestFocusInWindow();
	}
	
	private void errorNickYaExiste() {
		tfNombre.selectAll();
		JOptionPane.showMessageDialog(
				this,
				Const.E_NICK,
				Const.INTENTAR,
				JOptionPane.ERROR_MESSAGE);
		nombre = null;
		nickName = null;
		tfNickName.requestFocusInWindow();
	}
	
	private void cerrarDialogo() {
		tfNombre.setText(null);
		tfNickName.setText(null);
		setVisible(false);
	}
	
	private void guardarJugador() {
		PlayerFile aj = new PlayerFile();
		
		if (aj.playerExists(nickName)) {
			errorNickYaExiste();
		} else {
			Player jugador = new Player(nickName, nombre);
			MementoPlayer memento = jugador.savePlayer();
			aj.save(memento);
			try {
				aj.writeFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
