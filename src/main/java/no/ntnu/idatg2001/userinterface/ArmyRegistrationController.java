package no.ntnu.idatg2001.userinterface;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import no.ntnu.idatg2001.wargames.Army;
import no.ntnu.idatg2001.wargames.Unit;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ArmyRegistrationController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;

    private Army army1;

    @FXML
    private TextField nameTextField1;

    @FXML
    private TextField totalUnitsInArmy1TextField;

    @FXML
    private TableView<Unit> army1TableView;

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

    private Scene sceneToBeStored;

    private Scene tableViewScene;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    public void onGoBackButtonClick(ActionEvent event) throws IOException {
        WarGamesApplication.goToMainMenu();
    }

    @FXML
    public void onEditArmy1ButtonClick(ActionEvent event) throws IOException {

        if(!nameTextField1.getText().isEmpty()) {

            String armyName = nameTextField1.getText();
            //FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("ArmyEditor.fxml"));
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getClassLoader().getResource("ArmyEditor.fxml"));
            Parent tableViewParent = loader.load();
            tableViewScene = new Scene(tableViewParent);
            //root = loader.load();
            ArmyEditorController armyEditorController = loader.getController();
            armyEditorController.displayArmyName(armyName);
            //armyEditorController.storeScene(tableViewScene);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();


            if(army1 == null) {
                window.setScene(tableViewScene);
            }
            else {
                //window.setScene(armyEditorController.getTableViewScene());
            }
            window.show();
            /*
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            */
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error alert");
            alert.setHeaderText("Empty text fields!");
            alert.setContentText("Please fill in the text fields by choosing a name for your army.");
            alert.showAndWait();
        }
    }

    public void setScene1(Scene sceneSentOver)
    {
        this.sceneToBeStored = sceneSentOver;
    }

    @FXML
    public void onStartBattleSimulationButtonClick(ActionEvent event) throws IOException{
        //&& !nameTextField2.getText().isEmpty() && totalNumberOfUnit > 1
        if(!nameTextField1.getText().isEmpty()) {

            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("BattleSimulation.fxml"));
            root = loader.load();
            BattleSimulationController battleSimulationController = loader.getController();

            battleSimulationController.displayArmy1Name(nameTextField1.getText());
            battleSimulationController.displayTotalNumbersOfUnitsInArmy(army1);
            battleSimulationController.setUnitList1(army1);

            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error alert");
            alert.setHeaderText("Empty text fields!");
            alert.setContentText("Please fill in the text fields by choosing a name for your army.");
            alert.showAndWait();
        }
    }

    public void initArmyData(Army army1) {
        this.army1 = army1;

        ObservableList<Unit> unitObservableList = FXCollections.observableList(army1.getAllUnits());
        army1TableView.setItems(unitObservableList);
        unitTypeColumn.setCellValueFactory(new PropertyValueFactory<>("unitType"));
        unitNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        unitHealthColumn.setCellValueFactory(new PropertyValueFactory<>("health"));
        unitAttackColumn.setCellValueFactory(new PropertyValueFactory<>("attack"));
        unitArmorColumn.setCellValueFactory(new PropertyValueFactory<>("armor"));

    }

    public void displayArmyName(String armyName)
    {
        nameTextField1.setText(armyName);
    }

    public void displayTotalNumbersOfUnitsInArmy(Army army)
    {
        try {
            totalUnitsInArmy1TextField.setText(String.valueOf(army.getAllUnits().size()));
        }
        catch (Exception e) {

        }
    }

}
