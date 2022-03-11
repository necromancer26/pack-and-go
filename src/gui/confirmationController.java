package gui;

import com.sun.media.jfxmedia.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.StageStyle;
import models.User;
import models.modelBillet;
import models.modelVol;
import services.JavaMailUtil;
import services.ServiceUser;
import utils.UserSession;

import javax.mail.MessagingException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;


public class confirmationController implements Initializable {
modelVol v;
UserSession s;
    interBillet crudData = new implBillet();
    @FXML
    private Label first_name;

    @FXML
    private Label volid;

    @FXML
    private Label depart;

    @FXML
    private Button confirm;

    @FXML
    private Button cancel;

    @FXML
    private Label classe;

    @FXML
    void cancelAction(ActionEvent event) {

    }

    @FXML
    void confirmAction(ActionEvent event) throws MessagingException {
        modelBillet m = new modelBillet();
        m.set_nom("testamir");
        m.setVolid(this.v.getId());
        m.set_classe("type1");
        crudData.insert(m);
dialog(Alert.AlertType.INFORMATION, "Data has saved \n email sent to : amir.daghsen@esprit.tn");
JavaMailUtil.sendMail("amir.daghsen@esprit.tn","Billet reservé avec success","Votre reservation est confirmé");


    }
    private void dialog(Alert.AlertType alertType,String s){
        Alert alert = new Alert(alertType,s);
        alert.initStyle(StageStyle.UTILITY);
        alert.setTitle("Info");
        alert.showAndWait();
    }
    public void setVol(modelVol v)
    {
        this.v = v;
    }


    @FXML
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.first_name.setText("testamir");
        this.classe.setText("type1");
       // this.volid.setText(this.v.getId());
    }
}
