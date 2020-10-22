package server.model;
import java.io.IOException;
import java.net.*;
import server.controller.*;

public class Server 
{
	private static final int PORT = 1234;
	private static ServerSocket serverSocket;
	private Controller controller;
	
	public Server()
	{
		try 
		{
			System.out.println("Starting Server...");
			serverSocket = new ServerSocket(PORT);
			controller = new Controller();
		}
		catch (IOException e)
		{
			e.printStackTrace();
			System.exit(-1);
		}
		
		while(true)
		{
			try
			{
				Socket clientSocket = serverSocket.accept();
				System.out.println("New Client");
				controller.newClient(clientSocket);
			}
			catch(IOException e)
			{
				System.out.println("Couldn't connect to client. Trying one more time!");
			}
		}
	}
}
