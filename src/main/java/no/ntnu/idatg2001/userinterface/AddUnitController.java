package no.ntnu.idatg2001.userinterface;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddUnitController implements Initializable {


    @FXML
    private ChoiceBox<String> unitTypeChoiceBox;

    private String[] unitTypes = {"Infantry Unit", "Ranged Unit", "Cavalry Unit", "Commander Unit"};


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        unitTypeChoiceBox.getItems().addAll(unitTypes);
        unitTypeChoiceBox.setOnAction(this::getUnitType);
    }

    private String getUnitType(ActionEvent event) {
        String unitType = unitTypeChoiceBox.getValue();
        return unitType;
    }

    @FXML
    public void onGoBackButtonClick(ActionEvent event) throws IOException {
        WarGamesApplication.goToArmyRegistration();
    }
}
