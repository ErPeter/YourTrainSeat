package controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import persons.ActiveUser;
import yourtrainseat.TrainCoach;

import java.io.IOException;
import java.util.List;

public class TrainCoachController {
    public TrainCoachController(){
    }

    private TrainCoach trainCoach = new TrainCoach();

    @FXML
    private Label userName;

    @FXML
    private List<Pane> seatsList;

    public void initialize(){
        setUserNameLabel();
    }

    public void setUserNameLabel(){
        ActiveUser user = new ActiveUser();
        userName.setText(ActiveUser.getUserName());
    }

    public void clickedOnSeat(MouseEvent mouseEvent){
        Pane pane;
        pane = (Pane) mouseEvent.getSource();
        trainCoach.reserveSeat(pane);
    }

    public void saveButton(){
        trainCoach.setSeats(seatsList);
        trainCoach.changeToReservedColor();
    }

    public void logOut(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/signInView.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public List<Pane> getSeatsList() {
        return seatsList;
    }
}
