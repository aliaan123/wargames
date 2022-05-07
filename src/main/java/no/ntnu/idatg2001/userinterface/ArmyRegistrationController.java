package no.ntnu.idatg2001.userinterface;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import no.ntnu.idatg2001.wargames.Army;

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
    private TextField nameTextField2;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    @FXML
    public void onGoBackButtonClick(ActionEvent event) throws IOException {
        WarGamesApplication.goToMainMenu();
    }


    public void onEditArmyButtonClick(ActionEvent event) throws IOException {

        String armyName = nameTextField1.getText();

        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("ArmyEditor.fxml"));
        root = loader.load();

        ArmyEditorController armyEditorController = loader.getController();
        armyEditorController.displayArmyName(armyName);

        //WarGamesApplication.goToArmyEditor();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }

}
