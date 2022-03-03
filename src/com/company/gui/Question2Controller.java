package com.company.gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Question2Controller implements Initializable {
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
            System.out.println("in button 3");
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../gui/Question3.fxml"));
            VBox yourNewView = fxmlLoader.load();
            pane.getChildren().setAll(yourNewView);
            Question3Controller question3Controller = fxmlLoader.getController();
        } catch (IOException ioException) {
            System.out.println(ioException.getMessage());
        }
    }
}
