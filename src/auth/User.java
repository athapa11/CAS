package auth;

public class User {
	int userId;
	String userName;
	String surname;
	int houseNumber;
	String postcode;
	String city;
	String role;
	
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


	public void setCurrentUser(User user) {
		this.currentUser = user;
	}
	
	public User getCurrentUser() {
		return this.currentUser;
	}
}
