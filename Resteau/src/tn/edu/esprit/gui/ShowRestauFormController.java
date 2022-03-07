/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import java.io.IOException;
import java.net.URL;
import static java.nio.file.Files.list;
import static java.rmi.Naming.list;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
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
import tn.edu.esprit.models.Resteau;
import tn.edu.esprit.models.Commentaire;
import tn.edu.esprit.services.CommentaireResteau;
import tn.edu.esprit.services.ServiceResteau;
import tn.edu.esprit.utils.DataSource;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class ShowRestauFormController implements Initializable {

    @FXML
    private TableView<Resteau> TableViewRestau;
    @FXML
    private TableColumn<Resteau, String> coltypeR;
    @FXML
    private TableColumn<Resteau, String> colnomR;
    @FXML
    private TableColumn<Resteau, String> coladresseR;
    @FXML
    private TableColumn<Resteau, String> colPaysR;
    @FXML
    private TableColumn<Resteau, String> coltelR;
   ObservableList<Resteau> ResteaulList = FXCollections.observableArrayList();
    @FXML
    private TableColumn<Resteau, String> editcol;
    @FXML
    private TextField rechercheRestau;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        loadDate();
        editTableView();
        modifier();
        rechercheRestau();
                ServiceResteau sp = new ServiceResteau();
                ResteaulList =sp.getListResteau();
                TableViewRestau.setItems(ResteaulList);
                
    }    

    private void loadDate() {
        ServiceResteau sp = new ServiceResteau();
        ObservableList<Resteau> ResteaulList ;
        
        ResteaulList = sp.getListResteau();
        coltypeR.setCellValueFactory(new PropertyValueFactory<>("typeR"));
        colnomR.setCellValueFactory(new PropertyValueFactory<>("nomR"));
        coladresseR.setCellValueFactory(new PropertyValueFactory<>("adressR"));
        colPaysR.setCellValueFactory(new PropertyValueFactory<>("paysR"));
        coltelR.setCellValueFactory(new PropertyValueFactory<>("telR"));
       // colIdR.setCellValueFactory(new PropertyValueFactory <>("idR"));
        Callback<TableColumn<Resteau, String>, TableCell<Resteau, String>> cellFoctory = (TableColumn<Resteau, String> param) -> {
            final TableCell<Resteau, String> cell = new TableCell<Resteau, String>() {
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setGraphic(null);
                        setText(null);
                    } else {                      
                        final Button deleteButton = new Button("DELETE");
                        deleteButton.setOnAction(event -> {
                            Resteau R1 = getTableView().getItems().get(getIndex());
                            sp.supprimerR(R1);                                     
                            refrechRestau();                                   
                        });
                         final  Button commentaireButton = new Button("COMMENTAIRE");
                        commentaireButton.setOnAction(event -> {
                            CommentaireResteau C1 = new CommentaireResteau();
                            
                            
                            
 try{

            URL fxURL = getClass().getResource("../gui/ShowCommentaire.fxml");
            Parent root = FXMLLoader.load(fxURL);
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
           
            stage.show();

        } catch (IOException ex){
            System.out.println(ex.getMessage());
        }  
                              //CommentaireResteau C = new CommentaireResteau();

                           // Commentaire C1 = getTableView().getItems().get(getIndex());
                                                                 
                            refrechRestau();                                   
                       });
                        final Button editButton = new Button("UPDATE");
                        editButton.setOnAction(event -> {
                            modifier();
                        // Resteau R1 = getTableView().getItems().get(getIndex());
 /*  try{

            URL fxURL = getClass().getResource("../gui/modifierRestauForm.fxml");
            Parent root = FXMLLoader.load(fxURL);
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("modifier de Restau");
            stage.show();

        } catch (IOException ex){
            System.out.println(ex.getMessage());
        }    */                                                       

                 
                        });
                         HBox managebtn = new HBox(editButton, deleteButton,commentaireButton);
                        managebtn.setStyle("-fx-alignment:center");
                        setGraphic(managebtn);
                        setText(null);
                        }               
                    }

                private void refrechRestau() {
                                loadDate();
                 }
                };
            return cell;
        };
          
        editcol.setCellFactory(cellFoctory);  
        TableViewRestau.setItems(ResteaulList);

               
                
    }
     private void modifier() {
         Resteau R =TableViewRestau.getSelectionModel().getSelectedItem();
           ServiceResteau sp = new ServiceResteau();
                ResteaulList =sp.getListResteau();
                TableViewRestau.setItems(ResteaulList);
         try{
             sp.modifier(new Resteau (R.getTypeR(),R.getNomR(),R.getAdressR(),R.getPaysR(),R.getTelR()));
             Alert alert =new Alert(Alert.AlertType.INFORMATION);
             alert.show();
             alert.setTitle("updated");
             alert.setContentText("updated succesfully ");
         }catch (Exception e){
          

            System.out.println(e.getMessage());
        }  
         TableViewRestau.setItems(sp.getListResteau());
    }
        
public void editTableView(){
        TableViewRestau.setEditable(true);
       // tblChambres.setEditable(true);
        coltypeR.setCellFactory(TextFieldTableCell.forTableColumn());
        coltypeR.setOnEditCommit(e -> {
            e.getTableView().getItems().get(e.getTablePosition().getRow()).setTypeR(e.getNewValue());
        });
        colnomR.setCellFactory( TextFieldTableCell.forTableColumn());
        colnomR.setOnEditCommit(e -> {
            e.getTableView().getItems().get(e.getTablePosition().getRow()).setnomR(e.getNewValue());
        });
        coladresseR.setCellFactory(TextFieldTableCell.forTableColumn());        
        coladresseR.setOnEditCommit(e -> {
            e.getTableView().getItems().get(e.getTablePosition().getRow()).setAdressR(e.getNewValue());
        });
        colPaysR.setCellFactory(TextFieldTableCell.forTableColumn());        
        colPaysR.setOnEditCommit(e -> {
            e.getTableView().getItems().get(e.getTablePosition().getRow()).setPaysR(e.getNewValue());
        });
      
        coltelR.setCellFactory(TextFieldTableCell.forTableColumn());        
        coltelR.setOnEditCommit(e -> {
            e.getTableView().getItems().get(e.getTablePosition().getRow()).setTelR(e.getNewValue());
        });
     /*   
        colIdR.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));        
        colIdR.setOnEditCommit(e -> {
            e.getTableView().getItems().get(e.getTablePosition().getRow()).setIdR(e.getNewValue());
        });
      */
    }
    @FXML
    private void AjoutRestau(javafx.scene.input.MouseEvent event) {
        
    try{
            URL fxURL = getClass().getResource("../gui/RestauAddForm.fxml");
            Parent root = FXMLLoader.load(fxURL);
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Ajout de Restau");
            stage.show();

        } catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void refrechRestau(javafx.scene.input.MouseEvent event) {
          
                loadDate();
            }

    @FXML
     public void rechercheRestau(){
                ServiceResteau sp = new ServiceResteau();
    List<Resteau>results = new ArrayList<>();
    results = sp.getAll();
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
                                
				
                             
				     else  
				    	 return false; // Does not match.
			});
		});
		
		// 3. Wrap the FilteredList in a SortedList. 
		SortedList<Resteau> sortedData = new SortedList<>(filteredData);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(TableViewRestau.comparatorProperty());
		
		// 5. Add sorted (and filtered) data to the table.
		TableViewRestau.setItems(sortedData);
     }

    @FXML
    private void showList(MouseEvent event) {
         try{
            URL fxURL = getClass().getResource("../gui/AffichageReservationFormBack.fxml");
            Parent root = FXMLLoader.load(fxURL);
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Affichage Reservation");
            stage.show();

        } catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }
    }


                  
    


   

            
   


  

  
