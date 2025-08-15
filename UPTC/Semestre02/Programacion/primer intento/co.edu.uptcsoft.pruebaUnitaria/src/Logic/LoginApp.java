package Logic;
public class LoginApp {

    private static final String VALID_USERNAME = "admin";
    private static final String VALID_PASSWORD = "12345";


    public static boolean login(String username, String password) {
        return VALID_USERNAME.equals(username) && VALID_PASSWORD.equals(password);
    }

}
