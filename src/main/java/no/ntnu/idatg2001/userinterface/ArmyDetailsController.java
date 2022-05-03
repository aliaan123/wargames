package no.ntnu.idatg2001.userinterface;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import no.ntnu.idatg2001.wargames.*;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ArmyDetailsController implements Initializable {


    private Army unitList;
    private ObservableList<Unit> unitObservableList;

    private String[] unitTypes = {"Infantry Unit", "Ranged Unit", "Cavalry Unit", "Commander Unit"};

    @FXML
    private TableView<Unit> armyTableView;

    @FXML
    private TableColumn<Unit, String> unitTypeColumn;

    @FXML
    private TableColumn<Unit, String> unitNameColumn;

    @FXML
    private TableColumn<Unit, Integer> unitHealthColumn;

    @FXML
    private TableColumn<Unit, Integer> unitAttackColumn;

    @FXML
    private TableColumn<Unit, Integer> unitArmorColumn;

    @FXML
    private ChoiceBox<String> unitTypeChoiceBox;

    @FXML
    private TextField nameOfUnitTextField;


    public void onBackToArmyRegistrationButton(ActionEvent event) throws IOException {
        WarGamesApplication.goToArmyRegistration();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        unitTypeChoiceBox.getItems().addAll(unitTypes);
        unitTypeChoiceBox.setOnAction(this::getUnitType);


        unitObservableList = FXCollections.observableList(new ArrayList<>());
        unitList = new Army("Heio", unitObservableList);

        //unitList = new Army("Heio");
        //unitList.add(new InfantryUnit("Infantry Unit", 1));
        //unitList.add(new RangedUnit("Ranged Unit", 13));
        //unitObservableList = FXCollections.observableList(unitList.getAllUnits());
        armyTableView.setItems(unitObservableList);
        // ØNSKER Å FÅ INSTANCE OF UNIT HER, IKKE NAME
        unitTypeColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        unitNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        unitHealthColumn.setCellValueFactory(new PropertyValueFactory<>("health"));
        unitAttackColumn.setCellValueFactory(new PropertyValueFactory<>("attack"));
        unitArmorColumn.setCellValueFactory(new PropertyValueFactory<>("armor"));

    }

    private String getUnitType(ActionEvent event) {
        String unitType = unitTypeChoiceBox.getValue();
        return unitType;
    }

    public void addUnitToArmy()
    {
        if(!nameOfUnitTextField.getText().isEmpty() && !unitTypeChoiceBox.getValue().isEmpty()) {
            armyTableView.getItems().add(UnitFactory.factoryCreatingUnit(unitTypeChoiceBox.getValue(), nameOfUnitTextField.getText(), 100));
            nameOfUnitTextField.clear();
            //unitTypeChoiceBox.setValue(null);
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error alert");
            alert.setHeaderText("Empty text fields!");
            alert.setContentText("Please fill in the text fields and choose a unit type.");
            alert.showAndWait();
        }
    }


    public void onDeleteButtonClick()
    {
        if(!armyTableView.getSelectionModel().isEmpty())
        {
            Unit unit = armyTableView.getSelectionModel().getSelectedItem();
            unitList.remove(unit);
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!");
            alert.setHeaderText("Error when deleting a unit!");
            alert.setContentText("Please select a unit to remove in the table-view!");
            alert.showAndWait();
        }

    }






}
