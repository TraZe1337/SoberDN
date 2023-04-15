package com.example.soberdn.javafx.controllers;

import com.example.soberdn.javafx.SoberScreen;
import com.example.soberdn.javafx.controllers.template.UnknownTransitionException;
import javafx.scene.layout.AnchorPane;

public class SoberDNScreenController {

        private static final org.slf4j.Logger logger =
        org.slf4j.LoggerFactory.getLogger(SoberDNScreenController.class);

        AnchorPane anchorPane;
        private SoberScreen soberScreen;
        private SecondSober secondSober;

        public SoberDNScreenController(final AnchorPane calendarAnchorPane) {
            this.anchorPane = calendarAnchorPane;
        }

        public SoberScreen getFirstScreen() {
            if (soberScreen == null) {
                soberScreen = new SoberScreen(this);
            }
            return soberScreen;
        }
        public SecondSober getSecondScreen(){
            if(secondSober == null){
                secondSober = new SecondSober(this);
            }
            return secondSober;
        }


        public void switchTo(String fromScreen, String toScreen) throws UnknownTransitionException {
            logger.info("Switching from " + fromScreen + " to " + toScreen);
            switch (toScreen) {
                case SoberScreen.SCREEN0:
                    anchorPane.getChildren().clear();
                    anchorPane.getChildren().add(getFirstScreen());
                    break;
                case SecondSober.SCREEN1:
                    anchorPane.getChildren().clear();
                    anchorPane.getChildren().add(getSecondScreen());
                default:
                    throw new UnknownTransitionException("unknown screen: " + toScreen);
            }
        }
}