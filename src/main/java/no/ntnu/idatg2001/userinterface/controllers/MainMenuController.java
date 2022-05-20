package no.ntnu.idatg2001.userinterface.controllers;

import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import no.ntnu.idatg2001.userinterface.views.WarGamesApplication;

/**
 * @author Aliaan
 * @version 0.0.1
 *
 * MainMenuController is the controller class for the MainMenu.fxml file.
 * Represents the main menu scene of the graphical user interface.
 */
public class MainMenuController implements Initializable {


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    /**
     * Method behind the 'Continue' button in the MainMenu scene.
     * When the button is pressed the scene will change to the next one,
     * which is the ArmyRegistration scene.
     * @param event
     * @throws IOException
     */
    @FXML
    public void onContinueButtonClick(ActionEvent event) throws IOException {
        WarGamesApplication.goToArmyRegistration();
    }


}
