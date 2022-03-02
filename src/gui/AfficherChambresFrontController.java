/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
import  gui.AfficherHotelFrontController;
import static gui.AfficherHotelFrontController.index;
import java.io.FileInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import models.Chambre;
import models.Hotel;
import services.ServiceChambre;

/**
 * FXML Controller class
 *
 * @author dorsaf
 */
public class AfficherChambresFrontController implements Initializable {

    @FXML
    private ListView<Pane> listViewChambres;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listChambres();
    }    
    public void listChambres(){
        ObservableList<Pane> refresh = FXCollections.observableArrayList();
        listViewChambres.setItems(refresh);
        ServiceChambre sch = new ServiceChambre();
        ObservableList<Pane> Panes = FXCollections.observableArrayList();
        for (Chambre p3 : sch.getListchambresByID(index) ) {
            FileInputStream F1 = null;                    
            try {            
              //  pane.setStyle(" -fx-background-color: white");
                Pane pane2 = new Pane();
                pane2.setLayoutX(100);
                pane2.setLayoutY(100);
                pane2.setPrefWidth(pane2.getWidth() + 500);
                pane2.setPrefHeight(pane2.getHeight() + 500);
                pane2.setStyle("-fx-background-radius: 50;");
                pane2.setStyle("-fx-border-radius: 10 10 10 10;-fx-border-color: #3f2b63;");
                
             /*   final Button btnchambre = new Button("Voir chambres disponibles");     
                btnchambre.setStyle("-fx-alignment:right");
                btnchambre.setStyle("-fx-background-color: BLUE;");
                pane2.getChildren().add(btnchambre);
                btnchambre.layoutYProperty();
                btnchambre.setOnAction(event -> {
                    sch.getAll();
                });*/
                
                ImageView image = p3.getImg(); 
                image.setFitWidth(200);
                image.setFitHeight(200);
                image.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5), 8, 0, 0, 0);");
                image.setLayoutX(400);
                image.setLayoutY(200);
                pane2.getChildren().add(image);
                
                Text numt = new Text("Numéro de chambre ");
                Label num = new Label(String.valueOf(p3.getNum_chambre()));
                numt.setLayoutX(70);
                numt.setLayoutY(20);
                num.setLayoutX(200);
                num.setLayoutY(5);
              
                Text typet = new Text("Chambre ");
                Label type = new Label(p3.getType_chambre());
                typet.setLayoutX(70);
                typet.setLayoutY(40);
                type.setLayoutX(200);
                type.setLayoutY(25);              
                
                Text etaget = new Text("Se situe au " + p3.getEtage()+ "étage ");
                Label etage = new Label(String.valueOf(p3.getEtage()));
                etaget.setLayoutX(70);
                etaget.setLayoutY(60);
                etage.setLayoutX(200);
                etage.setLayoutY(45);
                
                Text prixt = new Text("PRIX:  ");
                Label prix = new Label(String.valueOf(p3.getPrix()));            
                prixt.setLayoutX(70);
                prixt.setLayoutY(80);
                prix.setLayoutX(200);
                prix.setLayoutY(65);              
              
                numt.setStyle("-fx-font-weight: bold;-fx-fill : #ce3b67");
                typet.setStyle("-fx-font-weight: bold;-fx-fill : #ce3b67");
                etaget.setStyle("-fx-font-weight: bold;-fx-fill : #ce3b67");
                prixt.setStyle("-fx-font-weight: bold;-fx-fill : #ce3b67");
                pane2.getChildren().addAll(numt, typet, etaget, prixt, num, type, etage, prix);
                Panes.add(pane2);
            } catch (Exception ex) {
            } finally {
                try {
                    F1.close();
                } catch (Exception ex) {
                }
            }
            listViewChambres.setPrefHeight(listViewChambres.getHeight() + 800);
            listViewChambres.setPrefHeight(listViewChambres.getWidth() + 800);
            listViewChambres.setItems(Panes);

        }
    }
    
}
