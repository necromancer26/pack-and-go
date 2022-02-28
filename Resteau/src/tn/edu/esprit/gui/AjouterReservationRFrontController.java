/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;

import static java.lang.Integer.parseInt;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import tn.edu.esprit.models.reservationR;
import tn.edu.esprit.services.cReservationR;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class AjouterReservationRFrontController implements Initializable {

    @FXML
    private TextField lblidR;
    @FXML
    private TextField lbliduser;
    @FXML
    private TextField llbltimeR;
    @FXML
    private TextField lblDateR;
    @FXML
    private TextField lblnbpR;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ReserverRestau(MouseEvent event) {
                             cReservationR RE = new cReservationR();
reservationR RE1= new reservationR();
              RE1.setIdR(parseInt(lblidR.getText())); 
               RE1.setId_user(parseInt(lbliduser.getText()));
               RE1.setNbrPersonneR(parseInt(lblnbpR.getText()));
              RE1.setTimeR(llbltimeR.getText()); 
              RE1.setDateR(lblDateR.getText());  
               RE.AjouterReservationR(RE1);
               Alert alert =new Alert(Alert.AlertType.INFORMATION);
               alert.setTitle("succes");
               alert.setHeaderText("Ajouté");
               alert.setContentText("reservation  Ajouté avec succés !");
            
               alert.showAndWait();
    }
    
    }
    

