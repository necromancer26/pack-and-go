package com.company.gui;

import com.company.models.Personality;
import com.company.services.PersonalityController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class MenuController implements Initializable {
    @FXML
    private Button menuButton;
    @FXML
    private Button toBackOffice;
    @FXML
    private VBox pane = new VBox();

    PersonalityController personalityController = new PersonalityController();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //init();
    }

    public void onButtonClicked(javafx.event.ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../gui/Question1.fxml"));
            VBox yourNewView = fxmlLoader.load();
            pane.getChildren().setAll(yourNewView);
            Question1Controller addUserPersonalityController = fxmlLoader.getController();
        } catch (IOException ioException) {
            System.out.println(ioException.getMessage());
        }
    }

    public void onAdminClicked(ActionEvent actionEvent) {
    }
}
