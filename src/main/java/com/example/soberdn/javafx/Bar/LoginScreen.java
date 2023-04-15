package com.example.soberdn.javafx.Bar;

import com.example.soberdn.javafx.controllers.template.SingletonAttributeStore;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginScreen implements Initializable {
    private static final org.slf4j.Logger logger =
            org.slf4j.LoggerFactory.getLogger(LoginScreen.class);
    public static final String SCREEN = "login.screen";
    public BarScreenController barScreenController;

    SingletonAttributeStore singletonAttributeStore = SingletonAttributeStore.getReference();


    @FXML
    Button buttonMenu;
    @FXML
    VBox vBox;
    @FXML
    HBox hBox;
    @FXML
    AnchorPane blur;
    @FXML
    RadioButton radio1;
    @FXML
    RadioButton radio2;
    @FXML
    Button buttonContinue;
    public LoginScreen(){
        this.barScreenController =
                (BarScreenController) singletonAttributeStore.getAttribute(LoginController.SCREEN_CONTROLLER);
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}