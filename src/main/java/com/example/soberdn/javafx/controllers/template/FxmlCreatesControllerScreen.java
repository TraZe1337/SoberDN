package com.example.soberdn.javafx.controllers.template;

import com.example.soberdn.javafx.controllers.Controller;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.soberdn.javafx.controllers.TemplateController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class FxmlCreatesControllerScreen implements Initializable {
  public static final String SCREEN = "third.screen";
  private static final org.slf4j.Logger logger =
      org.slf4j.LoggerFactory.getLogger(FxmlCreatesControllerScreen.class);

  @FXML
  private Label headingLabel;
  @FXML
  private Button backButton;
  @FXML
  private Button nextButton;

  SingletonAttributeStore singletonAttributeStore = SingletonAttributeStore.getReference();
  private ScreenController screenController;

  public FxmlCreatesControllerScreen() {
    screenController =
        (ScreenController) singletonAttributeStore.getAttribute(TemplateController.SCREEN_CONTROLLER);
  }

  @Override
  public void initialize(final URL location, final ResourceBundle resources) {
    headingLabel.setText("This is the Third Screen!");
  }

  public void onActionGoBack() {
    screenController.switchTo(SCREEN, FxmlPlusProgrammingScreen.SCREEN);
  }

  public void onActionGoNext() {
    screenController.switchTo(SCREEN, PurProgrammingScreen.SCREEN);
  }
}
