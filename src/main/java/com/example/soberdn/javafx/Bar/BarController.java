package com.example.soberdn.javafx.Bar;

import com.example.soberdn.javafx.controllers.Controller;
import com.example.soberdn.javafx.controllers.template.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class BarController extends Controller implements Initializable{

    private static final org.slf4j.Logger logger =
            org.slf4j.LoggerFactory.getLogger(BarController.class);

    public static final String SCREEN_CONTROLLER = "controller.bar";

    SingletonAttributeStore singletonAttributeStore = SingletonAttributeStore.getReference();

    @FXML
    AnchorPane anchorPayne;

    BarScreenController barScreenController;

    public BarController(){

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        barScreenController = new BarScreenController(anchorPayne);
        singletonAttributeStore.setAttribute(SCREEN_CONTROLLER, barScreenController);
        try {
            barScreenController.switchTo(null, BarScreen.SCREEN);
        } catch (UnknownTransitionException e) {
            e.printStackTrace();
        }

    }
}
