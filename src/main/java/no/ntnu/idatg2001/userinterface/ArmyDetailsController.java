package no.ntnu.idatg2001.userinterface;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import no.ntnu.idatg2001.wargames.Army;

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

    @FXML
    private TextField armyNameTextField;

    @FXML
    public void displayArmyName(String armyName)
    {
        armyNameTextField.setText(armyName);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void setContentInTextFields(Army army)
    {
        totalNumberOfUnitsInArmyText.setText(String.valueOf(army.getAllUnits().size()));
        numberOfInfantryUnitsText.setText(String.valueOf(army.getInfantryUnits().size()));
        numberOfCavalryUnitsText.setText(String.valueOf(army.getCavalryUnits().size()));
        numberOfRangedUnitsText.setText(String.valueOf(army.getRangedUnits().size()));
        numberOfCommanderUnitsText.setText(String.valueOf(army.getCommanderUnits().size()));
    }


}
