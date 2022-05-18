package no.ntnu.idatg2001.userinterface;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import no.ntnu.idatg2001.wargames.Army;
import no.ntnu.idatg2001.wargames.ArmyFileHandler;
import no.ntnu.idatg2001.wargames.Battle;
import no.ntnu.idatg2001.wargames.Unit;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class BattleSimulationController implements Initializable {


    private String[] terrains = {"HILLS", "FOREST", "PLAINS"};

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

    private Army unitList1;
    private Army opponentArmyFromFile;

    private ObservableList<Unit> unitObservableList1;
    private ObservableList<Unit> unitObservableList2;

    @FXML
    private TextField numberOfUnitsInArmy1TextField;

    @FXML
    private TextField numberOfUnitsInArmy2TextField;


    private String getTerrainChoice(ActionEvent event) {
        return terrainChoiceBox.getValue();
    }

    @FXML
    public void onStartSimulationButtonClick()
    {
        if(terrainChoiceBox.getValue() != null) {
            Battle battle = new Battle(unitList1, opponentArmyFromFile, terrainChoiceBox.getValue());
            Army winner = battle.simulate();
            battleOutcomeAlert();

            System.out.println("Winner of the battle:" + winner.getName());
            System.out.println(unitList1.getAllUnits().size());
            System.out.println(opponentArmyFromFile.getAllUnits().size());

            //army1TableView.refresh();
            //army2TableView.refresh();
        }
        else
        {
            emptyChoiceBoxAlert();
        }

    }

    public void displayArmy1Name(String armyName)
    {
        army1NameTextField.setText(armyName);
    }


    public void displayArmy2Name(String armyName)
    {
        army2NameTextField.setText(armyName);
    }


    public void displayTotalNumbersOfUnitsInArmy(Army army)
    {
        try {
            numberOfUnitsInArmy1TextField.setText(String.valueOf(army.getAllUnits().size()));
        }
        catch (Exception e)
        {

        }
    }

    @FXML
    public void onResetArmiesButtonClick(ActionEvent event) throws IOException {

        /*
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("ArmyRegistration.fxml"));
        Parent tableViewParent = loader.load();
        Scene tableViewScene = new Scene(tableViewParent);

        ArmyRegistrationController armyRegistrationController = loader.getController();



        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();

         */

    }

    public void setUnitList1(Army unitList1) throws IOException {
        this.unitList1 = unitList1;

        ObservableList<Unit> unitObservableList = FXCollections.observableList(unitList1.getAllUnits());
        army1TableView.setItems(unitObservableList);

        army1UnitTypeColumn.setCellValueFactory(new PropertyValueFactory<>("unitType"));
        army1UnitNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        army1UnitHealthColumn.setCellValueFactory(new PropertyValueFactory<>("health"));
        army1UnitAttackColumn.setCellValueFactory(new PropertyValueFactory<>("attack"));
        army1UnitArmorColumn.setCellValueFactory(new PropertyValueFactory<>("armor"));
        //saveArmy(unitList1);
    }




    public void initOpponentArmyFromFile(Army opponentArmy) {
        this.opponentArmyFromFile = opponentArmy;

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


    @FXML
    public void onLoadArmy1ButtonClick()
    {
        try {
            loadArmyFromFile("src/main/resources/SavedArmy/opponentArmy1.csv");
            Path path = Path.of("src/main/resources/SavedArmy/opponentArmy1.csv");
            loadArmyAlert(path);

        } catch (IOException | ClassNotFoundException e) {
            WarGamesApplication.errorPopUpWindow(String.valueOf(e.getCause()));
        }
    }

    @FXML
    public void onLoadArmy2ButtonClick()
    {
        try {
            loadArmyFromFile("src/main/resources/SavedArmy/opponentArmy2.csv");
            Path path = Path.of("src/main/resources/SavedArmy/opponentArmy2.csv");
            loadArmyAlert(path);

        } catch (IOException | ClassNotFoundException e) {
            WarGamesApplication.errorPopUpWindow(String.valueOf(e.getCause()));
        }
    }


    @FXML
    public void onLoadArmy3ButtonClick()
    {
        try {
            loadArmyFromFile("src/main/resources/SavedArmy/opponentArmy3.csv");
            Path path = Path.of("src/main/resources/SavedArmy/opponentArmy3.csv");
            loadArmyAlert(path);

        } catch (IOException | ClassNotFoundException e) {
            WarGamesApplication.errorPopUpWindow(String.valueOf(e.getCause()));
        }
    }

    public void loadArmyAlert(Path path)
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information!");
        alert.setHeaderText("Loading army from file");
        alert.setContentText("This army from loaded from: " + path);
        alert.showAndWait();
    }

    public void loadArmyFromFile(String path) throws IOException, ClassNotFoundException
    {
        opponentArmyFromFile = ArmyFileHandler.readCSV(Path.of(path));
        army2TableView.getItems().addAll(opponentArmyFromFile.getAllUnits());
        initOpponentArmyFromFile(opponentArmyFromFile);
    }

    public void emptyChoiceBoxAlert()
    {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error!");
        alert.setHeaderText("Choice box is empty!");
        alert.setContentText("Please choose a terrain for the battlefield before continuing.");
        alert.show();
    }

    public void battleOutcomeAlert()
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information!");
        alert.setHeaderText("View outcome of the battle");
        alert.setContentText("The battle is over. Press the 'view battle results' button to view the outcome.");
        alert.show();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        terrainChoiceBox.getItems().addAll(terrains);
        terrainChoiceBox.setOnAction(this::getTerrainChoice);

        //unitObservableList1 = FXCollections.observableList(unitList1.getAllUnits());

        unitObservableList1 = FXCollections.observableList(new ArrayList<>());
        unitObservableList2 = FXCollections.observableList(new ArrayList<>());

        // Vi oppretter nye armier her, så hva skjer med de vi sender over fra army registration??
        //unitList1 = new Army(army1NameTextField.getText(), unitObservableList1);
        //setUnitList1(new Army(army1NameTextField.getText(), unitObservableList1));
        //unitList2 = new Army(army2NameTextField.getText(), unitObservableList2);

        army1TableView.setItems(unitObservableList1);
        army2TableView.setItems(unitObservableList2);

    }
}
