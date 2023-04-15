package com.example.soberdn.javafx.controllers;

import com.example.soberdn.components.SimpleSoberDNService;
import com.example.soberdn.javafx.controllers.template.SingletonAttributeStore;
import com.google.zxing.WriterException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

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

  public static final String SCREEN = "QRScreen.screen";
  SingletonAttributeStore singletonAttributeStore = SingletonAttributeStore.getReference();
  private SoberDNScreenController screenController;

  public void SoberQrCodeScreen() {
  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    screenController =
        (SoberDNScreenController) singletonAttributeStore.getAttribute(
            SoberDNController.SCREEN_CONTROLLER);
    SimpleSoberDNService service = (SimpleSoberDNService) singletonAttributeStore.getAttribute(
        "service");
    int userId = (int) singletonAttributeStore.getAttribute("userId");
    try {
      imageView.setImage(new Image(service.createAddQRCode(userId)));
    } catch (IOException e) {
      throw new RuntimeException(e);
    } catch (WriterException e) {
      throw new RuntimeException(e);
    }

  }

  public void goBack() {
    singletonAttributeStore.setAttribute(SoberDNController.SCREEN_CONTROLLER, screenController);
    screenController.switchTo(SoberQrCodeScreen.SCREEN, FxmlCreatesSoberSecondScreen.SCREEN1);
  }

  public void doThis() {
    buttonBalance.setStyle("-fx-background-color : #3366ff ;");
  }

  public void doThat() {
    buttonBalance.setStyle("-fx-background-color : #6699ff");
  }

  public void doThis2() {
    buttonShop.setStyle("-fx-background-color : #3366ff ;");
  }

  public void doThat2() {
    buttonShop.setStyle("-fx-background-color : #6699ff");
  }


}
