/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
import models.Resteau;
import static models.Resteau.filename;
import static models.Resteau.pathfile;
import services.ServiceResteau;
/**
 * FXML Controller class
 *
 * @author hp
 */
public class RestauAddFormController implements Initializable {

    @FXML
    private TextField tfNomR;
    @FXML
    private TextField tfAdR;
    @FXML
    private TextField tfType;
    @FXML
    private TextField tfPays;
    @FXML
    private TextField tfTel;
    @FXML
    private ImageView nomtick;

    @FXML
    private ImageView nomcroix;

    @FXML
    private ImageView typetick;

    @FXML
    private ImageView typecroix;

    @FXML
    private ImageView teltick;

    @FXML
    private ImageView telcroix;
    @FXML
    private Label labelnom;
    @FXML
    private Label labeltyp;
    @FXML
    private Label labeltel;
    @FXML
    private Label labelnom1;
    @FXML
    private Label labelpays;
    @FXML
    private Label lbladress;
    @FXML
    private ImageView paystick;
    @FXML
    private ImageView payscroix1;
    @FXML
    private ImageView adresscroix;
    @FXML
    private ImageView adresstick;
    @FXML
    private ComboBox<String> cbPays;
    @FXML
    private ComboBox<String> cbTYPE;
    @FXML
    private ImageView imgR;
           private ImageView imgviewRestau;



 
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nomtick.setVisible(false);
        typetick.setVisible(false);
        teltick.setVisible(false);
        nomcroix.setVisible(false);
        typecroix.setVisible(false);
        telcroix.setVisible(false);
        payscroix1.setVisible(false);
        paystick.setVisible(false);
        adresscroix.setVisible(false);
        adresstick.setVisible(false);
           
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
            // TODO
     ObservableList<String> Type = FXCollections.observableArrayList("cafe resto"," fast food"," resto bar"); 
        cbTYPE.setItems(Type);
     
    }  
      boolean verifiervide()
           
    {
       
        if(tfNomR.getText().equals("")) {  
             
            labelnom.setText("il faut remplir les champs");
           
           return true;
        }
        else if(tfAdR.getText().equals("")) {
           lbladress.setText("il faut remplir les champs");
           return true;
         
            //usernameTick.setVisible(true);
        }
            /*   else if(tfType.getText().equals("")) {
           labeltyp.setText("il faut remplir les champs");
           return true;
         
            //usernameTick.setVisible(true);
        }*/
        /*   else if(tfPays.getText().equals("")) {
           labelpays.setText("il faut remplir les champs");
           return true;
         
            //usernameTick.setVisible(true);
        }
            */    
        else if(tfTel.getText().equals("")){
             labeltel.setText("il faut remplir les champs");
       
        return true;
       
        }
       
        return false;
   
   
   
    }
    boolean verifiernom()
    {
        Pattern regexPattern = Pattern.compile(Resteau.REGEX);
       Matcher matcher;
        matcher =regexPattern.matcher( tfNomR.getText());
         if(matcher.find()==false)
        {
           lbladress.setText("");
              nomcroix.setVisible(true);
               tfNomR.setText("");
             labelnom.setText("nom invalide");
             return true;
             
        }
         else
         {
           lbladress.setText("");
              labelnom.setText("valide");
              nomcroix.setVisible(false);
             nomtick.setVisible(true);
             
             return false;
         
         }
         

   
   
    }
  /*  boolean verifiertype()
    {
        Pattern regexPattern = Pattern.compile(Resteau.REGEX);
       Matcher matcher;
        matcher =regexPattern.matcher( tfType.getText());
         if(matcher.find()==false)
        {
           
         typecroix.setVisible(true);
               tfType.setText("");
             labeltyp.setText("type invalide");
             return true;
             
        }
         else
         {
           
              labeltyp.setText("valide");
              typecroix.setVisible(false);
             typetick.setVisible(true);
             
             return false;

   
   
    }
    }*/
    /*
     boolean verifierpays()
    {
        Pattern regexPattern = Pattern.compile(Resteau.REGEX);
       Matcher matcher;
        matcher =regexPattern.matcher( tfPays.getText());
         if(matcher.find()==false)
        {
           
             payscroix1.setVisible(true);
               tfPays.setText("");
             labelpays.setText("pays invalide");
             return true;
             
        }
         else
         {
           
              labelpays.setText("valide");
              payscroix1.setVisible(false);
             paystick.setVisible(true);
             
             return false;

   
   
    }
    }*/
    boolean verifiertel()
    {
        Pattern regexPattern = Pattern.compile(Resteau.REGEXnumber);
       Matcher matcher;
        matcher =regexPattern.matcher(tfTel.getText());
         if (matcher.find()==false)
        {
           
            
            
              telcroix.setVisible(true);
               tfTel.setText("");
             labeltel.setText("tel invalide");
             return true;
             
        }
         else
         {
           
              labeltel.setText("valide");
              telcroix.setVisible(false);
             teltick.setVisible(true);
             
             return false;
   
   
    }
    }
    @FXML
    private void AjouterResteau(ActionEvent event) {
       if((verifiervide()==false )&&(verifiernom()==false)&&(verifiertel()==false))
       {        
    
 
         ServiceResteau sp = new ServiceResteau();
               Resteau R1 = new Resteau();
               R1.setNomR(tfNomR.getText()); 

               R1.setTypeR(cbTYPE.getValue()); 
               R1.setAdressR(tfAdR.getText()); 
               R1.setPaysR(cbPays.getValue()); 
               R1.setTelR(tfTel.getText()); 
               R1.setImgR(Resteau.pathfile);
               sp.ajouter(R1);
               Alert alert =new Alert(Alert.AlertType.INFORMATION);
               alert.setTitle("succes");
               alert.setHeaderText("Ajouté");
               alert.setContentText("restau Ajouté avec succés !");
           
               Notifications notificationBuilder = Notifications.create()
                        .title(" Restaurant  Ajoutée")
                        .text("Saved in your DATABASE").darkStyle()
             .graphic(null)
   // .graphic(null)
                        
                        .hideAfter(Duration.seconds(15))
                        .position(Pos.TOP_RIGHT)
                        .onAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               System.out.println("Clicked on notification");
            }
        });
                notificationBuilder.darkStyle();
                notificationBuilder.show();
               alert.showAndWait();
          
         
    }
    }

  

    @FXML
    private void uploadImage(ActionEvent event) throws IOException {
    
  FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("imgR", "*.jpeg","*.png" , "*.jpg"));
        File f = fc.showOpenDialog(null);
        if (f != null) {
            String img = f.getAbsoluteFile().toURI().toString();
            Image imgR = new Image(img);
            //imgviewRestau.setImage(imgR);
            pathfile = f.getAbsolutePath();
            filename = f.getAbsolutePath();
            String path = "uploads//";
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
       //imgviewRestau.setFitHeight(135);
      // imgviewRestau.setFitWidth(270);    
    }

    }
    

