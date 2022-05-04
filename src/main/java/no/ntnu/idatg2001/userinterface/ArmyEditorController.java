package no.ntnu.idatg2001.userinterface;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import no.ntnu.idatg2001.wargames.*;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ArmyEditorController implements Initializable {



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

    @FXML
    private TableColumn<Unit, Integer> numberOfUnitsColumn;


    public void onBackToArmyRegistrationButton(ActionEvent event) throws IOException {
        WarGamesApplication.goToArmyRegistration();
    }

    public void OnViewArmyDetailsButtonClick(ActionEvent event) throws IOException
    {
        WarGamesApplication.goToArmyDetails();
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
        unitTypeColumn.setCellValueFactory(new PropertyValueFactory<>("unitType"));
        unitNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        unitHealthColumn.setCellValueFactory(new PropertyValueFactory<>("health"));
        unitAttackColumn.setCellValueFactory(new PropertyValueFactory<>("attack"));
        unitArmorColumn.setCellValueFactory(new PropertyValueFactory<>("armor"));

    }

    private String getUnitType(ActionEvent event) {
        String unitType = unitTypeChoiceBox.getValue();
        return unitType;
    }

    public Army getUnitList() {
        return unitList;
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


    public void onLoadArmyFromFileButtonClick()
    {
        try {
            loadArmyFromFile("src/main/resources/SavedArmy/units.csv");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information!");
            alert.setHeaderText("Loading army from file");
            alert.setContentText("This army from loaded from: src/main/resources/SavedArmy/units.csv");
            alert.showAndWait();

        } catch (IOException | ClassNotFoundException e) {
            WarGamesApplication.errorPopUpWindow(String.valueOf(e.getCause()));
        }
    }


    public void loadArmyFromFile(String path) throws IOException, ClassNotFoundException
    {
        Army army = ArmyFileHandler.readCSV(Path.of(path));
        armyTableView.getItems().addAll(army.getAllUnits());
    }








}
