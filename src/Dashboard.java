import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;

import auth.Login;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;

public class Dashboard extends JFrame {

	private JPanel contentPane;

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
		setLocationRelativeTo(null);
		setBounds(100, 100, 654, 587);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 153));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 102), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelMenu = new JPanel();
		panelMenu.setBackground(new Color(51, 102, 102));
		panelMenu.setBounds(0, 0, 197, 587);
		contentPane.add(panelMenu);
		panelMenu.setLayout(null);
		
		JLabel lblLogo = new JLabel("New label");
		lblLogo.setBounds(0, 0, 197, 196);
		lblLogo.setIcon(new ImageIcon(Login.class.getResource("/images/bg.jpg")));
		panelMenu.add(lblLogo);
		
		JPanel panelProductMenu = new JPanel();
		panelProductMenu.addMouseListener(new MenuButtonMouseAdampter(panelProductMenu));
		panelProductMenu.setBackground(new Color(51, 102, 102));
		panelProductMenu.setBounds(0, 195, 197, 40);
		panelMenu.add(panelProductMenu);
		panelProductMenu.setLayout(null);
		
		JLabel lblProductMenu = new JLabel("Product");
		lblProductMenu.setForeground(new Color(255, 255, 255));
		lblProductMenu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblProductMenu.setBounds(17, 6, 174, 28);
		panelProductMenu.add(lblProductMenu);
		
		JPanel panelProfileMenu = new JPanel();
		panelProfileMenu.addMouseListener(new MenuButtonMouseAdampter(panelProfileMenu));
		panelProfileMenu.setBackground(new Color(51, 102, 102));
		panelProfileMenu.setBounds(0, 235, 197, 40);
		panelMenu.add(panelProfileMenu);
		panelProfileMenu.setLayout(null);
		
		JLabel lblProfileMenu = new JLabel("Profile");
		lblProfileMenu.setBounds(18, 5, 173, 29);
		lblProfileMenu.setForeground(Color.WHITE);
		lblProfileMenu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelProfileMenu.add(lblProfileMenu);
		
		JPanel panelLogoutMenu = new JPanel();
		panelLogoutMenu.addMouseListener(new MenuButtonMouseAdampter(panelLogoutMenu));
		panelLogoutMenu.setBackground(new Color(51, 102, 102));
		panelLogoutMenu.setBounds(0, 275, 197, 40);
		panelMenu.add(panelLogoutMenu);
		panelLogoutMenu.setLayout(null);
		
		JLabel lblLogOutMenu = new JLabel("Log out");
		lblLogOutMenu.setForeground(Color.WHITE);
		lblLogOutMenu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLogOutMenu.setBounds(18, 6, 173, 29);
		panelLogoutMenu.add(lblLogOutMenu);
		
		JLabel lblCloseDashboard = new JLabel("X");
		lblCloseDashboard.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int optionYes=JOptionPane.showConfirmDialog(null,"Are you sure you want to close application?");  
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
		lblCloseDashboard.setBounds(628, 0, 26, 22);
		contentPane.add(lblCloseDashboard);
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
