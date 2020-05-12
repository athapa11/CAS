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

public class AddProduct extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel panelAddProductContent = new JPanel();
	private JTextField txtBarcode;
	private JTextField txtDeviceName;
	private JTextField txtDeviceType;
	private JTextField txtBrand;
	private JTextField txtColour;
	private JTextField txtConnectivity;
	private JTextField txtQuantity;
	private JTextField txtOriginalCost;
	private JTextField txtRetailPrice;
	private JTextField txtAdditionalInfo;


	/**
	 * Create the dialog.
	 */
	public AddProduct() {
		setBounds(100, 100, 494, 582);
		getContentPane().setLayout(new BorderLayout());
		setUndecorated(true);
		setLocationRelativeTo(null);
		panelAddProductContent.setBackground(new Color(0, 153, 153));
		panelAddProductContent.setBorder(new LineBorder(new Color(0, 0, 0)));
		getContentPane().add(panelAddProductContent, BorderLayout.CENTER);
		panelAddProductContent.setLayout(null);
		{
			txtBarcode = new JTextField();
			txtBarcode.setFont(new Font("Tahoma", Font.PLAIN, 13));
			txtBarcode.setColumns(10);
			txtBarcode.setBounds(164, 39, 298, 24);
			panelAddProductContent.add(txtBarcode);
		}
		{
			JLabel lblBarcodeError = new JLabel("Invalid Barcode");
			lblBarcodeError.setForeground(new Color(255, 102, 102));
			lblBarcodeError.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblBarcodeError.setBounds(164, 63, 298, 21);
			panelAddProductContent.add(lblBarcodeError);
		}
		{
			JLabel lblBarcode = new JLabel("Barcode");
			lblBarcode.setHorizontalAlignment(SwingConstants.RIGHT);
			lblBarcode.setForeground(Color.WHITE);
			lblBarcode.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblBarcode.setBounds(0, 39, 149, 24);
			panelAddProductContent.add(lblBarcode);
		}
		{
			JLabel lblBarcode = new JLabel("Device Name");
			lblBarcode.setHorizontalAlignment(SwingConstants.RIGHT);
			lblBarcode.setForeground(Color.WHITE);
			lblBarcode.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblBarcode.setBounds(0, 83, 149, 27);
			panelAddProductContent.add(lblBarcode);
		}
		{
			txtDeviceName = new JTextField();
			txtDeviceName.setFont(new Font("Tahoma", Font.PLAIN, 13));
			txtDeviceName.setColumns(10);
			txtDeviceName.setBounds(164, 86, 298, 24);
			panelAddProductContent.add(txtDeviceName);
		}
		{
			JLabel lblBarcodeError = new JLabel("Invalid Device Name");
			lblBarcodeError.setForeground(new Color(255, 102, 102));
			lblBarcodeError.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblBarcodeError.setBounds(164, 113, 298, 16);
			panelAddProductContent.add(lblBarcodeError);
		}
		{
			JLabel lblDeviceType = new JLabel("Device Type");
			lblDeviceType.setHorizontalAlignment(SwingConstants.RIGHT);
			lblDeviceType.setForeground(Color.WHITE);
			lblDeviceType.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblDeviceType.setBounds(0, 136, 149, 24);
			panelAddProductContent.add(lblDeviceType);
		}
		{
			txtDeviceType = new JTextField();
			txtDeviceType.setFont(new Font("Tahoma", Font.PLAIN, 13));
			txtDeviceType.setColumns(10);
			txtDeviceType.setBounds(164, 136, 298, 24);
			panelAddProductContent.add(txtDeviceType);
		}
		{
			JLabel lblInvalidBarcode = new JLabel("Invalid Type");
			lblInvalidBarcode.setForeground(new Color(255, 102, 102));
			lblInvalidBarcode.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblInvalidBarcode.setBounds(164, 160, 298, 21);
			panelAddProductContent.add(lblInvalidBarcode);
		}
		{
			txtBrand = new JTextField();
			txtBrand.setFont(new Font("Tahoma", Font.PLAIN, 13));
			txtBrand.setColumns(10);
			txtBrand.setBounds(164, 183, 298, 24);
			panelAddProductContent.add(txtBrand);
		}
		{
			JLabel lblInvalidBrand = new JLabel("Invalid Brand");
			lblInvalidBrand.setForeground(new Color(255, 102, 102));
			lblInvalidBrand.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblInvalidBrand.setBounds(164, 210, 298, 16);
			panelAddProductContent.add(lblInvalidBrand);
		}
		{
			JLabel lblBrand = new JLabel("Brand");
			lblBrand.setHorizontalAlignment(SwingConstants.RIGHT);
			lblBrand.setForeground(Color.WHITE);
			lblBrand.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblBrand.setBounds(0, 180, 149, 27);
			panelAddProductContent.add(lblBrand);
		}
		{
			JLabel lblColour = new JLabel("Colour");
			lblColour.setHorizontalAlignment(SwingConstants.RIGHT);
			lblColour.setForeground(Color.WHITE);
			lblColour.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblColour.setBounds(0, 233, 149, 24);
			panelAddProductContent.add(lblColour);
		}
		{
			txtColour = new JTextField();
			txtColour.setFont(new Font("Tahoma", Font.PLAIN, 13));
			txtColour.setColumns(10);
			txtColour.setBounds(164, 233, 298, 24);
			panelAddProductContent.add(txtColour);
		}
		{
			JLabel lblInvalidColour = new JLabel("Invalid Colour");
			lblInvalidColour.setForeground(new Color(255, 102, 102));
			lblInvalidColour.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblInvalidColour.setBounds(164, 257, 298, 21);
			panelAddProductContent.add(lblInvalidColour);
		}
		{
			txtConnectivity = new JTextField();
			txtConnectivity.setFont(new Font("Tahoma", Font.PLAIN, 13));
			txtConnectivity.setColumns(10);
			txtConnectivity.setBounds(164, 280, 298, 24);
			panelAddProductContent.add(txtConnectivity);
		}
		{
			JLabel lblInvalidConnectivity = new JLabel("Invalid Connectivity");
			lblInvalidConnectivity.setForeground(new Color(255, 102, 102));
			lblInvalidConnectivity.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblInvalidConnectivity.setBounds(164, 307, 298, 16);
			panelAddProductContent.add(lblInvalidConnectivity);
		}
		{
			JLabel lblConnectivity = new JLabel("Connectivity");
			lblConnectivity.setHorizontalAlignment(SwingConstants.RIGHT);
			lblConnectivity.setForeground(Color.WHITE);
			lblConnectivity.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblConnectivity.setBounds(0, 277, 149, 27);
			panelAddProductContent.add(lblConnectivity);
		}
		{
			JLabel lblQuantityInStock = new JLabel("Quantity in Stock");
			lblQuantityInStock.setHorizontalAlignment(SwingConstants.RIGHT);
			lblQuantityInStock.setForeground(Color.WHITE);
			lblQuantityInStock.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblQuantityInStock.setBounds(0, 330, 149, 24);
			panelAddProductContent.add(lblQuantityInStock);
		}
		{
			txtQuantity = new JTextField();
			txtQuantity.setFont(new Font("Tahoma", Font.PLAIN, 13));
			txtQuantity.setColumns(10);
			txtQuantity.setBounds(164, 330, 298, 24);
			panelAddProductContent.add(txtQuantity);
		}
		{
			JLabel lblInvalidQuantity = new JLabel("Invalid Quantity");
			lblInvalidQuantity.setForeground(new Color(255, 102, 102));
			lblInvalidQuantity.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblInvalidQuantity.setBounds(164, 354, 298, 21);
			panelAddProductContent.add(lblInvalidQuantity);
		}
		{
			txtOriginalCost = new JTextField();
			txtOriginalCost.setFont(new Font("Tahoma", Font.PLAIN, 13));
			txtOriginalCost.setColumns(10);
			txtOriginalCost.setBounds(164, 377, 298, 24);
			panelAddProductContent.add(txtOriginalCost);
		}
		{
			JLabel lblInvalidCost = new JLabel("Invalid Cost");
			lblInvalidCost.setForeground(new Color(255, 102, 102));
			lblInvalidCost.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblInvalidCost.setBounds(164, 404, 298, 16);
			panelAddProductContent.add(lblInvalidCost);
		}
		{
			JLabel lblOriginalCost = new JLabel("Original Cost");
			lblOriginalCost.setHorizontalAlignment(SwingConstants.RIGHT);
			lblOriginalCost.setForeground(Color.WHITE);
			lblOriginalCost.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblOriginalCost.setBounds(0, 374, 149, 27);
			panelAddProductContent.add(lblOriginalCost);
		}
		{
			JLabel lblRetailPrice = new JLabel("Retail Price");
			lblRetailPrice.setHorizontalAlignment(SwingConstants.RIGHT);
			lblRetailPrice.setForeground(Color.WHITE);
			lblRetailPrice.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblRetailPrice.setBounds(0, 426, 149, 24);
			panelAddProductContent.add(lblRetailPrice);
		}
		{
			txtRetailPrice = new JTextField();
			txtRetailPrice.setFont(new Font("Tahoma", Font.PLAIN, 13));
			txtRetailPrice.setColumns(10);
			txtRetailPrice.setBounds(164, 426, 298, 24);
			panelAddProductContent.add(txtRetailPrice);
		}
		{
			JLabel lblInvalidPrice = new JLabel("Invalid Price");
			lblInvalidPrice.setForeground(new Color(255, 102, 102));
			lblInvalidPrice.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblInvalidPrice.setBounds(164, 450, 298, 21);
			panelAddProductContent.add(lblInvalidPrice);
		}
		{
			txtAdditionalInfo = new JTextField();
			txtAdditionalInfo.setFont(new Font("Tahoma", Font.PLAIN, 13));
			txtAdditionalInfo.setColumns(10);
			txtAdditionalInfo.setBounds(164, 473, 298, 24);
			panelAddProductContent.add(txtAdditionalInfo);
		}
		{
			JLabel lblInvalidInfo = new JLabel("Invalid Info");
			lblInvalidInfo.setForeground(new Color(255, 102, 102));
			lblInvalidInfo.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblInvalidInfo.setBounds(164, 500, 298, 16);
			panelAddProductContent.add(lblInvalidInfo);
		}
		{
			JLabel lblAdditionalInfo = new JLabel("Additional Info");
			lblAdditionalInfo.setHorizontalAlignment(SwingConstants.RIGHT);
			lblAdditionalInfo.setForeground(Color.WHITE);
			lblAdditionalInfo.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblAdditionalInfo.setBounds(0, 470, 149, 27);
			panelAddProductContent.add(lblAdditionalInfo);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setForeground(new Color(255, 255, 255));
			buttonPane.setBackground(new Color(255, 255, 255));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnAddProduct = new JButton("Add Product");
				btnAddProduct.setForeground(new Color(255, 255, 255));
				btnAddProduct.setBackground(new Color(0, 153, 153));
				btnAddProduct.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Product.addProductToStock(txtBarcode, txtDeviceName, txtDeviceType, txtBrand, txtColour, txtConnectivity, 
								txtQuantity, txtOriginalCost, txtRetailPrice, txtAdditionalInfo);
						dispose();
					}
				});
				btnAddProduct.setActionCommand("OK");
				buttonPane.add(btnAddProduct);
				getRootPane().setDefaultButton(btnAddProduct);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setForeground(new Color(255, 255, 255));
				cancelButton.setBackground(new Color(0, 153, 153));
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
	
	
}
