package model;

import java.util.ArrayList;

public class Quiz {

	public String quizName;
	public ArrayList <Question> question;
	
	public Quiz(String quizName)
	{
		this.quizName = quizName;
		question = new ArrayList <Question>();
	}

	public String getQuizName() {
		return quizName;
	}

	public void setQuizName(String quizName) {
		this.quizName = quizName;
	}

	public ArrayList<Question> getQuestion() {
		return question;
	}

	public void setQuiz(ArrayList<Question> question) {
		this.question = question;
	}
	
	public void addQuestion(Question question)
	{
		this.question.add(question);
	}
}
