package com.example.soberdn.javafx.Bar;

import com.example.soberdn.javafx.controllers.Controller;
import com.example.soberdn.javafx.controllers.SoberDNController;
import com.example.soberdn.javafx.controllers.SoberDNScreenController;
import com.example.soberdn.javafx.controllers.template.SingletonAttributeStore;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController extends Controller implements Initializable {



    private static final org.slf4j.Logger logger =
            org.slf4j.LoggerFactory.getLogger(LoginController.class);
    public static final String SCREEN_CONTROLLER = "controller.login";
    SingletonAttributeStore singletonAttributeStore = SingletonAttributeStore.getReference();
    BarScreenController barScreenController;
    public LoginController(){

    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        barScreenController =
                (BarScreenController) singletonAttributeStore.getAttribute(LoginController.SCREEN_CONTROLLER);


    }
}
