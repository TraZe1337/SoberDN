package com.example.soberdn.javafx.Bar;

import com.example.soberdn.javafx.controllers.SoberDNController;
import com.example.soberdn.javafx.controllers.SoberDNScreenController;
import com.example.soberdn.javafx.controllers.template.SingletonAttributeStore;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class BarScreen implements Initializable {

    private static final org.slf4j.Logger logger =
            org.slf4j.LoggerFactory.getLogger(BarScreen.class);


    public static final String SCREEN = "bar.screen";

    public SoberDNScreenController screenController;

    @FXML
    Button buttonHistory;
    @FXML
    Button buttonMenu;
    @FXML
    Button buttonQrScan;
    @FXML
    Button buttonAdd;
    @FXML
    VBox vBox;
    @FXML
    HBox hBox;
    @FXML
    AnchorPane anchorPane;

    SingletonAttributeStore singletonAttributeStore = SingletonAttributeStore.getReference();

    public BarScreen() {
        this.screenController =
                (SoberDNScreenController) singletonAttributeStore.getAttribute(SoberDNController.SCREEN_CONTROLLER);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    public void dark1(){
        buttonAdd.setStyle("-fx-background-color : #3366ff ;");
    }
    public void dark2(){
        buttonQrScan.setStyle("-fx-background-color : #3366ff ;");
    }
    public void dark3(){
        buttonHistory.setStyle("-fx-background-color : #3366ff ;");
    }
    public void light1(){
        buttonAdd.setStyle("-fx-background-color : #6699ff");
    }
    public void light2(){
        buttonQrScan.setStyle("-fx-background-color : #6699ff");
    }
    public void light3(){
        buttonHistory.setStyle("-fx-background-color : #6699ff");
    }
}
