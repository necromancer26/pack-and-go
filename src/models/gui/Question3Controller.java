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

public class Question3Controller implements Initializable {
    @FXML
    private Button nextButton;
    @FXML
    private Button previousButton;
    @FXML
    private VBox pane = new VBox();
    @FXML
    private VBox canvas ;

    private String answer;

    // thinking vs feeling questions
    static String[] thinkingVsFeelingTest = {
            "A. logical, thinking, questioning. B. empathetic, feeling, accommodating",
            "B. candid, straight forward, frank. B.tactful, kind, encouraging",
            "A. firm, tend to criticize, hold the line. B. gentle, tend to appreciate, conciliate",
            "A. tough-minded, just B.tender-hearted, merciful",
            "A. matter of fact, issue-oriented B. sensitive, people-oriented, compassionate",
    };
    public static int[] thinkingVsFeelingAnswersStorage = {2,2,2,2,2};// answer storing

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
                    thinkingVsFeelingAnswersStorage[finalQuestionNb] = 1;
                    //System.out.println(thinkingVsFeelingAnswersStorage.toString());
                    //Arrays.stream(thinkingVsFeelingAnswersStorage).forEach(System.out::println);
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
                    thinkingVsFeelingAnswersStorage[finalQuestionNb] = 0;
                    //Arrays.stream(thinkingVsFeelingAnswersStorage).forEach(System.out::println);
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
        iterate(thinkingVsFeelingTest,thinkingVsFeelingAnswersStorage);

    }
    public boolean verifyInput(int[] arrayToVerify) {
        return !Arrays.stream(arrayToVerify).anyMatch(value -> value == 2);
    }

    public void onButtonClicked(javafx.event.ActionEvent actionEvent) {
        try {
            if (verifyInput(thinkingVsFeelingAnswersStorage)) {
                nextButton.setDisable(false);
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../gui/Question4.fxml"));
                VBox yourNewView = fxmlLoader.load();
                pane.getChildren().setAll(yourNewView);
                int sumOfAsInThinking= Test.sum(thinkingVsFeelingAnswersStorage);
                // append personality type accordingly
                if (sumOfAsInThinking < 3)
                    answer="F";
                else {
                    answer="T";
                }
                ResultController.setTest(answer);
            }else {
                nextButton.setDisable(true);
            }
        } catch (IOException ioException) {
            System.err.println(ioException.getMessage());
        }catch (Exception exception) {
            System.err.println(exception.getMessage());
        }
    }

    public void onPreviousClicked(javafx.event.ActionEvent actionEvent) {
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../gui/Question2.fxml"));
            VBox yourNewView = fxmlLoader.load();
            pane.getChildren().setAll(yourNewView);
            Question2Controller question2Controller = fxmlLoader.getController();
        } catch (IOException ioException) {
            System.out.println(ioException.getMessage());
        }
    }


}
