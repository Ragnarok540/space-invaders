package edu.patrones.vista;

import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import edu.patrones.intefaces.IPlayerNullObject;
import edu.patrones.jugador.PlayerFile;
import edu.patrones.jugador.Player;
import edu.patrones.jugador.MementoPlayer;
import edu.patrones.jugador.NullPlayer;

public class DialogoIngresoRapido extends JDialog implements PropertyChangeListener {

	private static final long serialVersionUID = 1L;

	private JOptionPane optionPane;
	private JTextField tfNickName;
	private String nickName;
	private Juego juego;

	public DialogoIngresoRapido(JFrame ventana, Juego juego) {
		super(ventana, true);
		this.juego = juego;
		setTitle(Const.T_INGR);

		
		tfNickName = new JTextField(10);

		Object[] msg = {Const.T_NICKRAPIDO, tfNickName};
		Object[] options = {Const.T_INIC, Const.CANCELAR};

		optionPane = new JOptionPane(msg,
				JOptionPane.QUESTION_MESSAGE,
				JOptionPane.OK_CANCEL_OPTION,
				null,
				options,
				options[0]);

		setContentPane(optionPane);

		addComponentListener(new ComponentAdapter() {
			public void componentShown(ComponentEvent ce) {
				tfNickName.requestFocusInWindow();
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

			if (value.equals(Const.T_INIC)) {
				nickName = tfNickName.getText();
				boolean nickOk = nickName.matches(Const.NICK_REGEX);
				boolean lnickOk = nickName.length() < 6;

				if (nickOk && lnickOk) {
					cargarJugador();
					cerrarDialogo();
				} else {
					errorNick();
				}

			} else {
				cerrarDialogo();
			}

		}

	}

	private void errorNick() {
		tfNickName.selectAll();
		JOptionPane.showMessageDialog(
				this,
				Const.E_NICK_V,
				Const.INTENTAR,
				JOptionPane.WARNING_MESSAGE);
		nickName = null;
		tfNickName.requestFocusInWindow();
	}
	
	private void errorNickNoExiste(IPlayerNullObject jugador) {
		tfNickName.selectAll();
		JOptionPane.showMessageDialog(
				this,
				jugador.getNickName(),
				Const.INTENTAR,
				JOptionPane.ERROR_MESSAGE);
		nickName = null;
		tfNickName.requestFocusInWindow();
	}
	
	private void cerrarDialogo() {
		tfNickName.setText(null);
		setVisible(false);
	}
	
	private void cargarJugador() {
		PlayerFile aj = new PlayerFile();
		IPlayerNullObject jugador;
		
		if (aj.playerExists(nickName)) {
			jugador = new Player();
			MementoPlayer jm = aj.open(nickName);
			juego.setJugador(jm);
			juego.iniciar();
		} else {
			jugador = new NullPlayer();
			errorNickNoExiste(jugador);
		}
		
	}

}
