package com.company.gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.Label;

import javax.management.Notification;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.io.IOException;

import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements Initializable {
    @FXML
    private Label text;

    @FXML
    private BorderPane pane = new BorderPane();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


    public void loadSecond(javafx.event.ActionEvent actionEvent) throws IOException {
        try {
            URL fxURL = getClass().getResource("../gui/AddUserPersonality.fxml");
            BorderPane borderPane = FXMLLoader.load(fxURL);
        } catch (IOException ioException) {
            System.out.println(ioException.getMessage());
        }

    }

    public void onButtonClicked(javafx.event.ActionEvent actionEvent) {
        System.out.println("hello"+text.getText());
        System.out.println(actionEvent.hashCode());
        try {
            //URL fxURL = getClass().getResource("../gui/AddUserPersonality.fxml");
            //BorderPane borderPane = FXMLLoader.load(fxURL);
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../gui/AddUserPersonality.fxml"));
            BorderPane yourNewView = fxmlLoader.load();
            pane.getChildren().setAll(yourNewView);
            AddUserPersonalityController addUserPersonalityController = fxmlLoader.getController();
        } catch (IOException ioException) {
            System.out.println(ioException.getMessage());
        }

    }
}
