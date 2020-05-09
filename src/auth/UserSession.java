package auth;


public final class UserSession {

    private static UserSession instance;

    private static User currentUser;


    private UserSession(User user) {
        UserSession.currentUser = user;
    }

    public static UserSession getInstace(User user) {
        if(instance == null) {
            instance = new UserSession(user);
        }
        return instance;
    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public void cleanUserSession() {
       currentUser = null; //clear user when log out
    }

    
}
