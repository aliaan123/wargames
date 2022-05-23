package no.ntnu.idatg2001.userinterface.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import no.ntnu.idatg2001.userinterface.views.DialogBoxes;
import no.ntnu.idatg2001.model.*;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.ResourceBundle;


/**
 *
 * @author Aliaan
 * @version 0.0.1
 *
 * ArmyEditorController is the controller class for the ArmyEditor.fxml file,
 * and is the controller for the scene where the army is being created.
 */
public class ArmyEditorController implements Initializable {

    //Field for the army that is being created in the scene
    private Army army1;

    //Field for the different unit types within an army
    private final String[] unitTypes = {"Infantry Unit", "Ranged Unit", "Cavalry Unit", "Commander Unit"};

    //Field for the tableview in the ArmyEditor scene.
    @FXML
    private TableView<Unit> armyTableView;

    //Field for the unit type column in the tableview.
    @FXML
    private TableColumn<Unit, String> unitTypeColumn;

    //Field for the name column in the tableview.
    @FXML
    private TableColumn<Unit, String> unitNameColumn;

    //Field for the health column in the tableview.
    @FXML
    private TableColumn<Unit, Integer> unitHealthColumn;

    //Field for the attack column in the tableview.
    @FXML
    private TableColumn<Unit, Integer> unitAttackColumn;

    //Field for the armor column in the tableview.
    @FXML
    private TableColumn<Unit, Integer> unitArmorColumn;

    //Field for the choice box for choosing a unit type.
    @FXML
    private ChoiceBox<String> unitTypeChoiceBox;

    //Field for the textfield where you write in a units name.
    @FXML
    private TextField nameOfUnitTextField;

    //Field for the textfield displaying the army's name
    @FXML
    private TextField nameOfArmyTextField;

    //Field for the viewArmyDetails button
    @FXML
    private Button viewArmyDetailsButton;


    /**
     * Initializer of the ArmyEditor scene
     * @param url url
     * @param resourceBundle resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        unitTypeChoiceBox.getItems().addAll(unitTypes);
        unitTypeChoiceBox.setOnAction(this::getUnitType);

        ObservableList<Unit> unitObservableList = FXCollections.observableList(new ArrayList<>());
        armyTableView.setItems(unitObservableList);

        army1 = new Army(nameOfArmyTextField.getText(), unitObservableList);

        unitTypeColumn.setCellValueFactory(new PropertyValueFactory<>("unitType"));
        unitNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        unitHealthColumn.setCellValueFactory(new PropertyValueFactory<>("health"));
        unitAttackColumn.setCellValueFactory(new PropertyValueFactory<>("attack"));
        unitArmorColumn.setCellValueFactory(new PropertyValueFactory<>("armor"));

    }


    /**
     * Method behind the 'Continue' button in the ArmyEditor scene.
     * When the button is pressed, the input given by the user will be transferred
     * to the next scene (ArmyRegistration) and the scenes will change.
     * @param event
     * @throws IOException
     */
    @FXML
    public void onContinueButtonClick(ActionEvent event) throws IOException {

        String armyName = nameOfArmyTextField.getText();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("ArmyRegistration.fxml"));
        Parent tableViewParent = loader.load();

        Scene tableViewScene = new Scene(tableViewParent);

        ArmyRegistrationController armyRegistrationController = loader.getController();
        armyRegistrationController.displayArmyName(armyName);
        armyRegistrationController.initArmyData(army1);
        armyRegistrationController.displayTotalNumbersOfUnitsInArmy(army1);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setTitle("Registration of an army");
        window.setScene(tableViewScene);
        window.show();

    }


    /**
     * Method behind the 'View army details' button in the ArmyEditor scene.
     * When the button is pressed, a pop-up window with details about the army will be displayed.
     * @param event
     * @throws IOException
     */
    @FXML
    public void onViewArmyDetailsButtonClick(ActionEvent event) throws IOException
    {
        String armyName = nameOfArmyTextField.getText();

        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("ArmyDetails.fxml"));
        Parent root = loader.load();

        ArmyDetailsController armyDetailsController = loader.getController();
        armyDetailsController.displayArmyName(armyName);
        armyDetailsController.setContentInTextFields(army1);

        stage.setScene(new Scene(root));
        stage.initModality(Modality.APPLICATION_MODAL); // To make ArmyDetails a Pop-up window
        stage.initOwner(viewArmyDetailsButton.getScene().getWindow()); //
        stage.setTitle("Details about army");
        stage.showAndWait();
    }

    /**
     * Method for setting the name of the army that has been created.
     * @param armyName takes in a String, the name of the army, as a parameter
     */
    public void displayArmyName(String armyName)
    {
        nameOfArmyTextField.setText(armyName);
        army1.setName(armyName);
    }

    /**
     * Method for getting the value in the choice box for choosing the unit's type.
     * @param event
     * @return returns the chosen value in the choicebox
     */
    private String getUnitType(ActionEvent event) {
        return unitTypeChoiceBox.getValue();
    }

    /**
     * Method behind the 'Add unit to army' button in the scene.
     * Meant to be clicked when the textfield for the unit's name is filled
     * and unit type has been chosen in the choice box.
     * It will then add a unit to the army with the given details.
     */
    @FXML
    public void onAddUnitToArmyButtonClicked()
    {
        try {
            if (!nameOfUnitTextField.getText().isEmpty() && !unitTypeChoiceBox.getValue().isEmpty()
                    && nameOfUnitTextField.getText().length() < 32)
            {
                army1.add(UnitFactory.factoryCreatingUnit(unitTypeChoiceBox.getValue(), nameOfUnitTextField.getText(), 100));
                nameOfUnitTextField.clear();
            } else {
                DialogBoxes.invalidNameTextFieldAlert();
            }
        }
        catch (NullPointerException e) {
            DialogBoxes.emptyChoiceBoxAlert();
        }
    }


    /**
     * Method for deleting a unit from the army when the unit in the tableview
     * is selected and the delete button in the scene is clicked.
     */
    @FXML
    public void onDeleteButtonClick()
    {
        if(!armyTableView.getSelectionModel().isEmpty())
        {
            Unit unit = armyTableView.getSelectionModel().getSelectedItem();
            army1.remove(unit);
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!");
            alert.setHeaderText("Error when deleting a unit!");
            alert.setContentText("Please select a unit to remove in the table-view!");
            alert.showAndWait();
        }

    }


    /**
     * Method for loading an army from a file when the 'load army' button
     * is clicked.
     */
    @FXML
    public void onLoadArmyFromFileButtonClick()
    {
        try {
            loadArmyFromFile("src/main/resources/SavedArmy/units.csv");
            Path path = Path.of("src/main/resources/SavedArmy/units.csv");
            DialogBoxes.loadArmyAlert(path);

        } catch (IOException e) {
            DialogBoxes.errorPopUpWindow(String.valueOf(e.getCause()));
        }
    }

    /**
     * Method for loading an army from a file.
     * @param path Takes in a path of a file as a parameter.
     * @throws IOException
     */
    public void loadArmyFromFile(String path) throws IOException
    {
        Army army = ArmyFileHandler.readCSV(Path.of(path));
        armyTableView.getItems().addAll(army.getAllUnits());
    }


}
