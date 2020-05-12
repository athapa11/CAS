package auth;

import java.io.File;
import java.util.Scanner;

public class User {
	public int userId;
	public String username;
	public String surname;
	public String postcode;
	public String role;
	
	protected User currentUser;
	
	public User() {}
	
	public User (int userId, String username, String surname, String postcode, String role) {
		this.userId = userId;
		this.username = username;
		this.surname = surname;
		this.postcode = postcode;
		this.role = role;
	}
	
	// Getter Methods
	public int getUserId() {
		return this.userId;
	}
	public String getUsername() {
		return this.username;
	}
	public String getSurname() {
		return this.surname;
	}
	public String getPostcode() {
		return this.postcode;
	}
	public String getRole() {
		return this.role;
	}
	
	public boolean isAdmin() {
		return this.role.equals("admin"); 
	}
	
	// Scan UserAccounts.txt to check if entered user name is valid
	public static boolean isValidUser(String username) {
		boolean isLoginSuccess = false;
		Scanner fileScanner = null;
		
		try {
			File users = new File("UserAccounts.txt");
			fileScanner = new Scanner(users);
			
			while (fileScanner.hasNextLine()) 
			{
				String[] attributes = fileScanner.nextLine().split(",");
				
				String fUsername = attributes[1].trim();
				
				if(fUsername.equals(username)) {
					isLoginSuccess = true;
					User user = new User(
							Integer.parseInt(attributes[0].trim()),
							attributes[1].trim(), 
							attributes[2].trim(), 
							attributes[4].trim(), 
							attributes[6].trim()							
							);
					
					//store logged in user for later use
					UserSession.getInstace(user);
							
					fileScanner.close();
					return isLoginSuccess;					
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		finally {
			fileScanner.close();
		}
		return isLoginSuccess;
	}
}
