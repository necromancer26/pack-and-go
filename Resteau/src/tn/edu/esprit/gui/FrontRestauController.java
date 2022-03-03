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
import static java.nio.file.Files.list;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import static javafx.scene.input.KeyCode.T;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import tn.edu.esprit.models.Commentaire;
import tn.edu.esprit.models.Resteau;
import tn.edu.esprit.models.reservationR;
import tn.edu.esprit.services.CommentaireResteau;
import tn.edu.esprit.services.ServiceResteau;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class FrontRestauController implements Initializable {
        public static int index = 0;
        public static int idd=0; 

    @FXML
    private Button rechercherRestauFront;
    @FXML
    private JFXListView<Pane> listViewRestau;
    @FXML
    private TextField rechercheRestau;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       listRestau(); 
    }
        public void listRestau(){
       // ObservableList<Pane> refresh = FXCollections.observableArrayList();
       // listViewRestau.setItems(refresh);
        ServiceResteau sp = new ServiceResteau();
        ObservableList<Pane> Panes = FXCollections.observableArrayList();
        for (Resteau p3 :  sp.getListResteau())  {
           // System.out.println(p3);
            FileInputStream F1 = null;
            try {
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
                final Button btnCommenter = new Button("Commentez");     
                btnCommenter.setStyle("-fx-alignment:right");
                btnCommenter.setStyle("-fx-background-color: #B0E0E6;");
                 btnCommenter.setLayoutX(520);
                 btnCommenter.setOnAction(event -> {try{
                Resteau.setIdd(p3.getIdR());
                  CommentaireResteau C = new CommentaireResteau();
             
              //r.setIdR(Resteau.getIdd());
              Commentaire.setIdres(Resteau.getIdd());

            URL fxURL = getClass().getResource("../gui/AddCmntrForm.fxml");
            Parent root = FXMLLoader.load(fxURL);
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
           
            stage.show();
           Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();


        } catch (IOException ex){
            System.out.println(ex.getMessage());
        }  
                
                              //CommentaireResteau C = new CommentaireResteau();

                           // Commentaire C1 = getTableView().getItems().get(getIndex());
                                                                 
                                                           
                       });
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                final Button btncommentaire = new Button("Voir commentaire");     
                btncommentaire.setStyle("-fx-alignment:right");
                btncommentaire.setStyle("-fx-background-color: #B0E0E6;");
                 btncommentaire.setLayoutX(320);
                 btncommentaire.setOnAction(event -> {
                     index = p3.getIdR();
                    FXMLLoader LOADER = new FXMLLoader(getClass().getResource("AfficherCommentaireFront.fxml"));
                    try {
                        Parent root = LOADER.load();
                        Scene sc = new Scene(root);
                        AfficherCommentaireFrontController cntr = LOADER.getController();
                        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        window.setScene(sc);
                        window.show();
                    } catch (Exception ex) {

                    }
                });
                
                 final Button btnreservation = new Button("reserver");     
                btnreservation.setStyle("-fx-alignment:right");
                btnreservation.setStyle("-fx-background-color: #B0E0E6;");
                btnreservation.setLayoutX(450);
                btnreservation.setOnAction(event -> {try{
                Resteau.setIdd(p3.getIdR());
                reservationR r =new reservationR ();
             
              //r.setIdR(Resteau.getIdd());
              reservationR.setIdres(Resteau.getIdd());

            URL fxURL = getClass().getResource("../gui/AjouterReservationRFront.fxml");
            Parent root = FXMLLoader.load(fxURL);
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
           
            stage.show();
           Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();


        } catch (IOException ex){
            System.out.println(ex.getMessage());
        }  
                
                              //CommentaireResteau C = new CommentaireResteau();

                           // Commentaire C1 = getTableView().getItems().get(getIndex());
                                                                 
                                                           
                       });
                
                pane2.getChildren().add(btncommentaire);
                pane2.getChildren().add(btnreservation);
                pane2.getChildren().add(btnCommenter);
               // String A = p3.getImage();
              /*  A = Hotel.filename;
                F1 = new  FileInputStream(A);
                Image image2 = new Image(F1);
                ImageView image = new ImageView(image2);
                image.setFitWidth(60);
                image.setFitHeight(60);
                image.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5), 8, 0, 0, 0);");
                image.setImage(image2);
                image.setLayoutX(10);
                image.setLayoutY(10);
                pane2.getChildren().add(image);*/
                Pane panequantitet = new Pane();
                panequantitet.setLayoutX(100);
                panequantitet.setLayoutY(40);
                panequantitet.setPrefWidth(panequantitet.getWidth() + 160);
                panequantitet.setPrefHeight(panequantitet.getHeight() + 30);
                Text quan1 = new Text("Nom : ");
                Label quant2 = new Label(String.valueOf(p3.getnomR() ));
                quan1.setLayoutX(-5);
                quan1.setLayoutY(-25);
                quant2.setLayoutX(50);
                quant2.setLayoutY(-40);
                quan1.setStyle("-fx-font-weight: bold;-fx-fill : #26a69a;-fx-font-size:15px;");
                quant2.setStyle("-fx-font-weight: bold;-fx-fill : #26a69a;-fx-font-size:15px;");
                panequantitet.getChildren().addAll(quan1, quant2);
                Text nomt = new Text("type: ");
                Label nom = new Label(p3.getTypeR());   
                Text prixt = new Text("id : ");
                Label prix = new Label(String.valueOf(p3.getIdR()));
                Text AdressT = new Text("adress : ");
                Label adress = new Label(p3.getAdressR());   
                Text payT = new Text("Pays : ");
                Label pay = new Label(p3.getPaysR());
                 Text telT = new Text(" Tel : ");
                Label tey = new Label(p3.getTelR());
                nomt.setLayoutX(100);
                nomt.setLayoutY(40);
                nom.setLayoutX(150);
                nom.setLayoutY(30);
                prixt.setLayoutX(100);
                prixt.setLayoutY(60);
                prix.setLayoutX(150);
                prix.setLayoutY(50);
                AdressT.setLayoutX(100);
                AdressT.setLayoutY(80);
                adress.setLayoutX(150);
                adress.setLayoutY(70);
                payT.setLayoutX(100);
                payT.setLayoutY(95);
                pay.setLayoutX(150);
                pay.setLayoutY(85);
                telT.setLayoutX(100);
                telT.setLayoutY(120);
                tey.setLayoutX(150);
                tey.setLayoutY(110);
                nomt.setStyle("-fx-font-weight: bold;-fx-fill : #26a69a");
                prixt.setStyle("-fx-font-weight: bold;-fx-fill : #26a69a");
                AdressT.setStyle("-fx-font-weight: bold;-fx-fill : #26a69a");
                payT.setStyle("-fx-font-weight: bold;-fx-fill : #26a69a");
                telT.setStyle("-fx-font-weight: bold;-fx-fill : #26a69a");

                pane2.getChildren().addAll(nomt, prixt,AdressT, payT,telT,nom, prix,adress,pay,tey, panequantitet);
                Panes.add(pane2);
                 } catch (Exception ex) {
                }
            } catch (Exception ex) {
            } finally {
                try {
                  //  F1.close();
                } catch (Exception ex) {
                }
            }
            listViewRestau.setPrefHeight(listViewRestau.getHeight() + 1000);
            listViewRestau.setPrefHeight(listViewRestau.getWidth() + 1000);
           listViewRestau.setItems(Panes);

        }
    }

 
     public void rechercheRestau(){
         /*  ServiceResteau sp = new ServiceResteau();
    List<Resteau>results = new ArrayList<>();
    results = sp.getAll();
            ObservableList<Resteau> ResteaulList = FXCollections.observableArrayList();

     FilteredList<Resteau> filteredData = new FilteredList<>(ResteaulList , b -> true);
		Resteau r = new Resteau();
		// 2. Set the filter Predicate whenever the filter changes.
		rechercheRestau.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(Resteau -> {
				// If filter text is empty, display all persons.
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (Resteau.getnomR().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
				} else if (Resteau.getTypeR().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				} else if (Resteau.getAdressR().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				}
                                
				else if (String.valueOf(r.getIdR()).indexOf(lowerCaseFilter)!=-1)
				     return true;
                             
				     else  
				    	 return false; // Does not match.
			});
		});
		
		// 3. Wrap the FilteredList in a SortedList. 
		SortedList<Resteau> sortedData = new SortedList<>(filteredData);

		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(listViewRestau.comparatorProperty());
		
		// 5. Add sorted (and filtered) data to the table.
		//listViewRestau.setItems(sortedData);
              
     }
     }
            */   
        
    }
}
        


