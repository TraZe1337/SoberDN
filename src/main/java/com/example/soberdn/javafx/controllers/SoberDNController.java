package com.example.soberdn.javafx.controllers;

import com.example.soberdn.javafx.Bar.LoginScreen;
import com.example.soberdn.javafx.SoberScreen;
import com.example.soberdn.javafx.controllers.template.SingletonAttributeStore;
import com.example.soberdn.javafx.controllers.template.UnknownTransitionException;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class SoberDNController extends Controller implements Initializable {
    private static final org.slf4j.Logger logger =
            org.slf4j.LoggerFactory.getLogger(SoberDNController.class);
    public static final String SCREEN_CONTROLLER = "SoberScreen.controller";

    @FXML
    AnchorPane soberAnchorPane;
    SoberDNScreenController screenController;
    SingletonAttributeStore singletonAttributeStore = SingletonAttributeStore.getReference();

    public SoberDNController() {
        logger.debug("Sober Controller created.");
    }

    @Override
    public void initialize(final URL location, final ResourceBundle resources) {

        screenController = new SoberDNScreenController(soberAnchorPane);
        singletonAttributeStore.setAttribute(SCREEN_CONTROLLER, screenController);
        try {
            screenController.switchTo(null, FxmlCreatesSoberSecondScreen.SCREEN1);
        } catch (UnknownTransitionException e) {
            e.printStackTrace();
        }

    }
}
