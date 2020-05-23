package yourtrainseat;

import lombok.Data;

import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * Class to handel the person who is signing in
 */

@Data
public class SignIn {

    private String personName;
    private String pwd;
    private Person foundPerson = new Person();
    private String hashedPassword;
    private Password password = new Password();
    private List<Person> personList = (new PersonDao().findAll());


    private boolean userNameMatch() {
        for (int i = 0; i < personList.size(); i++) {
            if (personList.get(i).getUserName().compareTo(personName) == 0) {
                foundPerson = personList.get(i);
                return true;
            }
        }
        return false;
    }

    private boolean passwordMatch() throws NoSuchAlgorithmException {
        password.setPassword(pwd);
        hashedPassword = password.getSecretPassword();

        if(this.foundPerson.getPassword().compareTo(hashedPassword) == 0){
            return true;
        }
        return false;
    }

    public boolean successfulLogin() throws NoSuchAlgorithmException {
        if(userNameMatch()){
            if(passwordMatch()){
                return true;
            }
        }
        return false;
    }
}
