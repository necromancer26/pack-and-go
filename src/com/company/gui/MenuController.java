package com.company.gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;

import javax.accessibility.AccessibleIcon;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements Initializable {
    @FXML
    private Button menuButton;
    @FXML
    private VBox pane = new VBox();



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void onButtonClicked(javafx.event.ActionEvent actionEvent) {
        try {
            //URL fxURL = getClass().getResource("../gui/AddUserPersonality.fxml");
            //BorderPane borderPane = FXMLLoader.load(fxURL);
            System.out.println("in button");
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../gui/Question1.fxml"));
            VBox yourNewView = fxmlLoader.load();
            pane.getChildren().setAll(yourNewView);
            Question1Controller addUserPersonalityController = fxmlLoader.getController();
        } catch (IOException ioException) {
            System.out.println(ioException.getMessage());
        }
    }
}
