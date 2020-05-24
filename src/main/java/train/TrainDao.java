package train;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TrainDao {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("yourseat-mysql");
    private EntityManager em = emf.createEntityManager();

    public void insertPerson(Train train){
        em.getTransaction().begin();
        em.persist(train);
        em.getTransaction().commit();
    }

}
