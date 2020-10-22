package server.model;
import java.io.*;

public class CorrectLetter implements Serializable
{
	private char letter;
	private int position;
	
	public CorrectLetter (char letter, int position)
	{
		this.letter = letter;
		this.position = position;
	}
	
	@Override
	public String toString()
	{
		return Character.toString(letter);
	}
	
	public int getPosition()
	{
		return position;
	}
}
