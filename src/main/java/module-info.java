module com.yomiroku.yomiroku {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.yomiroku.yomiroku to javafx.fxml;
    exports com.yomiroku.yomiroku;
}