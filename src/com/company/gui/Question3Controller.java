package com.company.gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Question3Controller implements Initializable {
    @FXML
    private Button nextButton;
    @FXML
    private VBox pane = new VBox();



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void onButtonClicked(javafx.event.ActionEvent actionEvent) {
        try {
            //URL fxURL = getClass().getResource("../gui/AddUserPersonality.fxml");
            //BorderPane borderPane = FXMLLoader.load(fxURL);
            System.out.println("in button 4");
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../gui/Question4.fxml"));
            VBox yourNewView = fxmlLoader.load();
            pane.getChildren().setAll(yourNewView);
            Question4Controller question4Controller = fxmlLoader.getController();
        } catch (IOException ioException) {
            System.out.println(ioException.getMessage());
        }
    }
}
