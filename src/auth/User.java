package auth;

public class User {
	public int userId;
	public String userName;
	public String surname;
	public int houseNumber;
	public String postcode;
	public String city;
	public String role;
	
	protected User currentUser;
	
	public User() {
		
	}
	
	public User (int userId, String userName, String surname, int houseNumber, 
			String postcode, String city, String role) {
		this.userId = userId;
		this.userName = userName;
		this.surname = surname;
		this.houseNumber = houseNumber;
		this.postcode = postcode;
		this.city = city;
		this.role = role;
	}
	
	public boolean isAdmin() {
		return this.role.equals("admin"); 
	}
}
