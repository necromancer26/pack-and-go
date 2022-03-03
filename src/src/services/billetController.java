package src.services;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.sun.media.jfxmedia.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import src.Billet;
import src.models.modelBillet;
//import src.models.modelBillet;

import javax.swing.event.DocumentListener;
import javax.swing.event.UndoableEditListener;
import javax.swing.text.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;


/**
 * FXML Controller class
 *
 * @author kjpsaycon
 */

//controller empdata
public class billetController implements Initializable {
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


    @FXML

    interBillet crudData = new implBillet();
    ObservableList<modelBillet> listData = crudData.getAll();
    private String statusCode, statusClick;
    ObservableList<modelBillet> listDelete;

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
                return new billetController.ButtonCell(tableBillet);
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
    private void actionSave(ActionEvent event) {
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
        dialog(Alert.AlertType.INFORMATION, "Data has saved");
        showData();
        clear();
        autoId();

    }

    @FXML
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


    private class ButtonCell extends TableCell<Object, Boolean> {
        final Hyperlink cellButtonDelete = new Hyperlink("Delete");
        final Hyperlink cellButtonEdit = new Hyperlink("Edit");
        final HBox hb = new HBox(cellButtonDelete, cellButtonEdit);

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

        //*************************************pdf*****************************************************
        TableColumn<modelBillet, Void> gotobtn = new TableColumn("PDF");
        Callback<TableColumn<modelBillet, Void>, TableCell<modelBillet, Void>> cellFactory
                = new Callback<TableColumn<modelBillet, Void>, TableCell<modelBillet, Void>>() {

            @Override
            public TableCell<modelBillet, Void> call(final TableColumn<modelBillet, Void> param) {
                final TableCell<modelBillet, Void> cell = new TableCell<modelBillet, Void>() {

                    private final Button btn = new Button("Pdf");

                    {
                        btn.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {
                                try {
                                    modelBillet data = getTableView().getItems().get(getIndex());
                                    int a = data.getId();
                                    System.out.println(a);
                                    String nom = data.get_nom();
                                    String prenom = data.get_prenom();


                                    Document doc = new Document();


                                    String file_name = "C:\\Users\\ASUS\\Desktop\\GYF_2\\GYF\\src\\GUI//reclamation.pdf";
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

                            }

                        });

                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn);
                        }
                    }
                };
                return cell;


            }


        };
       // gotobtn.setCellFactory(cellFactory);

      //  tableBillet.getColumns().add(gotobtn);
    }

}











