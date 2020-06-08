package uk.ac.qub.eeecs.dc.hwconcept.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Hardware extends Thread {
	// This represents a virtual hardware interface with incoming data feed
	
	// This is the subscription interface consumers will implement
	public interface Consumer {
		public void signal(int value);
	}
	
	// This is the singleton instance
	private static Hardware instance = null;
	
	// This is our list of consumers
	List<Consumer> consumers;
	
	// Running flag
	boolean running = true;
	
	private Hardware() // private constructor
	{
		// any setup code goes here
		this.consumers = new ArrayList<Consumer>();
		this.start();
	}
	
	// Get the instance (external), create if needed
	public static Hardware getInstance()
	{
		if (Hardware.instance == null)
			Hardware.instance = new Hardware();
		return Hardware.instance;
	}
	
	// Register a consumer
	public void registerConsumer(Consumer c)
	{
		this.consumers.add(c);
	}
	
	// Unregister a consumer
	public void unregisterConsumer(Consumer c)
	{
		this.consumers.remove(c);
	}
	
	// Send a signal to all consumers
	private void sendToConsumers(int signal)
	{
		for(Consumer c: this.consumers)
			c.signal(signal);
	}
	
	// The actual generation of randomised "signal", runs as a thread
	public void run()
	{
		Random r = new Random();
		while(this.running)
		{
			int signal = r.nextInt(100);
			this.sendToConsumers(signal);
			int sleep = r.nextInt(1000)+500;
			try 
			{
				Thread.sleep(sleep);
			} 
			catch (InterruptedException e) 
			{
				
				e.printStackTrace();
			}
		}
	}
}
