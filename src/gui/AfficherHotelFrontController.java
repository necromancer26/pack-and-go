/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.FileInputStream;
import java.net.URL;
import java.util.ResourceBundle;
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
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import models.Hotel;
import org.controlsfx.control.Rating;
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
                Pane pane2 = new Pane();
                pane2.setLayoutX(400);
                pane2.setLayoutY(400);
                pane2.setPrefWidth(pane2.getWidth() + 750);
                pane2.setPrefHeight(pane2.getHeight() + 500);
            //    pane2.setStyle("-fx-background-radius: 50;");
                pane2.setStyle(" -fx-border-radius: 10 10 10 10;-fx-border-color: #B2DFDB; -fx-border-width: 2px; -fx-background-radius: 30;");
                
                final Button btnchambre = new Button("Voir chambres disponibles");     
                btnchambre.setStyle("-fx-font: 18px Serif;");
                btnchambre.setStyle("-fx-padding: 20;");
                btnchambre.setStyle("-fx-alignment:right;");
                btnchambre.setLayoutX(700);
                btnchambre.setLayoutY(60);
                btnchambre.setStyle("-fx-background-color: #80CBC4;");
                
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
                image.setFitWidth(400);
                image.setFitHeight(270);
                image.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5), 8, 0, 0, 0);");
                image.setLayoutX(400);
                image.setLayoutY(180);
                pane2.getChildren().add(image);
                
                Text nomt = new Text("HOTEL ");
                Label nom = new Label(p3.getNom_hotel());
                nomt.setLayoutX(125);
                nomt.setLayoutY(30);
                nomt.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-fill: #26A69A");
                nom.setLayoutX(250);
                nom.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: #00695C");
                nom.setLayoutY(5);
              
              //  Text nbr_etoilest = new Text("Nbr etoiles ");
              //  Label nbr_etoiles = new Label(String.valueOf(p3.getNbr_etoiles() )+ "etoiles");
              //  nbr_etoilest.setLayoutX(70);
              //  nbr_etoilest.setLayoutY(70);
                Rating nbr_etoiles = new Rating();
                double x = Double.valueOf(p3.getNbr_etoiles());
                nbr_etoiles.setRating(x);
                nbr_etoiles.setLayoutX(120);
                nbr_etoiles.setLayoutY(50);
                nbr_etoiles.setDisable(true);
                
                Text nbr_chambrest = new Text("Nombre de chambres: ");
                Label nbr_chambres = new Label(String.valueOf(p3.getNbr_chambres()));
                nbr_chambrest.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;-fx-fill : #26A69A");
                nbr_chambres.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;-fx-text-fill : #263238");;
                nbr_chambrest.setLayoutX(70);
                nbr_chambrest.setLayoutY(110);
                nbr_chambres.setLayoutX(300);
                nbr_chambres.setLayoutY(85);
                
                Text adresset = new Text("Adresse :  ");
                Label adresse = new Label(p3.getAdresse()); 
                adresset.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;-fx-fill : #26A69A");  
                adresse.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;-fx-text-fill : #263238");;
                adresset.setLayoutX(70);
                adresset.setLayoutY(150);
                adresse.setLayoutX(300);
                adresse.setLayoutY(125);
              
                Text payst = new Text("Pays:  ");
                Label pays = new Label(p3.getPays()); 
                payst.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;-fx-fill : #26A69A");               
                pays.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;-fx-text-fill : #263238");               
                payst.setLayoutX(70);
                payst.setLayoutY(190);
                pays.setLayoutX(300);
                pays.setLayoutY(165);
              
                Text telt = new Text("Telephone:  ");
                Label tel = new Label(String.valueOf(p3.getTel()));
                telt.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;-fx-fill : #26A69A");               
                tel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;-fx-text-fill : #263238");               
                telt.setLayoutX(70);
                telt.setLayoutY(230);
                tel.setLayoutX(300);
                tel.setLayoutY(205);
              
                Text emailt = new Text("Email:  ");
                Label email = new Label(p3.getEmail()); 
                emailt.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;-fx-fill : #26A69A");               
                email.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;-fx-text-fill : #263238");               
                emailt.setLayoutX(70);
                emailt.setLayoutY(270);
                email.setLayoutX(300);
                email.setLayoutY(245);        
              
                pane2.getChildren().addAll(nomt, nbr_chambrest, adresset, payst, emailt, telt, nbr_etoiles, nom, nbr_chambres, adresse, pays,tel,email);
                Panes.add(pane2);
                pane2.getChildren().add(btnchambre);
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