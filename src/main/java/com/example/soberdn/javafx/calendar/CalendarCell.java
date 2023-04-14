package de.hhn.it.devtools.javafx.calendar;

import de.hhn.it.devtools.components.calendar.StudyCalendarEntry;
import de.hhn.it.devtools.javafx.controllers.template.SingletonAttributeStore;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.HashMap;

public class CalendarCell extends StackPane {

    private int day;
    private VBox vBox;
    private Label label;
    private Button button;
    private Button addButton;

    private HBox hBox;
    private HashMap<Integer, StudyCalendarEntry> studyCalendarEntries;

    SingletonAttributeStore singletonAttributeStore = SingletonAttributeStore.getReference();


    public CalendarCell(int day) {
        this.day = day;
        if (day > 30) {
            Region spacer = new Region();
            HBox.setHgrow(spacer, Priority.ALWAYS);
            vBox = new VBox();
            hBox = new HBox();
            vBox.setMinSize(70, 50);
            vBox.setPadding(new Insets(0, 0, 10, 0));
            vBox.getChildren().addAll(hBox);
            this.getChildren().addAll(vBox);
        } else {
            Region spacer = new Region();
            HBox.setHgrow(spacer, Priority.ALWAYS);
            vBox = new VBox();
            hBox = new HBox();
            hBox.setAlignment(Pos.BOTTOM_CENTER);
            vBox.setMinSize(70, 50);
            vBox.setSpacing(10);
            vBox.setPadding(new Insets(0, 0, 10, 0));
            label = new Label(" " + day);
            button = new Button("Task/Event");
            button.setStyle("-fx-background-color: transparent;");
            addButton = new Button("+");
            addButton.setStyle("-fx-background-color: transparent;");
            addButton.setMinSize(70, 10);
            label.setPadding(new Insets(0, 0, 0, 20));
            button.setPadding(new Insets(0, 0, 0, 4));
            hBox.getChildren().addAll(addButton);
            vBox.getChildren().addAll(label, button, hBox);
            this.getChildren().addAll(vBox);

            addButton.setOnAction(event -> {
                CalendarEntityPopUp calendarEntityPopUp = new CalendarEntityPopUp();
                LocalDate localDate = LocalDate.of(2023, 4,day);
                singletonAttributeStore.setAttribute("localDate",localDate);
                singletonAttributeStore.setAttribute("cell",this);

                calendarEntityPopUp.display();
            });

            button.setOnAction(event -> {
                System.out.println("works");
            });

        }
    }

        public void setStudyCalendarEntry(StudyCalendarEntry studyCalendarEntry){
            String title = studyCalendarEntry.getTitle();
            button.setText(title);
            studyCalendarEntries.put(studyCalendarEntry.getId(),studyCalendarEntry);
        }

        public void setColorOfEvent(StudyCalendarEntry studyCalendarEntry, Color color){
            //button.setStyle("-fx-text-fill:" + color.toString());
            studyCalendarEntry.setColor(color.toString());
        }
}
