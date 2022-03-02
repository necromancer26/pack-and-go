/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import java.awt.image.BufferedImage;
import javafx.scene.image.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
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
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.converter.IntegerStringConverter;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import models.Chambre;
import models.Hotel;
import models.ReservationChambre;
import services.ServiceChambre;
import services.ServiceHotel;
import services.ServiceReservationChambre;
import static models.Hotel.filename;
import static models.Chambre.filenameCh;
import org.controlsfx.control.Rating;

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
    private ComboBox<String> cbHotel;
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
    private Button btnDel;
    @FXML
    private FontAwesomeIcon refreshChambres;
    @FXML
    private Button btnModif;
    @FXML
    private TextField tfNomHotel;
    @FXML
    private TextField tfNbrEtoiles;
    @FXML
    private TextField tfNbrChambres;
    @FXML
    private TextField tfAdresse;
    @FXML
    private TextField tfPays;
    @FXML
    private TextField tfTel;
    @FXML
    private TextField tfEmail;
    @FXML
    private Button btnAjouterHotel1;
    @FXML
    private Button btnReset1;
    @FXML
    private TableView<ReservationChambre> tblReservations;
    @FXML
    private TableColumn<ReservationChambre, Integer> tblNumReserv;
    @FXML
    private TableColumn<ReservationChambre, String> tblCheckin;
    @FXML
    private TableColumn<ReservationChambre, String> tblCheckout;
    @FXML
    private TableColumn<ReservationChambre, Integer> tblIdCh_fk;
    @FXML
    private Button btnDelReserv;
    @FXML
    private Button uploadImgHotel;
    @FXML
    private ImageView imgviewHotel;
        
    ServiceHotel sh = new ServiceHotel();
    ServiceChambre sch = new ServiceChambre();
    ServiceReservationChambre sres_ch = new ServiceReservationChambre();
    @FXML
    private TableColumn<ReservationChambre, String> delColR;
    @FXML
    private Button supprimerHotel;
    @FXML
    private Button editHotel;
    @FXML
    private TableColumn<Hotel, ImageView> imgCol;
    @FXML
    private Button uploadImgChambre;
    @FXML
    private ImageView imgviewChambre;
    @FXML
    private TableColumn<Chambre, ImageView> tblImageChambre;
    @FXML
    private Rating nbrEtoiles;
    private List<Hotel> hotels;
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
        this.hotels = sh.getAll();
        ObservableList<String> ids = FillCombo();
        cbHotel.setItems(ids);
        
        
        tblHotels.refresh();
       
        ObservableList<Chambre> ChambreList;
        ChambreList = sch.getListchambres();
        ObservableList<Hotel> HotelList;     
        HotelList = sh.getListHotels();  
        ObservableList<ReservationChambre> ReservationList;
        ReservationList = sres_ch.getListReservations();
        
        tblIdHotel.setCellValueFactory(new PropertyValueFactory <>("id_hotel"));
        tblNomHotel.setCellValueFactory(new PropertyValueFactory <>("nom_hotel"));
        tblNbrEtoiles.setCellValueFactory(new PropertyValueFactory <>("nbr_etoiles"));
        tblNbrChambres.setCellValueFactory(new PropertyValueFactory <>("nbr_chambres"));
        tblAdresse.setCellValueFactory(new PropertyValueFactory <>("adresse"));
        tblPays.setCellValueFactory(new PropertyValueFactory <>("pays"));
        tblTel.setCellValueFactory(new PropertyValueFactory <>("tel"));
        tblEmail.setCellValueFactory(new PropertyValueFactory <>("email"));
        imgCol.setCellValueFactory(new PropertyValueFactory <>("img"));
        
        tblIdChambre.setCellValueFactory(new PropertyValueFactory <>("id_chambre"));
        tblNumChambre.setCellValueFactory(new PropertyValueFactory <>("num_chambre"));
        tblType.setCellValueFactory(new PropertyValueFactory <>("type_chambre"));
        tblEtage.setCellValueFactory(new PropertyValueFactory <>("etage"));
        tblPrix.setCellValueFactory(new PropertyValueFactory <>("prix"));
        tblHotelFK.setCellValueFactory(new PropertyValueFactory <>("nom"));  
        
        tblImageChambre.setCellValueFactory(new PropertyValueFactory<>("img"));

        tblNumReserv.setCellValueFactory(new PropertyValueFactory <>("num_reservation"));
        tblCheckin.setCellValueFactory(new PropertyValueFactory<>("check_in"));
        tblCheckout.setCellValueFactory(new PropertyValueFactory<>("check_out"));
        tblIdCh_fk.setCellValueFactory(new PropertyValueFactory<>("id_chambre"));
        
        tblHotels.setItems(HotelList);
        tblChambres.setItems(ChambreList);
        tblReservations.setItems(ReservationList);

        editTableView();      
        
        
        Callback<TableColumn<ReservationChambre, String>, TableCell<ReservationChambre, String>> cellFoctory = (TableColumn<ReservationChambre, String> param) -> {
            final TableCell<ReservationChambre, String> cell = new TableCell<ReservationChambre, String>() {
                @Override
                public void updateItem(String item, boolean empty) {           
                    super.updateItem(item, empty);
                    if (empty) {
                        setGraphic(null);
                        setText(null);
                    }else {                      
                        final Button deleteButton = new Button("DELETE");
                        deleteButton.setOnAction(event -> {
                        ReservationChambre reserv1 = getTableView().getItems().get(getIndex());
                        try{
                            sres_ch.supprimer(reserv1.getNum_reservation());                                     
                            Refresh();       
                        }catch (Exception e){
                            Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.show();
                            alert.setTitle("fail !");
                            alert.setContentText("erreur de suppression!");
                        }});
                      /*  final Button editButton = new Button("UPDATE");
                        editButton.setOnAction(event -> {
                           modifierHotel();                         
                        });*/
                        HBox managebtn = new HBox(deleteButton);
                        managebtn.setStyle("-fx-alignment:center");
                        setGraphic(managebtn);
                        deleteButton.setStyle("-fx-background-color: RED;");
                        }               
                    }
                };
            return cell;
        };
        
        delColR.setCellFactory(cellFoctory);
        tblReservations.setItems(ReservationList);
    }
    
    @FXML
    private void AjouterHotel(ActionEvent event) {     
        if((tfNomHotel.getText().isEmpty()) || (tfNbrChambres.getText().isEmpty()) || (tfAdresse.getText().isEmpty()) || (tfPays.getText().isEmpty()) || (tfTel.getText().isEmpty()) || (tfEmail.getText().isEmpty())){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.show();
            alert.setTitle("fail !");
            alert.setContentText("Veuillez remplir tous les champs !");
        }else if (!tfTel.getText().matches("^[0-9]+$") || (tfTel.getText().length() < 6 )){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.show();
            alert.setTitle("fail !");
            alert.setContentText("insérer un numéro de tel valide!");
        }else if(!tfEmail.getText().matches("^.+@.+\\..+$")){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.show();
            alert.setTitle("fail !");
            alert.setContentText("Veuillez insérer un mail valide!");
        }else if (!tfNbrChambres.getText().matches("^[0-9]+$") || (tfNbrChambres.getText().length() > 1000 )){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.show();
            alert.setTitle("fail !");
            alert.setContentText("nombre de chambres non valides!");
        }else if (!tfPays.getText().matches("^[A-Za-z]+$") || (tfPays.getText().length() < 3)){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.show();
            alert.setTitle("fail !");
            alert.setContentText("Veuillez insérer un pays valide!");
        }
        else{
            int nbr= (int) nbrEtoiles.getRating();
            Hotel h = new Hotel(tfNomHotel.getText(),  nbr , Integer.parseInt(tfNbrChambres.getText()) , tfAdresse.getText() , tfPays.getText(), Integer.parseInt(tfTel.getText()), tfEmail.getText(), Hotel.filename );
            sh.ajouter(h);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Succes");
            alert.setHeaderText("Ajouté");
            alert.setContentText("Hotel ajouté avec succès!");                
            alert.showAndWait();
            cleanHotel();
            Refresh();         
        }      
    }
    
    @FXML
    private void uploadImageHotel(ActionEvent event) throws IOException {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("image", "*.jpeg","*.png" , "*.jpg"));
        File f = fc.showOpenDialog(null);
        if (f != null) {
            //System.out.println(fc.getName());
            String img = f.getAbsoluteFile().toURI().toString();
            Image image = new Image(img);
            imgviewHotel.setImage(image);
            String imagecomp = f.getAbsolutePath();
            System.out.println(imagecomp);
            Hotel.filename = filename + imagecomp;
            //source = new File(pathimage);
            //dest = new File(System.getProperty("user.dir") + "\\src\\com\\esprit\\img\\" + filename);
           // Hotel.filename = "C:\\Users\\dorsaf\\OneDrive\\Documents\\NetBeansProjects\\GestionsHotels\\uploads" + filename;
            //se.sendphp(fc.getAbsolutePath());
        }
        imgviewHotel.setFitHeight(150);
        imgviewHotel.setFitWidth(250);
        //..\img\google.png
        //C:\Users\splin\Documents\NetBeansProjects\FanArt\\com\esprit\img
        Hotel.pathfile = f.getAbsolutePath();    
            
    }
         
    private void cleanHotel() {
        tfNomHotel.setText(null);
        tfNbrEtoiles.setText(null);
        tfNbrChambres.setText(null);
        tfAdresse.setText(null);
        tfPays.setText(null);
        tfTel.setText(null);
        tfEmail.setText(null);
        imgviewHotel.setImage(null);
        
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
     public void modifierHotel(){
        Hotel h = tblHotels.getSelectionModel().getSelectedItem();
        try{
            sh.modifier(new Hotel(h.getId_hotel(), h.getNom_hotel(), h.getNbr_etoiles(), h.getNbr_chambres(), h.getAdresse(), h.getPays(), h.getTel(), h.getEmail(), Hotel.filename));
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.show();
            alert.setTitle("updated !");
            alert.setContentText("updated succesfully");
            Refresh();
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

    
    
    @FXML
    private void deleteHotel(ActionEvent event) {
        Alert alert2 = new Alert(Alert.AlertType.CONFIRMATION);
        alert2.setTitle("Confirmation");
        alert2.setHeaderText("voulez vous supprimer cet hotel?");
        Optional<ButtonType> result = alert2.showAndWait();
        if (result.get() == ButtonType.OK) {
            Hotel h1 = (Hotel)tblHotels.getSelectionModel().getSelectedItem();
            try{
                sh.supprimer(h1.getId_hotel());                                     
                Refresh();       
            }catch (Exception e){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.show();
                alert.setTitle("Erreur !");
                alert.setContentText("Veuillez selectionnez un hotel!");
            };
        }else{
            alert2.close();
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
        ObservableList<ReservationChambre> ReservationList;
        ReservationList = sres_ch.getListReservations();
        tblReservations.setItems(ReservationList);

    }

    // ---------------------- CHAMBRE ------------------------//
    private ObservableList<String> FillCombo(){
        ObservableList<String> names = FXCollections.observableArrayList();
        this.hotels.forEach(hotel -> {
            names.add(hotel.getNom_hotel());
        });
       return names;
    }
    
    @FXML
    private void AjouterChambre(ActionEvent event) {
        int index = cbHotel.getSelectionModel().getSelectedIndex();
        Hotel hotel = this.hotels.get(index);
       Chambre ch = new Chambre(Integer.parseInt(tfNum.getText()) , tfType.getText() , Integer.parseInt(tfEtage.getText()) , Integer.parseInt(tfPrix.getText()), Chambre.filenameCh, hotel.getId_hotel());
       ch.setId_hotel(ch.getId_hotel());
       sch.ajouter(ch);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Succes");
        alert.setHeaderText("Ajouté");
        alert.setContentText("Chambre ajouté avec succès!");                
        alert.showAndWait();
        cleanCh();
        Refresh();
    }

    public void cleanCh() {
        tfNum.setText(null);
        tfType.setText(null);
        tfEtage.setText(null);
        tfPrix.setText(null);        
    }
    
    @FXML
    private void resetFields2(ActionEvent event) {
        cleanCh();
    } 
    
    @FXML
    public void deleteCh(){
       // int index = tblChambres.getSelectionModel().getSelectedIndex();
       // tblIdChambre.getCellData(index).toString();
       Alert alert2 = new Alert(Alert.AlertType.CONFIRMATION);
        alert2.setTitle("Confirmation");
        alert2.setHeaderText("voulez vous supprimer cet chambre?");
        Optional<ButtonType> result = alert2.showAndWait(); 
       if (result.get() == ButtonType.OK) {
            Chambre ch = (Chambre)tblChambres.getSelectionModel().getSelectedItem();
            try{
                sch.supprimer(ch.getId_chambre());                                     
                Refresh();       
            }catch (Exception e){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.show();
                alert.setTitle("Erreur !");
                alert.setContentText("Veuillez selectionnez une chambre!");
            }
       }else{
           alert2.close();
       }
        
        
    }   
     
  /* public void setListHotel(ObservableList<Hotel> list){
        sh.getListHotels();
        tblHotels.setItems(list);
    }*/

    @FXML
    private void refreshListChambres(MouseEvent event) {
        ObservableList<Chambre> ChambresList ;
        ChambresList = sch.getListchambres();
        tblChambres.setItems(ChambresList);
    }

    @FXML
    private void modifierChambre(ActionEvent event) {
        Chambre ch = tblChambres.getSelectionModel().getSelectedItem();
        try{
            sch.modifier(new Chambre(ch.getId_chambre(), ch.getNum_chambre(), ch.getType_chambre(), ch.getEtage(), ch.getPrix(), ch.filenameCh, ch.getId_hotel()));
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.show();
            alert.setTitle("updated !");
            alert.setContentText("updated succesfully");
            Refresh();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.show();
            alert.setTitle("fail !");
            alert.setContentText("failed");
        }
        tblChambres.setItems(sch.getListchambres());
    }

    @FXML
    private void resetFields(ActionEvent event) {
        cleanHotel();
    }
 
    // ----------------- RESERVATIONS ----------------- //

    @FXML
    private void deleteReserv(ActionEvent event) {
        Alert alert2 = new Alert(Alert.AlertType.CONFIRMATION);
        alert2.setTitle("Confirmation");
        alert2.setHeaderText("voulez vous supprimer cet réservation?");
        Optional<ButtonType> result = alert2.showAndWait();
        if (result.get() == ButtonType.OK) {
        ReservationChambre ReservCh = (ReservationChambre)tblReservations.getSelectionModel().getSelectedItem();
            try{
                sres_ch.supprimer(ReservCh.getNum_reservation());                                     
                Refresh();       
            }catch (Exception e){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.show();
                alert.setTitle("Erreur !");
                alert.setContentText("Veuillez selectionnez une reservation!");
            };
        }else{
            alert2.close();
        }
    }

    @FXML
    private void uploadImageChambre(ActionEvent event) {
       FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("image", "*.jpeg","*.png" , "*.jpg"));
        File f = fc.showOpenDialog(null);
        if (f != null) {
            String img = f.getAbsoluteFile().toURI().toString();
            Image image = new Image(img);
            imgviewChambre.setImage(image);
            String imagecomp = f.getAbsolutePath();
            System.out.println(imagecomp);
            Chambre.filenameCh = filenameCh + imagecomp;
            Chambre.pathfileCh = f.getAbsolutePath();
        }
        imgviewChambre.setFitHeight(150);
        imgviewChambre.setFitWidth(250);
    }


   
    
}
