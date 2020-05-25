package yourtrainseats.modell;

import org.junit.jupiter.api.Test;
import persons.Person;
import persons.PersonDao;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RegistrationTest {

    @Test
    void testPerson(){
        Person person = new Person();
        person.setUserName("test");
        PersonDao personDao = new PersonDao();
        int i = personDao.findAll().size();

        personDao.insertPerson(person);
        assertEquals(i+1, personDao.findAll().size());
    }
}
