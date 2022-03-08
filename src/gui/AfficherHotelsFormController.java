/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
import javafx.event.EventHandler;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.scene.image.Image;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.SQLException;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.print.PageLayout;
import javafx.print.PageOrientation;
import javafx.print.Paper;
import javafx.print.Printer;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.converter.IntegerStringConverter;
import models.Chambre;
import models.Hotel;
import models.ReservationChambre;
import services.ServiceChambre;
import services.ServiceHotel;
import services.ServiceReservationChambre;
import static models.Hotel.filename;
import static models.Hotel.pathfile;
import static models.Chambre.filenameCh;
import static models.Chambre.pathfileCh;
import models.User;
import org.controlsfx.control.Notifications;
import org.controlsfx.control.Rating;
import services.ServiceUser;

/**
 * FXML Controller class
 *
 * @author dorsaf
 */
public class AfficherHotelsFormController implements Initializable {
    @FXML
    private TableView<Hotel> tblHotels;
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
    private TextField tfNbrEtoiles;
    @FXML
    private TextField tfNbrChambres;
    @FXML
    private TextField tfAdresse;
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
    private TableColumn<ReservationChambre, String> tblIdCh_fk;
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
    @FXML
    private TextField tfRechercheHotel;
    /**
     * Initializes the controller class.
     */
    ObservableList<Chambre> ChambreList;
    ObservableList<Hotel> HotelList;     
    @FXML
    private TableColumn<ReservationChambre, String> id_user;
    
    ObservableList<String> ids ;
    @FXML
    private TextField tfRechercheCh;
    @FXML
    private Button tfSortHotels;
    @FXML
    private ComboBox<String> cbPays;
    @FXML
    private TableColumn<ReservationChambre, Integer> tblHotelReserv;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadData();
       
        
    }  
   
    private void loadData() {
        this.hotels = sh.getAll();
        ids= FillCombo();
        cbHotel.setItems(ids);
        
        tblHotels.refresh();
       
        ChambreList = sch.getListchambres();
        HotelList = sh.getListHotels();  
        ObservableList<ReservationChambre> ReservationList;
        ReservationList = sres_ch.getListReservations();
        
        tblNomHotel.setCellValueFactory(new PropertyValueFactory <>("nom_hotel"));
        tblNbrEtoiles.setCellValueFactory(new PropertyValueFactory <>("nbr_etoiles"));
        tblNbrChambres.setCellValueFactory(new PropertyValueFactory <>("nbr_chambres"));
        tblAdresse.setCellValueFactory(new PropertyValueFactory <>("adresse"));
        tblPays.setCellValueFactory(new PropertyValueFactory <>("pays"));
        tblTel.setCellValueFactory(new PropertyValueFactory <>("tel"));
        tblEmail.setCellValueFactory(new PropertyValueFactory <>("email"));
        imgCol.setCellValueFactory(new PropertyValueFactory <>("img"));
        
        tblHotelFK.setCellValueFactory(cellData -> 
        new SimpleStringProperty(sh.getNomByIDHotel(cellData.getValue().getId_hotel())));
 
        tblNumChambre.setCellValueFactory(new PropertyValueFactory <>("num_chambre"));
        tblType.setCellValueFactory(new PropertyValueFactory <>("type_chambre"));
        tblEtage.setCellValueFactory(new PropertyValueFactory <>("etage"));
        tblPrix.setCellValueFactory(new PropertyValueFactory <>("prix"));
        
        tblImageChambre.setCellValueFactory(new PropertyValueFactory<>("img"));
        tblNumReserv.setCellValueFactory(new PropertyValueFactory <>("num_reservation"));
        tblCheckin.setCellValueFactory(new PropertyValueFactory<>("check_in"));
        tblCheckout.setCellValueFactory(new PropertyValueFactory<>("check_out"));
        
        tblIdCh_fk.setCellValueFactory(cellData -> 
        new SimpleStringProperty(sch.getNomByID(cellData.getValue().getId_chambre())));

        tblHotelReserv.setCellValueFactory(cellData -> 
        new SimpleIntegerProperty(sch.getChambreByID(cellData.getValue().getId_chambre()).getNum_chambre()).asObject());
        
        tblHotels.setItems(HotelList);
        tblChambres.setItems(ChambreList);
        tblReservations.setItems(ReservationList);

        editTableView();      
        
        ObservableList<String> cities = FXCollections.observableArrayList();
        String[] locales1 = Locale.getISOCountries();
        for (String countrylist : locales1) {
            Locale obj = new Locale("", countrylist);
            String[] city = { obj.getDisplayCountry() };
            for (int x = 0; x < city.length; x++) {
                cities.add(obj.getDisplayCountry());
            }
        }
        cbPays.setItems(cities);
        
     /*  int size = (int) (Math.random() * 100);
    Integer[] result = new Integer[size];

    for (int i = 0; i < result.length; i++) {
        result[i] = (int) (Math.random() * 50);

    }
            countires.getItems().addAll(result);*/

        
       /* Callback<TableColumn<ReservationChambre, String>, TableCell<ReservationChambre, String>> cellFoctory = (TableColumn<ReservationChambre, String> param) -> {
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
                            alert.setTitle("fail !");
                            alert.setContentText("erreur de suppression!");
                            DialogPane dialogPane = alert.getDialogPane();
                            dialogPane.getStylesheets().add(getClass().getResource("bootstrap.css").toExternalForm());
                            dialogPane.getStyleClass().add("errDialog");
                            alert.showAndWait();
                        }});
                      /*  final Button editButton = new Button("UPDATE");
                        editButton.setOnAction(event -> {
                           modifierHotel();                         
                        });
                        HBox managebtn = new HBox(deleteButton);
                        managebtn.setStyle("-fx-alignment:center");
                        setGraphic(managebtn);
                        deleteButton.setStyle("-fx-background-color: RED;");
                        }               
                    }
                };
            return cell;
        };
        
        delColR.setCellFactory(cellFoctory);*/     
    
    }
    
    @FXML
    private void AjouterHotel(ActionEvent event) {    
        
        if((tfNomHotel.getText().isEmpty()) || (tfNbrChambres.getText().isEmpty()) || (tfAdresse.getText().isEmpty()) || (cbPays.getValue().isEmpty()) || (tfTel.getText().isEmpty()) || (tfEmail.getText().isEmpty())){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("fail !");
            alert.setContentText("Veuillez remplir tous les champs !");
            DialogPane dialogPane = alert.getDialogPane();
            dialogPane.getStylesheets().add(getClass().getResource("bootstrap.css").toExternalForm());
            dialogPane.getStyleClass().add("errDialog");
            alert.showAndWait();
        }else if (!tfTel.getText().matches("^[0-9]+$") || (tfTel.getText().length() < 6 )){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("fail !");
            alert.setContentText("insérer un numéro de tel valide!");
            DialogPane dialogPane = alert.getDialogPane();
            dialogPane.getStylesheets().add(getClass().getResource("bootstrap.css").toExternalForm());
            dialogPane.getStyleClass().add("errDialog");
            alert.showAndWait();
        }else if(!tfEmail.getText().matches("^.+@.+\\..+$")){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("fail !");
            alert.setContentText("Veuillez insérer un mail valide!");
            DialogPane dialogPane = alert.getDialogPane();
            dialogPane.getStylesheets().add(getClass().getResource("bootstrap.css").toExternalForm());
            dialogPane.getStyleClass().add("errDialog");
            alert.showAndWait();
        }else if (!tfNbrChambres.getText().matches("^[0-9]+$") || (tfNbrChambres.getText().length() > 1000 )){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("fail !");
            alert.setContentText("nombre de chambres non valides!");
            DialogPane dialogPane = alert.getDialogPane();
            dialogPane.getStylesheets().add(getClass().getResource("bootstrap.css").toExternalForm());
            dialogPane.getStyleClass().add("errDialog");
            alert.showAndWait();
        }
        else{
            int nbr= (int) nbrEtoiles.getRating();
            Hotel h = new Hotel(tfNomHotel.getText(),  nbr , Integer.parseInt(tfNbrChambres.getText()) , tfAdresse.getText() , cbPays.getValue(), Integer.parseInt(tfTel.getText()), tfEmail.getText(), Hotel.pathfile );
            sh.ajouter(h);
            cleanHotel();
            Refresh();
            Notifications notificationBuilder = Notifications.create()
                    .title("Alert").text("Hotel ajouté avec succès").graphic(null).hideAfter(javafx.util.Duration.seconds(5))
                    .position(Pos.CENTER)
                    .onAction(new EventHandler<ActionEvent>(){
                        @Override
                        public void handle(ActionEvent event) {
                            System.out.println("clicked on");
                        }
                    });         
            notificationBuilder.show();
        }      
    }
    
    @FXML
    private void uploadImageHotel(ActionEvent event) throws IOException {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("image", "*.jpeg","*.png" , "*.jpg"));
        File f = fc.showOpenDialog(null);
        if (f != null) {
            String img = f.getAbsoluteFile().toURI().toString();
            Image image = new Image(img);
            imgviewHotel.setImage(image);
            pathfile = f.getAbsolutePath();
            filename = f.getAbsolutePath();
            String path = "uploads\\";
            File uploads = new File(path);
            String imagecomp = f.getAbsolutePath();
            int index = imagecomp.lastIndexOf('\\');
            if (index > 0) {
                  pathfile = imagecomp.substring(index + 1);
            }          
            File sf = null;
            sf = new File(filename);
            File dest = null;
            Random rand = new Random();
            int n = rand.nextInt(50);
            String newpath =  path + pathfile ;
            dest = new File(newpath);
            Files.copy(sf.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
            pathfile =  newpath ;
            System.out.println(pathfile);
        }     
        imgviewHotel.setFitHeight(135);
        imgviewHotel.setFitWidth(270);    
    }
         
    private void cleanHotel() {
        tfNomHotel.setText(null);
        tfNbrChambres.setText(null);
        tfAdresse.setText(null);
        tfTel.setText(null);
        tfEmail.setText(null);
        imgviewHotel.setImage(null);
        
    }
    
    
    @FXML
     public void modifierHotel(){
        Hotel h = tblHotels.getSelectionModel().getSelectedItem();
        try{
            sh.modifier(new Hotel(h.getId_hotel(), h.getNom_hotel(), h.getNbr_etoiles(), h.getNbr_chambres(), h.getAdresse(), h.getPays(), h.getTel(), h.getEmail()));
            Notifications notificationBuilder = Notifications.create()
                    .title("Alert Succès").text("Modification effectuée!").graphic(null).hideAfter(javafx.util.Duration.seconds(5))
                    .position(Pos.CENTER)
                    .onAction(new EventHandler<ActionEvent>(){
                        @Override
                        public void handle(ActionEvent event) {
                            System.out.println("clicked on");
                        }
                    });
            notificationBuilder.show();
            Refresh();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur !");
            alert.setContentText("Veuillez selectionner un hotel!");
            DialogPane dialogPane = alert.getDialogPane();
            dialogPane.getStylesheets().add(getClass().getResource("bootstrap.css").toExternalForm());
            dialogPane.getStyleClass().add("errDialog");
            alert.showAndWait();
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
                Notifications notificationBuilder = Notifications.create()
                    .title("Alert succès").text("Hotel supprimé avec succès").graphic(null).hideAfter(javafx.util.Duration.seconds(5))
                    .position(Pos.CENTER)
                    .onAction(new EventHandler<ActionEvent>(){
                        @Override
                        public void handle(ActionEvent event) {
                            System.out.println("clicked on");
                        }
                    });
            notificationBuilder.show();
            Refresh();       
            }catch (Exception e){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur !");
                alert.setContentText("Veuillez selectionnez un hotel!");
                DialogPane dialogPane = alert.getDialogPane();
                dialogPane.getStylesheets().add(getClass().getResource("bootstrap.css").toExternalForm());
                dialogPane.getStyleClass().add("errDialog");
                alert.showAndWait();
            }
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
        this.hotels = sh.getAll();
        ids = FillCombo();
        cbHotel.setItems(ids);

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
        if((tfNum.getText().isEmpty()) || (tfType.getText().isEmpty()) || (tfEtage.getText().isEmpty()) || (tfPrix.getText().isEmpty())) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur !");
            alert.setContentText("Veuillez remplir tous les champs !");
            DialogPane dialogPane = alert.getDialogPane();
            dialogPane.getStylesheets().add(getClass().getResource("bootstrap.css").toExternalForm());
            dialogPane.getStyleClass().add("errDialog");
            alert.showAndWait();
        }
        else if(!tfNum.getText().matches("^[0-9]+$")){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur !");
            alert.setContentText("Veuillez insérer un numero de chambre valide!");
            DialogPane dialogPane = alert.getDialogPane();
            dialogPane.getStylesheets().add(getClass().getResource("bootstrap.css").toExternalForm());
            dialogPane.getStyleClass().add("errDialog");
            alert.showAndWait();
        }else if(!tfEtage.getText().matches("^[0-9]+$")){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur !");
            alert.setContentText("Veuillez insérer un numero d'étage!");
            DialogPane dialogPane = alert.getDialogPane();
            dialogPane.getStylesheets().add(getClass().getResource("bootstrap.css").toExternalForm());
            dialogPane.getStyleClass().add("errDialog");
            alert.showAndWait();
        }else if(!tfPrix.getText().matches("^[0-9]+$")){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur !");
            alert.setContentText("Veuillez insérer un prix!");
            DialogPane dialogPane = alert.getDialogPane();
            dialogPane.getStylesheets().add(getClass().getResource("bootstrap.css").toExternalForm());
            dialogPane.getStyleClass().add("errDialog");
            alert.showAndWait();                
        }else{
            int index = cbHotel.getSelectionModel().getSelectedIndex();
            Hotel hotel = this.hotels.get(index);
            Chambre ch = new Chambre(Integer.parseInt(tfNum.getText()) , tfType.getText() , Integer.parseInt(tfEtage.getText()) , Integer.parseInt(tfPrix.getText()), Chambre.pathfileCh, hotel.getId_hotel());
            ch.setId_hotel(ch.getId_hotel());
            sch.ajouter(ch);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            Notifications notificationBuilder = Notifications.create()
                    .title("Alert Succès").text("Chambre ajoutée avec succès!").graphic(null).hideAfter(javafx.util.Duration.seconds(5))
                    .position(Pos.CENTER)
                    .onAction(new EventHandler<ActionEvent>(){
                        @Override
                        public void handle(ActionEvent event) {
                            System.out.println("clicked on");
                        }
                    });
                notificationBuilder.show();         
            cleanCh();
            Refresh();
            
        }
    }

    public void cleanCh() {
        tfNum.setText(null);
        tfType.setText(null);
        tfEtage.setText(null);
        tfPrix.setText(null);        
        imgviewChambre.setImage(null);
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
        alert2.setHeaderText("voulez vous supprimer cette chambre?");
        Optional<ButtonType> result = alert2.showAndWait(); 
       if (result.get() == ButtonType.OK) {
            Chambre ch = (Chambre)tblChambres.getSelectionModel().getSelectedItem();
            try{
                sch.supprimer(ch.getId_chambre());  
                Notifications notificationBuilder = Notifications.create()
                    .title("Alert Succès").text("Chambre supprimée!").graphic(null).hideAfter(javafx.util.Duration.seconds(5))
                    .position(Pos.CENTER)
                    .onAction(new EventHandler<ActionEvent>(){
                        @Override
                        public void handle(ActionEvent event) {
                            System.out.println("clicked on");
                        }
                    });
                notificationBuilder.show();
                Refresh();       
            }catch (Exception e){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur !");
                alert.setContentText("Veuillez selectionnez une chambre!");
                DialogPane dialogPane = alert.getDialogPane();
                dialogPane.getStylesheets().add(getClass().getResource("bootstrap.css").toExternalForm());
                dialogPane.getStyleClass().add("errDialog");
                alert.showAndWait();
            }
       }else{
           alert2.close();
       }   
    }   

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
            sch.modifier(new Chambre(ch.getId_chambre(), ch.getNum_chambre(), ch.getType_chambre(), ch.getEtage(), ch.getPrix(), ch.getId_hotel()));
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            Notifications notificationBuilder = Notifications.create()
                    .title("Alert Succès").text("Modification effectuée!").graphic(null).hideAfter(javafx.util.Duration.seconds(5))
                    .position(Pos.CENTER)
                    .onAction(new EventHandler<ActionEvent>(){
                        @Override
                        public void handle(ActionEvent event) {
                            System.out.println("clicked on");
                        }
                    });
                notificationBuilder.show();
            Refresh();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur de modification!");
                alert.setContentText("Veuillez selectionnez une chambre!");
                DialogPane dialogPane = alert.getDialogPane();
                dialogPane.getStylesheets().add(getClass().getResource("bootstrap.css").toExternalForm());
                dialogPane.getStyleClass().add("errDialog");
                alert.showAndWait();
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
                Notifications notificationBuilder = Notifications.create()
                    .title("Alert succès").text("Hotel supprimé avec succès").graphic(null).hideAfter(javafx.util.Duration.seconds(5))
                    .position(Pos.CENTER)
                    .onAction(new EventHandler<ActionEvent>(){
                        @Override
                        public void handle(ActionEvent event) {
                            System.out.println("clicked on");
                        }
                    });
                notificationBuilder.show();
            }catch (Exception e){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur de suppresion!");
                alert.setContentText("Veuillez selectionnez une reservation!");
                DialogPane dialogPane = alert.getDialogPane();
                dialogPane.getStylesheets().add(getClass().getResource("bootstrap.css").toExternalForm());
                dialogPane.getStyleClass().add("errDialog");
                alert.showAndWait();
            };
        }else{
            alert2.close();
        }
    }

    @FXML
    private void uploadImageChambre(ActionEvent event) throws IOException {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("image", "*.jpeg","*.png" , "*.jpg"));
        File f = fc.showOpenDialog(null);
        if (f != null) {
            String img = f.getAbsoluteFile().toURI().toString();
            Image image = new Image(img);
            imgviewChambre.setImage(image);
            pathfileCh = f.getAbsolutePath();
            filenameCh = f.getAbsolutePath();
            String path = "uploads\\";
            File uploads = new File(path);
            String imagecomp = f.getAbsolutePath();
            int index = imagecomp.lastIndexOf('\\');
            if (index > 0) {
                  pathfileCh = imagecomp.substring(index + 1);
            }          
            File sf = null;
            sf = new File(filenameCh);
            File dest = null;
            Random rand = new Random();
            int n = rand.nextInt(50);
            String newpath =  path + pathfileCh ;
            dest = new File(newpath);
            Files.copy(sf.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
            pathfileCh =  newpath ;
        }  
    }


    @FXML
    private void rechercherHotel(KeyEvent event) {
        FilteredList<Hotel> filteredData = new FilteredList<>(HotelList , b -> true);
        //  Set the filter Predicate whenever the filter changes.
        tfRechercheHotel.textProperty().addListener(( observable, oldValue, newValue) -> {
            filteredData.setPredicate(Hotel -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                final String lowerCaseFilter = newValue.toLowerCase();
                if (Hotel.getNom_hotel().toLowerCase().startsWith(lowerCaseFilter) ) {
                    return true;
                } else if (String.valueOf(Hotel.getId_hotel()).toLowerCase().startsWith(lowerCaseFilter)) {
                    return true; // Filter matches last name.
                } else if (Hotel.getAdresse().toLowerCase().startsWith(lowerCaseFilter)) {
                    return true; 
                } else if( Hotel.getPays().toLowerCase().startsWith(lowerCaseFilter)) {
                    return true; // Filter matches last name. )
                }else if  (Hotel.getEmail().toLowerCase().startsWith(lowerCaseFilter)) {
                    return true;
                }else if  (String.valueOf(Hotel.getTel()).toLowerCase().startsWith(lowerCaseFilter)) {
                    return true;
                }else if(String.valueOf(Hotel.getNbr_chambres()).toLowerCase().startsWith(lowerCaseFilter)) {
                    return true;
                }else if(String.valueOf(Hotel.getNbr_etoiles()).toLowerCase().startsWith(lowerCaseFilter)) {
                    return true;
                }
                else
                    return false; 
            });
        });
        // Wrap the FilteredList in a SortedList. 
        SortedList<Hotel> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tblHotels.comparatorProperty());
        tblHotels.setItems(sortedData);
        tblHotels.refresh();
    }

    private void printListHotel(ActionEvent event) {
        PrinterJob job = PrinterJob.createPrinterJob();
        Node root= this.tblHotels;
        if(job != null){
            job.showPrintDialog(root.getScene().getWindow()); // Window must be your main Stage
            Printer printer = job.getPrinter();    
           PageLayout pageLayout = printer.createPageLayout(Paper.A3, PageOrientation.PORTRAIT, Printer.MarginType.DEFAULT);
           System.out.println("PageLayout: " + pageLayout.toString());
            boolean success = job.printPage(pageLayout, root);
            if(success){
               job.endJob();
            }
        }
    }

    @FXML
    private void rechercherChambre(KeyEvent event) {
        FilteredList<Chambre> filteredData = new FilteredList<>(ChambreList , b -> true);
        tfRechercheCh.textProperty().addListener(( observable, oldValue, newValue) -> {
            filteredData.setPredicate(ch -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                final String lowerCaseFilter = newValue.toLowerCase();
                if (String.valueOf(ch.getId_chambre()).toLowerCase().startsWith(lowerCaseFilter) ) {
                    return true;
                } else if (String.valueOf(ch.getNum_chambre()).startsWith(lowerCaseFilter)) {
                    return true;      
                } else if (ch.getType_chambre().toLowerCase().startsWith(lowerCaseFilter)) {
                    return true; // Filter matches last name.             
                } else if (String.valueOf(ch.getEtage()).startsWith(lowerCaseFilter)) {
                    return true; 
                } else if( String.valueOf(ch.getPrix()).startsWith(lowerCaseFilter)) {
                    return true; // Filter matches last name. )
                }else if (String.valueOf(ch.getId_hotel()).toLowerCase().startsWith(lowerCaseFilter)) {
                    return true;
                }else
                    return false; 
            });
        });
        //  FilteredList in a SortedList. 
        SortedList<Chambre> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tblChambres.comparatorProperty());
        tblChambres.setItems(sortedData);
    }

    @FXML
    private void sortHotels(ActionEvent event) {
        ObservableList<Hotel> list1;
        ObservableList<Hotel> list2= sh.getListHotels();
        list1= list2.stream().sorted((o1,o2)->o2.getNbr_etoiles()-o1.getNbr_etoiles()).collect((Collectors.toCollection(FXCollections::observableArrayList)));
        tblHotels.setItems(list1);
    }
   
    
}
