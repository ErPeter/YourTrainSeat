package yourtrainseats.modell;

import org.junit.jupiter.api.Test;
import train.Train;
import train.TrainDao;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestTrain {
    @Test
    void testTrain(){
        Train train = new Train();
        train.setSeat("test");
        TrainDao trainDao = new TrainDao();
        trainDao.deleteTable();
        trainDao.insertSeat(train);
        List<Train> trains = trainDao.findAll();
        assertEquals(1, trains.size());
    }
    @Test
    void testTrainDelete(){
        TrainDao trainDao = new TrainDao();
        trainDao.deleteTable();
        assertEquals(0, trainDao.findAll().size());
    }
}

