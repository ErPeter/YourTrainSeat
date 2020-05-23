package controller;


import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import yourtrainseat.TrainCoach;

import java.util.List;

public class TrainCoachController {
    TrainCoach trainCoach = new TrainCoach();


    @FXML
    public List<Pane> seatsList;

    public void clickedOnSeat(MouseEvent mouseEvent){
        Pane pane;
        pane = (Pane) mouseEvent.getSource();
        trainCoach.reserveSeat(pane);
    }

    public void saveButton(){
        trainCoach.setSeats(seatsList);
        trainCoach.changeToReservedColor();
    }

    public List<Pane> getSeatsList() {
        return seatsList;
    }
}
