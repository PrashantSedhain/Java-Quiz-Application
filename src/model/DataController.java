package model;


public class DataController {

	
	public void getNextData()
	{
		Application application = new Application();
		Quiz quiz = application.loadQuiz("quizwork.txt");
		

		for(int i = 0; i < quiz.getQuestion().size(); i++)
		{
			System.out.println(quiz.getQuestion().get(i).getQuestion());
			System.out.println(quiz.getQuestion().get(i).getOptionA());
			System.out.println(quiz.getQuestion().get(i).getOptionB());
			System.out.println(quiz.getQuestion().get(i).getOptionC());
			System.out.println(quiz.getQuestion().get(i).getOptionD());

		}
		
	}
}
