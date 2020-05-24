package yourtrainseat;

import javafx.scene.layout.Pane;
import lombok.Setter;
import persons.Person;
import persons.PersonDao;
import train.Train;
import train.TrainDao;

import java.util.List;

/**
 * Class to handle seat reservations.
 */

public class TrainCoach {
    @Setter
    private String activeUser;
    private PersonDao personDao = new PersonDao();
    private TrainDao trainDao = new TrainDao();
    private Person person;
    private String personsSeats = ",";


    @Setter
    private static List<Pane> seats;

    /**
     * Method witch changes the colour of the seat.
     */
    public void changeToReservedColor() {
        person = personDao.findPerson(activeUser);
        person.setSeats(null);
        personDao.update(person);
        for (int i = 0; i < seats.size(); i++){
            if (seats.get(i).getStyle().compareTo("-fx-background-color:  #548ef3") == 0){
                personsSeats = personsSeats + seats.get(i).getId() + " , ";
                person.setSeats(personsSeats);
                personDao.update(person);
                Train train = new Train();
                train.setSeat(seats.get(i).getId());
                trainDao.insertSeat(train);
               }
        }
    }

    /**
     * Checks if the person is an admin.
     * @return true if it is
     */
    public boolean isAdmin(){
        person = personDao.findPerson(activeUser);
        if(person.isAdmin()){
            return true;
        }
        return false;
    }

    /**
     * Resets all seats to not reserved.
     */
    public void startTrain(){
        trainDao.deleteTable();
    }

    /**
     * Resets all seats color to green.
     */
    public void setSeatsToFree(){
        for (int i = 0; i < seats.size(); i++){
            seats.get(i).setStyle("-fx-background-color:  LawnGreen");
        }
    }

    /**
     * Iterates all seats and if it is reserved sets the seat color to red.
     */
    public void checkReservedSeats(){
        List<Train> trains = trainDao.findAll();
        for (int i = 0; i < seats.size(); i++){
            for (int t = 0; t < trains.size(); t++ ){
                if(trains.get(t).getSeat().compareTo(seats.get(i).getId()) == 0){
                    seats.get(i).setStyle("-fx-background-color:  #d73030");
                }
            }
        }
    }

    /**
     * Method to handel a reservation.
     * @param pane
     */
    public void reserveSeat(Pane pane){
        if (isReserved(pane)) {
            pane.setStyle("-fx-background-color:  #548ef3");
        }
        else {
            System.out.println("Already reserved");
        }
    }

    /**
     * Method to check if is a seat already has been reserved.
     * @param pane a pane that we checking
     * @return  true if the color is blue
     */
    public boolean isReserved(Pane pane){
        if (pane.getStyle().equals("-fx-background-color:  #548ef3") || pane.getStyle().equals("-fx-background-color:  #d73030")){
            return false;
        }
        return true;
    }
}
