package com.example.soberdn.javafx;

import com.example.soberdn.javafx.controllers.FxmlCreatesSoberSecondScreen;
import com.example.soberdn.javafx.controllers.SecondSober;
import com.example.soberdn.javafx.controllers.SoberDNScreenController;
import com.example.soberdn.javafx.controllers.template.FxmlPlusProgrammingScreen;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class SoberScreen extends BorderPane {
    private static final org.slf4j.Logger logger =
            org.slf4j.LoggerFactory.getLogger(SoberScreen.class);
    public static final String SCREEN0 = "firstSober.screen";

    private SoberDNScreenController screenController;


    private VBox vBox;
    private HBox hBox;
    private Label helloLabel;

    private Button buttonToQR;
    private Button buttonToShop;
    private Label balanceLabel;
    private int balance = 0;
    private String Username = "Stefan";


    public SoberScreen(final SoberDNScreenController soberDNScreenController) {
        this.screenController = soberDNScreenController;
        helloLabel = new Label("Hello " + Username);
        helloLabel.setPadding(new Insets(50,0,0,290));
        helloLabel.setStyle("-fx-font: 30 arial");
        hBox = new HBox();
        vBox = new VBox();
        balanceLabel = new Label("Balance: " + balance);
        balanceLabel.setStyle("-fx-font: 30 arial;");
        balanceLabel.setPadding(new Insets(100,0,0,300));
        hBox.getChildren().addAll(balanceLabel);
        vBox.getChildren().add(hBox);
        vBox.setMinSize(500,500);
        setCenter(vBox);
        setTop(helloLabel);
        buttonToQR = new Button("Go To QR-Code");
        buttonToQR.setStyle("-fx-background-color: transparent; -fx-font:30 arial");
        buttonToShop = new Button("Spend your Sober-Coins!");
        buttonToShop.setStyle("-fx-background-color: transparent; -fx-font:30 arial");
        HBox hBox1 = new HBox();
        hBox1.setSpacing(250);
        hBox1.getChildren().addAll(buttonToQR,buttonToShop);
        setBottom(hBox1);

        buttonToShop.setOnAction(event -> {

            screenController.switchTo(SCREEN0, FxmlCreatesSoberSecondScreen.SCREEN1);
        });

    }

}
