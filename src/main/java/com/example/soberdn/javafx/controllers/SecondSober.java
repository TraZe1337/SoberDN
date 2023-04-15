package com.example.soberdn.javafx.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class SecondSober extends AnchorPane {

    public static final String SCREEN1 = "secondSober.screen";
    private static final org.slf4j.Logger logger =
            org.slf4j.LoggerFactory.getLogger(SecondSober.class);

    private SoberDNScreenController screenController;

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

    public SecondSober(final SoberDNScreenController soberDNScreenController) {
        this.screenController = soberDNScreenController;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/soberdn/SecondSober.fxml"));
        //loader.setRoot(this);
        //loader.setController(this);

        label1 = new Label();
        vbox2 = new HBox();
        vbox1 = new VBox();
        button1 = new Button();
        button2 = new Button();
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void onAction1() {
        System.out.println("works1");
    }

    public void onAction2() {
        System.out.println("works2");
    }

}
