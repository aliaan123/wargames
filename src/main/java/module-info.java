module JavaFX.Events {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.desktop;

    opens no.ntnu.idatg2001.model;
    //opens no.ntnu.idatg2001.userinterface;
    opens no.ntnu.idatg2001.userinterface.views;
    opens no.ntnu.idatg2001.userinterface.controllers;

    exports no.ntnu.idatg2001.model;
    //exports no.ntnu.idatg2001.userinterface;
    exports no.ntnu.idatg2001.userinterface.views;
    exports no.ntnu.idatg2001.userinterface.controllers;
}