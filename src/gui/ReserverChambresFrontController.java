/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
import MailingHotel.Mail;
import static gui.AfficherChambresFrontController.index_ch;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.Chambre;
import models.ReservationChambre;
import services.ServiceChambre;
import services.ServiceReservationChambre;
import utils.UserSession;

/**
 * FXML Controller class
 *
 * @author dorsaf
 */
public class ReserverChambresFrontController implements Initializable {

    @FXML
    private DatePicker check_in;
    @FXML
    private DatePicker check_out;
    @FXML
    private Button btnreserver;
    @FXML
    private TextField id_user;
    ServiceChambre sch = new ServiceChambre();
    @FXML
    private TextField prix;
    @FXML
    private Label nomHotel;
    ServiceReservationChambre sreserv = new ServiceReservationChambre();
    @FXML
    private Button annulerReserv;
    @FXML
    private Label nomHotel1;
    @FXML
    private TextField tfMail;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       /* prix.setText(Integer.toString(sch.getPrixByID(index_ch))+" DT");*/
        prix.setDisable(true);
        
        String c = sch.getNomByID(index_ch);
        nomHotel.setText("Hotel: " +c);
                
        check_in.setValue(LocalDate.now().plusDays(1));
                
        check_in.setDayCellFactory(picker -> new DateCell() {
            @Override
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                LocalDate today = LocalDate.now();
                setDisable(empty || date.compareTo(today) < 1 );
            }
        });
        check_out.setDayCellFactory(picker -> new DateCell() {
            @Override
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                LocalDate today = LocalDate.now();
                LocalDate check = check_in.getValue().plusDays(1);
                setDisable(empty || date.isBefore(check));
            }
        });
        check_in.valueProperty().addListener((ov, oldValue, newValue) -> {
            check_out.setValue(newValue.plusDays(1));
        });
        
    }

    @FXML
    private void ReserverChambreHotel(ActionEvent event) throws Exception {
        int userId = UserSession.getInstace().getUserId().intValue();
        System.out.println(userId);
        Chambre c = sch.getChambreByID(index_ch);
        ReservationChambre reservation = new ReservationChambre(Date.valueOf(check_in.getValue()), Date.valueOf(check_out.getValue()), userId, c.getId_chambre() );
        sreserv.ajouter(reservation);
        System.out.println(reservation.getId_user());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Succes");
        alert.setHeaderText("Réservation effectuée avec succès!");
        alert.setContentText("Merci d'avoir choisir Pack&Go");  
        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.getStylesheets().add(getClass().getResource("bootstrap.css").toExternalForm());
        dialogPane.getStyleClass().add("myDialog");
        alert.setOnCloseRequest((evt) ->{
            try {
                URL fxURL = getClass().getResource("AfficherHotelFront.fxml");
                FXMLLoader LOADER = new FXMLLoader(fxURL);
                Parent root = LOADER.load();
                Scene sc = new Scene(root);
                AfficherHotelFrontController cntr = LOADER.getController();
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.setScene(sc);
                window.show();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        });
        alert.showAndWait();
    }

    @FXML
    private void annulerReserv(ActionEvent event) {
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
    }

    @FXML
    private void calculerPrix(ActionEvent event) {
        int nbr_nuit = (int)(check_out.getValue().getDayOfMonth() - check_in.getValue().getDayOfMonth());
        prix.setText(Integer.toString(sch.getPrixByID(index_ch) * nbr_nuit )+" DT");
    }
    
}
