/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.util.Callback;
import tn.edu.esprit.models.reservationR;
import tn.edu.esprit.services.cReservationR;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class ShowReservationFormController implements Initializable {

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
                ObservableList<reservationR> ReservationlList ;
    @FXML
    private TextField searchInput;

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

    @FXML
    private void filtretReservationR(KeyEvent event)throws SQLException {
       cReservationR RE = new cReservationR();
        List <reservationR> reservationR=new ArrayList<>();
           List <reservationR>reservation=RE.getListResteau();
        List<reservationR> filtereresrevation = new ArrayList<>();
        if (!searchInput.getText().isEmpty()) {
            filtereresrevation = reservationR.stream().filter(p -> p.getIdreservationR().startsWith((parseInt(searchInput.getText())).collect(Collectors.toList());
        } else {
            filtereresrevation = reservationR;
        }
        ReservationlList.clear();
        ReservationlList = FXCollections.observableArrayList(filtereresrevation); ///conversion normal list to observable list
        colidR.setCellValueFactory(new PropertyValueFactory<>("idR"));
        colid_user.setCellValueFactory(new PropertyValueFactory<>("id_user"));
        colnbrPersonneR.setCellValueFactory(new PropertyValueFactory<>("nbrPersonneR"));
        coltimeR.setCellValueFactory(new PropertyValueFactory<>("timeR"));
        coldateR.setCellValueFactory(new PropertyValueFactory <>("dateR"));

        TableViewReservation.setEditable(true); //clickable
        TableViewReservation.setItems(ReservationlList); //remplir tableview with observablz list
    }
    
}
    
   
    

    

