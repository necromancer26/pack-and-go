package gui;

import models.Roles;
import models.User;
import services.ServiceUser;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class FXMLGSTuserController implements Initializable {

    @FXML
    private TextField TFforum_FN;
    @FXML
    private TextField TFforum_LN;
    @FXML
    private TextField TFforum_E;
    @FXML
    private TextField TFforum_UN;
    @FXML
    private PasswordField PFforum_PWD;
    @FXML
    private TextField TFforum_Num;
    @FXML
    private DatePicker DPforum_B;
    @FXML
    private ComboBox<Roles> ComboRoles;
    @FXML
    private TableView<User> TableUserView;
    @FXML
    private TextField TFSearch;
    @FXML
    private TableColumn<User, Long> id_userc;
    @FXML
    private TableColumn<User, String> FN_userc;
    @FXML
    private TableColumn<User, String> LN_userc;
    @FXML
    private TableColumn<User, String> Email_userc;
    @FXML
    private TableColumn<User, String> UN_userc;
    @FXML
    private TableColumn<User, String> pwd_userc;
    @FXML
    private TableColumn<User, Integer> Num_userc;
    @FXML
    private TableColumn<User, Roles> Role_userc;
    @FXML
    private TableColumn<User, LocalDateTime> Birthday_userc;
    @FXML
    private TableColumn<User, LocalDateTime> ACD_userc;
    @FXML
    private TableColumn<User, LocalDateTime> AUD_userc;

    ServiceUser su =new ServiceUser();
    long id_user_modifier;
    ObservableList<User> data=FXCollections.observableArrayList();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO
        TableUserView.setEditable(true);
        FN_userc.setOnEditCommit(e->edit_firstname(e));
        TableUserView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        ComboRoles.getItems().setAll(Roles.values());
        refreshlist();

        recherche_avance();
    }
    public void refreshlist(){


        data.clear();
        try {
            data= FXCollections.observableArrayList(su.afficher());
        } catch (SQLException ex) {
            Logger.getLogger(FXMLGSTuserController.class.getName()).log(Level.SEVERE, null, ex);
        }


        id_userc.setCellValueFactory(new PropertyValueFactory<>("id_user"));
        FN_userc.setCellValueFactory(new PropertyValueFactory<>("first_name"));
        FN_userc.setCellFactory(TextFieldTableCell.forTableColumn());
        LN_userc.setCellValueFactory(new PropertyValueFactory<>("last_name"));
        FN_userc.setCellFactory(TextFieldTableCell.forTableColumn());
        Email_userc.setCellValueFactory(new PropertyValueFactory<>("email"));
        FN_userc.setCellFactory(TextFieldTableCell.forTableColumn());
        UN_userc.setCellValueFactory(new PropertyValueFactory<>("username"));
        pwd_userc.setCellValueFactory(new PropertyValueFactory<>("password"));
        Num_userc.setCellValueFactory(new PropertyValueFactory<>("number"));
        Role_userc.setCellValueFactory(new PropertyValueFactory<>("role"));
        Birthday_userc.setCellValueFactory(new PropertyValueFactory<>("birthday"));
        ACD_userc.setCellValueFactory(new PropertyValueFactory<>("date_created_user"));
        AUD_userc.setCellValueFactory(new PropertyValueFactory<>("last_updated_user"));
        TableUserView.setItems(data);

    }
    @FXML
    private void Save_user(ActionEvent event) {

        User u =new User(
                TFforum_FN.getText(),
                TFforum_LN.getText(),
                TFforum_E.getText(),
                TFforum_UN.getText(),
                PFforum_PWD.getText(),
                Integer.parseInt(TFforum_Num.getText()),
                ComboRoles.getValue(),
                DPforum_B.getValue().atStartOfDay()
        );
        try {
            su.ajouter(u);
        } catch(Exception e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Required Fields Empty");
            alert.setContentText("Email and Username must be unique try again.");
            alert.showAndWait();
        }
        String tilte;
        String message;
        TrayNotification tray = new TrayNotification();
        AnimationType type = AnimationType.POPUP;
        tray.setAnimationType(type);
        tilte = "Added Successful";
        message = u.getRole()+" Is Added";
        tray.setTitle(tilte);
        tray.setMessage(message);
        tray.setNotificationType(NotificationType.SUCCESS);
        tray.showAndDismiss(Duration.millis(2000));
        refreshlist();
        recherche_avance();

    }

    @FXML
    private void Delete_user(ActionEvent event) {
        long id_user;
        id_user=TableUserView.getSelectionModel().getSelectedItem().getId_user();
        try {
            su.supprimer(id_user);
        } catch (SQLException ex) {
            Logger.getLogger(FXMLGSTuserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        String tilte;
        String message;
        TrayNotification tray = new TrayNotification();
        AnimationType type = AnimationType.POPUP;
        tray.setAnimationType(type);
        tilte = "Delete Success";
        message ="User Is Deleted";
        tray.setTitle(tilte);
        tray.setMessage(message);
        tray.setNotificationType(NotificationType.SUCCESS);
        tray.showAndDismiss(Duration.millis(2000));
        refreshlist();
        recherche_avance();

    }

    @FXML
    private void Update_User(ActionEvent event) {

        User u =new User(
                TFforum_FN.getText(),
                TFforum_LN.getText(),
                TFforum_E.getText(),
                TFforum_UN.getText(),
                PFforum_PWD.getText(),
                Integer.parseInt(TFforum_Num.getText()),
                ComboRoles.getValue(),
                DPforum_B.getValue().atStartOfDay()
        );
        try {
            su.modifier(id_user_modifier, u);
        } catch (SQLException ex) {
            Logger.getLogger(FXMLGSTuserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        refreshlist();
        recherche_avance();

    }


    private void recherche_avance() {
        FilteredList<User> filteredData = new FilteredList<>(data, b -> true);
        TFSearch.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(user -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if (user.getUsername().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
                    return true; 
                } else if (String.valueOf(user.getId_user()).indexOf(lowerCaseFilter) != -1) {
                    return true; 
                }else if (user.getEmail().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } 
                else
                    return false; // Does not match.
            });
        });

        // 3. Wrap the FilteredList in a SortedList.
        SortedList<User> sortedData = new SortedList<>(filteredData);

        // 4. Bind the SortedList comparator to the TableView comparator.
        // 	  Otherwise, sorting the TableView would have no effect.
        sortedData.comparatorProperty().bind(TableUserView.comparatorProperty());

        // 5. Add sorted (and filtered) data to the table.
        TableUserView.setItems(sortedData);


    }

    @FXML
    private void fillforum(MouseEvent event) {
        User u=TableUserView.getSelectionModel().getSelectedItem();
        id_user_modifier=u.getId_user();
        TFforum_FN.setText(u.getFirst_name());
        TFforum_LN.setText(u.getLast_name());
        TFforum_E.setText(u.getEmail());
        TFforum_UN.setText(u.getUsername());
        PFforum_PWD.setText(u.getPassword());
        TFforum_Num.setText(Integer.toString(u.getNumber()));
        ComboRoles.setValue(u.getRole());
        DPforum_B.setValue(u.getBirthday().toLocalDate());
    }

    @FXML
    private void edit_firstname(Event e) {
        TableColumn.CellEditEvent<User,String> cellEditEvent;
        cellEditEvent=(TableColumn.CellEditEvent<User,String>) e;
        User user=cellEditEvent.getRowValue();
        user.setFirst_name(cellEditEvent.getNewValue());
        try {
            su.modifier(user.getId_user(), user);
        } catch (SQLException ex) {
            Logger.getLogger(FXMLGSTuserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void hotelBack(MouseEvent event) {
        FXMLLoader LOADER = new FXMLLoader(getClass().getResource("AfficherHotelsForm.fxml"));
            try {
                Parent root = LOADER.load();
                Scene sc = new Scene(root);
                AfficherHotelsFormController cntr = LOADER.getController();
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.setScene(sc);
                window.show();
            } catch (Exception ex) {

        }
    }

    @FXML
    private void restauBack(MouseEvent event) {
        FXMLLoader LOADER = new FXMLLoader(getClass().getResource("ShowRestauForm.fxml"));
            try {
                Parent root = LOADER.load();
                Scene sc = new Scene(root);
                ShowRestauFormController cntr = LOADER.getController();
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.setScene(sc);
                window.show();
            } catch (Exception ex) {
        }
    }

    @FXML
    private void activiteBack(MouseEvent event) {
        FXMLLoader LOADER = new FXMLLoader(getClass().getResource("Activite.fxml"));
        try {
            Parent root = LOADER.load();
            Scene sc = new Scene(root);
            ActiviteController cntr = LOADER.getController();
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(sc);
            window.show();
        } catch (Exception ex) {

        }
    }
}



