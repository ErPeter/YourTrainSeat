package yourtrainseat;

import lombok.Data;

/**
 * Class to represent a person
 */

@Data
public class Person {

    private String firstName;
    private String lastName;
    private String userName;
    private String password;

    public Person(String firstName, String lastName, String userName, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = new Password(password).getSecretPassword();
    }


}
