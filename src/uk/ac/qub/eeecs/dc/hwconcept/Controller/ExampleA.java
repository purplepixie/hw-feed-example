package uk.ac.qub.eeecs.dc.hwconcept.Controller;

import uk.ac.qub.eeecs.dc.hwconcept.View.Display;

public class ExampleA implements Hardware.Consumer {

	private Display d;
	
	public void signal(int value) 
	{
		this.d.Print("A received: "+value);
	}
	
	public ExampleA(Display myView)
	{
		this.d = myView;
		// subscribe ourselves!
		Hardware.getInstance().registerConsumer(this);
	}

	
	
}
