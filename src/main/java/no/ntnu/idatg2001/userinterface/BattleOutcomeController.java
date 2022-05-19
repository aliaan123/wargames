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

import java.net.URL;
import java.util.ResourceBundle;

/**
 *
 * @author Aliaan
 * @version 0.0.1
 *
 * BattleOutcomeController is the controller class of the BattleOutcome.fxml file,
 * and it will display details about the outcome of the battle between the two armies.
 *
 */
public class BattleOutcomeController implements Initializable {


    //Field for the tableview of the army created by the user
    @FXML
    private TableView<Unit> army1TableView;

    //Field for the unit type column in the tableview.
    @FXML
    private TableColumn<Unit, String> army1UnitTypeColumn;

    //Field for the name column in the tableview.
    @FXML
    private TableColumn<Unit, String> army1NameColumn;

    //Field for the health column in the tableview.
    @FXML
    private TableColumn<Unit, Integer> army1HealthColumn;

    //Field for the attack column in the tableview.
    @FXML
    private TableColumn<Unit, Integer> army1AttackColumn;

    //Field for the armor column in the tableview.
    @FXML
    private TableColumn<Unit, Integer> army1ArmorColumn;

    //Field for the tableview of the opponent army loaded from a file.
    @FXML
    private TableView<Unit> army2TableView;

    //Field for the unit type column in the tableview.
    @FXML
    private TableColumn<Unit, String> army2UnitTypeColumn;

    //Field for the name column in the tableview.
    @FXML
    private TableColumn<Unit, String> army2NameColumn;

    //Field for the health column in the tableview.
    @FXML
    private TableColumn<Unit, Integer> army2HealthColumn;

    //Field for the attack column in the tableview.
    @FXML
    private TableColumn<Unit, Integer> army2AttackColumn;

    //Field for the armor column in the tableview.
    @FXML
    private TableColumn<Unit, Integer> army2ArmorColumn;

    //Field for the textfield displaying the name of the user's army.
    @FXML
    private TextField army1NameTextField;

    //Field for the textfield displaying the opponent army loaded from a file.
    @FXML
    private TextField army2NameTextField;

    //Field for the textfield displaying the name of the winner of the battle.
    @FXML
    private TextField winnerOfBattleTextField;

    //Field for the textfield displaying number of units left in the user's army after battle.
    @FXML
    private TextField unitsOfArmy1LeftTextField;

    //Field for the textfield displaying number of units left in the opponents' army after battle.
    @FXML
    private TextField unitsOfArmy2LeftTextField;

    //Field for the army that was created by the user.
    private Army army1;

    //Field for the opponent army, which is loaded from a file.
    private Army opponentArmy;


    /**
     * Method for setting the user's army in the tableview
     * and displaying the details of the army after battle.
     * @param army1 Takes in the user's army as a parameter.
     */
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

    /**
     * Method for setting the opponent army in the tableview
     * and displaying the details of the army after battle.
     * @param opponentArmy Takes opponent army loaded from a file as a parameter.
     */
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

    /**
     * Method for setting the number of the units left in the user's army
     * in the textfield, displaying the amount of units in the army alive after the battle
     * @param army1 Takes in the user's army as a parameter
     */
    public void setNumberOfUnitsLeftInArmy1(Army army1)
    {
        unitsOfArmy1LeftTextField.setText(String.valueOf(army1.getAllUnits().size()));
    }

    /**
     * Method for setting the number of the units left in the opponent army
     * in the textfield, displaying the amount of units in the army alive after the battle.
     * @param opponentArmy Takes in the army loaded from the file as a parameter.
     */
    public void setNumberOfUnitsLeftInOpponentArmy(Army opponentArmy)
    {
        unitsOfArmy2LeftTextField.setText(String.valueOf(opponentArmy.getAllUnits().size()));
    }

    /**
     * Method for setting the user's army in the textfield,
     * displaying the name of the army.
     * @param army1 Takes in the user's army as a parameter
     */
    public void setArmy1Name(Army army1)
    {
        army1NameTextField.setText(army1.getName());
    }


    /**
     * Method for setting the opponent army's name in the
     * textfield displaying the opponent army's name.
     * @param opponentArmy Takes in the opponent army as a parameter
     */
    public void setOpponentArmyName(Army opponentArmy)
    {
        army2NameTextField.setText(opponentArmy.getName());
    }


    /**
     * Method for setting the winning army's name in the textfield
     * displaying the winner of the battle between the armies.
     * @param army
     */
    public void setWinningArmyTextField(Army army)
    {
        winnerOfBattleTextField.setText(army.getName());
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
