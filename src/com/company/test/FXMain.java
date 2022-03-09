package com.company.test;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;
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
            //Group root =new Group();
            //Parent root = new GridPane();
            //Scene scene = new Scene(root);
            //primaryStage.setScene(scene);
            //root.getChildrenUnmodifiable().add(startButton);
            setUserAgentStylesheet(STYLESHEET_CASPIAN);
            try {
            StackPane stackPane = new StackPane();
                stackPane.getChildren().add(root);
                stackPane.setAlignment(Pos.CENTER);
                stackPane.setMaxWidth(1999);
                stackPane.setMaxHeight(1999);
                //stackPane.setStyle("-fx-border-color:yellow;-fx-background-color:blue;");
                stackPane.getChildren().setAll(root);

                ScrollPane scrollPane = new ScrollPane();
                scrollPane.setContent(stackPane);
                scrollPane.setStyle("-fx-border-color:red;");
                scrollPane.setFitToHeight(true);
                scrollPane.setFitToWidth(true);



                //root.getChildrenUnmodifiable().add(stackPane);
                //scrollPane.getChildrenUnmodifiable().add(stackPane);
                Scene scene = new Scene(scrollPane, 1000, 1000);
                primaryStage.setScene(scene);
                primaryStage.setTitle("Pack And Go!");
                primaryStage.show();

            } catch (Exception exception) {
                System.err.println(exception.getMessage());
            }

            //Test.test();


        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
