/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.IOException;
import java.net.URL;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author dorsaf
 */
public class FXMain extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        try {
            URL fxURL = getClass().getResource("../gui/Menu.fxml"); //AfficherHotelFront AfficherHotelsForm
            Parent root = FXMLLoader.load(fxURL);
            Scene scene = new Scene(root);
            String css = this.getClass().getResource("../gui/bootstrap.css").toExternalForm();
            scene.getStylesheets().add(css);
             scene.setFill(Color.TRANSPARENT);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Hotels");
            primaryStage.show();
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
