package com.example.soberdn.javafx.Bar;

import com.example.soberdn.javafx.controllers.TemplateController;
import com.example.soberdn.javafx.controllers.template.*;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class BarScreen implements Initializable {

    private static final org.slf4j.Logger logger =
            org.slf4j.LoggerFactory.getLogger(BarScreen.class);


    public static final String SCREEN = "bar.screen";

    public BarScreenController barScreenController;


    SingletonAttributeStore singletonAttributeStore = SingletonAttributeStore.getReference();

    public BarScreen() {
        this.barScreenController=
                (BarScreenController) singletonAttributeStore.getAttribute(BarController.SCREEN_CONTROLLER);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
