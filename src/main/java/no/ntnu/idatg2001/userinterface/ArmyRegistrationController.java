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

    private Army army;

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    public void onCreateAnArmyButtonClick(ActionEvent event) throws IOException {

        if(!nameTextField1.getText().isEmpty()) {

            String armyName = nameTextField1.getText();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getClassLoader().getResource("ArmyEditor.fxml"));
            Parent tableViewParent = loader.load();
            Scene tableViewScene = new Scene(tableViewParent);

            ArmyEditorController armyEditorController = loader.getController();
            armyEditorController.displayArmyName(armyName);

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            if(army == null) {
                window.setScene(tableViewScene);
            } else {
                //window.setScene(armyEditorController.getTableViewScene());
            }
            window.show();
        }
        else {
            emptyNameTextFieldAlert();
        }
    }

    @FXML
    public void onContinueToBattleSimulationButtonClick(ActionEvent event) throws IOException{
        if(!nameTextField1.getText().isEmpty()) {
            if(army != null) {
                FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("BattleSimulation.fxml"));
                Parent root = loader.load();
                BattleSimulationController battleSimulationController = loader.getController();

                battleSimulationController.displayArmy1Name(nameTextField1.getText());
                battleSimulationController.displayTotalNumbersOfUnitsInArmy(army);
                battleSimulationController.initArmy1(army);

                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } else {
                armyIsNullAlert();
            }
        } else {
           emptyNameTextFieldAlert();
        }
    }

    public void initArmyData(Army army) {
        this.army = army;

        ObservableList<Unit> unitObservableList = FXCollections.observableList(army.getAllUnits());
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
        totalUnitsInArmy1TextField.setText(String.valueOf(army.getAllUnits().size()));
    }

    public void armyIsNullAlert()
    {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error alert!");
        alert.setHeaderText("Please create an army before continuing to the battle simulation.");
        alert.setContentText("Click on the 'create army' button to create an army.");
        alert.showAndWait();
    }
    public void emptyNameTextFieldAlert()
    {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error alert");
        alert.setHeaderText("Empty text fields!");
        alert.setContentText("Please fill in the text fields by choosing a name for your army.");
        alert.showAndWait();
    }

}
