package gui;

import services.Test;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class Question4Controller implements Initializable {
    @FXML
    private Button nextButton;
    @FXML
    private Button previousButton;
    @FXML
    private VBox pane = new VBox();
    @FXML
    private VBox canvas;

    private String answer;
    // judging vs perceiving questions
    static String[] judgingVsPerceivingTest = {
            "A. organized, orderly. B. flexible, adaptable",
            "A. plan, schedule B. unplanned, spontaneous",
            "A. regulated, structured B. easygoing, “live\" and “let live\"",
            "A. preparation, plan ahead. B. go with the flow, adapt as you go",
            "A. control, govern B. latitude, freedom"};
    public static int[] judgingVsPerceivingAnswersStorage = new int[5];// answer storing

    public void iterate(String[] questions, int[] answers) {
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
                    judgingVsPerceivingAnswersStorage[finalQuestionNb] = 1;
                    //System.out.println(judgingVsPerceivingAnswersStorage.toString());
                    //Arrays.stream(judgingVsPerceivingAnswersStorage).forEach(System.out::println);
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
                    judgingVsPerceivingAnswersStorage[finalQuestionNb] = 0;
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


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
iterate(judgingVsPerceivingTest,judgingVsPerceivingAnswersStorage);
    }
    public boolean verifyInput(int[] arrayToVerify) {
        return !Arrays.stream(arrayToVerify).anyMatch(value -> value == 2);
    }



    public void onButtonClicked(javafx.event.ActionEvent actionEvent) {
        try {
            if (verifyInput(judgingVsPerceivingAnswersStorage)) {
                nextButton.setDisable(false);
                // append personality type accordingly
                int sumOfAsInJudging = Test.sum(judgingVsPerceivingAnswersStorage);
                if (sumOfAsInJudging < 3)
                    answer="P";
                else {
                    answer="J";
                }
                ResultController.setTest(answer);
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../gui/Result.fxml"));
                VBox yourNewView = fxmlLoader.load();
                pane.getChildren().setAll(yourNewView);
                ResultController resultController = fxmlLoader.getController();


            }else {
                nextButton.setDisable(true);
            }
        } catch (Exception ioException) {
            System.err.println(ioException.getMessage());
        }
    }

    public void onPreviousClicked(javafx.event.ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../gui/Question3.fxml"));
            VBox yourNewView = fxmlLoader.load();
            pane.getChildren().setAll(yourNewView);
            Question3Controller question3Controller = fxmlLoader.getController();
        } catch (IOException ioException) {
            System.err.println(ioException.getMessage());
        }
    }


}
