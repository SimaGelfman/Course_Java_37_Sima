package com.gelfman.courseJava.adressbook.tests;

import com.gelfman.courseJava.adressbook.model.ContactData;
import org.testng.annotations.Test;

/**
 * Created by Sima.Gelfman on 3/24/2017.
 */
public class ContactDetailsTests extends TestBased{

	@Test()
	public void testContactDetails(){
		app.goTo ().homePage ();
		ContactData contact = app.contact ().all ().iterator ().next ();
		System.out.println ("========================================== from");
		System.out.println (app.contact ().details ( contact.getId () ));
		System.out.println ("========================================== to ");
	}



}
