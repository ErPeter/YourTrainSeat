package persons;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class PersonDao {

    private Person person = new Person();
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("yourseat-mysql");
    private EntityManager em = emf.createEntityManager();

    public void insertPerson(Person person){
        em.getTransaction().begin();
        em.persist(person);
        em.getTransaction().commit();
    }

    public Person findPerson(String userName) {
        Query query = em.createQuery("select p from Person p where p.userName = :userName", Person.class);
        query.setParameter("userName", userName);
        return (Person) query.getSingleResult();
    }

    public void update(Person person){
        em.getTransaction().begin();
        em.merge(person);
        em.getTransaction().commit();
    }

    public List<Person> findAll() {
        return em.createQuery("SELECT a FROM Person a",Person.class).getResultList();
    }
}
