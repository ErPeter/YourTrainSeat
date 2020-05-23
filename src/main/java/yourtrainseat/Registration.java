package yourtrainseat;

import java.security.NoSuchAlgorithmException;
import java.util.List;

public class Registration {
    private Person person;
    private String givenPsw;
    private String repeatOfGivenPsw;
    private Password password;
    private List<Person> personList = (new PersonDao().findAll());
    boolean passwordProblem = false;
    boolean nameProblem = false;


    private boolean isUnique(Person person){
        boolean unique = true;
        for (int i = 0; i < personList.size(); i++){
            if (person.getUserName().compareTo(personList.get(i).getUserName()) == 0){
                nameProblem = true;
                unique = false;
            }
        }
        return unique;
    }

    private boolean isPasswordsMatch(){
        if(this.givenPsw.compareTo(this.repeatOfGivenPsw) == 0){
            return true;
        }
        return false;
    }

    private void hashPsw(String psw) throws NoSuchAlgorithmException {
        password.setPassword(psw);
        this.person.setPassword(password.getSecretPassword());
    }

    private void setPersonPassword() throws NoSuchAlgorithmException {
        if(isPasswordsMatch() == true){
            hashPsw(this.givenPsw);
        }
        else {
            passwordProblem = true;
        }
    }


}
