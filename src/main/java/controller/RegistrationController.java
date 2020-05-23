package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import yourtrainseat.Person;
import yourtrainseat.Registration;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;


public class RegistrationController {
    Registration registration = new Registration();
    @FXML
    private TextField firstName;

    @FXML
    private TextField lastName;

    @FXML
    private TextField userName;

    @FXML
    private TextField password;

    @FXML
    private TextField repeatPassword;

    @FXML
    private Label userNameAlert;

    @FXML
    private Label passwordAlert;


    private Person person = new Person();



    public void savePerson(ActionEvent event) throws NoSuchAlgorithmException, IOException {
        setPersonValues();
        registration.insertPerson();
        handleProblems();
        if (handleProblems()){
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/signInView.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        }
    }

    private boolean handleProblems(){
        if(registration.isNameProblem()){
            userNameAlert.setVisible(true);
            return false;
        }
        if (registration.isPasswordProblem()){
            passwordAlert.setVisible(true);
            return false;
        }
        return true;
    }

    private void setPersonValues(){
        person.setFirstName(firstName.getText());
        person.setLastName(lastName.getText());
        person.setUserName(userName.getText());
        registration.setGivenPsw(password.getText());
        registration.setRepeatOfGivenPsw(repeatPassword.getText());
        registration.setPerson(person);
    }

}
