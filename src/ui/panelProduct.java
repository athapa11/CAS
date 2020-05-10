package ui;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PanelProduct extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelProduct() {
		setForeground(new Color(0, 0, 0));
		setBackground(new Color(255, 255, 255));
		setBounds(0, 0, 992, 483);
		setLayout(null);
		setVisible(true);
		
		JLabel lblNewLabel = new JLabel("Products");
		lblNewLabel.setForeground(new Color(102, 102, 102));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(6, 6, 774, 27);
		add(lblNewLabel);
	}

}
