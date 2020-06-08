package uk.ac.qub.eeecs.dc.hwconcept.Controller;

import uk.ac.qub.eeecs.dc.hwconcept.View.Display;

public class ExampleB implements Hardware.Consumer {

	private Display d;
	
	public void signal(int value) 
	{
		this.d.Print("B received: "+value);
	}
	
	public ExampleB(Display myView)
	{
		this.d = myView;
		// subscribe ourselves!
		Hardware.getInstance().registerConsumer(this);
	}

	
	
}
