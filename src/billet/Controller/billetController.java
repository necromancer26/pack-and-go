/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package billet.Controller;


/*import billet.Model.modelBillet;
import billet.implement.implBillet;
import billet.interfaces.interBillet;
import com.sun.media.jfxmedia.logging.Logger;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.StageStyle;
import javafx.util.Callback;*/

/*import billet.Model.modelBillet;
import billet.implement.implBillet;
import billet.interfaces.interBillet;
import com.sun.media.jfxmedia.logging.Logger;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.StageStyle;
import javafx.util.Callback;

import java.awt.event.MouseEvent;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;


/**
 * FXML Controller class
 *
 * @author kjpsaycon
 */

import com.sun.media.jfxmedia.logging.Logger;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import billet.implement.implBillet;
import billet.interfaces.interBillet;
import billet.Model.modelBillet;

import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;

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

    @FXML
    private DatePicker date_de_naissance;

   /* @FXML
    private ImageView view_image;*/

    @FXML
    private ComboBox<modelBillet> classe;

    @FXML
    private TextField idtxt;



    @FXML

    interBillet crudData = new implBillet();
    ObservableList<modelBillet> listData;
    private String statusCode,statusClick;
    ObservableList<modelBillet> listDelete;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //classe.getItems().addAll("type1","type2","type3");
        classe.getSelectionModel().select(1);
        cln_id.setCellValueFactory((TableColumn.CellDataFeatures<modelBillet, Integer> cellData) ->
                        cellData.getValue().idProperty().asObject());
        cln_nom.setCellValueFactory((TableColumn.CellDataFeatures<modelBillet, String> cellData) ->
                        cellData.getValue().nomProperty());
        cln_prenom.setCellValueFactory((TableColumn.CellDataFeatures<modelBillet, String> cellData) ->
                        cellData.getValue().prenomProperty());
        cln_date_naissance.setCellValueFactory((TableColumn.CellDataFeatures<modelBillet, Date> cellData) ->
                cellData.getValue().date_de_naissanceProperty());
        /*cln_date_arrive.setCellValueFactory((TableColumn.CellDataFeatures<modelBillet, Date> cellData) ->
                cellData.getValue().date_arriveProperty());*/
        cln_classe.setCellValueFactory((TableColumn.CellDataFeatures<modelBillet, String> cellData) ->
                        cellData.getValue().classeProperty());
        /*cln_type.setCellValueFactory((TableColumn.CellDataFeatures<modelBillet, String> cellData) ->
                        cellData.getValue().type_avionProperty());
        cln_duree.setCellValueFactory((TableColumn.CellDataFeatures<modelBillet, String> cellData) ->
                        cellData.getValue().dureeProperty());*/
        //cln_prix.setCellValueFactory((TableColumn.CellDataFeatures<modelVol, String> cellData) ->
                      //  cellData.getValue().prixProperty());
      //  cln_image.setCellValueFactory((TableColumn.CellDataFeatures<modelVol, String> cellData) ->
       //                 cellData.getValue().imageProperty());

   cln_action.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Object, Boolean>,
              ObservableValue<Boolean>>() {
            @Override
            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<Object, Boolean> p) {
                return new SimpleBooleanProperty(p.getValue() != null);
            }
        });

        cln_action.setCellFactory(new Callback<TableColumn<Object, Boolean>, TableCell<Object, Boolean>>() {
            @Override
            public TableCell<Object, Boolean> call(TableColumn<Object, Boolean> p) {
                return new ButtonCell(tableBillet);
            }
        });
        listData = FXCollections.observableArrayList();
      //  AwesomeDude.setIcon(boutton_ajouter, AwesomeIcon.CHECK_SQUARE, "15px");
        //AwesomeDude.setIcon(Refresh, AwesomeIcon.CHAIN_BROKEN, "15px");

        date_de_naissance.setValue(LocalDate.of(1990, 01, 01));
        //date_arrive.setValue(LocalDate.of(1990, 01, 01));

        statusCode = "0";
        statusClick = "0";
        showData();
        autoId();
        tableBillet.getSelectionModel().clearSelection();
            
    }
   
  
   
    private void dialog(Alert.AlertType alertType,String s){
        Alert alert = new Alert(alertType,s);
        alert.initStyle(StageStyle.UTILITY);
        alert.setTitle("Info");
        alert.showAndWait();
    }
   
    private void clear(){
        idtxt.clear();
        nom.clear();
        prenom.clear();
        cin.clear();
        //classe.clear();
        //type_avion.clear();
        //image.clear();
        //duree.clear();
        /*txtSearch.clear();*/
        date_de_naissance.setValue(LocalDate.of(1990, 01, 01));
       //date_arrive.setValue(LocalDate.of(1990, 01, 01));

        statusCode = "0";
    }
   
    private void showData(){
        listData = crudData.getAll();
        tableBillet.setItems(listData);
    }
   
    private void autoId(){
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
        m.set_cin(cin.getText());
        m.set_date_de_naissance(Date.valueOf(date_de_naissance.getValue()));
        //m.set_date_arrive(Date.valueOf(date_arrive.getValue()));
       // m.set_type_avion(type_avion.getValue());
        //m.set_duree(duree.getText());
        //m.set_prix(Float.parseFloat(prix.getText()));
    //    m.set_image(image.getText());
        Logger.logMsg(1, String.valueOf(m));
        System.out.println(statusCode);
        if (statusCode.equals("0")) {

            crudData.insert(m);

        }else{
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
                cin.setText(click.get_cin());
                //classe.setText(click.get_classe());
                //prix.setText(click.get_prix().toString());
                 classe.getSelectionModel().select(1);
                // image.setText(click.get_image());
               
                date_de_naissance.setValue(LocalDate.parse(click.get_date_de_naissance().toString()));
                //date_arrive.setValue(LocalDate.parse(click.get_date_arrive().toString()));

            } catch (Exception e) {
           
        }
       
    }}

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
        final HBox hb = new HBox(cellButtonDelete,cellButtonEdit);
        ButtonCell(final TableView tableBillet){
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
            if(!empty){
                setGraphic(hb);
            }else{
                setGraphic(null);
            }
        }
    }
   
}
