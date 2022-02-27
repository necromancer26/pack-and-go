/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import tn.edu.esprit.models.Resteau;
import tn.edu.esprit.services.ServiceResteau;
/**
 * FXML Controller class
 *
 * @author hp
 */
public class RestauAddFormController implements Initializable {

    @FXML
    private TextField tfNomR;
    @FXML
    private TextField tfAdR;
    @FXML
    private TextField tfType;
    @FXML
    private TextField tfPays;
    @FXML
    private TextField tfTel;
    @FXML
    private Label lbAfficheR;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
           
    }    

    @FXML
    private void AjouterResteau(ActionEvent event) {
         ServiceResteau sp = new ServiceResteau();
               Resteau R1 = new Resteau();
               R1.setNomR(tfNomR.getText()); 
               R1.setTypeR(tfType.getText()); 
               R1.setAdressR(tfAdR.getText()); 
               R1.setPaysR(tfPays.getText()); 
               R1.setTelR(tfTel.getText()); 
               sp.ajouter(R1);
               Alert alert =new Alert(Alert.AlertType.INFORMATION);
               alert.setTitle("succes");
               alert.setHeaderText("Ajouté");
               alert.setContentText("restau Ajouté avec succés !");
            
               alert.showAndWait();
    }


    }
    

