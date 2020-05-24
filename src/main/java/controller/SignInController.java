package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import persons.ActiveUser;
import yourtrainseat.SignIn;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;


public class SignInController {

    private TrainCoachController trainCoachController = new TrainCoachController();
    private SignIn signIn = new SignIn();

    @FXML
    private TextField userName;

    @FXML
    private TextField password;

    public void switchToRegView(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/regView.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void switchToTrainCoachView(ActionEvent event) throws IOException, NoSuchAlgorithmException {
        setSignInValues();
        if(signIn.successfulLogin()) {
            ActiveUser user = new ActiveUser();
            ActiveUser.setUserName(userName.getText());
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/trainCoach.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    private void setSignInValues(){
        signIn.setPwd(password.getText());
        signIn.setPersonName(userName.getText());
    }

}
