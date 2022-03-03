package com.company.test;

import com.company.gui.AddUserPersonalityController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import com.aquafx_project.AquaFx;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

public class FXMain extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {

            URL fxURL = getClass().getResource("../gui/Menu.fxml");
            Parent root = FXMLLoader.load(fxURL);
            //Parent root = new GridPane();
            //Scene scene = new Scene(root);
            //primaryStage.setScene(scene);
            //root.getChildrenUnmodifiable().add(startButton);
            primaryStage.setScene(new Scene(root, 900, 800));
            primaryStage.setTitle("Pack And Go!");
            primaryStage.show();




        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
