package com.company.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Question4Controller implements Initializable {
    @FXML
    private Button nextButton;
    @FXML
    private Button previousButton;
    @FXML
    private VBox pane = new VBox();
    @FXML
    private RadioButton radioButton1;
    @FXML
    private RadioButton radioButton2;
    private String answer;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void onRadioButton1Clicked(ActionEvent actionEvent) {
        nextButton.setDisable(false);
        answer = "J";
    }

    public void onRadioButton2Clicked(ActionEvent actionEvent) {
        nextButton.setDisable(false);
        answer = "P";
    }

    public void onButtonClicked(javafx.event.ActionEvent actionEvent) {
        try {
            if (radioButton1.isSelected() || radioButton2.isSelected()) {
                ResultController.setTest(answer);
                nextButton.setDisable(false);
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../gui/Result.fxml"));
                VBox yourNewView = fxmlLoader.load();
                pane.getChildren().setAll(yourNewView);
                ResultController resultController = fxmlLoader.getController();

            } else {
                nextButton.setDisable(true);
            }
        } catch (IOException ioException) {
            System.out.println(ioException.getMessage());
        }
    }

    public void onPreviousClicked(javafx.event.ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../gui/Question3.fxml"));
            VBox yourNewView = fxmlLoader.load();
            pane.getChildren().setAll(yourNewView);
            Question3Controller question3Controller = fxmlLoader.getController();
        } catch (IOException ioException) {
            System.out.println(ioException.getMessage());
        }
    }


}
