package services;


import com.sun.media.jfxmedia.logging.Logger;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import org.apache.commons.lang3.RandomStringUtils;
import models.modelVol;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
    private TextField valrecherche;

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
    private TableColumn<Object, Image> cln_image;

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
    private ImageView ImageView;

    @FXML
    private Button btnImage;

    @FXML
    private Label lbNomImage;

    String erreur;
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
        /*cln_image.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Object, Image>,
                ObservableValue<Image>>() {
            @Override
            public ObservableValue<Image> call(TableColumn.CellDataFeatures<Object, Image> p) {
                return (ObservableValue<Image>) new Image("src/public/Image/\"+item+\".jpg");
            }
        });
        cln_image.setCellFactory = new Callback<TableColumn<modelVol, String>, TableCell<modelVol, String>>() {
            @Override
            public TableCell<modelVol, String> call(TableColumn<modelVol, String> param) {
                HBox box= new HBox();
                ImageView imageview = new ImageView();
                return new TableCell<modelVol, String> () {
                    @Override
                    public void updateItem(String item, boolean empty) {
                        //  super.updateItem(item, empty);
                        if (item != null) {
                            box.setSpacing(10) ;
                            box.setPadding(new Insets(10, 10, 10, 10));
                            Image img = null;
                            Image image = new Image(new Image("src/public/Image/"+item+".jpg");

                            imageview.setImage(image);
                            imageview.setFitHeight(320.0);
                            imageview.setFitWidth(200.0);

                        }
                        if(!box.getChildren().contains(imageview)) {
                            box.getChildren().add(imageview);
                            setGraphic(box);
                        }
                    }
                };
            }
        };*/
        //cln_prix.setCellValueFactory((TableColumn.CellDataFeatures<modelVol, String> cellData) ->
        //  cellData.getValue().prixProperty());



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


        FilteredList<modelVol>filteredData = new FilteredList<>(listData, b -> true);

        valrecherche.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(Vol -> {
                // If filter text is empty, display all persons.

                if (newValue == null || newValue.isEmpty()) {
                    return true;

                }

                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();



                 if (Vol.get_depart().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
                    return true;
                }else if (Vol.get_compagnie_aerien().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
                    return true;

                }else if (Vol.get_destination().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
                    return true;

                }

                else if (Vol.get_duree().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
                    return true;
                }else if (Vol.get_type_avion().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
                    return true;
                }
                else
                    return false;
            });
        });

        // 3. Wrap the FilteredList in a SortedList.
        SortedList<modelVol> sortedData = new SortedList<>(filteredData);

        // 4. Bind the SortedList comparator to the TableView comparator.
        // 	  Otherwise, sorting the TableView would have no effect.
        sortedData.comparatorProperty().bind(tableVol.comparatorProperty());

        // 5. Add sorted (and filtered) data to the table.
        tableVol.setItems(sortedData);
        tableVol.setRowFactory(tv -> new TableRow<modelVol>());
    }

    private void autoId(){
        modelVol m = new modelVol();
        crudData.autoId(m);
        idtxt.setText(Integer.toString(m.getId()));

    }

    @FXML
    private void actionSave(ActionEvent event) {
        if (this.testSaisie()) {
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
        m.set_image(lbNomImage.getText());
        //    m.set_image(image.getText());
        Logger.logMsg(1, String.valueOf(m));
        System.out.println(statusCode);
        if (statusCode.equals("0")) {

            crudData.insert(m);

        }else{
            crudData.update(m);
        }


        dialog(Alert.AlertType.INFORMATION, "Data has saved");
        /*Notifications notificationBuilder = Notifications.create()
                .title(" reservation  Ajoutée")
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
                });*/
        showData();
        clear();
        autoId();

    }}

    @FXML
    private void InsertImage(ActionEvent event) throws IOException {
        FileChooser chooser=new FileChooser();
        chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("JPG FILE","*.jpg"));
        chooser.setTitle("Choose Image");
        Stage stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        File file=chooser.showOpenDialog(stage);
        if(file !=null){
            String filename=file.getAbsolutePath();
            filename=filename.replace("\\" , "\\\\");
            String rndchars = RandomStringUtils.randomAlphanumeric(16);
            try {


                Path save= Paths.get("C:\\packandgo\\src\\src\\public\\Image\\"+rndchars+"_"+rndchars+".jpg");
                Files.copy(Paths.get(filename), save.toAbsolutePath());
                lbNomImage.setVisible(false);
                String pathbd=save.toString().replace("\\" , "\\\\");
                lbNomImage.setText(rndchars+"_"+rndchars+".jpg");
                System.out.println(save);
            } catch (java.nio.file.FileAlreadyExistsException e) {
                Path save=Paths.get("C:\\packandgo\\src\\src\\public\\Image\\"+rndchars+"_"+rndchars+".jpg");
                Files.copy(Paths.get(filename), save);
                String pathbd=save.toString().replace("\\" , "\\\\");
                lbNomImage.setVisible(false);
                lbNomImage.setText(rndchars+"_"+rndchars+".jpg");
                System.out.println(save);
            }

            Image img=new Image("file:///"+filename);
            ImageView.setImage(img);
        }
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
    private Boolean testSaisie() {
        this.erreur = "";
        if (!testCom(this.Compagnie_aerien.getText())) {
            erreur = erreur + ("Company shou be longer than 3 characters \n");
        }
        if (!testDep(this.depart.getText())) {
            erreur = erreur + ("Departure longer than 3 characters \n");
        }
        if (!testDest(this.destination.getText())) {
            erreur = erreur + ("Destination should longer than 3 characters \n");
        }

        if (!testCom(this.Compagnie_aerien.getText()) || !testDep(this.depart.getText()) || !testDest(this.destination.getText())) {
            this.dialog(Alert.AlertType.INFORMATION,this.erreur);
        }

        return testDep(this.depart.getText()) && testCom(this.Compagnie_aerien.getText()) && testDest(this.destination.getText());
    }

    private Boolean testCom(String s) {
       if (s.length()<5) {return false;}
       else {return true;}
    }
    private Boolean testDep(String s) {
        if (s.length()<5) {return false;}
        else {return true;}
    }
    private Boolean testDest(String s) {
        if (s.length()<5) {return false;}
        else {return true;}
    }



    class ButtonCell extends TableCell<Object, Boolean> {
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

