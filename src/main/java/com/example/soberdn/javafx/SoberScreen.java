package com.example.soberdn.javafx;

import com.example.soberdn.javafx.controllers.SoberDNScreenController;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;

public class SoberScreen extends BorderPane {
    private static final org.slf4j.Logger logger =
            org.slf4j.LoggerFactory.getLogger(SoberScreen.class);
    public static final String SCREEN = "first.screen";

    private SoberDNScreenController screenController;

    private Label helloLabel;
    private Button calendarEntityAdd;
    private Button goBackButton;
    private Button goForwardButton;

    private GridPane gridPane;
    private int daycounter;


    public SoberScreen(final SoberDNScreenController soberDNScreenController) {
        this.screenController = soberDNScreenController;
        helloLabel = new Label("April");
        setTop(helloLabel);
    }

}
