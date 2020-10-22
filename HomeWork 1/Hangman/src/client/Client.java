package client;
import java.io.*;
import java.net.*;
import client.io.*;

public class Client 
{
	private static InetAddress host;
	private static final int PORT = 1234;
	private static Socket client;
	private static String message;
	
	public static void main(String[]args)
	{
		try
		{
			host = InetAddress.getLocalHost();
			accessServer();
		}
		catch(IOException e)
		{
			System.out.println("Could not initiate connection");
		}
	}
	
	private static synchronized void accessServer()
	{
		try
		{
			client = new Socket(host, PORT);
			Thread receiver = new MessageReceive(client.getInputStream());
			receiver.start();
			Thread sender = new MessageSend(new PrintWriter(client.getOutputStream(), true));
			sender.start();
			sender.join();
			receiver.join();
			System.out.println("CONNECTION CLOSED");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
