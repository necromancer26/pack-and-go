/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vol.controller;


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
import vol.implement.implVol;
import vol.interfaces.interVol;
import vol.model.modelVol;

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
public class volController implements Initializable {
@FXML
    private AnchorPane paneLoadGraph;
  @FXML
    private TextField Compagnie_aerien;

    @FXML
    private TextField depart;

    @FXML
    private TextField destination;

    @FXML
    private TextField prix;

    @FXML
    private TextField duree;

    @FXML
    private Button actionSave;

    @FXML
    private TableView<modelVol> tableVol;

    @FXML
    private TableColumn<modelVol, Integer> cln_id;

    @FXML
    private TableColumn<modelVol, String> cln_compagnie;

    @FXML
    private TableColumn<modelVol, String> cln_depart;

    @FXML
    private TableColumn<modelVol, String> cln_destination;

    @FXML
    private TableColumn<modelVol, Date> cln_date_depart;

    @FXML
    private TableColumn<modelVol, Date> cln_date_arrive;

    @FXML
    private TableColumn<modelVol, String> cln_type;

    @FXML
    private TableColumn<modelVol, String> cln_duree;

    @FXML
    private TableColumn<modelVol, Float> cln_prix;

    @FXML
    private TableColumn<modelVol, String> cln_image;

    @FXML
    private TableColumn cln_action;

    @FXML
    private DatePicker date_arrive;

    @FXML
    private DatePicker date_depart;

    @FXML
    private ComboBox<String> type_avion;


    @FXML
    private TextField idtxt;



    @FXML

    interVol crudData = new implVol();
    ObservableList<modelVol> listData;
    private String statusCode,statusClick;
    ObservableList<modelVol> listDelete;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        type_avion.getItems().addAll("type1","type2","type3");
        type_avion.getSelectionModel().select(1);
        cln_id.setCellValueFactory((TableColumn.CellDataFeatures<modelVol, Integer> cellData) ->
                        cellData.getValue().idProperty().asObject());
        cln_compagnie.setCellValueFactory((TableColumn.CellDataFeatures<modelVol, String> cellData) ->
                        cellData.getValue().compagnie_aerienProperty());
        cln_depart.setCellValueFactory((TableColumn.CellDataFeatures<modelVol, String> cellData) ->
                        cellData.getValue().departProperty());
        cln_date_depart.setCellValueFactory((TableColumn.CellDataFeatures<modelVol, Date> cellData) ->
                cellData.getValue().date_departProperty());
        cln_date_arrive.setCellValueFactory((TableColumn.CellDataFeatures<modelVol, Date> cellData) ->
                cellData.getValue().date_arriveProperty());
        cln_destination.setCellValueFactory((TableColumn.CellDataFeatures<modelVol, String> cellData) ->
                        cellData.getValue().destinationProperty());
        cln_type.setCellValueFactory((TableColumn.CellDataFeatures<modelVol, String> cellData) ->
                        cellData.getValue().type_avionProperty());
        cln_duree.setCellValueFactory((TableColumn.CellDataFeatures<modelVol, String> cellData) ->
                        cellData.getValue().dureeProperty());
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
                return new ButtonCell(tableVol);
            }
        });
        listData = FXCollections.observableArrayList();
      //  AwesomeDude.setIcon(boutton_ajouter, AwesomeIcon.CHECK_SQUARE, "15px");
        //AwesomeDude.setIcon(Refresh, AwesomeIcon.CHAIN_BROKEN, "15px");

        date_depart.setValue(LocalDate.of(1990, 01, 01));
        date_arrive.setValue(LocalDate.of(1990, 01, 01));

        statusCode = "0";
        statusClick = "0";
        showData();
        autoId();
        tableVol.getSelectionModel().clearSelection();
            
    }
   
  
   
    private void dialog(Alert.AlertType alertType,String s){
        Alert alert = new Alert(alertType,s);
        alert.initStyle(StageStyle.UTILITY);
        alert.setTitle("Info");
        alert.showAndWait();
    }
   
    private void clear(){
        idtxt.clear();
        Compagnie_aerien.clear();
        depart.clear();
        destination.clear();
        prix.clear();
        //type_avion.clear();
        //image.clear();
        duree.clear();
        /*txtSearch.clear();*/
date_depart.setValue(LocalDate.of(1990, 01, 01));
       date_arrive.setValue(LocalDate.of(1990, 01, 01));

        statusCode = "0";
    }
   
    private void showData(){
        listData = crudData.getAll();
        tableVol.setItems(listData);
    }
   
    private void autoId(){
        modelVol m = new modelVol();
        crudData.autoId(m);
        idtxt.setText(Integer.toString(m.getId()));
    }

    @FXML
    private void actionSave(ActionEvent event) {
        modelVol m = new modelVol();
       m.setId(Integer.parseInt(idtxt.getText()));
        m.set_compagnie_aerien(Compagnie_aerien.getText());
        m.set_depart(depart.getText());
        m.set_destination(destination.getText());
        m.set_date_depart(Date.valueOf(date_depart.getValue()));
        m.set_date_arrive(Date.valueOf(date_arrive.getValue()));
        m.set_type_avion(type_avion.getValue());
        m.set_duree(duree.getText());
        m.set_prix(Float.parseFloat(prix.getText()));
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
                modelVol click = tableVol.getSelectionModel().getSelectedItems().get(0);
                idtxt.setText(String.valueOf(click.getId()));
                Compagnie_aerien.setText(click.get_compagnie_aerien());
                depart.setText(click.get_depart());
                destination.setText(click.get_destination());
                duree.setText(click.get_duree());
                prix.setText(click.get_prix().toString());
                // type_avion.getSelectionModel().select(1);
                // image.setText(click.get_image());
               
                date_depart.setValue(LocalDate.parse(click.get_date_depart().toString()));
                date_arrive.setValue(LocalDate.parse(click.get_date_arrive().toString()));

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
        ButtonCell(final TableView tableVol){
            hb.setSpacing(4);
           
            //cell delete
            cellButtonDelete.setOnAction((ActionEvent t) -> {
                statusClick = "1";
                int row = getTableRow().getIndex();
                tableVol.getSelectionModel().select(row);
                tableDataClick(null);
                modelVol m = new modelVol();
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
                tableVol.getSelectionModel().select(row);
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
