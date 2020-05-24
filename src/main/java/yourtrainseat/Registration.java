package yourtrainseat;

import lombok.Getter;
import lombok.Setter;
import persons.Password;
import persons.Person;
import persons.PersonDao;

import java.util.List;

/**
 * Class to handle registration.
 */

public class Registration {
    @Setter
    private Person person;
    @Setter
    private String givenPsw;
    @Setter
    private String repeatOfGivenPsw;
    private Password password = new Password();
    private List<Person> personList = (new PersonDao().findAll());
    @Getter
    boolean passwordProblem = false;
    @Getter
    boolean nameProblem = false;


    /**
     * Checks the uniqueness of a person's name.
     * @param person will be checked with all the other person in the database
     * @return true if it is unique or false if it is not
     */
    private boolean isUnique(Person person){
        this.nameProblem = false;
        boolean unique = true;
        for (int i = 0; i < personList.size(); i++){
            if (person.getUserName().compareTo(personList.get(i).getUserName()) == 0){
                nameProblem = true;
                unique = false;
            }
        }
        return unique;
    }

    /**
     * Checks the password and the repeated password.
     * @return true if they are the same or false if they are different
     */
    private boolean isPasswordsMatch(){
        this.passwordProblem = false;
        if(this.givenPsw.compareTo(this.repeatOfGivenPsw) == 0){
            return true;
        }
        this.passwordProblem = true;
        return false;
    }

    /**
     * Hashes the password with setPassword method from {@link Password} class.
     * @param psw this String will be hashed
     */
    private void hashPsw(String psw) {
        password.setPassword(psw);
        this.person.setPassword(password.getSecretPassword());
    }

    /**
     * If condition is matched then hashes password.
     */
    private void setPersonPassword() {
        if(isPasswordsMatch() == true){
            hashPsw(this.givenPsw);
        }
        else {
            this.passwordProblem = true;
        }
    }

    /**
     * If the person's user name is unique and passwords are the same, inserts the person to database.
     * The hashed password will be stored
     */
    public void insertPerson() {
        if(isUnique(person) && isPasswordsMatch()){
            setPersonPassword();
            PersonDao personDao = new PersonDao();
            personDao.insertPerson(person);
        }
    }
}
