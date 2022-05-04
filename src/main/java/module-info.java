module JavaFX.Events {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.desktop;

    opens no.ntnu.idatg2001.wargames to javafx.fxml;
    opens no.ntnu.idatg2001.userinterface to javafx.fxml;
    exports no.ntnu.idatg2001.wargames;
    exports no.ntnu.idatg2001.userinterface;
}