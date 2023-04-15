package com.example.soberdn.javafx.controllers;


import com.example.soberdn.javafx.controllers.template.ScreenController;
import com.example.soberdn.javafx.controllers.template.SingletonAttributeStore;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class FxmlCreatesSoberSecondScreen implements Initializable {

    @FXML
    Button button1;
    @FXML
    Button button2;
    @FXML
    Label label1;
    @FXML
    VBox vbox1;
    @FXML
    HBox vbox2;
    @FXML
    AnchorPane anchorPane;

    public static final String SCREEN1 = "secondSober.screen";
    private SoberDNScreenController screenController;

    public void FxmlCreatesControllerScreen(){
        SingletonAttributeStore singletonAttributeStore = SingletonAttributeStore.getReference();
        screenController =
                (SoberDNScreenController) singletonAttributeStore.getAttribute(SoberDNController.SCREEN_CONTROLLER);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    public void onAction1() {
        System.out.println("works1");
    }

    public void onAction2() {
        System.out.println("works2");
    }

}
