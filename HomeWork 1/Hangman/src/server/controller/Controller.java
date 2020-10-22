package server.controller;
import java.net.*;

public class Controller
{
	public void newClient(Socket client)
	{
		Thread t = new ClientHandler(client);
		t.start();
	}
}
