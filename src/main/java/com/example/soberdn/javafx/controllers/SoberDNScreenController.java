package com.example.soberdn.javafx.controllers;

import com.example.soberdn.javafx.SoberScreen;
import com.example.soberdn.javafx.controllers.template.UnknownTransitionException;
import javafx.scene.layout.AnchorPane;

public class SoberDNScreenController {

        private static final org.slf4j.Logger logger =
        org.slf4j.LoggerFactory.getLogger(SoberDNScreenController.class);

        AnchorPane anchorPane;
        private SoberScreen calendarScreen;

        public SoberDNScreenController(final AnchorPane calendarAnchorPane) {
            this.anchorPane = calendarAnchorPane;
        }

        private SoberScreen getFirstScreen() {
            if (calendarScreen == null) {
                calendarScreen = new SoberScreen(this);
            }
            return calendarScreen;
        }


        public void switchTo(String fromScreen, String toScreen) throws UnknownTransitionException {
            logger.info("Switching from " + fromScreen + " to " + toScreen);
            switch (toScreen) {
                case SoberScreen.SCREEN:
                    anchorPane.getChildren().clear();
                    anchorPane.getChildren().add(getFirstScreen());
                    break;
                default:
                    throw new UnknownTransitionException("unknown screen: " + toScreen);
            }
        }
}