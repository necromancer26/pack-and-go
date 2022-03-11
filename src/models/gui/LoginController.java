/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.Roles;
import models.User;
import utils.UserSession;
import services.ServiceUser;

/**
 * FXML Controller class
 *
 * @author Wala
 */
public class LoginController implements Initializable {

    @FXML
    private TextField username_login;
    @FXML
    private PasswordField password_login;

    ServiceUser su = new ServiceUser();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }

    @FXML
    private void gotosignup(ActionEvent event) {
        Stage stageclose = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stageclose.close();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Signup.fxml"));
        try {
            loader.load();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        Parent parent = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(parent));

        stage.show();
    }

    @FXML
    private void login(ActionEvent event) throws NoSuchAlgorithmException {
        StringBuilder errors = new StringBuilder();
        if (username_login.getText().trim().isEmpty()) {
            errors.append("- Please enter a Username.\n");
        }
        if (password_login.getText().trim().isEmpty()) {
            errors.append("- Please enter a Password.\n");
        }
        if (errors.length() > 0) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Required Fields Empty");
            alert.setContentText(errors.toString());
            alert.showAndWait();
        } else {
            try {
                try {
                    User user = su.checkLogin(username_login.getText(), password_login.getText());
                    if (user != null) {
                        UserSession.getInstace(user.getId_user(), user.getRole()); 
                        System.out.println("Your loged in");
                        Stage stageclose = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        stageclose.close();
                        if (su.SearchByUsername(username_login.getText()).getRole() == Roles.ADMIN) {
                            FXMLLoader loader = new FXMLLoader();
                            loader.setLocation(getClass().getResource("FXMLGSTuser.fxml"));
                            try {
                                loader.load();
                            } catch (IOException ex) {
                                System.out.println(ex.getMessage());
                            }
                            Parent parent = loader.getRoot();
                            Stage stage = new Stage();
                            stage.setScene(new Scene(parent));
                            stage.show();
                        }
                        if (su.SearchByUsername(username_login.getText()).getRole() == Roles.CLIENT) {
                            FXMLLoader loader = new FXMLLoader();
                            loader.setLocation(getClass().getResource("AfficherHotelFront.fxml"));
                            try {
                                loader.load();
                            } catch (IOException ex) {
                                System.out.println(ex.getMessage());
                            }
                            Parent parent = loader.getRoot();
                            Stage stage = new Stage();
                            stage.setScene(new Scene(parent));
                            stage.show();
                        }

                    } else {
                        System.out.println("Check ur username or password!");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            } catch (Exception ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
