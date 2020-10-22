package client.io;
import java.io.*;
import java.util.Scanner;

public class MessageSend extends Thread
{
	private PrintWriter output;
	private static Scanner in;
	private String message;
	
	public MessageSend(PrintWriter output)
	{
		this.output = output;
		in = new Scanner(System.in);
	}
	
	@Override
	public void run()
	{
		while(true)
		{
			System.out.println("getting input");
			message = in.nextLine();
			output.println(message);
			output.flush();
			if (message.equals("***CLOSE***"))
			{
				break;
			}
		}
	}
}
