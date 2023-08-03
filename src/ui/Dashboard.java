package ui;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;

import Main.User;
import Main.UserSession;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;

public class Dashboard extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private PanelProducts panelProducts;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard frame = new Dashboard();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Dashboard() {
		setBackground(new Color(0, 153, 153));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1190, 587);
		setUndecorated(true);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 153));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelProducts = new PanelProducts();

		JPanel panelMenu = new JPanel();
		panelMenu.setBackground(new Color(51, 102, 102));
		panelMenu.setBounds(0, 0, 200, 587);
		contentPane.add(panelMenu);
		panelMenu.setLayout(null);
		
		JLabel lblLogo = new JLabel("New label");
		lblLogo.setBounds(0, 0, 199, 199);
		lblLogo.setIcon(new ImageIcon(Login.class.getResource("/images/bg.jpg")));
		panelMenu.add(lblLogo);
		
		JPanel panelProductMenu = new JPanel();
		panelProductMenu.addMouseListener(new MenuButtonMouseAdampter(panelProductMenu) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelProducts);
			}
		});
		panelProductMenu.setBackground(new Color(51, 102, 102));
		panelProductMenu.setBounds(0, 200, 199, 40);
		panelMenu.add(panelProductMenu);
		panelProductMenu.setLayout(null);
		
		JLabel lblProductMenu = new JLabel("Product");
		lblProductMenu.setForeground(new Color(255, 255, 255));
		lblProductMenu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblProductMenu.setBounds(15, 0, 184, 40);
		panelProductMenu.add(lblProductMenu);
		
		JPanel panelLogoutMenu = new JPanel();
		panelLogoutMenu.addMouseListener(new MenuButtonMouseAdampter(panelLogoutMenu) {
			@Override
			public void mouseClicked(MouseEvent e) {
				int optionYes=JOptionPane.showConfirmDialog(null,"Are you sure you want to logout?", "Logout - CAS", JOptionPane.YES_NO_OPTION);  
				if(optionYes ==JOptionPane.YES_OPTION){  
					Login login = new Login();
					login.setVisible(true);
					Dashboard.this.dispose();
				}  
				
			} 
		});
		panelLogoutMenu.setBackground(new Color(51, 102, 102));
		panelLogoutMenu.setBounds(0, 240, 199, 40);
		panelMenu.add(panelLogoutMenu);
		panelLogoutMenu.setLayout(null);
		
		JLabel lblLogOutMenu = new JLabel("Log out");
		lblLogOutMenu.setForeground(Color.WHITE);
		lblLogOutMenu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLogOutMenu.setBounds(15, 0, 184, 40);
		panelLogoutMenu.add(lblLogOutMenu);
		
		JLabel lblCloseDashboard = new JLabel("X");
		lblCloseDashboard.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int optionYes=JOptionPane.showConfirmDialog(null,"Are you sure you want to close application?", "Close - CAS", JOptionPane.YES_NO_OPTION);  
				if(optionYes ==JOptionPane.YES_OPTION){  
					System.exit(0);
				}  
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblCloseDashboard.setForeground(Color.RED);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				lblCloseDashboard.setForeground(Color.WHITE);
			}
		});
		lblCloseDashboard.setHorizontalAlignment(SwingConstants.CENTER);
		lblCloseDashboard.setForeground(new Color(255, 255, 255));
		lblCloseDashboard.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCloseDashboard.setBounds(1164, 0, 26, 22);
		contentPane.add(lblCloseDashboard);
		
		JPanel panelMainContent = new JPanel();
		panelMainContent.setBounds(198, 104, 992, 483);
		contentPane.add(panelMainContent);
		panelMainContent.setLayout(null);
		
		//add menu panel
		panelMainContent.add(panelProducts);
		
		JLabel lblCurrentUser = new JLabel("User:");
		lblCurrentUser.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCurrentUser.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCurrentUser.setForeground(new Color(255, 255, 255));
		lblCurrentUser.setBounds(850, 6, 35, 33);
		contentPane.add(lblCurrentUser);
		
		JLabel label = new JLabel("Computer Accessories Shop");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label.setBounds(209, 6, 233, 39);
		contentPane.add(label);
		
		JLabel lblCurrentUserValue = new JLabel("");
		lblCurrentUserValue.setForeground(Color.WHITE);
		lblCurrentUserValue.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCurrentUserValue.setBounds(895, 6, 83, 33);
		User currentUser = UserSession.getCurrentUser();
		if(currentUser != null ) {
			lblCurrentUserValue.setText(currentUser.username);
		}
		
		
		contentPane.add(lblCurrentUserValue);
		panelProducts.setVisible(true);
		
		//menuClicked(panelProduct);
	}
	
	public void menuClicked(JPanel panel) {
	 panelProducts.setVisible(false);
	 
	 panel.setVisible(true);
	}
	
	private class MenuButtonMouseAdampter extends MouseAdapter{
		JPanel panel;
		public MenuButtonMouseAdampter(JPanel panel) {
			this.panel = panel;
		}
		
		@Override
		public void mouseEntered (MouseEvent e) {
			panel.setBackground(new Color(47, 79, 79));
		}
		
		@Override
		public void mouseExited (MouseEvent e) {
			panel.setBackground(new Color(51, 102, 102));
		}
		
		@Override
		public void mousePressed (MouseEvent e) {
			panel.setBackground(new Color(51, 153, 153));
		}
		
		@Override
		public void mouseReleased (MouseEvent e) {
			panel.setBackground(new Color(47, 79, 79));
		}
	}
		
	
}
