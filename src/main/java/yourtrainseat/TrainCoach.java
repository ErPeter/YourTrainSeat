package yourtrainseat;

import javafx.scene.layout.Pane;
import lombok.Setter;

import java.util.List;

/**
 * Class to handle seat reservations
 */

public class TrainCoach {

    @Setter
    private List<Pane> seats;

    /**
     * Method witch changes the colour of the seat
     */
    public void changeToReservedColor(){
        for (Pane pane : seats){
            if (pane.getId().equals("s0131")){
                pane.setStyle("-fx-background-color:  #F35454");
            }
        }
    }

    /**
     * Method to handel a reservation
     * @param pane
     */
    public void reserveSeat(Pane pane){
        if (isReserved(pane)) {
            pane.setStyle("-fx-background-color:  #f35454");
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
        if (pane.getStyle().equals("-fx-background-color:  #F35454")){
            return false;
        }
        return true;
    }
}
