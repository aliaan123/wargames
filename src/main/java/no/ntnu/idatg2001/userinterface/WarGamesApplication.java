package no.ntnu.idatg2001.userinterface;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import java.io.IOException;


/**
 * Class for the graphical user interface.
 * Lets the user interact with the program.
 */
public class WarGamesApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        try {
            //FXMLLoader fxmlLoader = new FXMLLoader(WarGamesApplication.class.getResource("MainMenu.fxml"));
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("MainMenu.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            primaryStage.setTitle("WarGames");
            primaryStage.setScene(scene);
            primaryStage.show();
        }
        catch (Exception e)
        {
            e.printStackTrace();
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

