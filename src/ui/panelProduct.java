package ui;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

import Main.*;
import javax.swing.JTable;
import javax.swing.JScrollPane;


import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class PanelProduct extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable tableProducts;
	private String col[] = {"Barcode", "Name", "Type", "Brand", "Colour", "Connectivity", "In stock", "Original cost",
			"Retail price", "Additional information"};

	private DefaultTableModel productTableModel = new DefaultTableModel(col, 0);
	                                            // The 0 argument is number rows.
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
		lblAddProduct.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// open JDilog to add product 
				JDialogAddProduct addProduct = new JDialogAddProduct();
				addProduct.setVisible(true);
			}
		});
		lblAddProduct.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddProduct.setForeground(Color.WHITE);
		lblAddProduct.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAddProduct.setBounds(636, 12, 165, 31);
		panelProductHeading.add(lblAddProduct);
		
		JLabel lblCart = new JLabel("Cart");
		lblCart.setHorizontalAlignment(SwingConstants.CENTER);
		lblCart.setForeground(Color.WHITE);
		lblCart.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCart.setBounds(899, 14, 78, 27);
		panelProductHeading.add(lblCart);
		
		JScrollPane scrollTableProducts = new JScrollPane();
		scrollTableProducts.setBounds(142, 42, 789, 382);
		add(scrollTableProducts);
		
		

		tableProducts = new JTable(productTableModel);
		scrollTableProducts.setViewportView(tableProducts);
		getProducts();
	
	}
	
	
	
	
	private void getProducts()
	{
		Scanner fileScanner = null;
		ArrayList<Product> products = new ArrayList<Product>();
		
		try {
			File stockFile = new File("Stock.txt");
			fileScanner = new Scanner(stockFile);
			
			Mouse mouse = null;
			Keyboard keyboard = null;
			
			while (fileScanner.hasNextLine()) 
			{
				String[] attributes = fileScanner.nextLine().split(",");
				
				if (attributes[1].equals("mouse")) 
				{
					mouse = new Mouse(
							Integer.parseInt(attributes[0].trim()),
							attributes[1].trim(), 
							attributes[2].trim(), 
							attributes[3].trim(), 
							attributes[4].trim(), 
							attributes[5].trim(), 
							Integer.parseInt(attributes[6].trim()), 
							Double.parseDouble(attributes[7].trim()), 
							Double.parseDouble(attributes[8].trim()), 
							Integer.parseInt(attributes[9].trim())
							);
					products.add(mouse);
					products.add(keyboard);
					Object[] data = {Integer.parseInt(attributes[0].trim()),
							attributes[1].trim(), 
							attributes[2].trim(), 
							attributes[3].trim(), 
							attributes[4].trim(), 
							attributes[5].trim(), 
							Integer.parseInt(attributes[6].trim()), 
							Double.parseDouble(attributes[7].trim()), 
							Double.parseDouble(attributes[8].trim()), 
							Integer.parseInt(attributes[9].trim())};
					productTableModel.addRow(data);
				}
				else 
				{
					keyboard = new Keyboard(
							Integer.parseInt(attributes[0].trim()), 
							attributes[1].trim(), 
							attributes[2].trim(), 
							attributes[3].trim(), 
							attributes[4].trim(), 
							attributes[5].trim(), 
							Integer.parseInt(attributes[6].trim()), 
							Double.parseDouble(attributes[7].trim()), 
							Double.parseDouble(attributes[8].trim()), 
							attributes[9].trim()
							);
					//System.out.println(keyboard);
					products.add(keyboard);
					Object[] data = {Integer.parseInt(attributes[0].trim()), 
							attributes[1].trim(), 
							attributes[2].trim(), 
							attributes[3].trim(), 
							attributes[4].trim(), 
							attributes[5].trim(), 
							Integer.parseInt(attributes[6].trim()), 
							Double.parseDouble(attributes[7].trim()), 
							Double.parseDouble(attributes[8].trim()), 
							attributes[9].trim()};
					productTableModel.addRow(data);

				}
				
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		finally 
		{
			fileScanner.close();
		}
	}

	}
}
