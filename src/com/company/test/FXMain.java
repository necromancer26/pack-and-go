package com.company.test;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

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
            //setUserAgentStylesheet(STYLESHEET_CASPIAN);
            primaryStage.setScene(new Scene(root, 640, 400));
            primaryStage.setTitle("Pack And Go!");
            primaryStage.show();


        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
