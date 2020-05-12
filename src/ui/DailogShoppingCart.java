package ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
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
import javax.swing.JDialog;
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

import Main.ActivityLog;
import Main.CartItem;
import Main.Product;
import Main.ShoppingCart;
import auth.*;
import java.awt.FlowLayout;
import javax.swing.border.LineBorder;


public class DailogShoppingCart extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTable tableCartItem;

	private DefaultTableModel productCartModel;
	private User currentUser = null;
	private ShoppingCart cart = new ShoppingCart();
	private ArrayList<CartItem> shoppingCartItems;
	private String col[] = {"Barcode", "Brand",  "Quantity", "Price", "Action"};
	private int selectedIndex = 0;
	private ActivityLog log = new ActivityLog();
	public DailogShoppingCart() {
		setForeground(new Color(0, 0, 0));
		setBackground(new Color(255, 255, 255));
		setBounds(0, 0, 992, 483);
		setUndecorated(true);
		getContentPane().setLayout(null);
		setVisible(true);
		setLocationRelativeTo(null);
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
		getContentPane().add(panelCartItemHeading);
		panelCartItemHeading.setLayout(null);
		
		JLabel lblCartTitle = new JLabel("Cart");
		lblCartTitle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCartTitle.setBounds(0, 0, 213, 55);
		panelCartItemHeading.add(lblCartTitle);
		lblCartTitle.setForeground(new Color(255, 255, 255));
		lblCartTitle.setHorizontalAlignment(SwingConstants.CENTER);
		
		JScrollPane scrollTableCartItems = new JScrollPane();
		scrollTableCartItems.setBounds(0, 55, 992, 382);
		getContentPane().add(scrollTableCartItems);
		
		tableCartItem = new JTable(productCartModel);
		tableCartItem.getColumnModel().getColumn(4).setCellRenderer(new CustomButtonRenderer());;
		tableCartItem.getColumnModel().getColumn(4).setCellEditor(new ActionButtonEditor(new JTextField()));

		tableCartItem.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		scrollTableCartItems.setViewportView(tableCartItem);
		
		JPanel panelFooter = new JPanel();
		panelFooter.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelFooter.setForeground(Color.WHITE);
		panelFooter.setBackground(Color.WHITE);
		panelFooter.setBounds(0, 437, 992, 44);
		getContentPane().add(panelFooter);
		
		JButton btnBuyNow = new JButton("Buy now");
		btnBuyNow.setBounds(641, 6, 125, 23);
		btnBuyNow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DailogPay pay = new DailogPay();
				pay.setVisible(true);
				dispose();
				
			}
		});
		panelFooter.setLayout(null);
		btnBuyNow.setForeground(Color.WHITE);
		btnBuyNow.setBackground(new Color(0, 153, 153));
		btnBuyNow.setActionCommand("OK");
		panelFooter.add(btnBuyNow);
		
		JButton btnRemoveAll = new JButton("Remove All");
		btnRemoveAll.setBounds(782, 6, 111, 23);
		btnRemoveAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeCartItems();
			}
		});
		btnRemoveAll.setForeground(Color.WHITE);
		btnRemoveAll.setBackground(new Color(0, 153, 153));
		btnRemoveAll.setActionCommand("OK");
		panelFooter.add(btnRemoveAll);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(903, 6, 83, 23);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setBackground(new Color(0, 153, 153));
		btnCancel.setActionCommand("Cancel");
		panelFooter.add(btnCancel);
		fillProductTable();
	
	}
	
	
	
	

	
	
	public void fillProductTable() {
		for (CartItem item : shoppingCartItems) {
			Product product = item.getProduct();
				Object[] data = {product.getBarcode(), product.getBrand(), item.getQuantity(), item.getTotalCost(),  "Remove"};
				productCartModel.addRow(data); 
	    }
	}
	
	private void removeCartItems() {
		for (CartItem item : shoppingCartItems) {
			log.addActivity(item, "cancelled", "");
		}
		cart.setCartItems( new ArrayList<CartItem> ());//remove all items
		cart.setOrderTotal(0.00);
		productCartModel.setRowCount(0);
		shoppingCartItems = cart.getCartItems();
		fillProductTable();		
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
			  selectedIndex = row;
			  btnLabel=(obj==null) ? "":obj.toString();
			  actionBtn.setText(btnLabel);
		     isClicked=true;
		    return actionBtn;
		  }
	
		   @Override
		  public Object getCellEditorValue() {
	
		     if(isClicked)
		      {
		    	  removeSelectedItem(selectedIndex);
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
			   int itemCount = cart.getLineItemCount();
			   System.out.println(" Itemcount : "+ itemCount);
				for (int i = 0; i < itemCount; i ++) {
					if(selectedIndex == i) {
						System.out.println(" selectedIndex : "+ selectedIndex);
						CartItem removedItem =	cart.remvoeCartItem(selectedIndex);
						productCartModel.setRowCount(0);
						shoppingCartItems = cart.getCartItems();
						fillProductTable();
						log.addActivity(removedItem, "cancelled", "");
						break;
					}
					
				}
			}
			
	}
}
