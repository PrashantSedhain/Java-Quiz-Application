package view;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.DataController;

public class viewController {
	

    @FXML
    private Button takeQuizButton;

    @FXML
    private Button createQuizButton;

    @FXML
    void takeQuizClicked(ActionEvent event) throws IOException {
    	
    	FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/view/takeQuizPage.fxml"));
		Parent view2 = loader.load();
 		Scene scene2 = new Scene(view2);
 		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	window.setScene(scene2);
    	window.show();
    	
    	
    	

    }

    @FXML
    void createQuizClicked(ActionEvent event) throws IOException {
    	
    	FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/view/createQuizPage.fxml"));
		Parent view2 = loader.load();
 		Scene scene2 = new Scene(view2);
 		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	window.setScene(scene2);
    	window.show();

    }


}
