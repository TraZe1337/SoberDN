package com.example.soberdn.javafx.controllers;


import com.example.soberdn.components.SimpleSoberDNService;
import com.example.soberdn.javafx.Bar.UserShopScreen;
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
    AnchorPane anchorPane;
    @FXML
    Label balanceLabel;

    public static final String SCREEN1 = "secondSober.screen";
    private SoberDNScreenController screenController;
    SingletonAttributeStore singletonAttributeStore = SingletonAttributeStore.getReference();
    private SimpleSoberDNService service;

    public void FxmlCreatesControllerScreen() {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        screenController =
                (SoberDNScreenController) singletonAttributeStore.getAttribute(
                        SoberDNController.SCREEN_CONTROLLER);
        service = (SimpleSoberDNService) singletonAttributeStore.getAttribute("service");
        int userId = (int) singletonAttributeStore.getAttribute("userId");
        label1.setText("Hallo " + service.getUserById(userId).getName());
<<<<<<< HEAD
        balanceLabel.setText(" " + service.getUserById(userId).getBalance() + " Sc's");
=======
        balanceLabel.setText(" " + service.getUserById(userId).getBalance() + "SCs");
>>>>>>> 0c213cefceea4633b9d8de423b4d0ef861664aed
    }

    public void onAction1() {
        singletonAttributeStore.setAttribute(SoberDNController.SCREEN_CONTROLLER, screenController);
        screenController.switchTo(FxmlCreatesSoberSecondScreen.SCREEN1, SoberQrCodeScreen.SCREEN);
    }

    public void doThis() {
        button2.setStyle("-fx-background-color : #80bfff ;");
    }

    public void doThat() {
        button2.setStyle("-fx-background-color : #99ccff");
    }

    public void doThis2() {
        button1.setStyle("-fx-background-color : #80bfff ;");
    }

    public void doThat2() {
        button1.setStyle("-fx-background-color : #99ccff");
    }

    public void onAction2() {
        singletonAttributeStore.setAttribute(SoberDNController.SCREEN_CONTROLLER, screenController);
        screenController.switchTo(FxmlCreatesSoberSecondScreen.SCREEN1, UserShopScreen.SCREEN);
    }

}
