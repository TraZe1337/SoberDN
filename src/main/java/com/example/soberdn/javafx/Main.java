package com.example.soberdn.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main extends Application {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(Main.class);

    private final int WIDTH = 1280;

    private final int HEIGHT = 720;
    private de.hhn.it.devtools.javafx.controllers.RootController rootController;
    private Map<String, de.hhn.it.devtools.javafx.modules.Module> moduleMap;

    public Main() {
        moduleMap = new HashMap<>();
    }


    public static void main(String[] args) {

        System.out.println("java version: " + System.getProperty("java.version"));
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Root2.fxml"));

        final Parent root = loader.load();
        rootController = loader.getController();

        primaryStage.setTitle("JavaFX UI");
        Scene scene = new Scene(root, WIDTH, HEIGHT);
        primaryStage.setMinWidth(WIDTH);
        primaryStage.setMinHeight(HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.show();

        addModule("CoffeeMakerService");
        addModule("Template");
        addModule("Calendar");
    }

    @Override
    public void stop() {
        logger.info("stop: Shutting down");
        // This is automatically called then you terminate the application using the window controls
        // ("x it out", "quit it", ...). It does not get called when you terminate the application
        // using control-C or an OS command like "kill".

        rootController.shutdown();
    }

    private void addModule(String name) {
        try {
            logger.info("addModule: Loading Module: \"" + name + "\"!");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/" + name + ".fxml"));
            Node content = loader.load();
            de.hhn.it.devtools.javafx.controllers.Controller controller = loader.getController();
            de.hhn.it.devtools.javafx.modules.Module module = new de.hhn.it.devtools.javafx.modules.Module(name, controller, content);
            rootController.addModule(module);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(8);
        }
    }
}
