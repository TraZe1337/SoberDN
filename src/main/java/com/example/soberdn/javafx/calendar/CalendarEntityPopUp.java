package de.hhn.it.devtools.javafx.calendar;

import de.hhn.it.devtools.components.calendar.StudyCalendarEntry;
import de.hhn.it.devtools.javafx.controllers.template.PurProgrammingScreen;
import de.hhn.it.devtools.javafx.controllers.template.SingletonAttributeStore;
import de.hhn.it.devtools.javafx.controllers.template.UnknownTransitionException;
import java.time.LocalDate;
import java.time.LocalTime;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class CalendarEntityPopUp extends Popup {

    Color color1;

    public void display() {
        Stage popupwindow = new Stage();
        popupwindow.initModality(Modality.APPLICATION_MODAL);
        popupwindow.setTitle("Add Event / Appointment");

        VBox vBox = new VBox();
        vBox.setPadding(new Insets(50, 0, 0, 30));
        Label titleLabel = new Label("Title: ");
        Label dateLabel = new Label("Pick Date: ");
        Label timeLabel = new Label("Start Time: ");
        Label timeLabel2 = new Label("End Time: ");
        Label color = new Label("Pick your Event Color:");
        Label addLabel = new Label("Add Event / Appointment to Calendar:");
        vBox.setSpacing(30);
        vBox.getChildren().addAll(titleLabel, dateLabel, timeLabel, timeLabel2, color, addLabel);


        MenuItem m0 = new MenuItem("00:00");
        MenuItem m1 = new MenuItem("01:00");
        MenuItem m2 = new MenuItem("02:00");

        VBox vBox1 = new VBox();
        vBox1.setPadding(new Insets(50, 0, 0, 30));
        TextField title = new TextField();
        title.setMinSize(60, 10);
        DatePicker datePicker = new DatePicker();
        datePicker.setMinSize(60, 10);
        SingletonAttributeStore singletonAttributeStore = SingletonAttributeStore.getReference();
        try {
            LocalDate localDate = (LocalDate) singletonAttributeStore.getAttribute("localDate");
            datePicker.setValue(localDate);
            singletonAttributeStore.removeAttribute("localDate");
        } catch (Exception e) {
            e.printStackTrace();
        }
        MenuButton menuButton = new MenuButton("00:00");
        menuButton.setMinSize(60, 10);
        menuButton.getItems().addAll(new MenuItem("00:00"), new MenuItem("01:00"), new MenuItem("02:00"));
        MenuButton menuButton2 = new MenuButton("01:00");
        menuButton2.setMinSize(60, 10);
        menuButton2.getItems().addAll(m0, m1, m2);
        ColorPicker colorPicker = new ColorPicker(Color.BLUE);
        colorPicker.setMinSize(60, 10);
        Button button1 = new Button("Add");
        button1.setMinSize(60, 10);
        vBox1.setSpacing(20);
        vBox1.getChildren().addAll(title, datePicker, menuButton, menuButton2, colorPicker, button1);


        m1.setOnAction(event -> {
            menuButton2.setText("01:00");
        });
        m0.setOnAction(event -> {
            menuButton2.setText("00:00");
        });
        m2.setOnAction(event -> {
            menuButton2.setText("02:00");
        });


        button1.setOnAction(e -> {
            if(title.getText().trim().isEmpty() || datePicker.getValue() == null){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Warning!");
                alert.setHeaderText("Something went wrong!");
                alert.setContentText("You should fill out everything before adding the Event / Appointment");
                alert.showAndWait();
            }
            else{
                StudyCalendarEntry studyCalendarEntry = new StudyCalendarEntry(title.getText(), LocalTime.MIN,LocalTime.MAX,datePicker.getValue());
                try {
                    CalendarCell calendarCell = (CalendarCell) singletonAttributeStore.getAttribute("cell");
                    calendarCell.setStudyCalendarEntry(studyCalendarEntry);
                    calendarCell.setColorOfEvent(studyCalendarEntry,color1);
                    singletonAttributeStore.removeAttribute("cell");

                } catch (Exception f) {
                    f.printStackTrace();
                }
                popupwindow.close();}
                }
        );

        HBox layout = new HBox();

        layout.setAlignment(Pos.CENTER);


        layout.getChildren().addAll(vBox, vBox1);


        Scene scene1 = new Scene(layout, 550, 390);

        popupwindow.setScene(scene1);

        popupwindow.showAndWait();

    }
}
