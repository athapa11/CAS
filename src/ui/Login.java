package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import auth.Auth;
import auth.User;
import auth.UserSession;

import java.awt.Color;
import java.awt.Button;
import javax.swing.JTextField;
import javax.swing.JLabel;
//import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Login extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	//private JPasswordField passwordField;
	
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
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 102, 102));
		panel.setBounds(0, 0, 346, 490);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CAS");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setForeground(new Color(240, 248, 255));
		lblNewLabel.setBounds(139, 305, 84, 27);
		panel.add(lblNewLabel);
		
		JLabel label = new JLabel("");
		
		JLabel lblLoginError = new JLabel("");
		lblLoginError.setForeground(new Color(204, 51, 0));
		lblLoginError.setBounds(395, 220, 400, 27);
		lblLoginError.setVisible(false);
		contentPane.add(lblLoginError);
		
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
		label.setBounds(-38, 0, 420, 275);
		label.setVerticalAlignment(SwingConstants.TOP);
		label.setIcon(new ImageIcon(Login.class.getResource("/images/bg.jpg")));
		panel.add(label);
		
		JLabel lblWeGotYou = new JLabel("Computer Accessories Shop");
		lblWeGotYou.setHorizontalAlignment(SwingConstants.CENTER);
		lblWeGotYou.setForeground(new Color(240, 248, 255));
		lblWeGotYou.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblWeGotYou.setBounds(49, 344, 252, 27);
		panel.add(lblWeGotYou);
		
		Button button = new Button("Log In");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = textField.getText();
				//String password = passwordField.getText();
				
				lblLoginError.setText("");
				lblLoginError.setVisible(false);
				
				if(isEmptyOrNull(username)) {
					lblLoginError.setText("Please fill username");
					lblLoginError.setVisible(true);
				}else {
					 //check log in
					 Auth auth = new Auth();
					 if(!auth.isValidUser(username)) {
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
		button.setForeground(Color.DARK_GRAY);
		button.setBackground(Color.WHITE);
		button.setBounds(395, 363, 283, 36);
		contentPane.add(button);
		
		textField = new JTextField();
		textField.setBounds(395, 83, 283, 36);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblUsername = new JLabel("USERNAME");
		lblUsername.setBounds(395, 58, 114, 14);
		contentPane.add(lblUsername);
		
		/*JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setBounds(395, 131, 96, 14);
		contentPane.add(lblPassword);*/
		
		/*passwordField = new JPasswordField();
		passwordField.setBounds(395, 156, 283, 36);
		contentPane.add(passwordField);*/
		
		
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
		
		
	}
	
	boolean isEmptyOrNull(String str) {
		return str == null || str.length() == 0;
	}
}