package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import Main.Product;
import auth.*;


public class PanelProduct extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable tableProducts;

	private DefaultTableModel productTableModel;
	
	private User currentUser = UserSession.getCurrentUser(); //new User(101, "user1", "Smith", 12, "LE11 3TU", "Loughborough", "admin");
	                                            // The 0 argument is number rows.
	private int lastColIndex = currentUser.isAdmin() ? 7 : 6;
	public PanelProduct() {
		setForeground(new Color(0, 0, 0));
		setBackground(new Color(255, 255, 255));
		setBounds(0, 0, 992, 483);
		setLayout(null);
		setVisible(true);
		prepareProductcolumns();
		
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
				AddProduct addProduct = new AddProduct();
				addProduct.setVisible(true);
				
				addProduct.addWindowListener(new WindowAdapter() 
				{
				  public void windowClosed(WindowEvent e)
				  {
					  productTableModel.setRowCount(0);
					  getProducts();				    
				  }
				});
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
		scrollTableProducts.setBounds(0, 55, 992, 382);
		add(scrollTableProducts);
		
		

		tableProducts = new JTable(productTableModel);

		tableProducts.getColumnModel().getColumn(lastColIndex).setPreferredWidth(280);
		tableProducts.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		scrollTableProducts.setViewportView(tableProducts);
		getProducts();
	
	}
	
	
	public void getProducts()
	{
		Scanner fileScanner = null;
		ArrayList<Product> products = new ArrayList<Product>();
		try {
			File stockFile = new File("Stock.txt");
			fileScanner = new Scanner(stockFile);			
			
				while (fileScanner.hasNextLine()) 
				{
					String[] attributes = fileScanner.nextLine().split(",");				
					
					Product product = 	new Product (
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
				products.add(product);
					
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
		fillProductTable(products);
	}

	private ArrayList<Product> sortProductsByQuantity(ArrayList<Product> products) {
		Collections.sort(products, new Comparator<Product>(){
		    public int compare(Product p1, Product p2) {
		        
		    	if (p1.getStockQuantity() > p2.getStockQuantity()) {
		            return -1;
		        } else if (p1.getStockQuantity() < p2.getStockQuantity()) {
		            return 1;
		        }
		        return 0;
		    }
		});
		
		return products;
		
	}
	
	private void fillProductTable(ArrayList<Product> products) {
		ArrayList<Product> sortedProducts = sortProductsByQuantity(products);
		for (Product item : sortedProducts) {
			String addtionalInfo = item.getFormattedAdditionalInfo();
			if(currentUser.isAdmin()) {
				Object[] data = {item.getBarcode(), item.getBrand(), item.getColour(), item.getConnectivity(), item.getStockQuantity(), item.getOriginalCost(), 
						item.getRetailPrice(), addtionalInfo
				};
				productTableModel.addRow(data); 
			
		  }else {
			  Object[] data = {item.getBarcode(), item.getBrand(), item.getColour(), item.getConnectivity(), item.getStockQuantity(), 
						item.getRetailPrice(), addtionalInfo
				};
				productTableModel.addRow(data); 
		  }
	    }
	}
	
	private void prepareProductcolumns() {
		if(currentUser.isAdmin()) {
			String col[] = {"Barcode", "Brand", "Colour", "Connectivity", "Quantity", "Original cost",
					"Retail price", "Additional information", "Action"};
			productTableModel = new DefaultTableModel(col, 0) {
				 @Override
				    public boolean isCellEditable(int row, int column) {
				       //all cells false
				       return false;
				    }
			};
		}else {
			String col[] = {"Barcode", "Brand", "Colour", "Connectivity", "Quantity",
					"Retail price", "Additional information", "Action"};
			
			productTableModel = new DefaultTableModel(col, 0) {
				 @Override
				    public boolean isCellEditable(int row, int column) {
				       //all cells false
				       return false;
				    }
			};
		}
		
	
	}
	
	
}
