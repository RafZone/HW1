package server.model;
import java.util.Random;

public class HangmanGame 
{
	private Guess guess;
	private String[] secretWords = {"home", "school", "book", "headphones", "mobile",
									"cat", "car", "hello", "window", "jacket"};
	private String word;
	private int score;
	boolean finished;
	
	public HangmanGame()
	{
		score = 0;
		finished = true;
	}
	
	public Guess startGame()
	{
		word = generateRandomWord();
		guess = new Guess(word.length(),score);
		finished = false;
		return guess;
	}
	
	public Guess userGuess(String userInput)
	{
		if(userInput.length()>1)
		{
			if(userInput.toLowerCase().equals(word.toLowerCase())) 
			{
//				System.out.println("word match ************");
				correctGuess();
				for(int i = 0; i<word.length(); i++)
				{
					CorrectLetter temp = new CorrectLetter(word.charAt(i), i);
					this.guess.addLetter(temp);
				}
			}
			
			else
			{
//				System.out.println("failed worddddd");
				wrongGuess();
			}
		}
		
		else if(userInput.length() == 1)
		{
//			System.out.println(userInput.charAt(0) +"  "+ userInput.length());
			if(word.toLowerCase().contains(userInput.toLowerCase()))
			{
//				System.out.println("letter ------- match");
				for(int i=0; i<word.length(); i++)
				{
					if(userInput.toLowerCase().charAt(0) == word.charAt(i))
					{
						CorrectLetter temp = new CorrectLetter(word.charAt(i), i);
						this.guess.addLetter(temp);
					}
				}
				if(guess.isComplete())
				{
					correctGuess();
				}
			}
			else
			{
//				System.out.println("failed letterrrrrr");
				wrongGuess();
			}
		}
		
		return this.guess;
	}
	
	private void correctGuess()
	{
		score++;
		guess.setScore(score);
		finished = true;
	}
	
	private void wrongGuess()
	{
		this.guess.setScore(score);
		this.guess.wrongGuess();
		if(guess.getAttempsts() == 0)
		{
			score--;
			finished = true;
		}
	}
	
	private String generateRandomWord()
	{
		Random rand = new Random();
		int i = rand.nextInt(10);
		return secretWords[i];
	}
	
	public boolean isFinished()
	{
		return finished;
	}
}
