/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import tn.edu.esprit.models.Resteau;
import tn.edu.esprit.models.reservationR;
import tn.edu.esprit.services.CommentaireResteau;
import tn.edu.esprit.services.cReservationR;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class AffichageReservationFormBackController implements Initializable {

    @FXML
    private TableView<reservationR> TableViewReservation;
    @FXML
    private TableColumn<reservationR, String> coltidreservationR;
    @FXML
    private TableColumn<reservationR, String>  colidR;
    @FXML
    private TableColumn<reservationR, String>  colid_user;
    @FXML
    private TableColumn<reservationR, String>  colnbrPersonneR;
    @FXML
    private TableColumn<reservationR, String>  coltimeR;
    @FXML
    private TableColumn<reservationR, String>  coldateR;
    @FXML
    private TableColumn<reservationR, String>  editcol;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
                loadDate();
    }    

    @FXML
    private void refrechReservation(MouseEvent event) {
                        loadDate();

    }

    private void loadDate() {
        cReservationR RE = new cReservationR();
        ObservableList<reservationR> ReservationlList ;
        ReservationlList = RE.getListResteau();
        coltidreservationR.setCellValueFactory(new PropertyValueFactory<>("idreservationR"));
        colidR.setCellValueFactory(new PropertyValueFactory<>("idR"));
        colid_user.setCellValueFactory(new PropertyValueFactory<>("id_user"));
        colnbrPersonneR.setCellValueFactory(new PropertyValueFactory<>("nbrPersonneR"));
        coltimeR.setCellValueFactory(new PropertyValueFactory<>("timeR"));
        coldateR.setCellValueFactory(new PropertyValueFactory <>("dateR"));


  Callback<TableColumn<reservationR, String>, TableCell<reservationR, String>> cellFoctory = (TableColumn<reservationR, String> param) -> {
            final TableCell<reservationR, String> cell = new TableCell<reservationR, String>() {
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setGraphic(null);
                        setText(null);
                    } else {                      
                        final Button deleteButton = new Button("DELETE");
                        deleteButton.setOnAction(event -> {
                            reservationR R1 = getTableView().getItems().get(getIndex());
                            RE.supprimerReservationR(R1);
                            refrechReservation();
                                                              
                        });
                             HBox managebtn = new HBox(deleteButton);
                        managebtn.setStyle("-fx-alignment:center");
                        setGraphic(managebtn);
                        setText(null);
                    }
                }
                
                          private void refrechReservation() {
                                loadDate();}
                
          
               
            };       
          return cell;
        };
          editcol.setCellFactory(cellFoctory);  
           TableViewReservation.setItems(ReservationlList);
}
    
}
    
   
    

    

