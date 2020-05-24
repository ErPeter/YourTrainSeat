package persons;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

/**
 * DAO class for the  {@link Person} class.
 */

public class PersonDao {

    private Person person = new Person();
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("yourseat-mysql");
    private EntityManager em = emf.createEntityManager();

    /**
     * This method inserts a person to the person table.
     * @param person this person object will be inserted
     */
    public void insertPerson(Person person){
        em.getTransaction().begin();
        em.persist(person);
        em.getTransaction().commit();
    }

    /**
     * This method finds the person by name in the database.
     * @param userName String will be searched in the database es a person name
     * @return returns the person object with @param name
     */
    public Person findPerson(String userName) {
        Query query = em.createQuery("select p from Person p where p.userName = :userName", Person.class);
        query.setParameter("userName", userName);
        return (Person) query.getSingleResult();
    }

    /**
     * The method updates a person's values in the database.
     * @param person this object will be updated
     */
    public void update(Person person){
        em.getTransaction().begin();
        em.merge(person);
        em.getTransaction().commit();
    }

    /**
     * finds all person records in the person table.
     * @return all found records
     */
    public List<Person> findAll() {
        return em.createQuery("SELECT a FROM Person a",Person.class).getResultList();
    }
}
