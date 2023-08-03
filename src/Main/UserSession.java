package Main;

public final class UserSession 
{
	private static UserSession instance;
    private static User currentUser;

    private UserSession(User user) {
        currentUser = user;
    }
    
    // Always save only the details of the user logged in
    public static UserSession getInstace(User user) {
        if(instance == null) {
            instance = new UserSession(user);
        }
        return instance;
    }

    public static User getCurrentUser() {
        return currentUser;
    }
    
    //clear user when log out
    public void cleanUserSession() {
       currentUser = null; 
    }
}
