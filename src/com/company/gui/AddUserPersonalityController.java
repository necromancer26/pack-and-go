package com.company.gui;


import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;

public class AddUserPersonalityController {
    @FXML
    private final BorderPane rootPane ;

    public AddUserPersonalityController() {
        this.rootPane = new BorderPane();
    }

    public BorderPane getRootPane() {
        return rootPane;
    }
}
