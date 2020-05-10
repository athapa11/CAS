package ui;
import javax.swing.JPanel;
import javax.swing.JLabel;
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
		
		JLabel lblNewLabel = new JLabel("Products");
		lblNewLabel.setForeground(new Color(102, 102, 102));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(6, 6, 774, 27);
		add(lblNewLabel);
		
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
