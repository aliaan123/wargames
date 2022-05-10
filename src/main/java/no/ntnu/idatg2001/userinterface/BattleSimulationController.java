package no.ntnu.idatg2001.userinterface;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;

import javax.print.DocFlavor;
import java.net.URL;
import java.util.ResourceBundle;

public class BattleSimulationController implements Initializable {


    private String[] terrains = {"HILLS", "FOREST", "PLAINS"};

    @FXML
    private ChoiceBox<String> terrainChoiceBox;


    private String getUnitType(ActionEvent event) {
        String unitType = terrainChoiceBox.getValue();
        return unitType;
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        terrainChoiceBox.getItems().addAll(terrains);
        terrainChoiceBox.setOnAction(this::getUnitType);
    }
}
