package no.ntnu.idatg2001.userinterface.controllers;

import java.io.IOException;
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
public class MainMenuController {

    /**
     * Method behind the 'Continue' button in the MainMenu scene.
     * When the button is pressed the scene will change to the next one,
     * which is the ArmyRegistration scene.
     * @param event
     * @throws IOException throws IOException
     */
    @FXML
    public void onContinueButtonClick(ActionEvent event) throws IOException {
        WarGamesApplication.goToArmyRegistration();
    }


}
