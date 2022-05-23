package no.ntnu.idatg2001.userinterface.views;


import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.nio.file.Path;
import java.util.Optional;

/**
 * @author Aliaan
 *
 * Class holding all the dialog-box methods in the application
 */
public class DialogBoxes {


    /**
     * Dialog box that is displayed when trying to continue
     * without filling the textfield for the name of the army.
     * Alerts the user about an error that occurred because of
     * empty text fields.
     */
    public static void invalidNameTextFieldAlert()
    {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error alert");
        alert.setHeaderText("Invalid input in text fields!");
        alert.setContentText("Please fill in the text fields by choosing a name with a valid length.");
        alert.showAndWait();
    }


    /**
     * Dialog box that is displayed when trying to continue without choosing a value in the choice box.
     * Method for displaying a dialog box, which alerts the user
     * about an error that occurred when trying to start the battle simulation.
     * The user will be alerted by this dialog box when trying to continue without
     * choosing a value for in the choice box.
     */
    public static void emptyChoiceBoxAlert()
    {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error!");
        alert.setHeaderText("Choice box is empty!");
        alert.setContentText("Please choose a value in the choice box before continuing.");
        alert.show();
    }

    /**
     * Dialog box that is displayed when loading an army from a file.
     * Method for displaying a dialog box, which alerts the user
     * and gives them information about where the army was loaded from.
     * @param path takes in the path of the file as a parameter
     */
    public static void loadArmyAlert(Path path)
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information!");
        alert.setHeaderText("Loading army from file");
        alert.setContentText("This army from loaded from: " + path);
        alert.showAndWait();
    }

    /**
     * Method to display and dialog box,
     * that will show that an error has occurred.
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
     * Dialog box that is displayed when trying to continue without creating an army.
     * Method for displaying a dialog box, which alerts the user
     * about an error that has occurred when trying to continue without
     * first creating an army by clicking on 'create army'.
     */
    public static void armyIsNullAlert()
    {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error alert!");
        alert.setHeaderText("Please create an army before continuing to the battle simulation.");
        alert.setContentText("Click on the 'create army' button to create an army.");
        alert.showAndWait();
    }


    /**
     * Dialog box that is displayed when the battle between the two armies is over.
     * Method for displaying a dialog box, which alerts the user
     * about information of the outcome of the battle.
     */
    public static void battleOutcomeAlert()
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information!");
        alert.setHeaderText("View outcome of the battle");
        alert.setContentText("The battle is over. Press the 'view battle results' button to view the outcome.");
        alert.show();
    }



    /**
     * Dialog box that is displayed when trying to continue without loading an opponent army.
     * Method for displaying a dialog box, which alerts the user
     * about an error that has occurred when trying to start the battle simulation.
     */
    public static void noOpponentArmyLoadedAlert()
    {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error when starting the simulation!");
        alert.setHeaderText("Please load an opponent army before continuing.");
        alert.setContentText("You must load an opponent army before starting the simulation by choosing one of the three loads on the right.");
        alert.showAndWait();
    }





}
