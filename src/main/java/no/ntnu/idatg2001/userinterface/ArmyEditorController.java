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
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import no.ntnu.idatg2001.wargames.*;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ArmyEditorController implements Initializable {

    private Army army1;

    private final String[] unitTypes = {"Infantry Unit", "Ranged Unit", "Cavalry Unit", "Commander Unit"};

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
    private TextField nameOfArmyTextField;

    @FXML
    private Button viewArmyDetailsButton;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        unitTypeChoiceBox.getItems().addAll(unitTypes);
        unitTypeChoiceBox.setOnAction(this::getUnitType);

        ObservableList<Unit> unitObservableList = FXCollections.observableList(new ArrayList<>());
        armyTableView.setItems(unitObservableList);

        army1 = new Army(nameOfArmyTextField.getText(), unitObservableList);

        //unitObservableList = FXCollections.observableList(unitList.getAllUnits());
        unitTypeColumn.setCellValueFactory(new PropertyValueFactory<>("unitType"));
        unitNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        unitHealthColumn.setCellValueFactory(new PropertyValueFactory<>("health"));
        unitAttackColumn.setCellValueFactory(new PropertyValueFactory<>("attack"));
        unitArmorColumn.setCellValueFactory(new PropertyValueFactory<>("armor"));


    }

    public void onContinueButtonClick(ActionEvent event) throws IOException {

        String armyName = nameOfArmyTextField.getText();
        //FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("ArmyRegistration.fxml"));
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("ArmyRegistration.fxml"));
        Parent tableViewParent = loader.load();

        Scene tableViewScene = new Scene(tableViewParent);
        //root = loader.load();
        ArmyRegistrationController armyRegistrationController = loader.getController();
        armyRegistrationController.displayArmyName(armyName);
        armyRegistrationController.initArmyData(army1);
        armyRegistrationController.displayTotalNumbersOfUnitsInArmy(army1);
        /*
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
         */
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();

    }

    @FXML
    public void OnViewArmyDetailsButtonClick(ActionEvent event) throws IOException
    {
        String armyName = nameOfArmyTextField.getText();

        Stage stage = new Stage(); // To make ArmyDetails a Pop-up window
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("ArmyDetails.fxml"));
        Parent root = loader.load();

        ArmyDetailsController armyDetailsController = loader.getController();
        armyDetailsController.displayArmyName(armyName);
        armyDetailsController.setContentInTextFields(army1);

        stage.setScene(new Scene(root)); // To make ArmyDetails a Pop-up window
        stage.initModality(Modality.APPLICATION_MODAL); // To make ArmyDetails a Pop-up window
        stage.initOwner(viewArmyDetailsButton.getScene().getWindow()); // To make ArmyDetails a Pop-up window
        stage.showAndWait(); // To make ArmyDetails a Pop-up window

        //ArmyDetailsController armyDetailsController = loader.getController();
        //armyDetailsController.displayArmyName(armyName);
        //armyDetailsController.setContentInTextFields(unitList);

        //stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        //scene = new Scene(root);
        //stage.setScene(scene);
        //stage.show();

    }

    public void displayArmyName(String armyName)
    {
        nameOfArmyTextField.setText(armyName);
        army1.setName(armyName);
    }

    private String getUnitType(ActionEvent event) {
        return unitTypeChoiceBox.getValue();
    }

    @FXML
    public void addUnitToArmy()
    {
        if(!nameOfUnitTextField.getText().isEmpty() && !unitTypeChoiceBox.getValue().isEmpty()) {
            //armyTableView.getItems().add(UnitFactory.factoryCreatingUnit(unitTypeChoiceBox.getValue(), nameOfUnitTextField.getText(), 100));
            army1.add(UnitFactory.factoryCreatingUnit(unitTypeChoiceBox.getValue(), nameOfUnitTextField.getText(), 100));
            nameOfUnitTextField.clear();
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


    @FXML
    public void onLoadArmyFromFileButtonClick()
    {
        try {
            loadArmyFromFile("src/main/resources/SavedArmy/units.csv");
            Path path = Path.of("src/main/resources/SavedArmy/units.csv");
            loadArmyAlert(path);

        } catch (IOException | ClassNotFoundException e) {
            WarGamesApplication.errorPopUpWindow(String.valueOf(e.getCause()));
        }
    }

    public void loadArmyFromFile(String path) throws IOException, ClassNotFoundException
    {
        Army army = ArmyFileHandler.readCSV(Path.of(path));
        armyTableView.getItems().addAll(army.getAllUnits());
    }


    public void loadArmyAlert(Path path)
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information!");
        alert.setHeaderText("Loading army from file");
        alert.setContentText("This army from loaded from: " + path);
        alert.showAndWait();
    }

}
