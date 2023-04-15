package com.example.soberdn.javafx.Bar;

import com.example.soberdn.components.SimpleSoberDNService;
import com.example.soberdn.components.User;
import com.example.soberdn.javafx.controllers.FxmlCreatesSoberSecondScreen;
import com.example.soberdn.javafx.controllers.SoberDNController;
import com.example.soberdn.javafx.controllers.SoberDNScreenController;
import com.example.soberdn.javafx.controllers.SoberQrCodeScreen;
import com.example.soberdn.javafx.controllers.template.SingletonAttributeStore;
import com.google.zxing.WriterException;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UserShopScreen implements Initializable {

    private static final org.slf4j.Logger logger =
            org.slf4j.LoggerFactory.getLogger(UserShopScreen.class);

    public static final String SCREEN = "shop.screen";

    public SoberDNScreenController screenController;
    SingletonAttributeStore singletonAttributeStore = SingletonAttributeStore.getReference();

    @FXML
    Button buttonWater;
    @FXML
    Button buttonHeineken;
    @FXML
    Button buttonCock1;
    @FXML
    Button buttonSprite;
    @FXML
    Button buttonBecks;
    @FXML
    Button buttonCock2;
    @FXML
    Button buttonBalance;
    @FXML
    Button buttonQrCode;

    SimpleSoberDNService service;
    int userId;
    int barId;

    public UserShopScreen() {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.screenController =
                (SoberDNScreenController) singletonAttributeStore.getAttribute(SoberDNController.SCREEN_CONTROLLER);
        this.service = (SimpleSoberDNService) singletonAttributeStore.getAttribute("service");
        this.userId = (int) singletonAttributeStore.getAttribute("userId");
        this.barId = (int) singletonAttributeStore.getAttribute("barId");

    }
    public void buttonGoToBalance(){
        singletonAttributeStore.setAttribute(SoberDNController.SCREEN_CONTROLLER, screenController);
        screenController.switchTo(UserShopScreen.SCREEN, FxmlCreatesSoberSecondScreen.SCREEN1);
    }
    public void buttonGoToQrCode(){
        singletonAttributeStore.setAttribute(SoberDNController.SCREEN_CONTROLLER, screenController);
        screenController.switchTo(UserShopScreen.SCREEN, SoberQrCodeScreen.SCREEN);
    }
    public void buttonOneCoin(){
        service.payDrink(userId,barId,1);
        SimpleSoberDNService service = (SimpleSoberDNService) singletonAttributeStore.getAttribute(
                "service");
        int userId = (int) singletonAttributeStore.getAttribute("userId");
        try {
           Image i = new Image(getClass().getResourceAsStream(service.createPayQRCode(userId,1)));
           singletonAttributeStore.setAttribute("image",i);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (WriterException e) {
            throw new RuntimeException(e);
        }
        singletonAttributeStore.setAttribute(SoberDNController.SCREEN_CONTROLLER, screenController);
        screenController.switchTo(UserShopScreen.SCREEN, SoberQrCodeScreen.SCREEN);
    }
    public void buttonTwoCoin(){

    }
    public void buttonThreeCoin(){

    }
    public void dark1(){
        buttonBalance.setStyle("-fx-background-color : #80bfff ;");
    }
    public void light1(){
        buttonBalance.setStyle("-fx-background-color : #99ccff ;");
    }
    public void dark2(){
        buttonQrCode.setStyle("-fx-background-color : #80bfff ;");

    }
    public void light2(){
        buttonQrCode.setStyle("-fx-background-color : #99ccff ;");

    }

}
