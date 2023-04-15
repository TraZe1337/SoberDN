package com.example.soberdn.javafx.controllers;

import com.example.soberdn.javafx.Bar.LoginScreen;
import com.example.soberdn.javafx.SoberScreen;
import com.example.soberdn.javafx.controllers.template.UnknownTransitionException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class SoberDNScreenController {

        private static final org.slf4j.Logger logger =
        org.slf4j.LoggerFactory.getLogger(SoberDNScreenController.class);

        public AnchorPane anchorPane;
        public SoberScreen soberScreen;
        public SecondSober secondSober;
        public FxmlCreatesSoberSecondScreen fxmlCreatesSoberSecondScreen;
        public SoberQrCodeScreen soberQrCodeScreen;
        public LoginScreen loginScreen;

        public Node loginScreenContent;

        public Node soberScreenContent;
        public Node qrCodeScreen;

        public SoberDNScreenController(final AnchorPane anchorPane) {
            this.anchorPane = anchorPane;
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
        public Node getFxmlScreen(){
            if (soberScreenContent == null) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/soberdn/SecondSober.fxml"));
                try {
                    soberScreenContent = loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                fxmlCreatesSoberSecondScreen = loader.getController();}
            return soberScreenContent;
        }
        public Node addQrScreen(){
            if(qrCodeScreen == null){
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/soberdn/SoberQrCodeScreen.fxml"));
                try{
                    qrCodeScreen = loader.load();
                }
                catch (IOException e){
                    e.printStackTrace();
                }
                soberQrCodeScreen = loader.getController();
            }
            return qrCodeScreen;
        }
        public Node loginScreen(){
            if(loginScreenContent == null){
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/soberdn/LoginScreen.fxml"));
                try{
                    loginScreenContent = loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                loginScreen = loader.getController();
            }
            return loginScreenContent;
        }


        public void switchTo(String fromScreen, String toScreen) throws UnknownTransitionException {
            logger.info("Switching from " + fromScreen + " to " + toScreen);
                if(toScreen.equals(SoberScreen.SCREEN0)){
                    anchorPane.getChildren().clear();
                    anchorPane.getChildren().add(getFirstScreen());
                }
                if(toScreen.equals(SecondSober.SCREEN1)) {
                    anchorPane.getChildren().clear();
                    anchorPane.getChildren().add(getSecondScreen());
                }
                if(toScreen.equals(FxmlCreatesSoberSecondScreen.SCREEN1)){
                    anchorPane.getChildren().clear();
                    anchorPane.getChildren().add(getFxmlScreen());
                }
                if(toScreen.equals(SoberQrCodeScreen.SCREEN)){
                    anchorPane.getChildren().clear();
                    anchorPane.getChildren().add(addQrScreen());
                }
                if(toScreen.equals(LoginScreen.SCREEN)){
                    anchorPane.getChildren().clear();
                    anchorPane.getChildren().add(loginScreen());
                }
            }
        }