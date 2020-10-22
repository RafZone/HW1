package client.io;
import java.io.*;

public class MessageReceive extends Thread
{
	private ObjectInputStream oi;
	private Object object;
	private InputStream input;

	public MessageReceive(InputStream input)
	{
		this.input = input;
		try
		{
			oi = new ObjectInputStream(input);
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	@Override
	public void run()
	{
		try
		{
			while((object = oi.readObject()) != null)
			{
				System.out.println(object);
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Something went wrong...");
		}
	}
}