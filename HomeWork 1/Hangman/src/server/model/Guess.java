package server.model;
import java.io.*;

public class Guess implements Serializable
{
	private CorrectLetter[] letters;
	private int attemptsLeft;
	private int score;
	
	public Guess(int length, int score)
	{
		letters = new CorrectLetter[length];
		attemptsLeft = 7;
		this.score = score;
	}
	
	public void addLetter(CorrectLetter a)
	{
		letters[a.getPosition()] = a;
	}
	
	public void wrongGuess()
	{
		attemptsLeft--;
	}
	
	public void setScore(int newScore)
	{
		score = newScore;
	}
	
	public int getAttempsts()
	{
		return attemptsLeft;
	}
	
	public boolean isComplete()
	{
		for(int i = 0; i<letters.length; i++)
		{
			if(letters[i] == null)
				return false;
		}
		return true;
	}
	
	public String toString()
	{
		String toReturn = "[";
		for(int i = 0; i<letters.length; i++)
		{
			if(letters[i] != null)
			{
				toReturn = toReturn + letters[i];
			}
			else
			{
				toReturn = toReturn + " _ ";
			}
		}
		
		return toReturn +"]"+ "\t" + Integer.toString(attemptsLeft) + "\t" + Integer.toString(score);
	}
}
