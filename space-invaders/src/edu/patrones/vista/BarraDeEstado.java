package edu.patrones.vista;


import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;


public class BarraDeEstado extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel labelEstado = new JLabel("Cree o seleccione un jugador para empezar...");

	public BarraDeEstado() {
		super();
		this.setBorder(new BevelBorder(BevelBorder.LOWERED));
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		this.labelEstado.setHorizontalAlignment(SwingConstants.LEFT);
		this.add(labelEstado);
	}

	public void setEstado(String estado) {
		this.labelEstado.setText(estado);
	}

}
