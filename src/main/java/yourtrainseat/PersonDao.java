package yourtrainseat;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class PersonDao {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("yourseat-mysql");
    private EntityManager em = emf.createEntityManager();

    public void insertPerson(Person person){
        em.getTransaction().begin();
        em.persist(person);
        em.getTransaction().commit();

    }

    public List<Person> findAll() {
        return em.createQuery("SELECT a FROM Person a",Person.class).getResultList();
    }
}
