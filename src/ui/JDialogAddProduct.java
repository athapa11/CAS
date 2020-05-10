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
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

public class JDialogAddProduct extends JDialog {

	private final JPanel panelAddProductContent = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			JDialogAddProduct dialog = new JDialogAddProduct();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public JDialogAddProduct() {
		setBounds(100, 100, 494, 582);
		getContentPane().setLayout(new BorderLayout());
		setUndecorated(true);
		setLocationRelativeTo(null);
		panelAddProductContent.setBackground(new Color(0, 153, 153));
		panelAddProductContent.setBorder(new LineBorder(new Color(0, 0, 0)));
		getContentPane().add(panelAddProductContent, BorderLayout.CENTER);
		panelAddProductContent.setLayout(null);
		{
			textField = new JTextField();
			textField.setFont(new Font("Tahoma", Font.PLAIN, 13));
			textField.setColumns(10);
			textField.setBounds(164, 39, 298, 24);
			panelAddProductContent.add(textField);
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
			textField_1 = new JTextField();
			textField_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
			textField_1.setColumns(10);
			textField_1.setBounds(164, 86, 298, 24);
			panelAddProductContent.add(textField_1);
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
			textField_2 = new JTextField();
			textField_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
			textField_2.setColumns(10);
			textField_2.setBounds(164, 136, 298, 24);
			panelAddProductContent.add(textField_2);
		}
		{
			JLabel lblInvalidBarcode = new JLabel("Invalid Type");
			lblInvalidBarcode.setForeground(new Color(255, 102, 102));
			lblInvalidBarcode.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblInvalidBarcode.setBounds(164, 160, 298, 21);
			panelAddProductContent.add(lblInvalidBarcode);
		}
		{
			textField_3 = new JTextField();
			textField_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
			textField_3.setColumns(10);
			textField_3.setBounds(164, 183, 298, 24);
			panelAddProductContent.add(textField_3);
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
			textField_4 = new JTextField();
			textField_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
			textField_4.setColumns(10);
			textField_4.setBounds(164, 233, 298, 24);
			panelAddProductContent.add(textField_4);
		}
		{
			JLabel lblInvalidColour = new JLabel("Invalid Colour");
			lblInvalidColour.setForeground(new Color(255, 102, 102));
			lblInvalidColour.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblInvalidColour.setBounds(164, 257, 298, 21);
			panelAddProductContent.add(lblInvalidColour);
		}
		{
			textField_5 = new JTextField();
			textField_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
			textField_5.setColumns(10);
			textField_5.setBounds(164, 280, 298, 24);
			panelAddProductContent.add(textField_5);
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
			textField_6 = new JTextField();
			textField_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
			textField_6.setColumns(10);
			textField_6.setBounds(164, 330, 298, 24);
			panelAddProductContent.add(textField_6);
		}
		{
			JLabel lblInvalidQuantity = new JLabel("Invalid Quantity");
			lblInvalidQuantity.setForeground(new Color(255, 102, 102));
			lblInvalidQuantity.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblInvalidQuantity.setBounds(164, 354, 298, 21);
			panelAddProductContent.add(lblInvalidQuantity);
		}
		{
			textField_7 = new JTextField();
			textField_7.setFont(new Font("Tahoma", Font.PLAIN, 13));
			textField_7.setColumns(10);
			textField_7.setBounds(164, 377, 298, 24);
			panelAddProductContent.add(textField_7);
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
			textField_8 = new JTextField();
			textField_8.setFont(new Font("Tahoma", Font.PLAIN, 13));
			textField_8.setColumns(10);
			textField_8.setBounds(164, 426, 298, 24);
			panelAddProductContent.add(textField_8);
		}
		{
			JLabel lblInvalidPrice = new JLabel("Invalid Price");
			lblInvalidPrice.setForeground(new Color(255, 102, 102));
			lblInvalidPrice.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblInvalidPrice.setBounds(164, 450, 298, 21);
			panelAddProductContent.add(lblInvalidPrice);
		}
		{
			textField_9 = new JTextField();
			textField_9.setFont(new Font("Tahoma", Font.PLAIN, 13));
			textField_9.setColumns(10);
			textField_9.setBounds(164, 473, 298, 24);
			panelAddProductContent.add(textField_9);
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
						//add product after validation
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
