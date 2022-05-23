package no.ntnu.idatg2001;

import no.ntnu.idatg2001.userinterface.views.WarGamesApplication;

/**
 * Represents the non-JavaFX main-class who's sole responsibility is to provide
 * a non-JavaFX entry point to the application. Needed in order to be able to create an
 * executable JAR.
 */
public class Main {

    /**
     * Main method in Main class
     * @param args
     */
    public static void main(String[] args) {
        WarGamesApplication.main(args);
    }


}
