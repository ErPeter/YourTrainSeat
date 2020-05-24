package persons;

public class ActiveUser {
    private static String userName;


    public static String getUserName() {
        return userName;
    }

    public static void setUserName(String userName) {
        ActiveUser.userName = userName;
    }
}
