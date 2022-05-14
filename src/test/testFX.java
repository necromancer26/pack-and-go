/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.jfoenix.controls.JFXTextArea;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Wala
 */
public class testFX extends Application {
    
    @Override
    public void start(Stage stage) {
        
        try{         
            Parent root = FXMLLoader.load(getClass().getResource("../gui/AfficherHotelsForm.fxml"));
            StackPane stackPane = new StackPane();
            stackPane.getChildren().add(root);
            stackPane.setAlignment(Pos.CENTER);
            stackPane.setMaxWidth(1999);
            stackPane.setMaxHeight(1999);
            ScrollPane scrollPane= new ScrollPane();
            scrollPane.setContent(stackPane);
            scrollPane.setFitToWidth(true);
            scrollPane.setFitToHeight(true);
            Scene scene = new Scene(scrollPane);
            stage.setScene(scene);
            stage.setTitle("Pack And Go!");
            stage.show();

            }catch(Exception e){
                System.out.println(e.getMessage());
            }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
