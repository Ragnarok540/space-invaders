package edu.patterns.gui;

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

import edu.patterns.player.PlayerFile;
import edu.patterns.player.PlayerFileProxy;
import edu.patterns.player.MementoPlayer;

public final class SelectPlayerDialog extends JDialog
    implements PropertyChangeListener {
    private static final long serialVersionUID = 1L;
    private static final int WIDTH = 320;
    private static final int HEIGHT = 160;
    private JOptionPane optionPane;
    private JComboBox<String> combo;
    private Game game;

    public SelectPlayerDialog(final JFrame window, final Game game) {
        super(window, true);
        setTitle(Const.T_SELECC);
        this.game = game;
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
            public void componentShown(final ComponentEvent ce) {
                PlayerFileProxy pfp = new PlayerFileProxy();
                List<String[]> data = pfp.getData();
                SortedSet<String> nickNames = pfp.nickNames(data);
                combo.removeAllItems();

                for (String nick: nickNames) {
                    combo.addItem(nick);
                }

                combo.setSelectedIndex(0);
                combo.requestFocusInWindow();
            }
        });

        optionPane.addPropertyChangeListener(this);

        setSize(new Dimension(WIDTH, HEIGHT));
        setResizable(false);
        setLocationRelativeTo(window);
    }

    @Override
    public void propertyChange(final PropertyChangeEvent pce) {
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
                String selection = (String) combo.getSelectedItem();
                loadPlayer(selection);
                closeDialog();
            } else {
                closeDialog();
            }
        }
    }

    private void closeDialog() {
        setVisible(false);
    }

    private void loadPlayer(final String selection) {
        PlayerFile pf = new PlayerFile();
        MementoPlayer mp = pf.open(selection);
        game.setPlayer(mp);
        game.startGame();
    }
}
