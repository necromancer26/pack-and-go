/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;

import static java.lang.Integer.parseInt;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import tn.edu.esprit.models.Commentaire;
import tn.edu.esprit.services.CommentaireResteau;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class AddCmntrFormController implements Initializable {

    @FXML
    private TextField lblcontenucmntr;
    @FXML
    private TextField lblIdR;
    @FXML
    private TextField lbliduser;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajoutercmntrR(MouseEvent event) {
        
                  CommentaireResteau C = new CommentaireResteau();
           Commentaire C1=new Commentaire();
               C1.setIdR(parseInt(lblIdR.getText())); 
               C1.setid_user(parseInt(lbliduser.getText()));
               C1.setContenuCommentaireR(lblcontenucmntr.getText());  
               C.AjouterCommentaire(C1);
               Alert alert =new Alert(Alert.AlertType.INFORMATION);
               alert.setTitle("succes");
               alert.setHeaderText("Ajouté");
               alert.setContentText("commentaire  Ajouté avec succés !");
            
               alert.showAndWait();
    }
    
}
