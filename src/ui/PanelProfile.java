package ui;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class PanelProfile extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelProfile() {
		setBackground(new Color(255, 255, 255));
		setBounds(0, 0, 992, 483);
		setLayout(null);
		setVisible(true);
		
		JLabel lblNewLabel = new JLabel("Profile");
		lblNewLabel.setForeground(new Color(153, 153, 153));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 802, 39);
		add(lblNewLabel);
	}

}
