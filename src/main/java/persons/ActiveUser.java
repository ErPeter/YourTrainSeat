package persons;


/**
 *Class represents a person who has logged in.
 */
public class ActiveUser {

    private static String userName;


    /**
     * Simple getter method.
     * @return the name of the person
     */
    public static String getUserName() {
        return userName;
    }

    /**
     * Simple setter method.
     * @param userName the param will provide the name of the person
     */
    public static void setUserName(String userName) {
        ActiveUser.userName = userName;
    }
}
