package no.ntnu.idatg2001.userinterface;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import no.ntnu.idatg2001.wargames.Army;
import org.w3c.dom.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ArmyDetailsController implements Initializable {


    @FXML
    private TextField totalNumberOfUnitsInArmyText;

    @FXML
    private TextField numberOfInfantryUnitsText;

    @FXML
    private TextField numberOfCavalryUnitsText;

    @FXML
    private TextField numberOfRangedUnitsText;

    @FXML
    private TextField numberOfCommanderUnitsText;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        setContentInTextFields("ha");
    }

    public void setContentInTextFields(String name)
    {
        totalNumberOfUnitsInArmyText.setText(String.valueOf(Army.getInstance(name).unitsSize()));
        numberOfInfantryUnitsText.setText(String.valueOf(Army.getInstance(name).getInfantryUnits().size()));
        numberOfCavalryUnitsText.setText(String.valueOf(Army.getInstance(name).getCavalryUnits().size()));
        numberOfRangedUnitsText.setText(String.valueOf(Army.getInstance(name).getRangedUnits().size()));
        numberOfCommanderUnitsText.setText(String.valueOf(Army.getInstance(name).getCommanderUnits().size()));
    }


    @FXML
    public void onGoBackButtonClick(ActionEvent event) throws IOException {
        WarGamesApplication.goToArmyRegistration();
    }

    @FXML
    public void onViewArmyDetailsButton(ActionEvent event) throws IOException {
        WarGamesApplication.goToArmyDetails();
    }
}
