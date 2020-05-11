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
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import Main.CartItem;
import Main.Product;
import Main.ShoppingCart;
import auth.*;


public class PanelShoppingCart extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable tableCartItem;

	private DefaultTableModel productCartModel;
	private User currentUser = null;
	private ShoppingCart cart = new ShoppingCart();
	private ArrayList<CartItem> shoppingCartItems;
	String col[] = {"Barcode", "Brand",  "Quantity", "Price", "Action"};
	public PanelShoppingCart() {
		setForeground(new Color(0, 0, 0));
		setBackground(new Color(255, 255, 255));
		setBounds(0, 0, 992, 483);
		setLayout(null);
		setVisible(true);
	    currentUser = UserSession.getCurrentUser(); 
		
		shoppingCartItems = cart.getCartItems();
		
		productCartModel = new DefaultTableModel(col, 0) {
			 @Override
			    public boolean isCellEditable(int row, int column) {
			       return true;
			    }
		};
		
		JPanel panelCartItemHeading = new JPanel();
		panelCartItemHeading.setBackground(new Color(102, 153, 153));
		panelCartItemHeading.setBounds(0, 0, 992, 55);
		add(panelCartItemHeading);
		panelCartItemHeading.setLayout(null);
		
		JLabel lblCartTitle = new JLabel("Cart");
		lblCartTitle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCartTitle.setBounds(0, 0, 213, 55);
		panelCartItemHeading.add(lblCartTitle);
		lblCartTitle.setForeground(new Color(255, 255, 255));
		lblCartTitle.setHorizontalAlignment(SwingConstants.CENTER);
		
		JScrollPane scrollTableCartItems = new JScrollPane();
		scrollTableCartItems.setBounds(0, 55, 992, 382);
		add(scrollTableCartItems);
		
		tableCartItem = new JTable(productCartModel);
		tableCartItem.getColumnModel().getColumn(4).setCellRenderer(new CustomButtonRenderer());;
		tableCartItem.getColumnModel().getColumn(4).setCellEditor(new ActionButtonEditor(new JTextField()));

		tableCartItem.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		scrollTableCartItems.setViewportView(tableCartItem);
		fillProductTable();
	
	}
	
	
	

	
	
	private void fillProductTable() {
		for (CartItem item : shoppingCartItems) {
			Product product = item.getProduct();
				Object[] data = {product.getBarcode(), product.getBrand(), item.getQuantity(), item.getTotalCost(),  "Remove"};
				productCartModel.addRow(data); 
	    }
	}
	



	class CustomButtonRenderer extends JButton implements  TableCellRenderer
	{
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


	class ActionButtonEditor extends DefaultCellEditor
	{
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
		  public Component getTableCellEditorComponent(JTable table, Object obj,
		      boolean selected, int row, int col) {
			  removeSelectedItem(row);
			  btnLabel=(obj==null) ? "":obj.toString();
			  actionBtn.setText(btnLabel);
		     isClicked=true;
		    return actionBtn;
		  }
	
		   @Override
		  public Object getCellEditorValue() {
	
		     if(isClicked)
		      {
		   	  System.out.println("label : "  + btnLabel);
		   	  System.out.println("selected product: "  + selectedProduct.getdeviceName());
			   	  if(btnLabel.equals("Update")) {
			   		 JOptionPane.showMessageDialog(actionBtn, btnLabel+" Clicked");
			   	  }
			   	  else{
			   		  AddItemToCart addItem = new AddItemToCart(selectedProduct);
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
		   
		   public void removeSelectedItem (int selectedIndex) {
				for (int i = 0; i < shoppingCartItems.size(); i ++) {
					if(selectedIndex == i) {
						cart.remvoeCartItem(selectedIndex);;
						break;
					}
					
				}
			}
			
	}
}
