package no.ntnu.idatg2001.userinterface;

import javafx.event.ActionEvent;

import java.io.IOException;

public class ArmyDetailsController {


    public void onBackToArmyRegistrationButton(ActionEvent event) throws IOException {
        WarGamesApplication.goToArmyRegistration();
    }
}
