package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Main.User;

import java.awt.Color;
import java.awt.Button;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Login extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox<?> cboUserName;
	int xx,xy;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setUndecorated(true);
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
	public Login() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 729, 476);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 153, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setUndecorated(true);
		JLabel label = new JLabel("");
		label.setBounds(0, 0, 346, 275);
		contentPane.add(label);
		
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				 xx = e.getX();
			     xy = e.getY();
			}
		});
		label.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				
				int x = arg0.getXOnScreen();
	            int y = arg0.getYOnScreen();
	            Login.this.setLocation(x - xx, y - xy);  
			}
		});
		label.setVerticalAlignment(SwingConstants.TOP);
		label.setIcon(new ImageIcon(Login.class.getResource("/images/bg.jpg")));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 102, 102));
		panel.setBounds(0, 0, 346, 490);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CAS");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setForeground(new Color(240, 248, 255));
		lblNewLabel.setBounds(0, 305, 346, 27);
		panel.add(lblNewLabel);
		
		JLabel lblLoginError = new JLabel("");
		lblLoginError.setForeground(new Color(204, 51, 0));
		lblLoginError.setBounds(394, 207, 266, 27);
		lblLoginError.setVisible(false);
		contentPane.add(lblLoginError);
		
		JLabel lblWeGotYou = new JLabel("Computer Accessories Shop");
		lblWeGotYou.setHorizontalAlignment(SwingConstants.CENTER);
		lblWeGotYou.setForeground(new Color(240, 248, 255));
		lblWeGotYou.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblWeGotYou.setBounds(0, 345, 346, 27);
		panel.add(lblWeGotYou);
		
		Button button = new Button("Log In");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = String.valueOf(cboUserName.getSelectedItem());
				lblLoginError.setText("");
				lblLoginError.setVisible(false);
				
				if(isEmptyOrNull(username)) {
					lblLoginError.setText("Please select username");
					lblLoginError.setVisible(true);
				}else {
					//check log in
					if(!User.isValidUser(username)) {
						lblLoginError.setText("Invalid");
						lblLoginError.setVisible(true);
					}else {
						setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						Dashboard dashboard = new Dashboard();
						dashboard.setLocationRelativeTo(null);
						dashboard.setVisible(true);
					}
				}
			}
		});
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(0, 153, 153));
		button.setBounds(394, 239, 266, 36);
		contentPane.add(button);
		
		JLabel lblUsername = new JLabel("USERNAME");
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setBounds(394, 137, 265, 20);
		contentPane.add(lblUsername);
		
		JLabel lblClose = new JLabel("X");
		lblClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				System.exit(0);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblClose.setForeground(Color.RED);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				lblClose.setForeground(Color.WHITE);
			}
		});
		lblClose.setHorizontalAlignment(SwingConstants.CENTER);
		lblClose.setForeground(new Color(255, 255, 255));
		lblClose.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblClose.setBounds(691, 0, 37, 27);
		contentPane.add(lblClose);
		
		cboUserName = new JComboBox();
		cboUserName.setForeground(new Color(255, 255, 255));
		cboUserName.setBackground(new Color(0, 153, 153));
		cboUserName.setModel(new DefaultComboBoxModel(new String[] {"user1", "user2", "user3", "user4"}));
		cboUserName.setBounds(394, 168, 266, 36);
		contentPane.add(cboUserName);
	}
	
	boolean isEmptyOrNull(String str) {
		return str == null || str.length() == 0;
	}
}