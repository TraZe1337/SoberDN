package com.example.soberdn.javafx.controllers;

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
    public static final String SCREEN_CONTROLLER = "screen.controller";

    @FXML
    AnchorPane soberAnchorPane;
    SoberDNScreenController screenController;

    public SoberDNController() {
        logger.debug("Calendar Controller created.");
    }

    @Override
    public void initialize(final URL location, final ResourceBundle resources) {

        screenController = new SoberDNScreenController(soberAnchorPane);
        SingletonAttributeStore singletonAttributeStore = SingletonAttributeStore.getReference();
        singletonAttributeStore.setAttribute(SCREEN_CONTROLLER, screenController);
        //singletonAttributeStore.setAttribute("calendar",new StudyCalendar("Test"));
        try {
            screenController.switchTo(null, SoberScreen.SCREEN);
        } catch (UnknownTransitionException e) {
            e.printStackTrace();
        }

    }
}
