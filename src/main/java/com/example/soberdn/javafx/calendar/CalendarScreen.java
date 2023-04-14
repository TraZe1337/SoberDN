package de.hhn.it.devtools.javafx.calendar;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;

public class CalendarScreen extends BorderPane {

    private static final org.slf4j.Logger logger =
            org.slf4j.LoggerFactory.getLogger(CalendarScreen.class);
    public static final String SCREEN = "first.screen";

    private CalendarScreenController screenController;

    private Label helloLabel;
    private Button calendarEntityAdd;
    private Button goBackButton;
    private Button goForwardButton;

    private GridPane gridPane;
    private int daycounter;


    public CalendarScreen(final CalendarScreenController calendarScreenController) {
        this.screenController = calendarScreenController;
        helloLabel = new Label("April");
        calendarEntityAdd = new Button("Add Calendar Entry");
        goBackButton = new Button("<-");
        goForwardButton = new Button("->");
        gridPane = new GridPane();
        gridPane.setGridLinesVisible(true);
        for (int i = 0; i < 7; i++) {
           int day = i+1;
            if (i == 0) {
                VBox v = new VBox(new Label("Monday"));
                v.setMinSize(75, 10);
                v.setPadding(new Insets(0,0,0,10));
                gridPane.add(v, i, 0);
            }
            if (i == 1) {
                VBox v = new VBox(new Label("Tuesday"));
                v.setMinSize(75, 10);
                v.setPadding(new Insets(0,0,0,10));
                gridPane.add(v, i, 0);
            }
            if (i == 2) {
                VBox v = new VBox(new Label("Wednesday"));
                v.setMinSize(75, 10);
                v.setPadding(new Insets(0,0,0,5));
                gridPane.add(v, i, 0);
            }
            if (i == 3) {
                VBox v = new VBox(new Label("Thursday"));
                v.setMinSize(75, 10);
                v.setPadding(new Insets(0,0,0,10));
                gridPane.add(v, i, 0);
            }
            if (i == 4) {
                VBox v = new VBox(new Label("Friday"));
                v.setMinSize(75, 10);
                v.setPadding(new Insets(0,0,0,10));
                gridPane.add(v, i, 0);
            }
            if (i == 5) {
                VBox v = new VBox(new Label("Saturday"));
                v.setMinSize(75, 10);
                v.setPadding(new Insets(0,0,0,10));
                gridPane.add(v, i, 0);
            }
            if (i == 6) {
                VBox v = new VBox(new Label("Sunday"));
                v.setMinSize(75, 10);
                v.setPadding(new Insets(0,0,0,10));
                gridPane.add(v, i, 0);
            }
            for (int j = 0; j < 5; j++) {
                gridPane.add(new CalendarCell(day), i, j + 1);
                day = day+7;
            }
        }


        calendarEntityAdd.setOnAction((event ->

        {
            CalendarEntityPopUp calendarEntityPopUp = new CalendarEntityPopUp();
            calendarEntityPopUp.display();

        }));

        helloLabel.setPadding(new Insets(50,0,0,240));
        setTop(helloLabel);

        HBox hBox = new HBox();
        hBox.getChildren().addAll(goBackButton,calendarEntityAdd,goForwardButton);
        hBox.setSpacing(50);
        hBox.setPadding(new Insets(25,0,25,125));
        setCenter(hBox);

        FlowPane flowPane = new FlowPane();
        flowPane.getChildren().addAll(gridPane);
        flowPane.setPadding(new Insets(20));
        setBottom(flowPane);

    }

}
