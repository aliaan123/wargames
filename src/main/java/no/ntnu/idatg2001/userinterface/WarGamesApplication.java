package no.ntnu.idatg2001.userinterface;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import java.io.IOException;


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

