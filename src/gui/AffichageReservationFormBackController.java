/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
import javafx.scene.input.KeyEvent;
import java.io.IOException;
import java.net.URL;
import static java.nio.file.Files.list;
import static java.rmi.Naming.list;
import java.sql.SQLException;
import java.util.ArrayList;
import static java.util.Collections.list;
import javafx.scene.control.Alert;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import java.util.List;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.Callback;
import javafx.util.converter.IntegerStringConverter;
import models.reservationR;
import services.ServiceResteau;
import services.cReservationR;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class AffichageReservationFormBackController implements Initializable {

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
    @FXML
    private TextField searchInput;
    @FXML
    private TableColumn<reservationR, String> colNomR;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
  
               loadDate();
               editTableView();
                modifier();
         cReservationR RE = new cReservationR();
          ObservableList<reservationR> ReservationlList ;
        ReservationlList = RE.getListResteau();
                TableViewReservation.setItems(ReservationlList);
                /*
                 modifier();
                cReservationR RE = new cReservationR();
      //  ObservableList<reservationR> ReservationlList ;
        ReservationlList =RE.getListResteau();
                TableViewReservation.setItems(ReservationlList);*/

    }    
    ServiceResteau sp = new ServiceResteau();

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
  colNomR.setCellValueFactory(cellData -> 
       new SimpleStringProperty(sp.getNomByIDResteau(cellData.getValue().getIdR())));

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
                   
                            
                        HBox managebtn = new HBox(editButton,deleteButton);
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
         
        reservationR C1 =TableViewReservation.getSelectionModel().getSelectedItem();
        cReservationR RE = new cReservationR();
      //  ObservableList<reservationR> ReservationlList ;
        ReservationlList =RE.getListResteau();
                TableViewReservation.setItems(ReservationlList);
        
         try{
            RE.modifierReservationR(new reservationR (C1.getIdreservationR(),C1.getIdR(),C1.getId_user(),C1.getNbrPersonneR(),C1.getTimeR(),C1.getDateR()));
            Alert alert =new Alert(Alert.AlertType.INFORMATION);
             alert.show();
             alert.setTitle("updated");
             alert.setContentText("updated succesfully ");
         }catch (Exception e){
          

            System.out.println(e.getMessage());
        }  
         TableViewReservation.setItems(RE.getListResteau());
    }
     public void editTableView(){
         
     
         TableViewReservation.setEditable(true);
       // tblChambres.setEditable(true);
       /*
        coltidreservationR.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        
        coltidreservationR.setOnEditCommit(e -> {
             e.getTableView().getItems().get(e.getTablePosition().getRow()).setIdreservationR(e.getNewValue());
             
        });
        colidR.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        
        
        colidR.setOnEditCommit(e -> {
             e.getTableView().getItems().get(e.getTablePosition().getRow()).setIdR(e.getNewValue());
        });
        
        colid_user.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter())); 
        
        colid_user.setOnEditCommit(e -> {
             e.getTableView().getItems().get(e.getTablePosition().getRow()).setId_user(e.getNewValue());
        });
*/
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

 