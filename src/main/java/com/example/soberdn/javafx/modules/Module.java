package com.example.soberdn.javafx.modules;

import com.example.soberdn.javafx.controllers.Controller;
import javafx.scene.Node;

public class Module {

    private String name;
    private Controller controller;
    private Node sceneGraph;

    public Module(String name, Controller controller, Node sceneGraph) {
        this.name = name;
        this.controller = controller;
        this.sceneGraph = sceneGraph;
    }

    public String getName() {
        return name;
    }

    public Controller getController() {
        return controller;
    }

    public Node getSceneGraph() {
        return sceneGraph;
    }
}

