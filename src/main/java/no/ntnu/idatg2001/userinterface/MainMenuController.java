package no.ntnu.idatg2001.userinterface;

import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class MainMenuController implements Initializable {


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    public void onContinueButtonClick(ActionEvent event) throws IOException {
        WarGamesApplication.goToArmyRegistration();
    }


}
