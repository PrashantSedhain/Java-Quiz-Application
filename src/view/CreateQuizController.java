package view;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class CreateQuizController {
	
	    @FXML
	    private TextField quizName;

	    @FXML
	    private TextField optionC;

	    @FXML
	    private TextField optionD;
	    
	    @FXML
	    private Label successText;

	    @FXML
	    private TextField questionField;
	    
	    @FXML
	    private TextField optionA;

	    @FXML
	    private Button addButton;

	    @FXML
	    private TextField optionB;

	    @FXML
	    private TextField correctAnswer;

	    @FXML
	    void addButtonClicked(ActionEvent event) throws IOException {
	    	
	    	saveQuiz("quizwork.txt");

	    }
	    
	    /**
	     * This function takes the user back to the home screen when home page is clicked.
	     * @param event Button event listener.
	     * @throws IOException Throws Input/Output exception
	     */
	    @FXML
	    public void homePageClicked(ActionEvent event) throws IOException {
	    	
	    	FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/view/view.fxml"));
			Parent view2 = loader.load();
	 		Scene scene2 = new Scene(view2);
	 		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
	    	window.setScene(scene2);
	    	window.show();

	    }

	    
	    /**
	     * This function saves the quiz to the file utilizing appendUsingPrintWriter function.
	     * @param fileName Filename where the file is to be saved.
	     * @throws IOException
	     */
	    void saveQuiz(String fileName) throws IOException
		{
	    	String question = questionField.getText();
	    	String correct_Answer = correctAnswer.getText();
	    	String option_A = optionA.getText();
	    	String option_B = optionB.getText();
	    	String option_C = optionC.getText();
	    	String option_D = optionD.getText();
	    	
	    	appendUsingPrintWriter(fileName, question + "~" + correct_Answer + "~" + option_A + "~" + option_B + "~" + option_C + "~" + option_D);
	        String successMessage = "Question added.";
	        successText.setText(successMessage);
	        clearTexts();
	         
		}
	    
	    /**
	     * This function uses FileWriter to append the user desired questions and options to the text file.
	     * @param filePath FileName where the data is written to.
	     * @param text Text gathered from UI to be appended to the file.
	     */
		private static void appendUsingPrintWriter(String filePath, String text) {
			File file = new File(filePath);
			FileWriter fr = null;
			BufferedWriter br = null;
			PrintWriter pr = null;
			try {
				fr = new FileWriter(file, true);
				br = new BufferedWriter(fr);
				pr = new PrintWriter(br);
				pr.println(text);
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					pr.close();
					br.close();
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	    
		/**
		 * A simple utility function to clear the texts entered in the GUI when user
		 * plans to add next question.
		 */
	    void clearTexts()
	   
	    {
	    	questionField.clear();
	    	optionA.clear();
	    	optionB.clear();
	    	optionC.clear();
	    	optionD.clear();
	    	correctAnswer.clear();
	    }
	    

}



