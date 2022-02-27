/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Background;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.converter.IntegerStringConverter;
import models.Chambre;
import models.Hotel;
import services.ServiceChambre;
import services.ServiceHotel;
/**
 * FXML Controller class
 *
 * @author dorsaf
 */
public class AfficherHotelsFormController implements Initializable {

    @FXML
    private TableView<Hotel> tblHotels;
    @FXML
    private TableColumn<Hotel, Integer> tblIdHotel;
    @FXML
    private TableColumn<Hotel, String> tblNomHotel;
    @FXML
    private TableColumn<Hotel, Integer> tblNbrEtoiles;
    @FXML
    private TableColumn<Hotel, Integer> tblNbrChambres;
    @FXML
    private TableColumn<Hotel, String> tblAdresse;
    @FXML
    private TableColumn<Hotel, String> tblPays;
    @FXML
    private TableColumn<Hotel, Integer> tblTel;
    @FXML
    private TableColumn<Hotel, String> tblEmail;
    @FXML
    private FontAwesomeIcon btnAjouterHotel;
    @FXML
    private FontAwesomeIcon closebtn;
    @FXML
    private FontAwesomeIcon btnRefresh;
    @FXML
    private TableColumn<Hotel, String> editCol;
    
    ServiceHotel sh = new ServiceHotel();
    ServiceChambre sch = new ServiceChambre();
    @FXML
    private TextField tfNum;
    @FXML
    private Button btnReset;
    @FXML
    private TextField tfType;
    @FXML
    private TextField tfEtage;
    @FXML
    private TextField tfPrix;
    @FXML
    private ComboBox<Integer> cbHotel;
    @FXML
    private Button btnAjouterChambre;
    @FXML
    private TableColumn<Chambre, Integer> tblIdChambre;
    @FXML
    private TableColumn<Chambre, Integer> tblNumChambre;
    @FXML
    private TableColumn<Chambre, String> tblType;
    @FXML
    private TableColumn<Chambre, Integer> tblEtage;
    @FXML
    private TableColumn<Chambre, Integer> tblPrix;
    @FXML
    private TableColumn<Chambre, String> tblHotelFK;
    @FXML
    private TableView<Chambre> tblChambres;
    @FXML
    private TableColumn<?, ?> delCol;
    @FXML
    private Button btnDel;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadData();
        
    }    

  /*  public TableView<Hotel> getTblHotels() {
        return tblHotels;
    }*/
   
    private void loadData() {
        ObservableList<Integer> ids ;
        ids = FillCombo();
        cbHotel.setItems(ids);
        
        tblHotels.refresh();
       
        ObservableList<Chambre> ChambreList;
        ChambreList = sch.getListchambres();
        ObservableList<Hotel> HotelList;     
        HotelList = sh.getListHotels();  
        
        tblIdHotel.setCellValueFactory(new PropertyValueFactory <>("id_hotel"));
        tblNomHotel.setCellValueFactory(new PropertyValueFactory <>("nom_hotel"));
        tblNbrEtoiles.setCellValueFactory(new PropertyValueFactory <>("nbr_etoiles"));
        tblNbrChambres.setCellValueFactory(new PropertyValueFactory <>("nbr_chambres"));
        tblAdresse.setCellValueFactory(new PropertyValueFactory <>("adresse"));
        tblPays.setCellValueFactory(new PropertyValueFactory <>("pays"));
        tblTel.setCellValueFactory(new PropertyValueFactory <>("tel"));
        tblEmail.setCellValueFactory(new PropertyValueFactory <>("email"));
        
        tblIdChambre.setCellValueFactory(new PropertyValueFactory <>("id_chambre"));
        tblNumChambre.setCellValueFactory(new PropertyValueFactory <>("num_chambre"));
        tblType.setCellValueFactory(new PropertyValueFactory <>("type_chambre"));
        tblEtage.setCellValueFactory(new PropertyValueFactory <>("etage"));
        tblPrix.setCellValueFactory(new PropertyValueFactory <>("prix"));
        tblHotelFK.setCellValueFactory(new PropertyValueFactory <>("id_hotel"));     
        
        tblHotels.setItems(HotelList);
        tblChambres.setItems(ChambreList);

        editTableView();      
        
        Callback<TableColumn<Hotel, String>, TableCell<Hotel, String>> cellFoctory = (TableColumn<Hotel, String> param) -> {
            final TableCell<Hotel, String> cell = new TableCell<Hotel, String>() {
                @Override
                public void updateItem(String item, boolean empty) {           
                    super.updateItem(item, empty);
                    if (empty) {
                        setGraphic(null);
                        setText(null);
                    }else {                      
                        final Button deleteButton = new Button("DELETE");
                        deleteButton.setOnAction(event -> {
                        Hotel h1 = getTableView().getItems().get(getIndex());
                        try{
                            sh.supprimer(h1.getId_hotel());                                     
                            Refresh();       
                        }catch (Exception e){
                            Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.show();
                            alert.setTitle("fail !");
                            alert.setContentText("cet hotel est lié a des chambres!");
                        }});
                        final Button editButton = new Button("UPDATE");
                        editButton.setOnAction(event -> {
                           modifierHotel();                         
                        });
                        HBox managebtn = new HBox(editButton, deleteButton);
                        managebtn.setStyle("-fx-alignment:center");
                        setGraphic(managebtn);
                        deleteButton.setStyle("-fx-background-color: RED;");
                        }               
                    }
                };
            return cell;
        };
        editCol.setCellFactory(cellFoctory);  
        tblHotels.setItems(HotelList);
    }
    
    
    @FXML
    private void getAjouterHotelForm(MouseEvent event) {
        try{
            URL fxURL = getClass().getResource("../gui/AjouterHotelForm.fxml");
            Parent root = FXMLLoader.load(fxURL);
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Ajouter un hotel");
            stage.show();

        } catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void close(MouseEvent event) {
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    private void refreshListHotels(MouseEvent event) {
        ObservableList<Hotel> HotelList ;
        HotelList = sh.getListHotels();   
        tblHotels.setItems(HotelList);
    }
    
    public void Refresh(){
        ObservableList<Hotel> HotelList ;
        HotelList = sh.getListHotels();   
        tblHotels.setItems(HotelList);
        ObservableList<Chambre> ChambreList;
        ChambreList = sch.getListchambres();
        tblChambres.setItems(ChambreList);
    }
     
    public void modifierHotel(){
        Hotel h = tblHotels.getSelectionModel().getSelectedItem();
        try{
            sh.modifier(new Hotel(h.getId_hotel(), h.getNom_hotel(), h.getNbr_etoiles(), h.getNbr_chambres(), h.getAdresse(), h.getPays(), h.getTel(), h.getEmail()));
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.show();
            alert.setTitle("updated !");
            alert.setContentText("updated succesfully");
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.show();
            alert.setTitle("fail !");
            alert.setContentText("failed");
        }
        tblHotels.setItems(sh.getListHotels());
    }
   
    public void editTableView(){
        tblHotels.setEditable(true);
        tblChambres.setEditable(true);
        tblNomHotel.setCellFactory(TextFieldTableCell.forTableColumn());
        tblNomHotel.setOnEditCommit(e -> {
            e.getTableView().getItems().get(e.getTablePosition().getRow()).setNom_hotel(e.getNewValue());
        });
        tblNbrEtoiles.setCellFactory( TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        tblNbrEtoiles.setOnEditCommit(e -> {
            e.getTableView().getItems().get(e.getTablePosition().getRow()).setNbr_etoiles(e.getNewValue());
        });
        tblNbrChambres.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));        
        tblNbrChambres.setOnEditCommit(e -> {
            e.getTableView().getItems().get(e.getTablePosition().getRow()).setNbr_chambres(e.getNewValue());
        });
        tblAdresse.setCellFactory(TextFieldTableCell.forTableColumn());        
        tblAdresse.setOnEditCommit(e -> {
            e.getTableView().getItems().get(e.getTablePosition().getRow()).setAdresse(e.getNewValue());
        });
        tblPays.setCellFactory(TextFieldTableCell.forTableColumn());        
        tblPays.setOnEditCommit(e -> {
            e.getTableView().getItems().get(e.getTablePosition().getRow()).setPays(e.getNewValue());
        });
        tblTel.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));        
        tblTel.setOnEditCommit(e -> {
            e.getTableView().getItems().get(e.getTablePosition().getRow()).setTel(e.getNewValue());
        });
        tblEmail.setCellFactory(TextFieldTableCell.forTableColumn());        
        tblEmail.setOnEditCommit(e -> {
            e.getTableView().getItems().get(e.getTablePosition().getRow()).setEmail(e.getNewValue());
        });     
        tblNumChambre.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));        
        tblNumChambre.setOnEditCommit(e -> {
            e.getTableView().getItems().get(e.getTablePosition().getRow()).setNum_chambre(e.getNewValue());
        });
        tblType.setCellFactory(TextFieldTableCell.forTableColumn());        
        tblType.setOnEditCommit(e -> {
            e.getTableView().getItems().get(e.getTablePosition().getRow()).setType_chambre(e.getNewValue());
        }); 
        tblTel.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));        
        tblTel.setOnEditCommit(e -> {
            e.getTableView().getItems().get(e.getTablePosition().getRow()).setTel(e.getNewValue());
        });
        tblEtage.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));        
        tblEtage.setOnEditCommit(e -> {
            e.getTableView().getItems().get(e.getTablePosition().getRow()).setEtage(e.getNewValue());
        });
        tblPrix.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));        
        tblPrix.setOnEditCommit(e -> {
            e.getTableView().getItems().get(e.getTablePosition().getRow()).setPrix(e.getNewValue());
        });
    }     

    // ---------------------- CHAMBRE ------------------------//
    private ObservableList<Integer> FillCombo(){
       return sh.getIds();
    }
    
    @FXML
    private void AjouterChambre(ActionEvent event) {
       Chambre ch = new Chambre(Integer.parseInt(tfNum.getText()) , tfType.getText() , Integer.parseInt(tfEtage.getText()) , Integer.parseInt(tfPrix.getText()), Integer.parseInt(cbHotel.getSelectionModel().getSelectedItem().toString()));
       ch.setId_hotel(ch.getId_hotel());
       sch.ajouter(ch);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Succes");
        alert.setHeaderText("Ajouté");
        alert.setContentText("Chambre ajouté avec succès!");                
        alert.showAndWait();
        clean();
    }

    @FXML
    public void deleteCh(){
       // int index = tblChambres.getSelectionModel().getSelectedIndex();
       // tblIdChambre.getCellData(index).toString();
        Chambre ch = (Chambre)tblChambres.getSelectionModel().getSelectedItem();
        try{
            sch.supprimer(ch.getId_chambre());                                     
            Refresh();       
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.show();
            alert.setTitle("fail !");
            alert.setContentText("cet hotel est lié a des chambres!");
        };
        
    }
    
    public void clean() {
        tfNum.setText(null);
        tfType.setText(null);
        tfEtage.setText(null);
        tfPrix.setText(null);        
    }
    
    @FXML
    private void resetFields2(ActionEvent event) {
        clean();
    }
     
     
  /* public void setListHotel(ObservableList<Hotel> list){
        sh.getListHotels();
        tblHotels.setItems(list);
    }*/
     
}
