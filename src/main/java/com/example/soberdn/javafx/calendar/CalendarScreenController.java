package de.hhn.it.devtools.javafx.calendar;

import de.hhn.it.devtools.javafx.controllers.template.UnknownTransitionException;
import javafx.scene.layout.AnchorPane;


public class CalendarScreenController {
    private static final org.slf4j.Logger logger =
            org.slf4j.LoggerFactory.getLogger(de.hhn.it.devtools.javafx.calendar.CalendarScreenController.class);

    AnchorPane anchorPane;
    private CalendarScreen calendarScreen;

    public CalendarScreenController(final AnchorPane calendarAnchorPane) {
        this.anchorPane = calendarAnchorPane;
    }

    private CalendarScreen getFirstScreen() {
        if (calendarScreen == null) {
            calendarScreen = new CalendarScreen(this);
        }
        return calendarScreen;
    }


    public void switchTo(String fromScreen, String toScreen) throws UnknownTransitionException {
        logger.info("Switching from " + fromScreen + " to " + toScreen);
        switch (toScreen) {
            case CalendarScreen.SCREEN:
                anchorPane.getChildren().clear();
                anchorPane.getChildren().add(getFirstScreen());
                break;
            default:
                throw new UnknownTransitionException("unknown screen: " + toScreen);
        }
    }
}
