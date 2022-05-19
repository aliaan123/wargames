package no.ntnu.idatg2001.userinterface;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import no.ntnu.idatg2001.wargames.Army;
import no.ntnu.idatg2001.wargames.Unit;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class BattleOutcomeController implements Initializable {



    @FXML
    private TableView<Unit> army1TableView;

    @FXML
    private TableColumn<Unit, String> army1UnitTypeColumn;

    @FXML
    private TableColumn<Unit, String> army1NameColumn;

    @FXML
    private TableColumn<Unit, Integer> army1HealthColumn;

    @FXML
    private TableColumn<Unit, Integer> army1AttackColumn;

    @FXML
    private TableColumn<Unit, Integer> army1ArmorColumn;

    @FXML
    private TableView<Unit> army2TableView;

    @FXML
    private TableColumn<Unit, String> army2UnitTypeColumn;

    @FXML
    private TableColumn<Unit, String> army2NameColumn;

    @FXML
    private TableColumn<Unit, Integer> army2HealthColumn;

    @FXML
    private TableColumn<Unit, Integer> army2AttackColumn;

    @FXML
    private TableColumn<Unit, Integer> army2ArmorColumn;

    @FXML
    private TextField army1NameTextField;

    @FXML
    private TextField army2NameTextField;

    @FXML
    private TextField winnerOfBattleTextField;

    @FXML
    private TextField unitsOfArmy1LeftTextField;

    @FXML
    private TextField unitsOfArmy2LeftTextField;

    private Army army1;

    private Army opponentArmy;


    public void initArmy1Data(Army army1) {
        this.army1 = army1;

        ObservableList<Unit> unitObservableList = FXCollections.observableList(army1.getAllUnits());
        army1TableView.setItems(unitObservableList);

        army1UnitTypeColumn.setCellValueFactory(new PropertyValueFactory<>("unitType"));
        army1NameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        army1HealthColumn.setCellValueFactory(new PropertyValueFactory<>("health"));
        army1AttackColumn.setCellValueFactory(new PropertyValueFactory<>("attack"));
        army1ArmorColumn.setCellValueFactory(new PropertyValueFactory<>("armor"));

        setArmy1Name(army1);
        setNumberOfUnitsLeftInArmy1(army1);
    }



    public void initOpponentArmyData(Army opponentArmy) {
        this.opponentArmy = opponentArmy;

        ObservableList<Unit> unitObservableList = FXCollections.observableList(opponentArmy.getAllUnits());
        army2TableView.setItems(unitObservableList);

        army2UnitTypeColumn.setCellValueFactory(new PropertyValueFactory<>("unitType"));
        army2NameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        army2HealthColumn.setCellValueFactory(new PropertyValueFactory<>("health"));
        army2AttackColumn.setCellValueFactory(new PropertyValueFactory<>("attack"));
        army2ArmorColumn.setCellValueFactory(new PropertyValueFactory<>("armor"));

        setOpponentArmyName(opponentArmy);
        setNumberOfUnitsLeftInOpponentArmy(opponentArmy);

    }

    public void setNumberOfUnitsLeftInArmy1(Army army1)
    {
        unitsOfArmy1LeftTextField.setText(String.valueOf(army1.getAllUnits().size()));
    }

    public void setNumberOfUnitsLeftInOpponentArmy(Army opponentArmy)
    {
        unitsOfArmy2LeftTextField.setText(String.valueOf(opponentArmy.getAllUnits().size()));
    }

    public void setArmy1Name(Army army1)
    {
        army1NameTextField.setText(army1.getName());
    }

    public void setOpponentArmyName(Army opponentArmy)
    {
        army2NameTextField.setText(opponentArmy.getName());
    }


    public void setWinningArmyTextField(Army army)
    {
        winnerOfBattleTextField.setText(army.getName());
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
