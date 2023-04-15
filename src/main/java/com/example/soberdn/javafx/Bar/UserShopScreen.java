package com.example.soberdn.javafx.Bar;

import com.example.soberdn.javafx.controllers.SoberDNController;
import com.example.soberdn.javafx.controllers.SoberDNScreenController;
import com.example.soberdn.javafx.controllers.template.SingletonAttributeStore;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class UserShopScreen implements Initializable {

    private static final org.slf4j.Logger logger =
            org.slf4j.LoggerFactory.getLogger(UserShopScreen.class);

    public static final String SCREEN = "shop.screen";

    public SoberDNScreenController screenController;
    SingletonAttributeStore singletonAttributeStore = SingletonAttributeStore.getReference();

    public UserShopScreen() {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.screenController =
                (SoberDNScreenController) singletonAttributeStore.getAttribute(SoberDNController.SCREEN_CONTROLLER);
    }
}
