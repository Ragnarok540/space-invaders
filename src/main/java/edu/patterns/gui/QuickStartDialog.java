package edu.patterns.gui;

import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import edu.patterns.interfaces.IPlayerNullObject;
import edu.patterns.player.PlayerFile;
import edu.patterns.player.Player;
import edu.patterns.player.MementoPlayer;
import edu.patterns.player.NullPlayer;

public final class QuickStartDialog extends JDialog
    implements PropertyChangeListener {
    private static final long serialVersionUID = 1L;
    private static final int WIDTH = 320;
    private static final int HEIGHT = 160;
    private static final int TF_LENGHT = 10;
    private static final int MAX_NICK_LENGHT = 6;
    private JOptionPane optionPane;
    private JTextField tfNickName;
    private String nickName;
    private Game game;

    public QuickStartDialog(final JFrame window, final Game game) {
        super(window, true);
        this.game = game;
        setTitle(Const.T_INGR);
        tfNickName = new JTextField(TF_LENGHT);
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
            public void componentShown(final ComponentEvent ce) {
                tfNickName.requestFocusInWindow();
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

            if (value.equals(Const.T_INIC)) {
                nickName = tfNickName.getText();
                boolean nickOk = nickName.matches(Const.NICK_REGEX);
                boolean lnickOk = nickName.length() < MAX_NICK_LENGHT;

                if (nickOk && lnickOk) {
                    loadPlayer();
                    closeDialog();
                } else {
                    nickError();
                }
            } else {
                closeDialog();
            }
        }
    }

    private void nickError() {
        tfNickName.selectAll();
        JOptionPane.showMessageDialog(
                this,
                Const.E_NICK_V,
                Const.INTENTAR,
                JOptionPane.WARNING_MESSAGE);
        nickName = null;
        tfNickName.requestFocusInWindow();
    }

    private void unexistentNickError(final IPlayerNullObject player) {
        tfNickName.selectAll();
        JOptionPane.showMessageDialog(
                this,
                player.getNickName(),
                Const.INTENTAR,
                JOptionPane.ERROR_MESSAGE);
        nickName = null;
        tfNickName.requestFocusInWindow();
    }

    private void closeDialog() {
        tfNickName.setText(null);
        setVisible(false);
    }

    private void loadPlayer() {
        PlayerFile pf = new PlayerFile();
        IPlayerNullObject player;

        if (pf.playerExists(nickName)) {
            player = new Player();
            MementoPlayer mp = pf.open(nickName);
            game.setPlayer(mp);
            game.startGame();
        } else {
            player = new NullPlayer();
            unexistentNickError(player);
        }
    }
}
