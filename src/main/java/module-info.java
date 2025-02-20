module com.yomiroku.yomiroku {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.yomiroku.yomiroku to javafx.fxml;
    exports com.yomiroku.yomiroku;
    exports com.yomiroku.yomiroku.controller;
    opens com.yomiroku.yomiroku.controller to javafx.fxml;
}