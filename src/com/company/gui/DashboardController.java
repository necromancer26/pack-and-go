package com.company.gui;

import com.company.models.*;
import com.company.services.PersonalityComponentsController;
import com.company.services.PersonalityController;
import com.company.services.PersonalityTest;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.KeyEvent;
import javafx.util.converter.IntegerStringConverter;

import java.lang.reflect.Array;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

public class DashboardController implements Initializable {
    //list1= list2.stream().filter(c ->c.getNomhotel().startsWith(val)).collect(Collectors.toList());
    //list1= list2.stream().sorted((o1,o2)->o1.getNomhotel().compareTo(o2.getNomhotel())).collect(Collectors.toList());
    //list1= list2.stream().sorted((o1,o2)->o1.getNbrChambre()-o2.getNbrChambre()).collect(Collectors.toList());
    PersonalityController personalityController = new PersonalityController();
    PersonalityTest personalityTest = new PersonalityTest();
    PersonalityComponentsController personalityComponentsController = new PersonalityComponentsController();
    List<Personality> personalities = null;
    List<UserPersonality> userPersonalities = null;
    List<SocialStyle> socialStyles = null;
    List<ProcessingStyle> processingStyles = null;
    List<DecisionMakingStyle> decisionMakingStyles = null;
    List<InteractionStyle> interactionStyles = null;
    String keyboardPersonalitySearch = "";

    @FXML
    ComboBox comboBoxSortPersonality;
    @FXML
    TextField searchFieldPersonality;
    @FXML
    Button deleteUserPersonality;
    @FXML
    TableView<Personality> personalityTableView;
    @FXML
    TableView<UserPersonality> userPersonalityTableView;
    @FXML
    TableView<SocialStyle> socialStyleTableView;
    @FXML
    TableView<ProcessingStyle> processingStyleTableView;
    @FXML
    TableView<DecisionMakingStyle> decisionMakingStyleTableView;
    @FXML
    TableView<InteractionStyle> interactionStyleTableView;


    public void setUserPersonalities(List<UserPersonality> userPersonalities) {
        this.userPersonalities = userPersonalities;
    }

    public void initSocialStyles() {
        socialStyleTableView.setEditable(true);
        TableColumn<SocialStyle, String> socialIdColumn = new TableColumn<>("Social ID");
        socialIdColumn.setCellValueFactory(new PropertyValueFactory<>("socialId"));
        socialIdColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        /*socialIdIdColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<SocialStyle, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<SocialStyle, String> socialStyleStringCellEditEvent) {

            }
        });*/
        socialIdColumn.setOnEditCommit(socialStyleStringCellEditEvent -> {
            SocialStyle socialStyle = socialStyleStringCellEditEvent.getRowValue();
            socialStyle.setSocialId(socialStyleStringCellEditEvent.getNewValue());
            //personalityComponentsController.editSocialStyle(socialStyle);
        });

        TableColumn<SocialStyle, String> socialNameColumn = new TableColumn<>("Social Name");
        socialNameColumn.setCellValueFactory(new PropertyValueFactory<>("socialName"));
        socialNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        socialNameColumn.setOnEditCommit(socialStyleStringCellEditEvent -> {
            SocialStyle socialStyle = socialStyleStringCellEditEvent.getRowValue();
            socialStyle.setSocialName(socialStyleStringCellEditEvent.getNewValue());
            personalityComponentsController.editSocialStyle(socialStyle);
        });

        TableColumn<SocialStyle, String> socialDetailsColumn = new TableColumn<>("Social Details");
        socialDetailsColumn.setCellValueFactory(new PropertyValueFactory<>("socialDetails"));
        socialDetailsColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        socialDetailsColumn.setOnEditCommit(socialStyleStringCellEditEvent -> {
            SocialStyle socialStyle = socialStyleStringCellEditEvent.getRowValue();
            socialStyle.setSocialDetails(socialStyleStringCellEditEvent.getNewValue());
            personalityComponentsController.editSocialStyle(socialStyle);
        });

        socialStyleTableView.getColumns().add(0, socialIdColumn);
        socialStyleTableView.getColumns().add(1, socialNameColumn);
        socialStyleTableView.getColumns().add(2, socialDetailsColumn);

        socialStyleTableView.getItems().setAll(socialStyles);
        //System.out.println(socialStyles.toString());
    }

    public void initInteractionStyles() {
        interactionStyleTableView.setEditable(true);
        TableColumn<InteractionStyle, String> interactionIdColumn = new TableColumn<>("Interaction ID");
        interactionIdColumn.setCellValueFactory(new PropertyValueFactory<>("interactionId"));
        interactionIdColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        interactionIdColumn.setOnEditCommit(interactionStyleStringCellEditEvent -> {
            InteractionStyle interactionStyle = interactionStyleStringCellEditEvent.getRowValue();
            interactionStyle.setInteractionId(interactionStyleStringCellEditEvent.getNewValue());
            //personalityComponentsController.editInteractionStyle(interactionStyle);
        });

        TableColumn<InteractionStyle, String> interactionNameColumn = new TableColumn<>("Interaction Name");
        interactionNameColumn.setCellValueFactory(new PropertyValueFactory<>("interactionName"));
        interactionNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        interactionNameColumn.setOnEditCommit(interactionStyleStringCellEditEvent -> {
            InteractionStyle interactionStyle = interactionStyleStringCellEditEvent.getRowValue();
            interactionStyle.setInteractionName(interactionStyleStringCellEditEvent.getNewValue());
            personalityComponentsController.editInteractionStyle(interactionStyle);
        });

        TableColumn<InteractionStyle, String> interactionDetailsColumn = new TableColumn<>("Interaction Details");
        interactionDetailsColumn.setCellValueFactory(new PropertyValueFactory<>("interactionDetails"));
        interactionDetailsColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        interactionDetailsColumn.setOnEditCommit(interactionStyleStringCellEditEvent -> {
            InteractionStyle interactionStyle = interactionStyleStringCellEditEvent.getRowValue();
            interactionStyle.setInteractionDetails(interactionStyleStringCellEditEvent.getNewValue());
            personalityComponentsController.editInteractionStyle(interactionStyle);
        });

        interactionStyleTableView.getColumns().add(0, interactionIdColumn);
        interactionStyleTableView.getColumns().add(1, interactionNameColumn);
        interactionStyleTableView.getColumns().add(2, interactionDetailsColumn);

        interactionStyleTableView.getItems().setAll(interactionStyles);
        //System.out.println(socialStyles.toString());
    }

    public void initProcessingStyles() {
        processingStyleTableView.setEditable(true);
        TableColumn<ProcessingStyle, String> processingIdColumn = new TableColumn<>("Processing ID");
        processingIdColumn.setCellValueFactory(new PropertyValueFactory<>("processingId"));
        processingIdColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        processingIdColumn.setOnEditCommit(processingStyleStringCellEditEvent -> {
            ProcessingStyle processingStyle = processingStyleStringCellEditEvent.getRowValue();
            processingStyle.setProcessingId(processingStyleStringCellEditEvent.getNewValue());
            //personalityComponentsController.editDecisionMakingStyle(decisionMakingStyle);
        });

        TableColumn<ProcessingStyle, String> processingNameColumn = new TableColumn<>("Processing Name");
        processingNameColumn.setCellValueFactory(new PropertyValueFactory<>("processingName"));
        processingNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        processingNameColumn.setOnEditCommit(processingStyleStringCellEditEvent -> {
            ProcessingStyle processingStyle = processingStyleStringCellEditEvent.getRowValue();
            processingStyle.setProcessingName(processingStyleStringCellEditEvent.getNewValue());
            personalityComponentsController.editProcessingStyle(processingStyle);
        });

        TableColumn<ProcessingStyle, String> processingDetailsColumn = new TableColumn<>("Processing Details");
        processingDetailsColumn.setCellValueFactory(new PropertyValueFactory<>("processingDetails"));
        processingDetailsColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        processingDetailsColumn.setOnEditCommit(processingStyleStringCellEditEvent -> {
            ProcessingStyle processingStyle = processingStyleStringCellEditEvent.getRowValue();
            processingStyle.setProcessingDetails(processingStyleStringCellEditEvent.getNewValue());
            personalityComponentsController.editProcessingStyle(processingStyle);
        });

        processingStyleTableView.getColumns().add(0, processingIdColumn);
        processingStyleTableView.getColumns().add(1, processingNameColumn);
        processingStyleTableView.getColumns().add(2, processingDetailsColumn);

        processingStyleTableView.getItems().setAll(processingStyles);
        //System.out.println(socialStyles.toString());
    }

    public void initDecisionMakingStyles() {
        decisionMakingStyleTableView.setEditable(true);
        TableColumn<DecisionMakingStyle, String> decisionMakingIdColumn = new TableColumn<>("Decision MakingID");
        decisionMakingIdColumn.setCellValueFactory(new PropertyValueFactory<>("decisionMakingId"));
        decisionMakingIdColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        decisionMakingIdColumn.setOnEditCommit(decisionMakingStyleStringCellEditEvent -> {
            DecisionMakingStyle decisionMakingStyle = decisionMakingStyleStringCellEditEvent.getRowValue();
            decisionMakingStyle.setDecisionMakingId(decisionMakingStyleStringCellEditEvent.getNewValue());
            //personalityComponentsController.editDecisionMakingStyle(decisionMakingStyle);
        });

        TableColumn<DecisionMakingStyle, String> decisionMakingNameColumn = new TableColumn<>("Decision Making Name");
        decisionMakingNameColumn.setCellValueFactory(new PropertyValueFactory<>("decisionMakingName"));
        decisionMakingNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        decisionMakingNameColumn.setOnEditCommit(decisionMakingStyleStringCellEditEvent -> {
            DecisionMakingStyle decisionMakingStyle = decisionMakingStyleStringCellEditEvent.getRowValue();
            decisionMakingStyle.setDecisionMakingName(decisionMakingStyleStringCellEditEvent.getNewValue());
            personalityComponentsController.editDecisionMakingStyle(decisionMakingStyle);
        });

        TableColumn<DecisionMakingStyle, String> decisionMakingDetailsColumn = new TableColumn<>("Decision Making Details");
        decisionMakingDetailsColumn.setCellValueFactory(new PropertyValueFactory<>("decisionMakingDetails"));
        decisionMakingDetailsColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        decisionMakingDetailsColumn.setOnEditCommit(decisionMakingStyleStringCellEditEvent -> {
            DecisionMakingStyle decisionMakingStyle = decisionMakingStyleStringCellEditEvent.getRowValue();
            decisionMakingStyle.setDecisionMakingDetails(decisionMakingStyleStringCellEditEvent.getNewValue());
            personalityComponentsController.editDecisionMakingStyle(decisionMakingStyle);
        });

        decisionMakingStyleTableView.getColumns().add(0, decisionMakingIdColumn);
        decisionMakingStyleTableView.getColumns().add(1, decisionMakingNameColumn);
        decisionMakingStyleTableView.getColumns().add(2, decisionMakingDetailsColumn);

        decisionMakingStyleTableView.getItems().setAll(decisionMakingStyles);
        //System.out.println(socialStyles.toString());
    }

    public void initUserPersonalityTable() {
        setUserPersonalities(personalityTest.getAllPersonalityUsers());
        userPersonalityTableView.setEditable(true);
        TableColumn<UserPersonality, Integer> userPersonalityIdColumn = new TableColumn<>("User Personality ID");
        userPersonalityIdColumn.setCellValueFactory(new PropertyValueFactory<>("userPersonalityId"));
        userPersonalityIdColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        userPersonalityIdColumn.setOnEditCommit(userPersonalityIntegerCellEditEvent -> {
            UserPersonality userPersonality = userPersonalityIntegerCellEditEvent.getRowValue();
            userPersonality.setUserPersonalityId(userPersonalityIntegerCellEditEvent.getNewValue());
            personalityTest.modifierUserPersonality(userPersonality);
        });

        TableColumn<UserPersonality, Integer> userIdColumn = new TableColumn<>("User ID");
        userIdColumn.setCellValueFactory(new PropertyValueFactory<>("userId"));
        userIdColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));

        TableColumn<UserPersonality, String> personalityColumn = new TableColumn<>("Personality ID");
        personalityColumn.setCellValueFactory(new PropertyValueFactory<>("personality"));
        personalityColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        userPersonalityTableView.getColumns().add(0, userPersonalityIdColumn);
        userPersonalityTableView.getColumns().add(1, userIdColumn);
        userPersonalityTableView.getColumns().add(2, personalityColumn);

        userPersonalityTableView.getItems().setAll(userPersonalities);
//root.setCenter(table);
    }

    public void initPersonalityTable() {
        setPersonalities(personalityController.getAllPersonality());
        TableColumn<Personality, String> personalityIdColumn = new TableColumn<>("Personality ID");
        personalityIdColumn.setCellValueFactory(new PropertyValueFactory<>("personalityId"));
        personalityIdColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        TableColumn<Personality, String> socialIdColumn = new TableColumn<>("Social ID");
        socialIdColumn.setCellValueFactory(new PropertyValueFactory<>("social"));
        socialIdColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        TableColumn<Personality, String> processingIdColumn = new TableColumn<>("Processing ID");
        processingIdColumn.setCellValueFactory(new PropertyValueFactory<>("processing"));
        processingIdColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        TableColumn<Personality, String> decisionMakingIdColumn = new TableColumn<>("Decision Making ID");
        decisionMakingIdColumn.setCellValueFactory(new PropertyValueFactory<>("decisionMaking"));
        decisionMakingIdColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        TableColumn<Personality, String> interactionIdColumn = new TableColumn<>("Interaction ID");
        interactionIdColumn.setCellValueFactory(new PropertyValueFactory<>("interaction"));
        interactionIdColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        personalityTableView.getColumns().add(0, personalityIdColumn);
        personalityTableView.getColumns().add(1, socialIdColumn);
        personalityTableView.getColumns().add(2, processingIdColumn);
        personalityTableView.getColumns().add(3, decisionMakingIdColumn);
        personalityTableView.getColumns().add(4, interactionIdColumn);

        //personalities.forEach(personality -> personalityTableView.getItems().add(personality));
        personalityTableView.getItems().setAll(personalities);

    }


    public void setPersonalities(List<Personality> personalities) {
        this.personalities = personalities;
        //personalities.forEach(s -> System.out.println(s.toString()));
    }

    public void onDeleteUserPersonalityClicked() {
        System.out.println("clicked");
        ObservableList<UserPersonality> row, allRows;
        allRows = userPersonalityTableView.getItems();
        row = userPersonalityTableView.getSelectionModel().getSelectedItems();
        //System.out.println(row.toString());
        row.forEach(userPersonality -> personalityTest.supprimerUserPersonality(userPersonality));
        row.forEach(allRows::remove);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        PersonalityComponentsController personalityComponentsController = new PersonalityComponentsController();
        socialStyles = personalityComponentsController.getSocialStyles();
        decisionMakingStyles = personalityComponentsController.getDecisionMakingStyles();
        interactionStyles = personalityComponentsController.getInteractionStyles();
        processingStyles = personalityComponentsController.getProcessingStyles();
        initPersonalityTable();
        initUserPersonalityTable();
        initSocialStyles();
        initProcessingStyles();
        initDecisionMakingStyles();
        initInteractionStyles();
    }

    public void handleSearchPersonality(KeyEvent keyEvent) {
        keyboardPersonalitySearch += keyEvent.getText().toUpperCase(Locale.ROOT);
        //System.out.println(keyboardPersonalitySearch);

        //System.out.println(list.toString());

        //System.out.println(keyEvent.getCode());
        if (keyEvent.getCode().toString().equals("BACK_SPACE")) {
            System.out.println("hhh");
            try {
                String[] parts = keyboardPersonalitySearch.split(String.valueOf(keyboardPersonalitySearch.charAt(keyboardPersonalitySearch.length() - 1)));
                System.out.println(parts[0].length());
                keyboardPersonalitySearch = parts[0];
                System.out.println(parts[0]);
            } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                System.err.println(indexOutOfBoundsException.getMessage());
                keyboardPersonalitySearch = "";
            }

            //keyboardPersonalitySearch.split(Character.toString(keyboardPersonalitySearch.charAt()))
            //keyboardPersonalitySearch= String.valueOf(keyboardPersonalitySearch.split(Character.toString(keyboardPersonalitySearch.charAt(keyboardPersonalitySearch.length())),keyboardPersonalitySearch.length()-1));
        }
        List<Personality> list = personalities.stream().filter(personality -> personality.getPersonalityId().startsWith(keyboardPersonalitySearch)).collect(Collectors.toList());
        personalityTableView.getItems().setAll(list);
        //personalities.stream().filter(personality -> personality.getPersonalityId().startsWith());
    }

    public void handleComboBoxPersonality(ActionEvent actionEvent) {
        //list1 = list2.stream().sorted((o1, o2) -> o1.getNbrChambre() - o2.getNbrChambre()).collect(Collectors.toList());
        List<Personality> l = personalities;
        try{
            if (comboBoxSortPersonality.getValue().equals("Sort reverse by ID")){
            l.sort(Collections.reverseOrder((o1, o2) -> o1.getPersonalityId().compareTo(o2.getPersonalityId())));
            //System.out.println(l);
            }
            if (comboBoxSortPersonality.getValue().equals("Sort normal by ID")){
            l=    personalities.stream().sorted((o1, o2) -> o1.getPersonalityId().compareTo(o2.getPersonalityId())).toList();
            }
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
        //System.out.println(l);
       // List<Personality> l = personalities.stream()
         //       .sorted((o1, o2) -> o1.getPersonalityId().compareTo(o2.getPersonalityId())).toList();
        personalityTableView.getItems().setAll(l);
        //System.out.println(list.toString());
    }
}
