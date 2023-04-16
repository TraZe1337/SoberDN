package com.example.soberdn.javafx.controllers;

import com.example.soberdn.components.SimpleSoberDNService;
import com.example.soberdn.javafx.Bar.UserShopScreen;
import com.example.soberdn.javafx.controllers.template.SingletonAttributeStore;
import com.google.zxing.WriterException;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SoberQrCodeScreen implements Initializable {

    @FXML
    Button buttonShop;
    @FXML
    Button buttonBalance;
    @FXML
    Label label1;
    @FXML
    AnchorPane anchorPane;
    @FXML
    ImageView imageView;
    @FXML
    VBox vBox;
    @FXML
    HBox hBox;
    @FXML
    HBox hBox1;
    @FXML
    Button buttonAddCoins;

    boolean dothis = false;

    public static final String SCREEN = "QRScreen.screen";
    SingletonAttributeStore singletonAttributeStore = SingletonAttributeStore.getReference();
    private SoberDNScreenController screenController;
    private SimpleSoberDNService service;
    private int userId;
    private int barId;

    public void SoberQrCodeScreen() {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        screenController =
                (SoberDNScreenController) singletonAttributeStore.getAttribute(
                        SoberDNController.SCREEN_CONTROLLER);
        service = (SimpleSoberDNService) singletonAttributeStore.getAttribute("service");

        userId = (int) singletonAttributeStore.getAttribute("userId");
        barId = (int) singletonAttributeStore.getAttribute("barId");

        try {
            int f = (int) singletonAttributeStore.getAttribute("coin");
            service.payDrink(userId, barId, f);
            imageView.setImage(new Image(getClass().getResourceAsStream(service.createPayQRCode(userId, f))));
            dothis = true;
            singletonAttributeStore.removeAttribute("coin");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!dothis) {
            try {
                imageView.setImage(new Image(getClass().getResourceAsStream(service.createAddQRCode(userId))));
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (WriterException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void goBack() {
        imageView.setImage(null);
        singletonAttributeStore.setAttribute(SoberDNController.SCREEN_CONTROLLER, screenController);
        screenController.switchTo(SoberQrCodeScreen.SCREEN, FxmlCreatesSoberSecondScreen.SCREEN1);
    }

    public void doThis() {
        buttonBalance.setStyle("-fx-background-color : #80bfff ;");
    }

    public void doThat() {
        buttonBalance.setStyle("-fx-background-color : #99ccff");
    }

    public void doThis2() {
        buttonShop.setStyle("-fx-background-color : #80bfff ;");
    }

    public void doThat2() {
        buttonShop.setStyle("-fx-background-color :  #99ccff");
    }

    public void goToShop() {
        imageView.setImage(null);
        singletonAttributeStore.setAttribute(SoberDNController.SCREEN_CONTROLLER, screenController);
        screenController.switchTo(SoberQrCodeScreen.SCREEN, UserShopScreen.SCREEN);
    }

    public void addCoins() {
        try {
            service.addCoins(userId, 6);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
