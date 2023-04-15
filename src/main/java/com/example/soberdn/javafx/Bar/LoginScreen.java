package com.example.soberdn.javafx.Bar;

import com.example.soberdn.javafx.controllers.FxmlCreatesSoberSecondScreen;
import com.example.soberdn.javafx.controllers.SoberDNController;
import com.example.soberdn.javafx.controllers.SoberDNScreenController;
import com.example.soberdn.javafx.controllers.SoberQrCodeScreen;
import com.example.soberdn.javafx.controllers.template.SingletonAttributeStore;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginScreen implements Initializable {
    private static final org.slf4j.Logger logger =
            org.slf4j.LoggerFactory.getLogger(LoginScreen.class);


    public static final String SCREEN = "login.screen";

    SingletonAttributeStore singletonAttributeStore = SingletonAttributeStore.getReference();

    public SoberDNScreenController screenController;

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
    @FXML
    AnchorPane anch;
    @FXML
    VBox vBox10;
    @FXML
    TextField textUsername;
    @FXML
    TextField textPassword;
    public LoginScreen(){
       }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        screenController =
                (SoberDNScreenController) singletonAttributeStore.getAttribute(SoberDNController.SCREEN_CONTROLLER);
    }

    public void click1(){
        radio1.setSelected(true);
        radio2.setSelected(false);
    }
    public void click2(){
        radio1.setSelected(false);
        radio2.setSelected(true);
    }
    public void clickContinue(){
        if(!radio1.isSelected()&&!radio2.isSelected()){
            throw new IllegalArgumentException("Dont do that");
        } else if (radio1.isSelected()) {
            singletonAttributeStore.setAttribute(SoberDNController.SCREEN_CONTROLLER, screenController);
            screenController.switchTo(LoginScreen.SCREEN, FxmlCreatesSoberSecondScreen.SCREEN1 );
        }
        else if(radio2.isSelected()){
            singletonAttributeStore.setAttribute(SoberDNController.SCREEN_CONTROLLER, screenController);
            screenController.switchTo(LoginScreen.SCREEN, BarScreen.SCREEN );
        }
    }
}
