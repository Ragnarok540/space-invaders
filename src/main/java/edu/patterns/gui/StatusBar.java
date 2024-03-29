package edu.patterns.gui;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

public final class StatusBar extends JPanel {
    private static final long serialVersionUID = 1L;
    private JLabel statusLabel = new JLabel(Const.ESTADO_INI);

    public StatusBar() {
        super();
        this.setBorder(new BevelBorder(BevelBorder.LOWERED));
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.statusLabel.setHorizontalAlignment(SwingConstants.LEFT);
        this.add(statusLabel);
    }

    public void setStatus(final String status) {
        this.statusLabel.setText(status);
    }

    public void setStatus(final String nick, final int score,
        final int lives, final boolean launchingMissile) {
        this.statusLabel.setText(Const.ESTADO[0]
                + nick
                + Const.ESTADO[1]
                + score
                + Const.ESTADO[2]
                + lives
                + Const.ESTADO[3]
                + (launchingMissile ? Const.ESTADO[4] : Const.ESTADO[5]));
    }
}
