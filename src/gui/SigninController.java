package gui;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import models.Roles;
import models.User;
import services.ServiceUser;
//import utils.Mailer;
import utils.SMS;


public class SigninController implements Initializable {

    @FXML
    private DatePicker DPbirthday;

    @FXML
    private PasswordField PFpassword_signup;

    @FXML
    private TextField TFemail;

    @FXML
    private TextField TFfirstname;

    @FXML
    private TextField TFlastname;

    @FXML
    private TextField TFnumber;

    @FXML
    private TextField TFusername_signup;

    ServiceUser su = new ServiceUser() ;

    @FXML
    void Signin(ActionEvent event) {
        StringBuilder errors = new StringBuilder();
        if(TFfirstname.getText().trim().isEmpty()){
            errors.append("- Please enter a First Name.\n");
        }
        if(TFlastname.getText().trim().isEmpty()){
            errors.append("- Please enter a Last Name.\n");
        }
        if(TFusername_signup.getText().trim().isEmpty()){
            errors.append("- Please enter a Username.\n");
        }
        if(PFpassword_signup.getText().trim().isEmpty()){
            errors.append("- Please enter a Password.\n");
        }
        if(TFemail.getText().trim().isEmpty()){
            errors.append("- Please enter a Email.\n");
        }
        if(TFnumber.getText().trim().isEmpty()){
            errors.append("- Please enter a Number.\n");
        }
        if(DPbirthday.getValue() == null){
            errors.append("- Please enter a Birthday.\n");
        }
        if(!isNumeric(TFnumber.getText()) || TFnumber.getText().length() == 8){
            errors.append("- Please enter a Valid Number.\n");
        }
        if (errors.length() > 0) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Required Fields Empty");
            alert.setContentText(errors.toString());

            alert.show();
        }
        else{
            User u = new User(TFfirstname.getText(),
                    TFlastname.getText(),
                    TFemail.getText(),
                    TFusername_signup.getText(),
                    PFpassword_signup.getText(),
                    Integer.parseInt(TFnumber.getText()),
                    Roles.CLIENT,
                    DPbirthday.getValue().atStartOfDay()
            );
            try {
                su.ajouter(u);
                SMS sms = new SMS();
                ///// sms.sendSMS("Votre compte a été créer avec succées");
                //Mailer mailer = new Mailer();
               // mailer.SendMail(TFemail.getText(), "Bienevenu " + TFusername_signup.getText() + "\nVotre compte a été créer avec succées.");

                Stage stageclose = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stageclose.close();

                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/pidev/GUI/Login.fxml"));
                try {
                    loader.load();
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
                Parent parent = loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(parent));
                stage.show();

            }catch(Exception e){
                System.out.println("duplicate err");
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setHeaderText("Required Fields Empty");
                alert.setContentText("Duplicate user, try again!");
                alert.show();
            }

        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    private boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
}
