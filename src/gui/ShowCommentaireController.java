 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
import MailR.MailRestau;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.converter.IntegerStringConverter;
import models.Resteau;
import models.Commentaire;
import services.CommentaireResteau;
import services.ServiceResteau;
import services.ServiceUser;
import utils.DataSource;
import utils.UserSession;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class ShowCommentaireController implements Initializable {

    @FXML
    private TableView<Commentaire> TableViewCommentaireR;
    @FXML
    private TableColumn<Commentaire, Integer> colidcmntrR;
    @FXML
    private TableColumn<Commentaire, Integer> colidR;
    @FXML
    private TableColumn<Commentaire, String> coliduser;
    @FXML
    private TableColumn<Commentaire, String>colcmntrR;
        @FXML

    private TableColumn<Commentaire, String>collllC;
    @FXML
    private TableColumn<Commentaire, String> colNomR;

    /**
     * Initializes the controller class.
     */
        ServiceResteau sp = new ServiceResteau();
    @FXML
    private TextField tfMail;
          ServiceUser su = new ServiceUser ();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
          CommentaireResteau C = new CommentaireResteau();
       ObservableList<Commentaire> commentairelList ;
        commentairelList = C.getListcommentaire();
          TableViewCommentaireR.setItems(commentairelList);

        loaDate();
        editTableView();
        modifier();
    }    

    private void loaDate() {
       CommentaireResteau C = new CommentaireResteau();
        ObservableList<Commentaire> commentairelList ;
        
        commentairelList = C.getListcommentaire();
        colidcmntrR.setCellValueFactory(new PropertyValueFactory<>("idCommentaireR"));
        colidR.setCellValueFactory(new PropertyValueFactory<>("idR"));
        coliduser.setCellValueFactory(new PropertyValueFactory<>("id_user"));
        colcmntrR.setCellValueFactory(new PropertyValueFactory<>("contenuCommentaireR"));
        
        coliduser.setCellValueFactory(cellData ->
               new SimpleStringProperty(su.getUserById1(cellData.getValue().getId_user())));
        colNomR.setCellValueFactory(cellData -> 
       new SimpleStringProperty(sp.getNomByIDResteau(cellData.getValue().getIdR())));
           Callback<TableColumn<Commentaire, String>, TableCell<Commentaire, String>> cellFoctory = (TableColumn<Commentaire, String> param) -> {
            final TableCell<Commentaire, String> cell = new TableCell<Commentaire, String>() {
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setGraphic(null);
                        setText(null);
                    } else {                      
                       final Button deleteButton = new Button("DELETE");
                        deleteButton.setOnAction(event -> {
                            try {
                            Commentaire C1 = getTableView().getItems().get(getIndex());
                           C.supprimerCommentaireR(C1);                                  
                            refrechRestau();  
                            
                           
                            MailRestau.sendMail(tfMail.getText());
                            
                         
                        } catch (Exception ex) {
                                System.out.println(ex.getMessage());
                        } 

                        });
                       
                                  
 
                      
                       
                                                                 
                        
                
                         HBox managebtn = new HBox( deleteButton);
                        managebtn.setStyle("-fx-alignment:center");
                        setGraphic(managebtn);
                        setText(null);
                        }               
                    }

                private void refrechRestau() {
                                loaDate();
                 }
                };
            return cell;
        };
        
        
                collllC.setCellFactory(cellFoctory);  

                TableViewCommentaireR.setItems(commentairelList);

        
    }
       private void modifier() {
         Commentaire C1 =TableViewCommentaireR.getSelectionModel().getSelectedItem();
       CommentaireResteau C = new CommentaireResteau();
        ObservableList<Commentaire> commentairelList ;

        commentairelList = C.getListcommentaire();
                TableViewCommentaireR.setItems(commentairelList);
         try{
             C.modifierCommentaireR(new Commentaire (C1.getIdCommentaireR(),C1.getIdR(),C1.getid_user(),C1.getContenuCommentaireR()));
             Alert alert =new Alert(Alert.AlertType.INFORMATION);
             alert.show();
             alert.setTitle("updated");
             alert.setContentText("updated succesfully ");
         }catch (Exception e){
          

            System.out.println(e.getMessage());
        }  
         TableViewCommentaireR.setItems(C.getListcommentaire());
    }
    public void editTableView(){
        TableViewCommentaireR.setEditable(true);
       // tblChambres.setEditable(true);
        colidcmntrR.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        colidcmntrR.setOnEditCommit(e -> {
            e.getTableView().getItems().get(e.getTablePosition().getRow()).setIdcommentaireR(e.getNewValue());
        });
        /*
        colidR.setCellFactory( TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        colidR.setOnEditCommit(e -> {
            e.getTableView().getItems().get(e.getTablePosition().getRow()).setIdR(e.getNewValue());
        });
        coliduser.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));        
        coliduser.setOnEditCommit(e -> {
            e.getTableView().getItems().get(e.getTablePosition().getRow()).setid_user(e.getNewValue());
        });
*/
        colcmntrR.setCellFactory(TextFieldTableCell.forTableColumn());        
        colcmntrR.setOnEditCommit(e -> {
            e.getTableView().getItems().get(e.getTablePosition().getRow()).setContenuCommentaireR(e.getNewValue());
        });
   
      
    }

    @FXML
    private void addCmntrR(MouseEvent event) {
        
        
      try{
            URL fxURL = getClass().getResource("AddCmntrForm.fxml");
            Parent root = FXMLLoader.load(fxURL);
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
                      
            stage.setTitle("Ajout de commentaire");
            stage.show();

        } catch (IOException ex){
            System.out.println(ex.getMessage());
        }
      refrechcmntr();
    }

    @FXML
    private void refrechcmntr() {
                        loaDate();

    }

     @FXML
    private void hotelBack(MouseEvent event) {
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
    private void UsersBack(MouseEvent event) {
    
          FXMLLoader LOADER = new FXMLLoader(getClass().getResource("FXMLGSTuser.fxml"));
            try {
                Parent root = LOADER.load();
                Scene sc = new Scene(root);
                 FXMLGSTuserController cntr = LOADER.getController();
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.setScene(sc);
                window.show();
            } catch (Exception ex) {

        }
    }
}
