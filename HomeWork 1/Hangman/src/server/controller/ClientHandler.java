package server.controller;
import java.net.*;
import java.io.*;
import server.model.*;

public class ClientHandler extends Thread
{
	private Socket client;
	private BufferedReader input;
	private ObjectOutputStream output;
	private static String message; 
	
	public ClientHandler(Socket client)
	{
		this.client = client;
	}
	
	@Override
	public void run()
	{
		try
		{
			input = new BufferedReader(new InputStreamReader(client.getInputStream()));
			output = new ObjectOutputStream(client.getOutputStream());
			HangmanGame hangman = new HangmanGame();
			
			
			while(true)
			{
				message = input.readLine();
				
				if(message.equals("***CLOSE***"))
				{
					output.writeObject(null);
					output.close();
					break;
				}
				else if(message.equals("Start Game"))
				{
					output.writeObject(hangman.startGame());
					output.reset();
					output.flush();
				}
				
				else if(!hangman.isFinished())
				{
					output.writeObject(hangman.userGuess(message));
					output.reset();
					output.flush();
				}
				
				else
				{
					System.out.println(">Client " + message);
				}
			}
		}
		catch(IOException e)
		{
			System.out.println("Couldn't get input/output stream");
		}
	}
}



//Guess guess = new Guess(4);
//CorrectLetter l = new CorrectLetter('a', 2);
//guess.addLetter(l);
//output.writeObject(guess);