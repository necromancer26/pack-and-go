/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
//import test.FXMain;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class MenuController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void espaceadmin(MouseEvent event) {
              try{
            URL fxURL = getClass().getResource("ShowRestauForm.fxml");
            Parent root = FXMLLoader.load(fxURL);
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            
            stage.show();

        } catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void espaceclient(MouseEvent event) {
          try{
            URL fxURL = getClass().getResource("FrontRestau.fxml");
            Parent root = FXMLLoader.load(fxURL);
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            
            stage.show();

        } catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }
    
}
