module com.soft.yomirokualt {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires java.logging;

    opens com.soft.yomirokualt.domain to javafx.base;
    opens com.soft.yomirokualt to javafx.fxml;
    opens com.soft.yomirokualt.factory to java.base;
    opens com.soft.yomirokualt.controller to javafx.fxml;

    exports com.soft.yomirokualt;
}