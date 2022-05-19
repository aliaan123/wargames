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


/**
 * @author Aliaan
 * @version 0.0.1
 *
 * ArmyRegistrationController is the controller of the ArmyRegistration.fxml file.
 * Controller of the scene where the armies will be registered.
 */
public class ArmyRegistrationController implements Initializable {

    //Field for the army created by the user.
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

    /**
     * Method behind the 'Create an army' button.
     * When the button is pressed, the input from this scene
     * will be transferred to the next one, and the scenes will switch.
     * The ArmyEditor scene will be loaded.
     * @param event
     * @throws IOException
     */
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
            window.setTitle("Creation of army");
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

    /**
     * Method behind the 'Continue to battle simulation' button.
     * When pressed the input and info from this scene will be
     * transferred to the next scene, and the scenes will switch to
     * the BattleSimulation scene.
     * @param event
     * @throws IOException
     */
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
                stage.setTitle("Simulation of the battle");
                stage.setScene(scene);
                stage.show();
            } else {
                armyIsNullAlert();
            }
        } else {
           emptyNameTextFieldAlert();
        }
    }


    /**
     * Method for setting the user's army in the tableview
     * and displaying the details of units in the army.
     * @param army Takes in the user's army as a parameter.
     */
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

    /**
     * Method for setting the text field that
     * displays the name of the army created by the user.
     * @param armyName Takes in a String, the name of the army, as a parameter.
     */
    public void displayArmyName(String armyName)
    {
        nameTextField1.setText(armyName);
    }

    /**
     * Method for setting the text field
     * that displays the total units in the army
     * created by the user.
     * @param army Takes in an army as a parameter.
     */
    public void displayTotalNumbersOfUnitsInArmy(Army army)
    {
        totalUnitsInArmy1TextField.setText(String.valueOf(army.getAllUnits().size()));
    }

    /**
     * Dialog box that is displayed when trying to continue without creating an army.
     * Method for displaying a dialog box, which alerts the user
     * about an error that has occurred when trying to continue without
     * first creating an army by clicking on 'create army'.
     */
    public void armyIsNullAlert()
    {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error alert!");
        alert.setHeaderText("Please create an army before continuing to the battle simulation.");
        alert.setContentText("Click on the 'create army' button to create an army.");
        alert.showAndWait();
    }


    /**
     * Dialog box that is displayed when trying to continue
     * without filling the textfield for the name of the army.
     * Alerts the user about an error that occurred because of
     * empty text fields.
     */
    public void emptyNameTextFieldAlert()
    {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error alert");
        alert.setHeaderText("Empty text fields!");
        alert.setContentText("Please fill in the text fields by choosing a name for your army.");
        alert.showAndWait();
    }

}
