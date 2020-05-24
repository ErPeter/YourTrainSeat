package yourtrainseat;

import javafx.scene.layout.Pane;
import lombok.Setter;
import persons.Person;
import persons.PersonDao;
import train.TrainDao;

import java.util.List;

/**
 * Class to handle seat reservations
 */

public class TrainCoach {
    @Setter
    private String activeUser;
    private PersonDao personDao = new PersonDao();
    private TrainDao trainDao = new TrainDao();
    private Person person;
    private String personsSeats = ",";

    @Setter
    private List<Pane> seats;

    /**
     * Method witch changes the colour of the seat
     */
    public void changeToReservedColor(){
        person = personDao.findPerson(activeUser);
        person.setSeats(null);
        personDao.update(person);
        for (Pane pane : seats){
            if (pane.getStyle().compareTo("-fx-background-color:  #548ef3") == 0){
                personsSeats = personsSeats + pane.getId() + " , ";
                person.setSeats(personsSeats);
                personDao.update(person);
            }
        }
    }

    /**
     * Method to handel a reservation
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
     * Method to check if is a seat already has been reserved
     * @param pane
     * @return
     */
    public boolean isReserved(Pane pane){
        if (pane.getStyle().equals("-fx-background-color:  #548ef3")){
            return false;
        }
        return true;
    }
}
