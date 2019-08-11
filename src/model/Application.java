package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Application {
	
	Quiz quiz = null;
	Question question = null;
	
	
	/**
	 * This function loads the '~' delimited file and populates the data.
	 * @param fileName Filename from where the data is read and later loaded.
	 * @return Returns the Quiz data after everything is read from the file.
	 */
	public Quiz loadQuiz(String fileName)
	{
		File file = new File(fileName);
		try {
			Scanner input = new Scanner(file);
			String[] tokens = null;
			quiz = new Quiz("Test");
			String delimeter = "~";

			while(input.hasNextLine())
			{
				String line = input.nextLine();
				tokens = line.split(delimeter);
				question = new Question();
				question.setQuestion(tokens[0]);
				question.setCorrectAnswer(tokens[1]);
				question.setOptionA(tokens[2]);
				question.setOptionB(tokens[3]);
				question.setOptionC(tokens[4]);
				question.setOptionD(tokens[5]);
				quiz.addQuestion(question);
				
				
			}
			
			
				input.close();
			}
		
			catch (FileNotFoundException e) {
			e.printStackTrace();
			
			}
		return quiz;
		
	}
	
	

}
