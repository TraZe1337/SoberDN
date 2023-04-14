package de.hhn.it.devtools.javafx.controllers;

import de.hhn.it.devtools.components.calendar.StudyCalendar;
import de.hhn.it.devtools.javafx.calendar.CalendarScreen;
import de.hhn.it.devtools.javafx.calendar.CalendarScreenController;
import de.hhn.it.devtools.javafx.controllers.template.PurProgrammingScreen;
import de.hhn.it.devtools.javafx.controllers.template.ScreenController;
import de.hhn.it.devtools.javafx.controllers.template.SingletonAttributeStore;
import de.hhn.it.devtools.javafx.controllers.template.UnknownTransitionException;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class CalendarController extends Controller implements Initializable {
  private static final org.slf4j.Logger logger =
          org.slf4j.LoggerFactory.getLogger(CalendarController.class);
  public static final String SCREEN_CONTROLLER = "screen.controller";

  @FXML
  AnchorPane calendarAnchorPane;
  CalendarScreenController screenController;

  public CalendarController() {
    logger.debug("Calendar Controller created.");
  }

  @Override
  public void initialize(final URL location, final ResourceBundle resources) {

    screenController = new CalendarScreenController(calendarAnchorPane);
    SingletonAttributeStore singletonAttributeStore = SingletonAttributeStore.getReference();
    singletonAttributeStore.setAttribute(SCREEN_CONTROLLER, screenController);
    singletonAttributeStore.setAttribute("calendar",new StudyCalendar("Test"));
    try {
      screenController.switchTo(null, CalendarScreen.SCREEN);
    } catch (UnknownTransitionException e) {
      e.printStackTrace();
    }

  }
}
