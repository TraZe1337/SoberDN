module com.example.soberdn {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.soberdn to javafx.fxml;
    exports com.example.soberdn;
}