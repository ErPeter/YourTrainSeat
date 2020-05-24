package yourtrainseat;

import lombok.Data;
import persons.Password;
import persons.Person;
import persons.PersonDao;

import java.util.List;

/**
 * Class to handel the person who is signing in.
 */

@Data
public class SignIn {

    private String personName;
    private String pwd;
    private Person foundPerson = new Person();
    private String hashedPassword;
    private Password password = new Password();
    private List<Person> personList = (new PersonDao().findAll());


    /**
     * Finds the person whit the given name.
     * @return true if found the person with name
     */
    private boolean userNameMatch() {
        for (int i = 0; i < personList.size(); i++) {
            if (personList.get(i).getUserName().compareTo(personName) == 0) {
                foundPerson = personList.get(i);
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if the password is correct.
     * @return true if it's matched
     */
    private boolean passwordMatch() {
        password.setPassword(pwd);
        hashedPassword = password.getSecretPassword();

        return this.foundPerson.getPassword().compareTo(hashedPassword) == 0;
    }

    /**
     * Checks if the username is correct and the password is correct.
     * @return true if all condition are matched
     */
    public boolean successfulLogin() {
        if(userNameMatch()){
            return passwordMatch();
        }
        return false;
    }
}
