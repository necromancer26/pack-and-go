/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;

import com.jfoenix.controls.JFXListView;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import static tn.edu.esprit.gui.FrontRestauController.index;
import tn.edu.esprit.models.Commentaire;
import tn.edu.esprit.models.Resteau;
import tn.edu.esprit.models.reservationR;
import tn.edu.esprit.services.CommentaireResteau;
import tn.edu.esprit.services.cReservationR;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class FrontReservController implements Initializable {
 public static int index = 0;
  public static int idusr = 0;
    public static int idRESERV = 0;

    @FXML
    private JFXListView<Pane> listeReserve;
    @FXML
    private TextField rechercheRestau;
    @FXML
    private Button rechercherRestauFront;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         listReserv();
    }    
      public void listReserv(){
                                       cReservationR RE = new cReservationR();
        ObservableList<Pane> Panes = FXCollections.observableArrayList();
        for (reservationR p3 :  RE.getListResteau())  {
           // System.out.println(p3);
            FileInputStream F1 = null;
            
                try{
                Pane pane = new Pane();
                pane.setStyle(" -fx-background-color: white");
                Pane pane2 = new Pane();
                pane2.setLayoutX(300);
                pane2.setLayoutY(300);
                pane2.setPrefWidth(pane2.getWidth() + 250);
                pane2.setPrefHeight(pane2.getHeight() + 150);
                pane2.setStyle("-fx-background-radius: 50;");
                pane2.setStyle(" -fx-border-radius: 10 10 10 10;-fx-border-color: #3f2b63;");
                final Button btnCommenter = new Button("delete");     
                btnCommenter.setStyle("-fx-alignment:right");
                btnCommenter.setStyle("-fx-background-color: #B0E0E6;");
                 btnCommenter.setLayoutX(520);
                 btnCommenter.setOnAction(event -> {
                     index=p3.getIdreservationR();

                 RE.supprimerReservationR(p3);  
    });
                                 pane2.getChildren().add(btnCommenter);
  final Button btnmodifier = new Button("modifier");     
                btnmodifier.setStyle("-fx-alignment:right");
                btnmodifier.setStyle("-fx-background-color: #B0E0E6;");
                btnmodifier.setLayoutX(450);
                btnmodifier.setOnAction(event -> {
                     Resteau.setIdd(p3.getIdR());
                  reservationR.setIdres(Resteau.getIdd());
                  
                  reservationR.setIdusr(p3.getId_user());
                  reservationR.setIdRESERV(p3.getIdreservationR());

                      index = p3.getIdR();
                      idusr=p3.getId_user();
                      idRESERV=p3.getIdreservationR();
                      

           URL fxURL = getClass().getResource("../gui/ModifReserv.fxml");
            Parent root;
                           try {
                               root = FXMLLoader.load(fxURL);
                          
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
           
            stage.show();
           Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
 } catch (IOException ex) {
                               Logger.getLogger(AfficherCommentaireFrontController.class.getName()).log(Level.SEVERE, null, ex);
                           }

         //  Panes.remove(pane2);
       //  inde=p3.getIdCommentaireR();
       //  C.supprimerCommentaireR(p3);
           

                
                              //CommentaireResteau C = new CommentaireResteau();

                           // Commentaire C1 = getTableView().getItems().get(getIndex());
                                                                 
                                                           
                       });
                
                pane2.getChildren().add(btnmodifier);
    Pane panequantitet = new Pane();
                panequantitet.setLayoutX(100);
                panequantitet.setLayoutY(40);
                panequantitet.setPrefWidth(panequantitet.getWidth() + 160);
                panequantitet.setPrefHeight(panequantitet.getHeight() + 30);
                Text quan1 = new Text("Nombre de personne : ");
                Label quant2 = new Label(String.valueOf(p3.getNbrPersonneR() ));
                quan1.setLayoutX(-5);
                quan1.setLayoutY(-25);
                quant2.setLayoutX(200);
                quant2.setLayoutY(-40);
                quan1.setStyle("-fx-font-weight: bold;-fx-fill : #26a69a;-fx-font-size:15px;");
                quant2.setStyle("-fx-font-weight: bold;-fx-fill : #26a69a;-fx-font-size:15px;");
                panequantitet.getChildren().addAll(quan1, quant2);
                Text nomt = new Text("Time: ");
                Label nom = new Label(p3.getTimeR());   
                Text dateT = new Text("date : ");
               
                Label date = new Label(p3.getDateR());   
               
                nomt.setLayoutX(100);
                nomt.setLayoutY(40);
                nom.setLayoutX(150);
                nom.setLayoutY(30);
                dateT.setLayoutX(100);
                dateT.setLayoutY(60);
                date.setLayoutX(150);
                date.setLayoutY(50);
               
               
                nomt.setStyle("-fx-font-weight: bold;-fx-fill : #26a69a");
                dateT.setStyle("-fx-font-weight: bold;-fx-fill : #26a69a");
               

                pane2.getChildren().addAll(nomt, dateT,nom,date, panequantitet);
                Panes.add(pane2);   
 } catch (Exception ex) {
            } finally {
                try {
                  F1.close();
                } catch (Exception ex) {
                }
            }
            listeReserve.setPrefHeight(listeReserve.getHeight() + 700);
            listeReserve.setPrefHeight(listeReserve.getWidth() + 700);
           listeReserve.setItems(Panes);

        }
    }
        @FXML
    private void getBack(MouseEvent event) {
        FXMLLoader LOADER = new FXMLLoader(getClass().getResource("AjouterReservationRFront.fxml"));
        try {
            Parent root = LOADER.load();
            Scene sc = new Scene(root);
            FrontRestauController cntr = LOADER.getController();
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(sc);
            window.show();
        } catch (Exception ex) {

        }
      
    }
}

