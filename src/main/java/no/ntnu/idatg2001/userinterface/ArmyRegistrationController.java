package no.ntnu.idatg2001.userinterface;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class ArmyRegistrationController {

    @FXML
    public void onGoBackButtonClick(ActionEvent event) throws IOException {
        WarGamesApplication.goToMainMenu();
    }


    public void onAddUnitButtonClick(ActionEvent event) throws IOException {
        WarGamesApplication.goToAddUnits();
    }
}
