 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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
    private TableColumn<Commentaire, Integer> coliduser;
    @FXML
    private TableColumn<Commentaire, String>colcmntrR;
        @FXML

    private TableColumn<Commentaire, String>collllC;

    /**
     * Initializes the controller class.
     */
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
                            Commentaire C1 = getTableView().getItems().get(getIndex());
                           C.supprimerCommentaireR(C1);                                  
                            refrechRestau();                                   
                        });
                        
                              //CommentaireResteau C = new CommentaireResteau();

                           // Commentaire C1 = getTableView().getItems().get(getIndex());
                                                                 
                        
                        final Button editButton = new Button("UPDATE");
                        editButton.setOnAction(event -> {
                            modifier();
                            
                         /*Commentaire C1 = getTableView().getItems().get(getIndex());
   try{

            URL fxURL = getClass().getResource("../gui/ModifierCommentaireForm.fxml");
            Parent root = FXMLLoader.load(fxURL);
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("modifier de commentaire");
            stage.show();

        } catch (IOException ex){
            System.out.println(ex.getMessage());
        }                                                           

                 */
                        });
                         HBox managebtn = new HBox(editButton, deleteButton);
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

    
}
