package com.example.soberdn.javafx.Scenes;

import com.example.soberdn.javafx.controllers.SoberController;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;

public class HelloWindow extends BorderPane {

    private static final org.slf4j.Logger logger =
            org.slf4j.LoggerFactory.getLogger(HelloWindow.class);

    private SoberController soberController;

    private Button button;


    public HelloWindow(final SoberController soberScreenController){
        this.soberController = soberScreenController;
        button = new Button("test");
        this.getChildren().addAll(button);
    }
}
