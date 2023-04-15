package com.example.soberdn.javafx.Bar;

import com.example.soberdn.javafx.controllers.template.ScreenController;
import com.example.soberdn.javafx.controllers.template.SingletonAttributeStore;
import com.example.soberdn.javafx.controllers.template.UnknownTransitionException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class BarScreenController {

    AnchorPane anchorPane;
    private BarScreen barScreen;

    private Node firstScreenContent;

    SingletonAttributeStore singletonAttributeStore = SingletonAttributeStore.getReference();

    private static final org.slf4j.Logger logger =
            org.slf4j.LoggerFactory.getLogger(ScreenController.class);

    public BarScreenController(final AnchorPane barAnchorPane) {
        this.anchorPane = barAnchorPane;
    }


    private Node getFirstScreen() {
        if (firstScreenContent == null) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/soberdn/BarScreen.fxml"));
            try {
                firstScreenContent = loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
             barScreen = loader.getController();
        }
        return firstScreenContent;
    }

    public void switchTo(String fromScreen, String toScreen) throws UnknownTransitionException {
        logger.info("Switching from " + fromScreen + " to " + toScreen);
        if (toScreen.equals(BarScreen.SCREEN)) {
            anchorPane.getChildren().clear();
            anchorPane.getChildren().add(getFirstScreen());
        }
    }
}