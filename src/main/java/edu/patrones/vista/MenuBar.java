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

public class MenuBar extends JMenuBar implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JMenu gameMenu = new JMenu(Const.JUEGO);
	private JMenuItem newPlayerItem = new JMenuItem(Const.T_NUEVO);  
	private JMenuItem selectPlayerItem = new JMenuItem(Const.T_SELECC);
	private JMenuItem quickStartItem = new JMenuItem(Const.T_INGR);
	private JMenuItem startGameItem = new JMenuItem(Const.T_INIC);  
	private JMenuItem bestScoresItem = new JMenuItem(Const.T_PUNT);
	private JMenu helpMenu = new JMenu(Const.AYUDA);
	private JMenuItem helpItem = new JMenuItem(Const.T_INSTRUCC);  
	private JMenuItem aboutItem = new JMenuItem(Const.T_ACERCA);
	private NewPlayerDialog npd;
	private SelectPlayerDialog spd;
	private BestScoresDialog dmp;
	private QuickStartDialog qsd;
	private JOptionPane helpDialog = new JOptionPane(Const.INSTRUCC);
	private JOptionPane aboutDialog = new JOptionPane(Const.ACERCA);
	private JDialog dialog;
	private JFrame window;
	private Game game;

	public MenuBar(JFrame window, Game game) throws HeadlessException {
		this.window = window;
		this.game = game;
		gameMenu.add(newPlayerItem);
		newPlayerItem.addActionListener(this);
		gameMenu.add(selectPlayerItem);
		selectPlayerItem.addActionListener(this);
		gameMenu.add(quickStartItem);
		quickStartItem.addActionListener(this);
		gameMenu.add(startGameItem);   
		startGameItem.addActionListener(this);
		gameMenu.add(bestScoresItem);
		bestScoresItem.addActionListener(this);
		this.add(gameMenu); 
		helpMenu.add(helpItem);
		helpItem.addActionListener(this);
		helpMenu.add(aboutItem);
		aboutItem.addActionListener(this);
		this.add(helpMenu);
		
		npd = new NewPlayerDialog(this.window);
		spd = new SelectPlayerDialog(this.window, this.game);
		qsd = new QuickStartDialog(this.window, this.game);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case Const.T_NUEVO:
			npd.setVisible(true);
			dialog = null;
			break;
		case Const.T_INIC:
			game.start_game();
			dialog = null;
			break;
		case Const.T_SELECC:
			spd.setVisible(true);
			dialog = null;
			break;
		case Const.T_INGR:
			qsd.setVisible(true);
			dialog = null;
			break;
		case Const.T_PUNT:
			dmp = new BestScoresDialog();
			dialog = dmp.createDialog(this, Const.T_PUNT);
			break;
		case Const.T_INSTRUCC:
			dialog = helpDialog.createDialog(this, Const.T_INSTRUCC);
			break;
		case Const.T_ACERCA:
			dialog = aboutDialog.createDialog(this, Const.T_ACERCA);
			break;
		default:
			dialog = null;
		}

		if (dialog != null) {
			dialog.setLocationRelativeTo(this.window);
			dialog.setVisible(true);
		}
	}
}
