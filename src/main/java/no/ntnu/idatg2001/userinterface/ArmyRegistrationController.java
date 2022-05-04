package no.ntnu.idatg2001.userinterface;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class ArmyRegistrationController {

    @FXML
    public void onGoBackButtonClick(ActionEvent event) throws IOException {
        WarGamesApplication.goToMainMenu();
    }

    @FXML
    public void onAddUnitButtonClick(ActionEvent event) throws IOException {
        WarGamesApplication.goToArmyEditor();
    }


    public void onEditArmyButtonClick(ActionEvent event) throws IOException {
        WarGamesApplication.goToArmyEditor();
    }
}
