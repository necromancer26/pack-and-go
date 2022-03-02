/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.converter.IntegerStringConverter;
import tn.edu.esprit.models.Commentaire;
import tn.edu.esprit.models.Resteau;
import tn.edu.esprit.services.CommentaireResteau;
import static tn.edu.esprit.gui.FrontRestauController.index;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class AfficherCommentaireFrontController implements Initializable {
    @FXML
    private ListView<Pane> listcmntr;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

          CommentaireResteau C = new CommentaireResteau();
       ObservableList<Commentaire> commentairelList ;
       // commentairelList = C.getListcommentaire();

       liteCommentaire();
    }    

public void liteCommentaire(){
          CommentaireResteau C = new CommentaireResteau();

     ObservableList<Pane> Panes = FXCollections.observableArrayList();
        for (Commentaire p3 :  C.getListCommentaireByID(index))  {
           //System.out.println(p3);
            FileInputStream F1 = null;
           
                try{
                Pane pane = new Pane();
                pane.setStyle(" -fx-background-color: white");
                Pane pane2 = new Pane();
                pane2.setLayoutX(150);
                pane2.setLayoutY(150);
                Pane panequantitet = new Pane();
                   pane2.setLayoutX(150);
                pane2.setLayoutY(150);
                pane2.setPrefWidth(pane2.getWidth() + 250);
                pane2.setPrefHeight(pane2.getHeight() + 150);
                pane2.setStyle("-fx-background-radius: 50;");
                pane2.setStyle(" -fx-border-radius: 10 10 10 10;-fx-border-color: #3f2b63;");

                panequantitet.setLayoutX(100);
                panequantitet.setLayoutY(40);
                panequantitet.setPrefWidth(panequantitet.getWidth() + 160);
                panequantitet.setPrefHeight(panequantitet.getHeight() + 30);
                Text quan1 = new Text("ID : ");
                Label quant2 = new Label(String.valueOf(p3.getIdR() ));
                quan1.setLayoutX(150);
                quan1.setLayoutY(80);
                quant2.setLayoutX(150);
                quant2.setLayoutY(80);
                quan1.setStyle("-fx-font-weight: bold;-fx-fill : #d82819;-fx-font-size:15px;");
                quant2.setStyle("-fx-font-weight: bold;-fx-fill : #d82819;-fx-font-size:15px;");
                panequantitet.getChildren().addAll(quan1, quant2);
                Text nomt = new Text("type: ");
                Label nom = new Label(p3.getContenuCommentaireR()); 
                nomt.setLayoutX(100);
                nomt.setLayoutY(20);
                nom.setLayoutX(150);
                nom.setLayoutY(10);
                pane2.getChildren().addAll(nomt,nom,panequantitet);
                Panes.add(pane2);
     } catch (Exception ex) {
  } finally {
                try {
                  //  F1.close();
                } catch (Exception ex) {
                    }
                }
        }
                  listcmntr.setPrefHeight(listcmntr.getHeight() + 1000);
            listcmntr.setPrefHeight(listcmntr.getWidth() + 1000);
           listcmntr.setItems(Panes);
                
} 
}

    

