package gui;

import services.Test;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;


public class Question1Controller implements Initializable {
    @FXML
    private Button nextButton;
    @FXML
    private Button previousButton;
    @FXML
    private VBox pane = new VBox();
    @FXML
    private RadioButton radioButton1;
    @FXML
    private RadioButton radioButton2;
    @FXML
    private VBox canvas;
    @FXML
    private ToggleGroup qToggleGroup;

    private String answer;
    public static int[] extrovertVsIntrovertAnswersStorage = {2, 2, 2, 2, 2};//new int[5];// answer storing
    private String[] extroversionVsIntroversionTest = {
            "A. expend energy, enjoy groups. B. conserve energy, enjoy one-on-one :",
            "A. more outgoing, think out loud. B. more reserved, think to yourself :",
            "A. seek many tasks, public activities, interaction with others. :" +
                    "B. seek private solitary activities with quiet to concentrate :",
            "A. external, communicative,  express yourself. B. internal, reticent, keep to yourself :",
            "A. active, initiate. B. reflective, deliberate :"};


    public void iterate(String[] questions, int[] answers) {
        // loop through string array
        // print quetions numbers, print questions print options, and save answers to
        int questionNb = 1;
        //canvas.setStyle("-fx-border-color:aqua;");
        canvas.setPadding(new Insets(10, 30, 10, 30));

        for (String question : questions) {
            //Label questionNumber = new Label("Question " + Test.questionNumber++);

            Label questionNumber = new Label("Question Number : " + questionNb);
            questionNumber.setStyle("-fx-text-fill:#62cdc6;-fx-font-size:27;");
            questionNumber.setAlignment(Pos.CENTER);
            HBox questionNumberContainer = new HBox();
            questionNumberContainer.setAlignment(Pos.CENTER);
            questionNumberContainer.getChildren().add(questionNumber);
            Text questionText = new Text(question);
            //questionLabel.setStyle("-fx-background-color: #94d2bd;");
            questionText.setStyle("-fx-text-fill:#17c3b2; -fx-font-weight:900;-fx-font-size:18;-fx-border-color:orange;");
            questionText.setWrappingWidth(600);
            questionText.setFill(Color.TEAL);

            ToggleGroup answerToggleGroup = new ToggleGroup();

            RadioButton A = new RadioButton("A");
            A.setPadding(new Insets(10, 0, 10, 0));
            A.setToggleGroup(answerToggleGroup);
            int finalQuestionNb = questionNb - 1;
            A.setOnAction(actionEvent -> {
                try {
                    nextButton.setDisable(false);
                    extrovertVsIntrovertAnswersStorage[finalQuestionNb] = 1;
                    //System.out.println(extrovertVsIntrovertAnswersStorage.toString());
                    //Arrays.stream(extrovertVsIntrovertAnswersStorage).forEach(System.out::println);
                } catch (Exception exception) {
                    System.err.println(exception.getMessage());
                }
                //((RadioButton)actionEvent.getSource()).getText();
            });

            RadioButton B = new RadioButton("B");
            B.setPadding(new Insets(10, 0, 10, 0));
            B.setToggleGroup(answerToggleGroup);
            B.setOnAction(actionEvent -> {
                try {
                    nextButton.setDisable(false);
                    extrovertVsIntrovertAnswersStorage[finalQuestionNb] = 0;
                    //Arrays.stream(extrovertVsIntrovertAnswersStorage).forEach(System.out::println);
                } catch (Exception exception) {
                    System.err.println(exception.getMessage());
                }
                //((RadioButton)actionEvent.getSource()).getText();
            });

            VBox questionContainer = new VBox();
            questionContainer.getChildren().addAll(questionNumberContainer, questionText, A, B);
            canvas.getChildren().add(questionContainer);

            questionNb++;
        }
    }


    public void init() {
        pane.setAlignment(Pos.CENTER);
        canvas.setAlignment(Pos.CENTER);
        iterate(extroversionVsIntroversionTest, extrovertVsIntrovertAnswersStorage);
        //System.out.println(extrovertVsIntrovertAnswersStorage.toString());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //init();
        //Arrays.stream(extrovertVsIntrovertAnswersStorage).forEach(value -> value= Integer.parseInt(null));
        pane.setAlignment(Pos.CENTER);
        iterate(extroversionVsIntroversionTest, extrovertVsIntrovertAnswersStorage);

    }


    public boolean verifyInput(int[] arrayToVerify) {
        return !Arrays.stream(arrayToVerify).anyMatch(value -> value == 2);
    }

    public void onButtonClicked(javafx.event.ActionEvent actionEvent) {
        try {
            if (verifyInput(extrovertVsIntrovertAnswersStorage)) {
                nextButton.setDisable(false);
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../gui/Question2.fxml"));
                VBox yourNewView = fxmlLoader.load();
                pane.getChildren().setAll(yourNewView);
                Question2Controller question2Controller = fxmlLoader.getController();
                int sumOfAsInExtroversion=Test.sum(extrovertVsIntrovertAnswersStorage);
                // append personality type accordingly
                if (sumOfAsInExtroversion < 3)
                    answer="I";
                else {
                    answer="E";
                }
                ResultController.setTest(answer);

            } else {
                nextButton.setDisable(true);
            }

        } catch (IOException ioException) {
            System.out.println(ioException.getMessage());
        }
    }

    public void onPreviousClicked(javafx.event.ActionEvent actionEvent) {
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../gui/Menu.fxml"));
            VBox yourNewView = fxmlLoader.load();
            pane.getChildren().setAll(yourNewView);
            MenuController menuController = fxmlLoader.getController();
        } catch (IOException ioException) {
            System.out.println(ioException.getMessage());
        }
    }
}
