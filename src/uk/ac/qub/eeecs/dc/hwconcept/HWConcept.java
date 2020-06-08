package uk.ac.qub.eeecs.dc.hwconcept;

import uk.ac.qub.eeecs.dc.hwconcept.View.*;
import uk.ac.qub.eeecs.dc.hwconcept.Controller.*;

public class HWConcept extends Thread {

	public static void main(String[] args) {
		
		HWConcept hw = new HWConcept();
		hw.start();
		
	}
	
	public HWConcept()
	{
		// Let's set up
		Display d = new Console();
		
		ExampleA a = new ExampleA(d);
		ExampleB b = new ExampleB(d);
		ExampleA c = new ExampleA(d); // another A
		
		// now we just need to sleep
		while(true)
		{
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
