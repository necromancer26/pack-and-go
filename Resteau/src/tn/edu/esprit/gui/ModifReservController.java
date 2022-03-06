/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;

import com.jfoenix.controls.JFXTimePicker;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
import static tn.edu.esprit.gui.AfficherCommentaireFrontController.idusr;
import static tn.edu.esprit.gui.AfficherCommentaireFrontController.inde;
import static tn.edu.esprit.gui.FrontRestauController.index;
import tn.edu.esprit.models.Commentaire;
import tn.edu.esprit.models.Resteau;
import tn.edu.esprit.models.reservationR;
import tn.edu.esprit.services.cReservationR;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class ModifReservController implements Initializable {

    @FXML
    private TextField lblidR;
    @FXML
    private TextField lbliduser;
    @FXML
    private TextField lblnbpR;
    @FXML
    private DatePicker lblDateR;
    @FXML
    private JFXTimePicker llbltimeR;

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

   
              index=RE1.getIdR();
              idusr=RE1.getId_user();
            // C1.setIdR(parseInt(lblIdR.getText()));
               // Commentaire.setIdres(Resteau.getIdd());

             RE1.setIdR(Resteau.getIdd());
             RE1.setIdreservationR(reservationR.getIdRESERV());
             RE1.setId_user(reservationR.getIdusr());
            // C1.set
             //C1.s
                   // C1.setid_user(parseInt(lbliduser.getText()));
            //  C1.setContenuCommentaireR(lblcontenucmntr.getText()); 
             RE1.setNbrPersonneR(parseInt(lblnbpR.getText()));
             RE1.setDateR(String.valueOf(lblDateR.getValue()));
             RE1.setTimeR(String.valueOf(llbltimeR.getValue()));
             //C.modifierCommentaireR(inde,index,setContenuCommentaireR);
              RE.modifierReservationR(RE1);
              System.out.println(RE1);
               Alert alert =new Alert(Alert.AlertType.INFORMATION);
               alert.setTitle("succes");
               alert.setHeaderText("modifiéé");
               alert.setContentText("commentaire  modifier avec succés !");
            
              Notifications notificationBuilder = Notifications.create()
                        .title(" commentaire  modifier")
                        .text("Saved in your DATABASE").darkStyle()
             .graphic(null)
   // .graphic(null)
                        
                        .hideAfter(Duration.seconds(15))
                        .position(Pos.TOP_RIGHT)
                        .onAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               System.out.println("Clicked on notification");
            }
        });
                notificationBuilder.darkStyle();
                notificationBuilder.show();
               alert.showAndWait();
               
    }
        
    
    @FXML
    private void affichageReserv(MouseEvent event) {

    }
    
}

