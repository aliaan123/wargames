package no.ntnu.idatg2001.userinterface;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import no.ntnu.idatg2001.wargames.Army;

/**
 * @author Aliaan
 * @version 0.0.1
 *
 * ArmyDetailsController is the controller class for the ArmyDetails.fxml file,
 * and is made for showing details of an army.
 */
public class ArmyDetailsController{


    //Field for the textfield displaying the total number of units in the army.
    @FXML
    private TextField totalNumberOfUnitsInArmyText;

    //Field for the textfield displaying the number of infantry units in the army.
    @FXML
    private TextField numberOfInfantryUnitsText;

    //Field for the textfield displaying the number of cavalry units in the army.
    @FXML
    private TextField numberOfCavalryUnitsText;

    //Field for the textfield displaying the number of ranged units in the army.
    @FXML
    private TextField numberOfRangedUnitsText;

    //Field for the textfield displaying the number of commander units in the army.
    @FXML
    private TextField numberOfCommanderUnitsText;

    //Field for the textfield displaying the name of the army.
    @FXML
    private TextField armyNameTextField;

    /**
     * Method for displaying the name of an army in a textfield.
     * @param armyName Takes in a String, the name of the army, as a parameter.
     */
    public void displayArmyName(String armyName)
    {
        armyNameTextField.setText(armyName);
    }

    /**
     * Method for setting the textfields in the ArmyDetails scene.
     * @param army Takes in an army as a parameter.
     */
    public void setContentInTextFields(Army army)
    {
        totalNumberOfUnitsInArmyText.setText(String.valueOf(army.getAllUnits().size()));
        numberOfInfantryUnitsText.setText(String.valueOf(army.getInfantryUnits().size()));
        numberOfCavalryUnitsText.setText(String.valueOf(army.getCavalryUnits().size()));
        numberOfRangedUnitsText.setText(String.valueOf(army.getRangedUnits().size()));
        numberOfCommanderUnitsText.setText(String.valueOf(army.getCommanderUnits().size()));
    }


}
