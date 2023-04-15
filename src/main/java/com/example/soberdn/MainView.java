package com.example.soberdn;

import com.example.soberdn.components.SimpleSoberDNService;
import com.example.soberdn.components.User;
import com.example.soberdn.javafx.controllers.Controller;
import com.example.soberdn.javafx.controllers.RootController;
import com.example.soberdn.javafx.controllers.template.SingletonAttributeStore;
import com.example.soberdn.javafx.modules.Module;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MainView extends Application {

    private static final org.slf4j.Logger logger =
            org.slf4j.LoggerFactory.getLogger(MainView.class);
    private final int WIDTH = 1280;

    private final int HEIGHT = 720;
    private RootController rootController;
    private Map<String, Module> moduleMap;
    SingletonAttributeStore singletonAttributeStore = SingletonAttributeStore.getReference();

    public MainView() {
        moduleMap = new HashMap<>();
    }

    /**
     * the main method.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        System.out.println("java version: " + System.getProperty("java.version"));
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/soberdn/Root2.fxml"));

        final Parent root = loader.load();
        rootController = loader.getController();

        primaryStage.setTitle("JavaFX UI");
        Scene scene = new Scene(root, WIDTH, HEIGHT);
        primaryStage.setMinWidth(WIDTH);
        primaryStage.setMinHeight(HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.show();

        singletonAttributeStore.setAttribute("stage", primaryStage);
        singletonAttributeStore.setAttribute("service", new SimpleSoberDNService());

        //addModule("Template");
        addModule("Sober");
        //addModule("Bar");

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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/soberdn/" + name + ".fxml"));
            Node content = loader.load();
            Controller controller = loader.getController();
            Module module = new Module(name, controller, content);
            rootController.addModule(module);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(8);
        }
    }
}