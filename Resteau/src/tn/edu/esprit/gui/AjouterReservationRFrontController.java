/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;

import com.jfoenix.controls.JFXTimePicker;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
import tn.edu.esprit.models.Resteau;
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
    private JFXTimePicker llbltimeR;
    @FXML
    private DatePicker lblDateR;
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
             // RE1.setIdR(parseInt(lblidR.getText())); 
             RE1.setIdR(Resteau.getIdd());
             
               RE1.setId_user(parseInt(lbliduser.getText()));
               RE1.setNbrPersonneR(parseInt(lblnbpR.getText()));
               RE1.setTimeR(String.valueOf(llbltimeR.getValue())); 
               RE1.setDateR(String.valueOf(lblDateR.getValue()));  
               lblDateR.setDayCellFactory(picker -> new DateCell() {
            public void updateItem(LocalDate String, boolean empty) {
                super.updateItem(String, empty);
                LocalDate today = LocalDate.now();
             //  setDisable(empty || String.compareTo(today));
            }
        });
               RE.AjouterReservationR(RE1);
               Alert alert =new Alert(Alert.AlertType.INFORMATION);
               alert.setTitle("succes");
               alert.setHeaderText("Ajouté");
               alert.setContentText("reservation  Ajouté avec succés !");
            
                 Notifications notificationBuilder = Notifications.create()
                        .title(" reservation  Ajoutée")
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
           try{
            URL fxURL = getClass().getResource("../gui/FrontReserv.fxml");
            Parent root = FXMLLoader.load(fxURL);
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Ajout de Restau");
            stage.show();

        } catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    }
    

