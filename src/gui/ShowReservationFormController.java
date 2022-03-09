/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.util.Callback;
import javafx.util.converter.IntegerStringConverter;
import models.Resteau;
import models.reservationR;
import services.ServiceResteau;
import services.cReservationR;


/**
 * FXML Controller class
 *
 * @author hp
 */
public class ShowReservationFormController implements Initializable {

     @FXML
    private TableView<reservationR> TableViewReservation;
    @FXML
    private TableColumn<reservationR, Integer> coltidreservationR;
    @FXML
    private TableColumn<reservationR, Integer>  colidR;
    @FXML
    private TableColumn<reservationR, Integer>  colid_user;
    @FXML
    private TableColumn<reservationR, Integer>  colnbrPersonneR;
    @FXML
    private TableColumn<reservationR, String>  coltimeR;
    @FXML
    private TableColumn<reservationR, String>  coldateR;
    @FXML
    private TableColumn<reservationR, String>  editcol;
                ObservableList<reservationR> ReservationlList ;
    private TextField searchInput;
    @FXML
    private TextField rechercheRestau;

    
    // Initializes the controller class.
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

                loadDate();
                 editTableView();
                           modifier();
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
        //colid_user.setCellValueFactory(new PropertyValueFactory<>("id_user"));
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
                          final Button editButton = new Button("UPDATE");
                        editButton.setOnAction(event -> {
                            modifier();
                      });
                        
                        
                        
                         HBox managebtn = new HBox(editButton, deleteButton);
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
     private void modifier() {
                  reservationR R1 =TableViewReservation.getSelectionModel().getSelectedItem();

      cReservationR R = new cReservationR();
       ObservableList<reservationR> ReservationlList ;
                ReservationlList =R.getListResteau();
                TableViewReservation.setItems(ReservationlList);
         try{
             R.modifierReservationR(new reservationR (R1.getIdreservationR(),R1.getIdR(),R1.getId_user(),R1.getNbrPersonneR(),R1.getTimeR(),R1.getDateR()));
             Alert alert =new Alert(Alert.AlertType.INFORMATION);
             alert.show();
             alert.setTitle("updated");
             alert.setContentText("updated succesfully ");
         }catch (Exception e){
          

            System.out.println(e.getMessage());
        }  
         TableViewReservation.setItems(R.getListResteau());
    }
        
public void editTableView()
{
    
        TableViewReservation.setEditable(true);
       // tblChambres.setEditable(true);
        
       colnbrPersonneR.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        colnbrPersonneR.setOnEditCommit(e -> {
            e.getTableView().getItems().get(e.getTablePosition().getRow()).setNbrPersonneR(e.getNewValue());
        });
       
        
       coltimeR.setCellFactory(TextFieldTableCell.forTableColumn());   
        coltimeR.setOnEditCommit(e -> {
           e.getTableView().getItems().get(e.getTablePosition().getRow()).setTimeR(e.getNewValue());
        });
       

        coldateR.setCellFactory(TextFieldTableCell.forTableColumn());        
        coldateR.setOnEditCommit(e -> {
            e.getTableView().getItems().get(e.getTablePosition().getRow()).setDateR(e.getNewValue());
        });

} 

   
    
}

    

   
    

