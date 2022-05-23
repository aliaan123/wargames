package no.ntnu.idatg2001.userinterface.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import no.ntnu.idatg2001.userinterface.views.DialogBoxes;
import no.ntnu.idatg2001.model.Army;
import no.ntnu.idatg2001.model.ArmyFileHandler;
import no.ntnu.idatg2001.model.Battle;
import no.ntnu.idatg2001.model.Unit;
import no.ntnu.idatg2001.userinterface.views.WarGamesApplication;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.util.ResourceBundle;


/**
 * @author Aliaan
 * @version 0.0.1
 *
 * BattleSimulationController is the controller of the BattleSimulation.fxml file.
 * This is the scene where the simulation between the two armies happen.
 *
 */
public class BattleSimulationController implements Initializable {


    //Field for the different terrains in the choice box.
    private final String[] terrains = {"HILLS", "FOREST", "PLAINS"};

    //Field for the army created by the user.
    private Army army1;

    //Field for copy of the army that the user created.
    private Army army1Copy;

    //Field for the opponent army loaded from a file.
    private Army opponentArmyFromFile;

    //Field for the copy of the opponent army loaded from a file.
    private Army opponentArmyCopy;

    //Field for the winning army in battle.
    private Army winnerOfBattle;

    @FXML
    private TextField army1NameTextField;

    @FXML
    private TextField army2NameTextField;

    @FXML
    private ChoiceBox<String> terrainChoiceBox;

    @FXML
    private TableView<Unit> army1TableView;

    @FXML
    private TableColumn<Unit, String> army1UnitTypeColumn;

    @FXML
    private TableColumn<Unit, String> army1UnitNameColumn;

    @FXML
    private TableColumn<Unit, Integer> army1UnitHealthColumn;

    @FXML
    private TableColumn<Unit, Integer> army1UnitAttackColumn;

    @FXML
    private TableColumn<Unit, Integer> army1UnitArmorColumn;


    @FXML
    private TableView<Unit> army2TableView;

    @FXML
    private TableColumn<Unit, String> army2UnitTypeColumn;

    @FXML
    private TableColumn<Unit, String> army2UnitNameColumn;

    @FXML
    private TableColumn<Unit, Integer> army2UnitHealthColumn;

    @FXML
    private TableColumn<Unit, Integer> army2UnitAttackColumn;

    @FXML
    private TableColumn<Unit, Integer> army2UnitArmorColumn;

    @FXML
    private Button viewBattleResultsButton;

    @FXML
    private TextField numberOfUnitsInArmy1TextField;

    @FXML
    private TextField numberOfUnitsInArmy2TextField;


    /**
     * Method for getting the value in the choice box for
     * choosing a terrain of the battle.
     * @param event
     * @return returns the value in the choice box
     */
    private String getTerrainChoice(ActionEvent event) {
        return terrainChoiceBox.getValue();
    }


    /**
     * Method for starting a battle between two armies.
     * @param army1 takes in army created by user as a parameter.
     * @param army2 takes in opponent army as a parameter.
     * @param terrain takes in terrain of the battlefield as a parameter.
     * @return returns the winner of the battle
     */
    public Army battleBetweenArmies(Army army1, Army army2, String terrain)
    {
        Battle battle = new Battle(army1, army2, terrain);
        winnerOfBattle = battle.simulate();
        return winnerOfBattle;
    }

    /**
     * Method behind the 'Start simulation' button.
     * The battle simulation between the two armies will
     * start when a terrain is chosen and the button has been pressed.
     */
    @FXML
    public void onRunSimulationButtonClick() {

        army1Copy = army1.cloneArmy();
        if(this.opponentArmyFromFile != null) {
            opponentArmyCopy = opponentArmyFromFile.cloneArmy();
        } else {
            DialogBoxes.noOpponentArmyLoadedAlert();
        }
            try {
                if (!terrainChoiceBox.getValue().isEmpty()) {
                    battleBetweenArmies(army1Copy, opponentArmyCopy, terrainChoiceBox.getValue());
                    DialogBoxes.battleOutcomeAlert();
                }
            } catch (NullPointerException e) {
                DialogBoxes.emptyChoiceBoxAlert();

            }
    }



    /**
     * Method for setting the textfield of the army created by the user,
     * to display the army's name.
     * @param armyName takes in String, representing army's name, as parameter
     */
    public void displayArmy1Name(String armyName)
    {
        army1NameTextField.setText(armyName);
    }


    /**
     * Method for setting the textfield of the opponent army,
     * to display the opponent army's name.
     * @param armyName takes in String, representing army's name as parameter
     */
    public void displayArmy2Name(String armyName)
    {
        army2NameTextField.setText(armyName);
    }

    /**
     * Method for setting textfield that displays the total number of units in the army
     * created by the user.
     * @param army takes in army object as parameter
     */
    public void displayTotalNumbersOfUnitsInArmy(Army army)
    {
        numberOfUnitsInArmy1TextField.setText(String.valueOf(army.getAllUnits().size()));
    }

    /**
     * Method behind the 'View battle results' button in the BattleSimulation scene.
     * It will load a pop-up window that displays details about the outcome of the battle
     * between the two armies after their battle has been fought when pressed.
     * @param event
     * @throws IOException throws IOException
     */
    @FXML
    public void onViewBattleResultsButtonClick(ActionEvent event) throws IOException {
        if(opponentArmyFromFile != null) {
            try {
                Stage stage = new Stage();
                FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("BattleOutcome.fxml"));
                Parent root = loader.load();

                BattleOutcomeController battleOutcomeController = loader.getController();
                battleOutcomeController.initArmy1Data(army1Copy);
                battleOutcomeController.initOpponentArmyData(opponentArmyCopy);
                battleOutcomeController.setWinningArmyTextField(winnerOfBattle);

                stage.setScene(new Scene(root));
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.initOwner(viewBattleResultsButton.getScene().getWindow());
                stage.setTitle("Results of the battle");
                stage.showAndWait();
            } catch (NullPointerException e) {
                DialogBoxes.errorPopUpWindow(String.valueOf(e.getMessage()));
            }
        } else {
            DialogBoxes.noOpponentArmyLoadedAlert();
        }

    }


    /**
     * Method behind the 'Reset armies' button in the BattleSimulation scene.
     * When the button is pressed the armies will go back to their original state,
     * like they were before battling with eachother.
     * @param event
     */
    @FXML
    public void onInfoButtonClick(ActionEvent event) {


        initArmy1(army1);
        initOpponentArmyFromFile(opponentArmyFromFile);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information!");
        alert.setHeaderText("Information about how to run a new simulation.");
        alert.setContentText("You can run the simulation as many times as you want as long as there are two armies in the tableviews. " +
                "If you wish to battle another army," +
                "then just click on another load file button and run the simulation again.");
        alert.showAndWait();

    }

    /**
     * set-method for setting army.
     * @param army1 Takes in army object as parameter
     */
    public void setArmy1(Army army1) {
        this.army1 = army1;
    }


    /**
     * Method for setting the army created by the user in the tableview
     * to display the details of the units in the army.
     * @param army Takes in the army as a parameter
     */
    public void initArmy1(Army army) {

        ObservableList<Unit> unitObservableList = FXCollections.observableList(army.getAllUnits());
        army1TableView.setItems(unitObservableList);

        army1UnitTypeColumn.setCellValueFactory(new PropertyValueFactory<>("unitType"));
        army1UnitNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        army1UnitHealthColumn.setCellValueFactory(new PropertyValueFactory<>("health"));
        army1UnitAttackColumn.setCellValueFactory(new PropertyValueFactory<>("attack"));
        army1UnitArmorColumn.setCellValueFactory(new PropertyValueFactory<>("armor"));

    }

    /**
     * Method for setting the opponent army in the tableview
     * to display the details of the units in the army.
     * @param opponentArmyFromFile Takes in the opponent army as a parameter
     */
    public void initOpponentArmyFromFile(Army opponentArmyFromFile) {

        ObservableList<Unit> unitObservableList = FXCollections.observableList(opponentArmyFromFile.getAllUnits());
        army2TableView.setItems(unitObservableList);

        army2UnitTypeColumn.setCellValueFactory(new PropertyValueFactory<>("unitType"));
        army2UnitNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        army2UnitHealthColumn.setCellValueFactory(new PropertyValueFactory<>("health"));
        army2UnitAttackColumn.setCellValueFactory(new PropertyValueFactory<>("attack"));
        army2UnitArmorColumn.setCellValueFactory(new PropertyValueFactory<>("armor"));

        displayArmy2Name(opponentArmyFromFile.getName());
        numberOfUnitsInArmy2TextField.setText(String.valueOf(opponentArmyFromFile.getAllUnits().size()));

    }


    /**
     * Method that sends you back to the main menu
     * @throws IOException throws IOException
     */
    @FXML
    public void onMainMenuButtonClick() throws IOException {
        WarGamesApplication.goToMainMenu();
    }

    /**
     * Method behind the 'load 1' button in the BattleSimulation scene.
     * It will load an opponent army from a file when pressed.
     */
    @FXML
    public void onLoadArmy1ButtonClick()
    {
        try {
            loadArmyFromFile("src/main/resources/SavedArmy/opponentArmy1.csv");
            Path path = Path.of("src/main/resources/SavedArmy/opponentArmy1.csv");
            DialogBoxes.loadArmyAlert(path);

        } catch (IOException e) {
            DialogBoxes.errorPopUpWindow(String.valueOf(e.getCause()));
        }
    }


    /**
     * Method behind the 'load 2' button in the BattleSimulation scene.
     * It will load an opponent army from a file when pressed.
     */
    @FXML
    public void onLoadArmy2ButtonClick()
    {
        try {
            loadArmyFromFile("src/main/resources/SavedArmy/opponentArmy2.csv");
            Path path = Path.of("src/main/resources/SavedArmy/opponentArmy2.csv");
            DialogBoxes.loadArmyAlert(path);

        } catch (IOException e) {
            DialogBoxes.errorPopUpWindow(String.valueOf(e.getCause()));
        }
    }


    /**
     * Method behind the 'load 3' button in the BattleSimulation scene.
     * It will load an opponent army from a file when pressed.
     */
    @FXML
    public void onLoadArmy3ButtonClick()
    {
        try {
            loadArmyFromFile("src/main/resources/SavedArmy/opponentArmy3.csv");
            Path path = Path.of("src/main/resources/SavedArmy/opponentArmy3.csv");
            DialogBoxes.loadArmyAlert(path);

        } catch (IOException e) {
            DialogBoxes.errorPopUpWindow(String.valueOf(e.getCause()));
        }
    }


    /**
     * Method behind the 'load 4' button in the BattleSimulation scene.
     * It will load an opponent army from a file when pressed.
     */
    @FXML
    public void onLoadArmy4ButtonClick()
    {
        try {
            loadArmyFromFile("src/main/resources/SavedArmy/opponentArmy4.csv");
            Path path = Path.of("src/main/resources/SavedArmy/opponentArmy4.csv");
            DialogBoxes.loadArmyAlert(path);

        } catch (IOException e) {
            DialogBoxes.errorPopUpWindow(String.valueOf(e.getCause()));
        }
    }

    /**
     * Method for loading an opponent army from a file, and setting the army in the tableview.
     * @param path Takes a file path as a parameter.
     * @throws IOException throws IOException
     */
    public void loadArmyFromFile(String path) throws IOException
    {
        opponentArmyFromFile = ArmyFileHandler.readCSV(Path.of(path));
        army2TableView.getItems().addAll(opponentArmyFromFile.getAllUnits());
        initOpponentArmyFromFile(opponentArmyFromFile);
    }


    /**
     * Initialize method, which initializes the choice box
     * for choosing the terrain of the battlefield.
     * @param url url
     * @param resourceBundle resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        terrainChoiceBox.getItems().addAll(terrains);
        terrainChoiceBox.setOnAction(this::getTerrainChoice);
    }
}
