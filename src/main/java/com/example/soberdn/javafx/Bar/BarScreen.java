package com.example.soberdn.javafx.Bar;

import com.example.soberdn.components.SimpleSoberDNService;
import com.example.soberdn.javafx.controllers.SoberDNController;
import com.example.soberdn.javafx.controllers.SoberDNScreenController;
import com.example.soberdn.javafx.controllers.template.SingletonAttributeStore;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
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
    @FXML
    Button openFileButton;
    @FXML
    HBox fileChooser;


    private Desktop desktop = Desktop.getDesktop();


    SingletonAttributeStore singletonAttributeStore = SingletonAttributeStore.getReference();

    public BarScreen() {

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.screenController =
                (SoberDNScreenController) singletonAttributeStore.getAttribute(SoberDNController.SCREEN_CONTROLLER);

    }

    public void dark1() {
        buttonAdd.setStyle("-fx-background-color : #80bfff ;");
    }
    public void dark2() {
        buttonQrScan.setStyle("-fx-background-color : #80bfff ;");
    }

    public void dark3() {
        buttonHistory.setStyle("-fx-background-color : #80bfff ;");
    }

    public void light1() {
        buttonAdd.setStyle("-fx-background-color : #99ccff");
    }

    public void light2() {
        buttonQrScan.setStyle("-fx-background-color : #99ccff");
    }

    public void light3() {
        buttonHistory.setStyle("-fx-background-color : #99ccff");
    }

    public void chooseFile() {
        Stage stage = (Stage) SingletonAttributeStore.getReference().getAttribute("stage");
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        File file = fileChooser.showOpenDialog(stage);
        if (file != null) {
            openFile(file);
        }
        SimpleSoberDNService service = (SimpleSoberDNService) SingletonAttributeStore.getReference()
                .getAttribute("service");
        int barId = (int) SingletonAttributeStore.getReference().getAttribute("barId");
        service.scanQRCode(Objects.requireNonNull(file), barId);

    }

    public void qrScan() {
        fileChooser.setVisible(true);
    }

    private void openFile(File file) {
        try {
            desktop.open(file);
        } catch (IOException ex) {
            throw new RuntimeException();
        }
    }
}
