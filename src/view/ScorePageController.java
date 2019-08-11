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
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ScorePageController implements Initializable {
	
	

    @FXML
    private Label correctChoiceLabel;

    @FXML
    private Label incorrectChoiceLabel;

    @FXML
    private Label skippedLabel;

    @FXML
    private Label scoreLabel;
    
    public void setCorrectChoices(int score)
    {
		String finScore = Integer.toString(score);
		correctChoiceLabel.setText("  "+finScore);
    }
    
    public void setIncorrectChoices(int score)
    {
		String finScore = Integer.toString(score);
		incorrectChoiceLabel.setText("  "+finScore);
    }
    
    public void setScore(int score)
    {
		String finScore = Integer.toString(score);
		scoreLabel.setText(finScore);
    }
    
    public void setSkipped(int score)
    {
		String finScore = Integer.toString(score);
		skippedLabel.setText("  "+finScore);
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

    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
			
	}

}
