package train;

import org.tinylog.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 *DAO class for the {@link Train} entity.
 */
public class TrainDao {

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("yourseat-mysql");
    private EntityManager entityManager = entityManagerFactory.createEntityManager();

    /**
     * Insert a record to the Train table.
     * @param train this train will be inserted into Train table
     */
    public void insertSeat(Train train){
        entityManager.getTransaction().begin();
        entityManager.persist(train);
        entityManager.getTransaction().commit();
        Logger.info("Added train to database");
    }

    /**
     * Deletes the Train table.
     */
    public void deleteTable(){
        entityManager.getTransaction().begin();
        entityManager.createQuery("delete from Train").executeUpdate();
        entityManager.getTransaction().commit();
        Logger.info("deleted all record from Train");
    }

    /**
     * Finds all train record.
     * @return found records with a list
     */
    public List<Train> findAll(){
        Logger.info("Finding all seats");
        return entityManager.createQuery("SELECT a FROM Train a", Train.class).getResultList();
    }
}
