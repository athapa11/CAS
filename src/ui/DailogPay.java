package ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

import Main.ActivityLog;
import Main.CartItem;
import Main.Product;
import Main.ShoppingCart;
import auth.User;
import auth.UserSession;

import javax.swing.JRadioButton;

public class DailogPay extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel panelAddProductContent = new JPanel();
	private JTextField txtCreditCard;
	private ShoppingCart cart = new ShoppingCart();
	private JTextField txtEmail;
	private JRadioButton radioPaypal;
	private JRadioButton radioCreditCard;
	private JLabel lblCreditCard;
	private JLabel lblEmail;
	private ArrayList<CartItem> shoppingCartItems;
	private Double totalToPay = 0.00;
	public DailogPay() {
		
		getContentPane().setForeground(new Color(255, 255, 255));
		setBounds(100, 100, 348, 255);
		setUndecorated(true);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);		
		panelAddProductContent.setForeground(new Color(255, 255, 255));
		panelAddProductContent.setBounds(0, 0, 348, 216);
		panelAddProductContent.setBackground(new Color(0, 153, 153));
		panelAddProductContent.setBorder(new LineBorder(new Color(0, 51, 0)));
		getContentPane().add(panelAddProductContent);
	
			
		 shoppingCartItems = cart.getCartItems();
		 totalToPay = cart.getOrderTotal();
		 
		 System.out.print("items count "+ cart.getLineItemCount());
		 System.out.print("total "+ totalToPay);
		
		panelAddProductContent.setLayout(null);
		{
			JLabel lblTotalToPay = new JLabel("Total To Pay");
			lblTotalToPay.setBounds(22, 164, 85, 27);
			lblTotalToPay.setHorizontalAlignment(SwingConstants.RIGHT);
			lblTotalToPay.setForeground(Color.WHITE);
			lblTotalToPay.setFont(new Font("Tahoma", Font.PLAIN, 13));
			panelAddProductContent.add(lblTotalToPay);
		}
		
		lblCreditCard = new JLabel("Credit card");
		lblCreditCard.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCreditCard.setForeground(Color.WHITE);
		lblCreditCard.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCreditCard.setBounds(10, 101, 91, 27);
		panelAddProductContent.add(lblCreditCard);
		
		txtCreditCard = new JTextField();
		txtCreditCard.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtCreditCard.setColumns(10);
		txtCreditCard.setBounds(111, 102, 208, 24);
		panelAddProductContent.add(txtCreditCard);
		{
			JLabel lblTotalVal = new JLabel(formatTotal(totalToPay));
			lblTotalVal.setForeground(Color.WHITE);
			lblTotalVal.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblTotalVal.setBounds(123, 164, 126, 27);
			panelAddProductContent.add(lblTotalVal);
		}
		
		 radioCreditCard = new JRadioButton("Credit card");
		 radioCreditCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radioCreditCard.isSelected()) {
					setCreditCardOption();
				}
			}
		});
		radioCreditCard.setForeground(new Color(255, 255, 255));
		radioCreditCard.setFont(new Font("Tahoma", Font.PLAIN, 13));
		radioCreditCard.setBackground(new Color(0, 153, 153));
		radioCreditCard.setBounds(68, 45, 135, 23);
		panelAddProductContent.add(radioCreditCard);
		
		JLabel lblPaymentHeading = new JLabel("Please select method of payment");
		lblPaymentHeading.setHorizontalAlignment(SwingConstants.CENTER);
		lblPaymentHeading.setForeground(Color.WHITE);
		lblPaymentHeading.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPaymentHeading.setBounds(22, 11, 297, 27);
		panelAddProductContent.add(lblPaymentHeading);
		
		radioPaypal = new JRadioButton("Paypal");
		radioPaypal.setHorizontalAlignment(SwingConstants.LEFT);
		radioPaypal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radioPaypal.isSelected()) {
					setPaypalOption();
				}
			}
		});
		radioPaypal.setBackground(new Color(0, 153, 153));
		radioPaypal.setForeground(new Color(255, 255, 255));
		radioPaypal.setBounds(68, 71, 109, 23);
		panelAddProductContent.add(radioPaypal);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtEmail.setColumns(10);
		txtEmail.setBounds(111, 102, 208, 24);
		panelAddProductContent.add(txtEmail);
		
		lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEmail.setBounds(16, 101, 85, 27);
		panelAddProductContent.add(lblEmail);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new LineBorder(new Color(0, 51, 0)));
			buttonPane.setBounds(0, 215, 348, 43);
			buttonPane.setForeground(new Color(255, 255, 255));
			buttonPane.setBackground(new Color(0, 153, 153));
			getContentPane().add(buttonPane);
			{
				JButton btnPay = new JButton("Pay");
				btnPay.setBounds(165, 11, 78, 23);
				btnPay.setForeground(new Color(0, 0, 0));
				btnPay.setBackground(new Color(255, 255, 255));
				btnPay.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {						
						String message = logActivity();
						dispose();
						 Object[] options = {"OK"};
						  JOptionPane.showOptionDialog(null,
						                   message ,"Your order has been successfully saved.",
						                   JOptionPane.PLAIN_MESSAGE,
						                   JOptionPane.QUESTION_MESSAGE,
						                   null,
						                   options,
						                   options[0]);
					}
				});
				buttonPane.setLayout(null);
				btnPay.setActionCommand("OK");
				buttonPane.add(btnPay);
				getRootPane().setDefaultButton(btnPay);
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
		radioCreditCard.setSelected(true);
		setCreditCardOption();
	}
	
	
	private void setCreditCardOption() {
		radioPaypal.setSelected(false);
		txtCreditCard.setVisible(true);
		lblCreditCard.setVisible(true);
		txtEmail.setVisible(false);
		lblEmail.setVisible(false);		
	}
	
	private void setPaypalOption() {
		radioCreditCard.setSelected(false);
		txtCreditCard.setVisible(false);
		lblCreditCard.setVisible(false);
		txtEmail.setVisible(true);
		lblEmail.setVisible(true);
	}
	
	private String logActivity() {
		String paymentMethod = "Credit Card";
		if(radioPaypal.isSelected()) {
			paymentMethod =  "PayPal";
		}
		
		String message =formatTotal(totalToPay) + " paid using " + paymentMethod;
		
		ActivityLog log = new ActivityLog();
		for (CartItem item : shoppingCartItems) {
			log.addActivity(item, "purchased", paymentMethod);
		}
		cart.setCartItems( new ArrayList<CartItem> ());//remove all items
		cart.setOrderTotal(0.00);
		
	 return message;
	}
	
	private String formatTotal(Double total) {
		DecimalFormat decimalFormat = new DecimalFormat(".##");
		return decimalFormat.format(total); 
	}
}
