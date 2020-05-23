package yourtrainseat;

import lombok.Getter;
import lombok.Setter;

import java.security.NoSuchAlgorithmException;
import java.util.List;

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

    private boolean isPasswordsMatch(){
        this.passwordProblem = false;
        if(this.givenPsw.compareTo(this.repeatOfGivenPsw) == 0){
            return true;
        }
        this.passwordProblem = true;
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
            this.passwordProblem = true;
        }
    }

    public void insertPerson() throws NoSuchAlgorithmException {
        if(isUnique(person) && isPasswordsMatch()){
            setPersonPassword();
            PersonDao personDao = new PersonDao();
            personDao.insertPerson(person);
        }
    }
}
