package ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import Main.Product;
import Main.Basket;
import Main.User;
import Main.UserSession;

public class PanelProducts extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable tableProducts;

	private DefaultTableModel productTableModel;
	
	private ArrayList<Product> sortedProducts = null;
	
	private User currentUser = null;                                            
	private int lastColIndex = 0;
	Basket cart = new Basket();
	public PanelProducts() {
		
		setForeground(new Color(0, 0, 0));
		setBackground(new Color(0, 153, 153));
		setBounds(0, 0, 992, 483);
		setLayout(null);
		setVisible(true);
		sortedProducts = Product.getProducts();
	    currentUser = UserSession.getCurrentUser(); 
        
		lastColIndex = currentUser.isAdmin() ? 7 : 6;
		
		prepareProductcolumns();
		
		JPanel panelProductsHeading = new JPanel();
		panelProductsHeading.setBackground(new Color(102, 153, 153));
		panelProductsHeading.setBounds(0, 0, 992, 55);
		add(panelProductsHeading);
		panelProductsHeading.setLayout(null);
		
		JLabel lblProductTitle = new JLabel("Products");
		lblProductTitle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblProductTitle.setBounds(0, 0, 213, 55);
		panelProductsHeading.add(lblProductTitle);
		lblProductTitle.setForeground(new Color(255, 255, 255));
		lblProductTitle.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblAddProduct = new JLabel("Add Product");
		lblAddProduct.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// open JDilog to add product 
				DialogAddProduct addProduct = new DialogAddProduct();
				addProduct.setVisible(true);
				
				addProduct.addWindowListener(new WindowAdapter() 
				{
				  public void windowClosed(WindowEvent e)
				  {
					  System.out.println("add product dialog: ");
					  productTableModel.setRowCount(0);
					  sortedProducts = Product.getProducts();
					  fillProductTable();
				  }
				});
			}
		});
		lblAddProduct.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddProduct.setForeground(Color.WHITE);
		lblAddProduct.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAddProduct.setBounds(636, 12, 165, 31);
		panelProductsHeading.add(lblAddProduct);
		
		JLabel lblBasket = new JLabel("Basket");
		lblBasket.setHorizontalAlignment(SwingConstants.CENTER);
		lblBasket.setForeground(Color.WHITE);
		lblBasket.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBasket.setBounds(899, 14, 78, 27);
		panelProductsHeading.add(lblBasket);
		
		JScrollPane scrollTableProducts = new JScrollPane();
		scrollTableProducts.setBounds(0, 55, 992, 382);
		add(scrollTableProducts);
		
		tableProducts = new JTable(productTableModel);
		tableProducts.getColumnModel().getColumn(lastColIndex+1).setCellRenderer(new CustomButtonRenderer());;
		tableProducts.getColumnModel().getColumn(lastColIndex+1).setCellEditor(new ActionButtonEditor(new JTextField()));

		tableProducts.getColumnModel().getColumn(lastColIndex).setPreferredWidth(280);
		tableProducts.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		scrollTableProducts.setViewportView(tableProducts);
		
		JLabel lblFilterByBrandName = new JLabel("Filter By Brand :");
		lblFilterByBrandName.setForeground(new Color(255, 255, 255));
		lblFilterByBrandName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblFilterByBrandName.setHorizontalAlignment(SwingConstants.CENTER);
		lblFilterByBrandName.setBounds(58, 438, 152, 45);
		add(lblFilterByBrandName);
		
		JLabel lblBrandName = new JLabel("");
		lblBrandName.setForeground(new Color(255, 255, 255));
		lblBrandName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBrandName.setBounds(215, 438, 152, 45);
		add(lblBrandName);
		
		JLabel lblFilterByKeyboard = new JLabel("Filter By UK Keyboards");
		lblFilterByKeyboard.setHorizontalAlignment(SwingConstants.CENTER);
		lblFilterByKeyboard.setForeground(new Color(255, 255, 255));
		lblFilterByKeyboard.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblFilterByKeyboard.setBounds(690, 438, 302, 45);
		add(lblFilterByKeyboard);
		fillProductTable();
		
	}
	
	private void fillProductTable() {
		for (Product item : sortedProducts) 
		{
			String addtionalInfo = item.getFormattedAdditionalInfo();
			if(currentUser.isAdmin()) 
			{
				Object[] data = {item.getBarcode(), item.getBrand(), item.getColour(), item.getConnectivity(), item.getStockQuantity(), 
						item.getOriginalCost(), item.getRetailPrice(), addtionalInfo, "Update"
				};
				productTableModel.addRow(data); 
			
		  }
			else 
		  {
			  Object[] data = {item.getBarcode(), item.getBrand(), item.getColour(), item.getConnectivity(), item.getStockQuantity(), 
						item.getRetailPrice(), addtionalInfo , "Add to cart"
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
				 /**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				@Override
				public boolean isCellEditable(int row, int column) {
					//all cells false
				    return true;
				}
			};
		} else {
			String col[] = {"Barcode", "Brand", "Colour", "Connectivity", "Quantity",
					"Retail price", "Additional information", "Action"};
			
			productTableModel = new DefaultTableModel(col, 0) {
				 /**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				@Override
				public boolean isCellEditable(int row, int column) {
					//all cells false
				    return true;
				}
			};
		}
		
	
	}
	
	class CustomButtonRenderer extends JButton implements  TableCellRenderer {
		private static final long serialVersionUID = 1L;
	
		public CustomButtonRenderer() {
		  setOpaque(true);
		}
		
		@Override
		public Component getTableCellRendererComponent(JTable table, Object obj,
		    boolean selected, boolean focused, int row, int col) {
		
		    setText((obj==null) ? "":obj.toString());
		
		  return this;
		}
	
	}

	class ActionButtonEditor extends DefaultCellEditor {
		private static final long serialVersionUID = 1L;
		protected JButton actionBtn;
		private String btnLabel;
		private Boolean isClicked;
		Product selectedProduct = null;
	
		public ActionButtonEditor(JTextField txt) {
			super(txt);
	
			actionBtn=new JButton();
			actionBtn.setOpaque(true);
	
			actionBtn.addActionListener(new ActionListener() {
			    @Override
			    public void actionPerformed(ActionEvent e) {
			
			      fireEditingStopped();
			    }
			});
		}
		 
		 @Override
		 public Component getTableCellEditorComponent(JTable table, Object obj, boolean selected, int row, int col) {
			 setSelectedProduct(row);
			 btnLabel=(obj==null) ? "":obj.toString();
			 actionBtn.setText(btnLabel);
		     isClicked=true;
		     return actionBtn;
		  }
	
		   @Override
		 public Object getCellEditorValue()
		 {
			   if(isClicked) {
				   System.out.println("label : "  + btnLabel);
				   System.out.println("selected product: "  + selectedProduct.getdeviceName());
				   if(btnLabel.equals("Update")) {
					   JOptionPane.showMessageDialog(actionBtn, btnLabel+" Clicked");
				   } else {
			   		  DialogAddToBasket addItem = new DialogAddToBasket(selectedProduct);
			   		  addItem.setVisible(true);
			   		}
			   }
			   isClicked=false;
			   return new String(btnLabel);
		 }
	
		   @Override
		 public boolean stopCellEditing() {
			   isClicked=false;
			   return super.stopCellEditing();
		 }
	
		   @Override
		 protected void fireEditingStopped() {
			   super.fireEditingStopped();
		 }
		   
		 public void setSelectedProduct (int selectedIndex) {
			 for (int i = 0; i < sortedProducts.size(); i ++) {
				 if(selectedIndex == i) {
					 selectedProduct =  sortedProducts.get(i);
					 break;
				 }
			 }
		 }	
	}
}
