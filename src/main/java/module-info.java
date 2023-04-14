module com.example.soberdn {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.slf4j;


    opens com.example.soberdn to javafx.fxml;
    exports com.example.soberdn;
}