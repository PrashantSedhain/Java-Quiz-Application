package view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.Application;
import model.Quiz;

public class TakeQuizController implements Initializable {
	
		
		@FXML
	    private Button testButton;
	       
	    @FXML
	    private Button nextButton;


	    @FXML
	    private Label quizNameLabel;

	    @FXML
	    private Label questioNoLabel;

	    @FXML
	    private Button optionAButton;

	    @FXML
	    private Button optionCButton;
	    

	    @FXML
	    private Button optionDButton;

	    @FXML
	    private Button optionBButton;

	    @FXML
	    private Label questionLabel;

		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			
			quizNameLabel.setText("Application Programming Quiz");
			questioNoLabel.setText("Question No: " + 1);
			questionLabel.setText(quiz.getQuestion().get(0).getQuestion());
			optionAButton.setText(quiz.getQuestion().get(0).getOptionA());;
			optionBButton.setText(quiz.getQuestion().get(0).getOptionB());
			optionCButton.setText(quiz.getQuestion().get(0).getOptionC());
			optionDButton.setText(quiz.getQuestion().get(0).getOptionD());	
			
		}
		
		int questionNumber = 2;
		int click = 0;
    	public int Score = 0;

    	Application application = new Application();
		Quiz quiz = application.loadQuiz("quizwork.txt");
		
		/**
		 * This function groups the buttons together and updates the score if correct button filled
		 * with correct answer is clicked. 
		 * @param event ActionListener to check if the button is clicked or not.
		 * @throws IOException
		 */
		    public void handle(final ActionEvent event) throws IOException {
		    	
		    
		        if (event.getSource() == optionAButton)
		        {
		        	if(quiz.question.get(click).getCorrectAnswer().equals(optionAButton.getText()))
		        	{
		        		Score += 50;
		        	}
		        }
		        else if(event.getSource() == optionBButton)
		        {
		        	if(quiz.question.get(click).getCorrectAnswer().equals(optionBButton.getText()))
		        	{
		        		Score += 50;
		        	}
		        }
		        else if(event.getSource() == optionCButton)
		        {
		        	if(quiz.question.get(click).getCorrectAnswer().equals(optionCButton.getText()))
		        	{
		        		Score += 50;
		        	}
		        }
		        else if(event.getSource() == optionDButton)
		        {
		        	if(quiz.question.get(click).getCorrectAnswer().equals(optionDButton.getText()))
		        	{
		        		Score += 50;
		        	}
		        }		
		        
		        setScene(event);
		    
		    }
		    
		    /**
		     * This function updates the quiz with new data after every button click and shows the 
		     * score page once every question is attempted.
		     * @param event Listener to see if the button is clicked.
		     * @throws IOException
		     */
		    public void setScene(ActionEvent event) throws IOException
			{
				click++;
				if(click < quiz.getQuestion().size())
		    	{
		    		questioNoLabel.setText("Question No: " + questionNumber);
					questionLabel.setText(quiz.getQuestion().get(click).getQuestion());
					optionAButton.setText(quiz.getQuestion().get(click).getOptionA());
					optionBButton.setText(quiz.getQuestion().get(click).getOptionB());
					optionCButton.setText(quiz.getQuestion().get(click).getOptionC());
					optionDButton.setText(quiz.getQuestion().get(click).getOptionD());
					questionNumber++;
		    	}
		    	
		    	else 
		    	{
		    		int incorrectChoices = quiz.question.size() - (Score/50);
		    		int correctChoices = quiz.question.size() - incorrectChoices;
		    		FXMLLoader loader = new FXMLLoader();
		    		loader.setLocation(getClass().getResource("/view/scorePage.fxml"));
		    		Parent view2 = loader.load();
		     		Scene scene2 = new Scene(view2);
		     		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		     		
		     		ScorePageController controller = loader.getController();
		     		controller.setScore(Score);
		     		controller.setIncorrectChoices(incorrectChoices);
		     		controller.setCorrectChoices(correctChoices);
		     		controller.setSkipped(0);
		     		
		        	window.setScene(scene2);
		        	window.show();
		    	}

			}
			
		
	    
	    

}
