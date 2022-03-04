/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author dorsaf
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
    private void loginAdmin(ActionEvent event) {
        FXMLLoader LOADER = new FXMLLoader(getClass().getResource("AfficherHotelsForm.fxml"));
        try {
            Parent root = LOADER.load();
            Scene sc = new Scene(root);
            AfficherHotelsFormController cntr = LOADER.getController();
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(sc);
            window.show();
        } catch (Exception ex) {

        }
    }

    @FXML
    private void loginClient(ActionEvent event) {
        FXMLLoader LOADER = new FXMLLoader(getClass().getResource("AfficherHotelFront.fxml"));
        try {
            Parent root = LOADER.load();
            Scene sc = new Scene(root);
            AfficherHotelFrontController cntr = LOADER.getController();
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(sc);
            window.show();
        } catch (Exception ex) {

        }
    }
    
}
