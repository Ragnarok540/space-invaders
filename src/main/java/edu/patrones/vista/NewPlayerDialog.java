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

public class NewPlayerDialog extends JDialog implements PropertyChangeListener {

	private static final long serialVersionUID = 1L;
	private JOptionPane optionPane;
	private JTextField nameTf, nickTf;
	private String name, nickName;

	public NewPlayerDialog(JFrame window) {
		super(window, true);
		setTitle(Const.T_NUEVO);

		nameTf = new JTextField(10);
		nickTf = new JTextField(10);

		Object[] msg = {Const.M_NOMBRE, nameTf, Const.M_NICK, nickTf};
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
				nameTf.requestFocusInWindow();
			}
		});	

		optionPane.addPropertyChangeListener(this);

		setSize(new Dimension(320, 160));
		setResizable(false);
		setLocationRelativeTo(window);
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
				name = nameTf.getText();
				boolean nombOk = name.matches(Const.NAME_REGEX);
				boolean lNombOk = name.length() < 25;

				nickName = nickTf.getText();
				boolean nickOk = nickName.matches(Const.NICK_REGEX);
				boolean lnickOk = nickName.length() < 6;

				if (nombOk && lNombOk && nickOk && lnickOk) {
					savePlayer();
					closeDialog();
				} else {
					nameNickError();
				}
			} else {
				closeDialog();
			}
		}
	}

	private void nameNickError() {
		nameTf.selectAll();
		JOptionPane.showMessageDialog(
				this,
				Const.E_NUEVO_JUG,
				Const.INTENTAR,
				JOptionPane.WARNING_MESSAGE);
		name = null;
		nickName = null;
		nameTf.requestFocusInWindow();
	}

	private void nickAlreadyExistsError() {
		nameTf.selectAll();
		JOptionPane.showMessageDialog(
				this,
				Const.E_NICK,
				Const.INTENTAR,
				JOptionPane.ERROR_MESSAGE);
		name = null;
		nickName = null;
		nickTf.requestFocusInWindow();
	}

	private void closeDialog() {
		nameTf.setText(null);
		nickTf.setText(null);
		setVisible(false);
	}

	private void savePlayer() {
		PlayerFile pf = new PlayerFile();
		
		if (pf.playerExists(nickName)) {
			nickAlreadyExistsError();
		} else {
			Player player = new Player(nickName, name);
			MementoPlayer memento = player.savePlayer();
			pf.save(memento);
			try {
				pf.writeFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
