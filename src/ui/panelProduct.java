package ui;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Font;

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
		
		JPanel panelProductHeading = new JPanel();
		panelProductHeading.setBackground(new Color(102, 153, 153));
		panelProductHeading.setBounds(0, 0, 992, 55);
		add(panelProductHeading);
		panelProductHeading.setLayout(null);
		
		JLabel lblProductTitle = new JLabel("Products");
		lblProductTitle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblProductTitle.setBounds(0, 0, 213, 55);
		panelProductHeading.add(lblProductTitle);
		lblProductTitle.setForeground(new Color(255, 255, 255));
		lblProductTitle.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblAddProduct = new JLabel("Add Product");
		lblAddProduct.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddProduct.setForeground(Color.WHITE);
		lblAddProduct.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAddProduct.setBounds(656, 12, 165, 31);
		panelProductHeading.add(lblAddProduct);
		
		JLabel lblCart = new JLabel("Cart");
		lblCart.setHorizontalAlignment(SwingConstants.CENTER);
		lblCart.setForeground(Color.WHITE);
		lblCart.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCart.setBounds(826, 14, 78, 27);
		panelProductHeading.add(lblCart);
	}
}
