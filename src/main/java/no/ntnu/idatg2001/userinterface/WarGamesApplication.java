package no.ntnu.idatg2001.userinterface;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javafx.scene.Scene;
import java.io.IOException;
import java.util.Optional;


/**
 * Class for the graphical user interface.
 * Lets the user interact with the program.
 */
public class WarGamesApplication extends Application {

    private static Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws IOException {
        try {
            //FXMLLoader fxmlLoader = new FXMLLoader(WarGamesApplication.class.getResource("MainMenu.fxml"));
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("MainMenu.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 700, 500);
            primaryStage.setTitle("Main Menu");
            primaryStage.setScene(scene);
            primaryStage.show();
            this.primaryStage = primaryStage;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        primaryStage.setOnCloseRequest(e -> {
            e.consume();
            exitApplicationWindow();
        });
    }


    public static void goToMainMenu() throws IOException{
        FXMLLoader loader = new FXMLLoader(WarGamesApplication.class.getClassLoader().getResource("MainMenu.fxml"));
        Parent root = loader.load();
        primaryStage.getScene().setRoot(root);
        primaryStage.setTitle("Main menu");
    }



    public static void goToArmyRegistration() throws IOException{
        FXMLLoader loader = new FXMLLoader(WarGamesApplication.class.getClassLoader().getResource("ArmyRegistration.fxml"));
        Parent root = loader.load();
        primaryStage.getScene().setRoot(root);
        primaryStage.setTitle("Main menu");
    }

    public static void goToArmyDetails() throws IOException{
        FXMLLoader loader = new FXMLLoader(WarGamesApplication.class.getClassLoader().getResource("ArmyDetails.fxml"));
        Parent root = loader.load();
        primaryStage.getScene().setRoot(root);
        primaryStage.setTitle("Add units to army");
    }


    public static void goToArmyEditor() throws IOException{
        FXMLLoader loader = new FXMLLoader(WarGamesApplication.class.getClassLoader().getResource("ArmyEditor.fxml"));
        Parent root = loader.load();
        primaryStage.getScene().setRoot(root);
        primaryStage.setTitle("Details about army");
    }



    public static void exitApplicationWindow() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("Exit Application?");
        alert.setContentText("Are you sure you want to exit this application?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent()) {
            if (result.get() == ButtonType.OK) {
                Platform.exit();
            } else {

            }
        }
    }


    @FXML
    /**
     * Method to show an error popupmenu.
     * @param e, The string of the error message.
     */
    public static void errorPopUpWindow(String e) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("There was an error");
        alert.setContentText("Error: " + e);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent()) {
            if (result.get() == ButtonType.OK) {

            } else {

            }
        }
    }



    /**
     * The stop() method is being called by the JavaFX-platform when the
     * platform stops, are being terminated.
     */
    @Override
    public void stop()
    {
        System.exit(0);
    }

    /**
     * The entry-point to start the application.
     * @param args Command-line arguments supplied during startup
     */
    public static void main(String[] args)
    {
        launch(args);
    }



}

