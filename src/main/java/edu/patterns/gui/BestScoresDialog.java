package edu.patterns.gui;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import edu.patterns.player.PlayerFileProxy;

public class BestScoresDialog extends JOptionPane {
    private static final long serialVersionUID = 1L;
    private PlayerFileProxy pfp;

    public BestScoresDialog() {
        pfp = new PlayerFileProxy();
        List<String[]> data = pfp.getData();
        Object[][] datos = pfp.convert(data);
        JTable tabla = new JTable(datos, Const.COL_NAMES);
        JScrollPane scroll = new JScrollPane(tabla);
        this.setMessage(scroll);
    }
}
