module JavaFX.Events {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.desktop;

    opens no.ntnu.idatg2001.model to javafx.fxml;
    //opens no.ntnu.idatg2001.userinterface to javafx.fxml;
    opens no.ntnu.idatg2001.userinterface.views to javafx.fxml;
    opens no.ntnu.idatg2001.userinterface.controllers to javafx.fxml;

    exports no.ntnu.idatg2001.model;
    //exports no.ntnu.idatg2001.userinterface;
    exports no.ntnu.idatg2001.userinterface.views;
    exports no.ntnu.idatg2001.userinterface.controllers;
}