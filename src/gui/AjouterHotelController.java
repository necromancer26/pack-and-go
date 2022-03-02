/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import models.Hotel;
import services.ServiceHotel;

/**
 * FXML Controller class
 *
 * @author dorsaf
 */
public class AjouterHotelController implements Initializable {

    @FXML
    private TextField tfNomHotel;
    @FXML
    private TextField tfNbrEtoiles;
    @FXML
    private TextField tfNbrChambres;
    @FXML
    private TextField tfAdresse;
    @FXML
    private TextField tfEmail;
    @FXML
    private TextField tfTel;
    @FXML
    private TextField tfPays;
    @FXML
    private Button btnAjouterHotel;
    @FXML
    private Button btnReset;
    
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       
    }    

    @FXML
    private void AjouterHotel(ActionEvent event) {
    /*    ServiceHotel sh = new ServiceHotel();
     //   Hotel h = new Hotel(tfNomHotel.getText(), Integer.parseInt(tfNbrEtoiles.getText()) , Integer.parseInt(tfNbrChambres.getText()) , tfAdresse.getText() , tfPays.getText(), Integer.parseInt(tfTel.getText()), tfEmail.getText() );
        sh.ajouter(h);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Succes");
        alert.setHeaderText("Ajouté");
        alert.setContentText("Hotel ajouté avec succès!");                
        alert.showAndWait();
        clean();
        */
    }
    
     private void clean() {
        tfNomHotel.setText(null);
        tfNbrEtoiles.setText(null);
        tfNbrChambres.setText(null);
        tfAdresse.setText(null);
        tfPays.setText(null);
        tfTel.setText(null);
        tfEmail.setText(null);
        
    }
        
    public void setNom_hotel(String nom){
        
        
    }

    @FXML
    private void resetFields(ActionEvent event) {
        clean();
    }

}
