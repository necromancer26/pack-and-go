package gui;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.sun.media.jfxmedia.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import models.modelBillet;

import javax.mail.MessagingException;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author kjpsaycon
 */

//controller empdata
public class billetController implements Initializable {
    String erreur;
    @FXML
    private TextField email;

    @FXML
    private AnchorPane anchor;

    @FXML
    private TextField nom;

    @FXML
    private TextField prenom;

    @FXML
    private TextField cin;

    @FXML
    private Button actionSave;

    @FXML
    private TableView<modelBillet> tableBillet;

    @FXML
    private TableColumn<modelBillet, Integer> cln_id;

    @FXML
    private TableColumn<modelBillet, String> cln_nom;

    @FXML
    private TableColumn<modelBillet, String> cln_prenom;

    @FXML
    private TableColumn<modelBillet, Integer> cln_cin;

    @FXML
    private TableColumn<modelBillet, Date> cln_date_naissance;

    @FXML
    private TableColumn<modelBillet, String> cln_classe;
    @FXML
    private TableColumn cln_action;

    //@FXML
    // private TableColumn<modelBillet, ?> cln_action;

    @FXML
    private DatePicker date_de_naissance;

    //@FXML
    //private ImageView view_image;

    @FXML
    private ComboBox<String> classe;


    @FXML
    private TextField idtxt;


    interBillet crudData = new implBillet();
    ObservableList<modelBillet> listData = crudData.getAll();
    private String statusCode, statusClick;
    ObservableList<modelBillet> listDelete;
    @FXML
    private ImageView view_image;
    @FXML
    private Button backbtn;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        classe.getItems().addAll("type1", "type2", "type3");
        classe.getSelectionModel().select(1);
        cln_id.setCellValueFactory((TableColumn.CellDataFeatures<modelBillet, Integer> cellData) ->
                cellData.getValue().idProperty().asObject());
        cln_nom.setCellValueFactory((TableColumn.CellDataFeatures<modelBillet, String> cellData) ->
                cellData.getValue().nomProperty());
        cln_prenom.setCellValueFactory((TableColumn.CellDataFeatures<modelBillet, String> cellData) ->
                cellData.getValue().prenomProperty());
        // cln_date_depart.setCellValueFactory((TableColumn.CellDataFeatures<modelBillet, Date> cellData) ->
        //cellData.getValue().date_departProperty());
        // cln_date_naissance.setCellValueFactory((TableColumn.CellDataFeatures<modelBillet, Date> cellData) ->
        //cellData.getValue().date_de_naissanceProperty());
        // cln_destination.setCellValueFactory((TableColumn.CellDataFeatures<modelBillet, String> cellData) ->
        //       cellData.getValue().destinationProperty());
        cln_classe.setCellValueFactory((TableColumn.CellDataFeatures<modelBillet, String> cellData) ->
                cellData.getValue().classeProperty());
        //cln_duree.setCellValueFactory((TableColumn.CellDataFeatures<modelBillet, String> cellData) ->
        // cellData.getValue().dureeProperty());
        //cln_prix.setCellValueFactory((TableColumn.CellDataFeatures<modelVol, String> cellData) ->
        //  cellData.getValue().prixProperty());
        //  cln_image.setCellValueFactory((TableColumn.CellDataFeatures<modelVol, String> cellData) ->
        //                 cellData.getValue().imageProperty());

        cln_action.setCellFactory(new Callback<TableColumn<Object, Boolean>, TableCell<Object, Boolean>>() {
            @Override
            public TableCell<Object, Boolean> call(TableColumn<Object, Boolean> p) {
                return new ButtonCell(tableBillet);
            }
        });

        listData = FXCollections.observableArrayList();
        //  AwesomeDude.setIcon(boutton_ajouter, AwesomeIcon.CHECK_SQUARE, "15px");
        //AwesomeDude.setIcon(Refresh, AwesomeIcon.CHAIN_BROKEN, "15px");

        // date_depart.setValue(LocalDate.of(1990, 01, 01));
        date_de_naissance.setValue(LocalDate.of(1990, 01, 01));

        statusCode = "0";
        statusClick = "0";
        showData();
        autoId();
        tableBillet.getSelectionModel().clearSelection();

    }


    private void dialog(Alert.AlertType alertType, String s) {
        Alert alert = new Alert(alertType, s);
        alert.initStyle(StageStyle.UTILITY);
        alert.setTitle("Info");
        alert.showAndWait();
    }

    private void clear() {
        idtxt.clear();
        nom.clear();
        prenom.clear();
        cin.clear();
        //prix.clear();
        //type_avion.clear();
        //image.clear();
        //classe.clear();
        /*txtSearch.clear();*/
        //date_depart.setValue(LocalDate.of(1990, 01, 01));
        date_de_naissance.setValue(LocalDate.of(1990, 01, 01));

        statusCode = "0";
    }

    private void showData() {
        listData = crudData.getAll();
        tableBillet.setItems(listData);
    }

    private void autoId() {
        modelBillet m = new modelBillet();
        crudData.autoId(m);
        idtxt.setText(Integer.toString(m.getId()));
    }

    @FXML
    private void actionSave(ActionEvent event) throws MessagingException {
        if (this.testSaisie()) {
        modelBillet m = new modelBillet();
        m.setId(Integer.parseInt(idtxt.getText()));
        m.set_nom(nom.getText());
        m.set_prenom(prenom.getText());
        m.set_cin(Integer.parseInt(cin.getText()));
        //m.set_date_depart(Date.valueOf(date_depart.getValue()));
        m.set_date_de_naissance(Date.valueOf(date_de_naissance.getValue()));
        m.set_classe(classe.getValue());
        //m.set_duree(duree.getText());
        //m.set_prix(Float.parseFloat(prix.getText()));
        //    m.set_image(image.getText());
        Logger.logMsg(1, String.valueOf(m));
        System.out.println(statusCode);
        if (statusCode.equals("0")) {

            crudData.insert(m);

        } else {
            crudData.update(m);
        }
        dialog(Alert.AlertType.INFORMATION, "Data has saved \n email sent to : "+this.email.getText().toString());

            JavaMailUtil.sendMail(this.email.getText().toString(),"Billet reservé avec success","Votre reservation est confirmé");
        showData();
        clear();
        autoId();

    }}

    private void tableDataClick(MouseEvent event) {
        if (statusClick.equals("1")) {
            statusCode = "1";
            try {
                modelBillet click = tableBillet.getSelectionModel().getSelectedItems().get(0);
                idtxt.setText(String.valueOf(click.getId()));
                nom.setText(click.get_nom());
                prenom.setText(click.get_prenom());
                cin.setText(String.valueOf(click.get_cin()));
                //duree.setText(click.get_duree());
                //prix.setText(click.get_prix().toString());
                // type_avion.getSelectionModel().select(1);
                // image.setText(click.get_image());

                //date_depart.setValue(LocalDate.parse(click.get_date_depart().toString()));
                date_de_naissance.setValue(LocalDate.parse(click.get_date_de_naissance().toString()));

            } catch (Exception e) {

            }

        }
    }

  /*  @FXML
    private void actionSearch(KeyEvent event) {
        listData = crudData.likeByName(txtSearch.getText());
        tableData.setItems(listData);
    } */

    /*@FXML
    private void Refresh(ActionEvent event) {
        clear();
        showData();
        autoId();
    }*/

    @FXML
    private void backClicked(ActionEvent event) {
         try {
            Parent root = FXMLLoader.load(getClass().getResource("vol.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }


    private class ButtonCell extends TableCell<Object, Boolean> {
        final Hyperlink cellButtonDelete = new Hyperlink("Delete");
        final Hyperlink cellButtonEdit = new Hyperlink("Edit");
        final Hyperlink cellButtonPrint = new Hyperlink("Print");
        final HBox hb = new HBox(cellButtonDelete, cellButtonEdit, cellButtonPrint);

        ButtonCell(final TableView tableBillet) {
            hb.setSpacing(4);

            //cell delete
            cellButtonDelete.setOnAction((ActionEvent t) -> {
                statusClick = "1";
                int row = getTableRow().getIndex();
                tableBillet.getSelectionModel().select(row);
                tableDataClick(null);
                modelBillet m = new modelBillet();
                m.setId(Integer.valueOf(idtxt.getText()));
                crudData.delete(m);
                showData();
                clear();
                autoId();
                dialog(Alert.AlertType.INFORMATION, "Data has successfully removed");
                statusClick = "0";
                statusCode = "0";
            });
            //cell Print
            cellButtonPrint.setOnAction((ActionEvent t) -> {
                try {
                    int row = getTableRow().getIndex();
                    modelBillet m = (modelBillet) tableBillet.getItems().get(row);
                     int a = m.getId();
                    String nom =  m.get_nom();
                   String prenom =  m.get_prenom();


                    Document doc = new Document();


                    String file_name = "C:\\Users\\emird\\Desktop//billet.pdf";
                    try {
                        PdfWriter.getInstance(doc, new FileOutputStream(file_name));
                    } catch (DocumentException e) {
                        e.printStackTrace();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    doc.open();
                    doc.addTitle("Evenemet: " + a);
                    try {
                        doc.add(new Paragraph("nom user : '" + nom + "'"));
                    } catch (DocumentException e) {
                        e.printStackTrace();
                    }
                    try {
                        doc.add(new Paragraph("prenom user: '" + prenom + "'"));
                    } catch (DocumentException e) {
                        e.printStackTrace();
                    }
                    doc.close();
                    try {
                        Desktop.getDesktop().open(new File(file_name));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    doc.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            });


            //cell edit
            cellButtonEdit.setOnAction((ActionEvent event) -> {
                statusClick = "1";
                int row = getTableRow().getIndex();
                tableBillet.getSelectionModel().select(row);
                tableDataClick(null);
                statusClick = "0";
            });
        }


        @Override
        protected void updateItem(Boolean t, boolean empty) {
            super.updateItem(t, empty);
            if (!empty) {
                setGraphic(hb);
            } else {
                setGraphic(null);
            }
        }
    }

    private Boolean testSaisie() {
        this.erreur = "";
        if (!testMail(this.email.getText())) {
            erreur = erreur + ("Email format should be ***@**.** \n");
        }
        if (!testCin(this.cin.getText())) {
            erreur = erreur + ("Cin should contain only 8 numbers \n");
        }


        if (!testMail(this.email.getText()) || (!testCin(this.cin.getText()) ) ) {
            this.dialog(Alert.AlertType.INFORMATION,this.erreur);
        }

        return testMail(this.email.getText()) && testCin(this.cin.getText());
    }
    private Boolean testMail(String s) {

         final Pattern VALID_EMAIL_ADDRESS_REGEX =
                Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(s);
        return matcher.find();

    }
    private Boolean testCin(String s) {

       if (s.length() != 8) {return false;} else {return true;}

    }
}










