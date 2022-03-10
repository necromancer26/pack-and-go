package com.company.test;

import com.company.models.Package;
import com.company.services.PackageController;
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
import java.util.List;


public class FXMain extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            URL fxURL = getClass().getResource("../gui/Menu.fxml");
            Parent root = FXMLLoader.load(fxURL);
            setUserAgentStylesheet(STYLESHEET_CASPIAN);
            StackPane stackPane = new StackPane();
            stackPane.getChildren().add(root);
            stackPane.setAlignment(Pos.CENTER);
            stackPane.setMaxWidth(1999);
            stackPane.setMaxHeight(1999);
            //stackPane.setStyle("-fx-border-color:yellow;-fx-background-color:blue;");
            stackPane.getChildren().setAll(root);

            ScrollPane scrollPane = new ScrollPane();
            scrollPane.setContent(stackPane);
            //scrollPane.setStyle("-fx-border-color:red;");
            scrollPane.setFitToHeight(true);
            scrollPane.setFitToWidth(true);
            Scene scene = new Scene(scrollPane, 1000, 1000);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Pack And Go!");
            primaryStage.show();


            //Test.test();


        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        } catch (Exception exception) {
            System.err.println(exception.getMessage());
        }
    }
}
