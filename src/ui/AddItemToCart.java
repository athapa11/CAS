package ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

import Main.Product;

public class AddItemToCart extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel panelAddProductContent = new JPanel();
	private JTextField txtRetailPrice;
	private JTextField txtQuantity;


	public AddItemToCart(Product product) {
		getContentPane().setForeground(new Color(255, 255, 255));
		setBounds(100, 100, 348, 249);
		setUndecorated(true);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		panelAddProductContent.setForeground(new Color(255, 255, 255));
		panelAddProductContent.setBounds(0, 0, 348, 206);
		panelAddProductContent.setBackground(new Color(0, 153, 153));
		panelAddProductContent.setBorder(new LineBorder(new Color(0, 51, 0)));
		getContentPane().add(panelAddProductContent);
		panelAddProductContent.setLayout(null);
		{
			JLabel lblBrand = new JLabel("Brand");
			lblBrand.setBounds(22, 13, 85, 27);
			lblBrand.setHorizontalAlignment(SwingConstants.RIGHT);
			lblBrand.setForeground(Color.WHITE);
			lblBrand.setFont(new Font("Tahoma", Font.PLAIN, 13));
			panelAddProductContent.add(lblBrand);
		}
		{
			txtRetailPrice = new JTextField();
			txtRetailPrice.setText( Double.toString(product.getRetailPrice()));
			txtRetailPrice.setBounds(133, 75, 116, 24);
			txtRetailPrice.setFont(new Font("Tahoma", Font.PLAIN, 13));
			txtRetailPrice.setColumns(10);
			panelAddProductContent.add(txtRetailPrice);
		}
		
		JLabel lblBrandVal = new JLabel(product.getBrand());
		lblBrandVal.setBounds(123, 13, 339, 27);
		lblBrandVal.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblBrandVal.setForeground(Color.WHITE);
		panelAddProductContent.add(lblBrandVal);
		
		JLabel lblDeviceName = new JLabel("Device");
		lblDeviceName.setBounds(22, 42, 85, 27);
		lblDeviceName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDeviceName.setForeground(Color.WHITE);
		lblDeviceName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelAddProductContent.add(lblDeviceName);
		
		JLabel lblDeviceNameVal = new JLabel(product.getdeviceName());
		lblDeviceNameVal.setBounds(123, 42, 339, 27);
		lblDeviceNameVal.setForeground(Color.WHITE);
		lblDeviceNameVal.setFont(new Font("Tahoma", Font.BOLD, 13));
		panelAddProductContent.add(lblDeviceNameVal);
		{
			JLabel lblPrice = new JLabel("Brand");
			lblPrice.setBounds(22, 74, 85, 27);
			lblPrice.setHorizontalAlignment(SwingConstants.RIGHT);
			lblPrice.setForeground(Color.WHITE);
			lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 13));
			panelAddProductContent.add(lblPrice);
		}
		
		JLabel lblQuantity = new JLabel("Brand");
		lblQuantity.setHorizontalAlignment(SwingConstants.RIGHT);
		lblQuantity.setForeground(Color.WHITE);
		lblQuantity.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblQuantity.setBounds(22, 109, 85, 27);
		panelAddProductContent.add(lblQuantity);
		
		txtQuantity = new JTextField();
		txtQuantity.setText("1");
		txtQuantity.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtQuantity.setColumns(10);
		txtQuantity.setBounds(133, 110, 116, 24);
		panelAddProductContent.add(txtQuantity);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new LineBorder(new Color(0, 51, 0)));
			buttonPane.setBounds(0, 206, 348, 43);
			buttonPane.setForeground(new Color(255, 255, 255));
			buttonPane.setBackground(new Color(0, 153, 153));
			getContentPane().add(buttonPane);
			{
				JButton btnAddProduct = new JButton("Add");
				btnAddProduct.setBounds(165, 11, 78, 23);
				btnAddProduct.setForeground(new Color(0, 0, 0));
				btnAddProduct.setBackground(new Color(255, 255, 255));
				btnAddProduct.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						addToCart();
					}
				});
				buttonPane.setLayout(null);
				btnAddProduct.setActionCommand("OK");
				buttonPane.add(btnAddProduct);
				getRootPane().setDefaultButton(btnAddProduct);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setBounds(253, 11, 85, 23);
				cancelButton.setForeground(new Color(0, 0, 0));
				cancelButton.setBackground(new Color(255, 255, 255));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	private void addToCart() {
		//add product after validation
		//String barcode = txtBarcode.getText();
		//String deviceName = txtDeviceName.getText();
		int quantity = Integer.parseInt(txtQuantity.getText());
		
	}
}
