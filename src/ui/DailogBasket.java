package ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import Main.ActivityLog;
import Main.BasketItem;
import Main.Product;
import Main.Basket;
import Main.User;
import Main.UserSession;
import javax.swing.border.LineBorder;


public class DailogBasket extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTable tableBasketItem;

	private DefaultTableModel productCartModel;
	private User currentUser = null;
	private Basket basket = new Basket();
	private ArrayList<BasketItem> basketItems;
	private String col[] = {"Barcode", "Brand",  "Quantity", "Price", "Action"};
	private int selectedIndex = 0;
	private ActivityLog log = new ActivityLog();
	public DailogBasket() {
		setForeground(new Color(0, 0, 0));
		setBackground(new Color(255, 255, 255));
		setBounds(0, 0, 992, 483);
		setUndecorated(true);
		getContentPane().setLayout(null);
		setVisible(true);
		setLocationRelativeTo(null);
	    currentUser = UserSession.getCurrentUser(); 
		
	    basketItems = basket.getBasketItems();
		
		productCartModel = new DefaultTableModel(col, 0) {
			 /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			    public boolean isCellEditable(int row, int column) {
			       return true;
			    }
		};
		
		JPanel panelBasketItemHeading = new JPanel();
		panelBasketItemHeading.setBackground(new Color(102, 153, 153));
		panelBasketItemHeading.setBounds(0, 0, 992, 55);
		getContentPane().add(panelBasketItemHeading);
		panelBasketItemHeading.setLayout(null);
		
		JLabel lblBasketTitle = new JLabel("Basket");
		lblBasketTitle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBasketTitle.setBounds(0, 0, 213, 55);
		panelBasketItemHeading.add(lblBasketTitle);
		lblBasketTitle.setForeground(new Color(255, 255, 255));
		lblBasketTitle.setHorizontalAlignment(SwingConstants.CENTER);
		
		JScrollPane scrollTableBasketItems = new JScrollPane();
		scrollTableBasketItems.setBounds(0, 55, 992, 382);
		getContentPane().add(scrollTableBasketItems);
		
		tableBasketItem = new JTable(productCartModel);
		tableBasketItem.getColumnModel().getColumn(4).setCellRenderer(new CustomButtonRenderer());;
		tableBasketItem.getColumnModel().getColumn(4).setCellEditor(new ActionButtonEditor(new JTextField()));

		tableBasketItem.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		scrollTableBasketItems.setViewportView(tableBasketItem);
		
		JPanel panelFooter = new JPanel();
		panelFooter.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelFooter.setForeground(Color.WHITE);
		panelFooter.setBackground(Color.WHITE);
		panelFooter.setBounds(0, 437, 992, 44);
		getContentPane().add(panelFooter);
		
		JButton btnPay = new JButton("Pay");
		btnPay.setBounds(655, 6, 111, 23);
		btnPay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DailogPay pay = new DailogPay();
				pay.setVisible(true);
				dispose();
				
			}
		});
		panelFooter.setLayout(null);
		btnPay.setForeground(Color.WHITE);
		btnPay.setBackground(new Color(0, 153, 153));
		btnPay.setActionCommand("OK");
		panelFooter.add(btnPay);
		
		JButton btnCancelAll = new JButton("Cancel All");
		btnCancelAll.setBounds(781, 6, 112, 23);
		btnCancelAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeCartItems();
			}
		});
		btnCancelAll.setForeground(Color.WHITE);
		btnCancelAll.setBackground(new Color(0, 153, 153));
		btnCancelAll.setActionCommand("OK");
		panelFooter.add(btnCancelAll);
		
		JButton btnReturn = new JButton("Return");
		btnReturn.setBounds(903, 6, 83, 23);
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnReturn.setForeground(Color.WHITE);
		btnReturn.setBackground(new Color(0, 153, 153));
		btnReturn.setActionCommand("Cancel");
		panelFooter.add(btnReturn);
		fillProductTable();
	
	}
	
	// Show items in basket as a Jtable
	public void fillProductTable() {
		for (BasketItem item : basketItems) {
			Product product = item.getProduct();
				Object[] data = {product.getBarcode(), product.getBrand(), item.getQuantity(), item.getTotalCostOfItem(),  "Remove"};
				productCartModel.addRow(data); 
	    }
	}
	
	// Log cancellation to the file for all items in the basket
	private void removeCartItems() {
		for (BasketItem item : basketItems) {
			log.logActivity(item, "cancelled", "");
		}
		basket.setBasketItems(new ArrayList<BasketItem> ()); // Clear the basket
		basket.setTotalCost(0.00);
		productCartModel.setRowCount(0);
		basketItems = basket.getBasketItems();
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
		public Component getTableCellEditorComponent(JTable table, Object obj, boolean selected, 
				int row, int col) {
			selectedIndex = row;
			btnLabel=(obj==null) ? "":obj.toString();
			actionBtn.setText(btnLabel);
		    isClicked=true;
		    return actionBtn;
		}
	
		@Override
		public Object getCellEditorValue() {
			if(isClicked){
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
		
		// Remove and log cancellation for each item individually
		public void removeSelectedItem (int selectedIndex) {
			int itemCount = basket.getLineItemCount();
			System.out.println(" Itemcount : "+ itemCount);
			for (int i = 0; i < itemCount; i ++) {
				if(selectedIndex == i) {
					System.out.println(" selectedIndex : "+ selectedIndex);
					BasketItem removedItem = basket.removeBasketItem(selectedIndex);
					productCartModel.setRowCount(0);
					basketItems = basket.getBasketItems();
					fillProductTable();
					log.logActivity(removedItem, "cancelled", "");
					break;
				}	
			}
		}	
	}
}
