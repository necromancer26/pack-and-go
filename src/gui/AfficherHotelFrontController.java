/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import models.Chambre;
import models.Hotel;
import models.ReservationChambre;
import services.ServiceChambre;
import services.ServiceHotel;

/**
 * FXML Controller class
 *
 * @author dorsaf
 */
public class AfficherHotelFrontController implements Initializable {
    public static int index = 0;

    @FXML
    private ListView<Pane> listViewHotels;
    
    ServiceChambre sch = new ServiceChambre();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listHotels();

    }    

    public void listHotels(){
     //   ObservableList<Pane> refresh = FXCollections.observableArrayList();
      //  listViewHotels.setItems(refresh);
        ServiceHotel sh = new ServiceHotel();
        ObservableList<Pane> Panes = FXCollections.observableArrayList();
        for (Hotel p3 : sh.getListHotels()){
            FileInputStream F1 = null; 
            try {            
              //  pane.setStyle(" -fx-background-color: white");
                Pane pane2 = new Pane();
                pane2.setLayoutX(100);
                pane2.setLayoutY(100);
                pane2.setPrefWidth(pane2.getWidth() + 500);
                pane2.setPrefHeight(pane2.getHeight() + 500);
                pane2.setStyle("-fx-background-radius: 50;");
                pane2.setStyle(" -fx-border-radius: 10 10 10 10;-fx-border-color: #3f2b63;");
                
                final Button btnchambre = new Button("Voir chambres disponibles");     
                btnchambre.setStyle("-fx-alignment:right");
                btnchambre.setStyle("-fx-background-color: BLUE;");
                btnchambre.setStyle("-fx-font: 16px Serif;");
                btnchambre.setStyle("-fx-padding: 10;");
                btnchambre.setAlignment(Pos.CENTER_RIGHT);
                btnchambre.setStyle("-fx-background-color: #CCFF99;");
                pane2.getChildren().add(btnchambre);
                btnchambre.layoutYProperty();
                btnchambre.setOnAction(event -> {
                    index  = p3.getId_hotel();
                    FXMLLoader LOADER = new FXMLLoader(getClass().getResource("AfficherChambresFront.fxml"));
                    try {
                        Parent root = LOADER.load();
                        Scene sc = new Scene(root);
                        AfficherChambresFrontController cntr = LOADER.getController();
                        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        window.setScene(sc);
                        window.show();
                    } catch (Exception ex) {

                    }
                });      
                ImageView image = p3.getImg(); 
                image.setFitWidth(200);
                image.setFitHeight(200);
                image.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5), 8, 0, 0, 0);");
                image.setLayoutX(400);
                image.setLayoutY(200);
                pane2.getChildren().add(image);
                
                Text nomt = new Text("Hotel ");
                Label nom = new Label(p3.getNom_hotel());
                nomt.setLayoutX(70);
                nomt.setLayoutY(20);
                nom.setLayoutX(200);
                nom.setLayoutY(5);
              
                Text nbr_etoilest = new Text("Nbr etoiles ");
                Label nbr_etoiles = new Label(String.valueOf(p3.getNbr_etoiles() )+ "etoiles");
                nbr_etoilest.setLayoutX(70);
                nbr_etoilest.setLayoutY(40);
                nbr_etoiles.setLayoutX(200);
                nbr_etoiles.setLayoutY(25);
                
                
                Text nbr_chambrest = new Text("Nombre de chambre dispo : ");
                Label nbr_chambres = new Label(String.valueOf(p3.getNbr_chambres()));
                nbr_chambrest.setLayoutX(70);
                nbr_chambrest.setLayoutY(60);
                nbr_chambres.setLayoutX(200);
                nbr_chambres.setLayoutY(45);
                
                Text adresset = new Text("Adresse du l'hotel:  ");
                Label adresse = new Label(p3.getAdresse());            
                adresset.setLayoutX(70);
                adresset.setLayoutY(80);
                adresse.setLayoutX(200);
                adresse.setLayoutY(65);
              
                Text payst = new Text("PAYS  ");
                Label pays = new Label(p3.getPays());          
                payst.setLayoutX(70);
                payst.setLayoutY(100);
                pays.setLayoutX(200);
                pays.setLayoutY(85);
              
                Text telt = new Text("Telephone:  ");
                Label tel = new Label(String.valueOf(p3.getTel()));
                telt.setLayoutX(70);
                telt.setLayoutY(120);
                tel.setLayoutX(200);
                tel.setLayoutY(105);
              
                Text emailt = new Text("Email:  ");
                Label email = new Label(p3.getEmail());             
                emailt.setLayoutX(70);
                emailt.setLayoutY(140);
                email.setLayoutX(200);
                email.setLayoutY(125);        
              
                nomt.setStyle("-fx-font-weight: bold;-fx-fill : #ce3b67");
                nbr_chambrest.setStyle("-fx-font-weight: bold;-fx-fill : #ce3b67");
                nbr_etoilest.setStyle("-fx-font-weight: bold;-fx-fill : #ce3b67");
                adresset.setStyle("-fx-font-weight: bold;-fx-fill : #ce3b67");
                payst.setStyle("-fx-font-weight: bold;-fx-fill : #ce3b67");
                telt.setStyle("-fx-font-weight: bold;-fx-fill : #ce3b67");
                emailt.setStyle("-fx-font-weight: bold;-fx-fill : #ce3b67");
                pane2.getChildren().addAll(nomt, nbr_chambrest, nbr_etoilest, adresset, payst, emailt, telt, nom, nbr_etoiles, nbr_chambres, adresse, pays,tel,email);
                Panes.add(pane2);
            } catch (Exception ex) {
            } finally {
                try {
                    F1.close();
                } catch (Exception ex) {
                }
            }
            listViewHotels.setPrefHeight(listViewHotels.getHeight() + 800);
            listViewHotels.setPrefHeight(listViewHotels.getWidth() + 800);
            listViewHotels.setItems(Panes);
            
        }
    }
}