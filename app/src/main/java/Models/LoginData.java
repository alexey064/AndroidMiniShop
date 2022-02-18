package Models;

public class LoginData {
    private static String Username;
    private static String Password;
    private static String Token;

    public static String getUsername() {
        return Username;
    }

    public static void setUsername(String username) {
        Username = username;
    }

    public static String getPassword() {
        return Password;
    }

    public static void setPassword(String password) {
        Password = password;
    }
    public static void setToken(String token){Token=token;}
    public static String getToken(){return Token;}
}
