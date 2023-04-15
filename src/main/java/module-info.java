module com.example.soberdn {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.slf4j;
    requires com.google.zxing;
    requires com.google.zxing.javase;
    requires java.desktop;

    exports com.example.soberdn.javafx.controllers to javafx.fxml;
    opens com.example.soberdn.javafx.controllers.template to javafx.fxml;
    opens com.example.soberdn.javafx.controllers to javafx.fxml;
    opens com.example.soberdn to javafx.fxml;
    exports com.example.soberdn;
}