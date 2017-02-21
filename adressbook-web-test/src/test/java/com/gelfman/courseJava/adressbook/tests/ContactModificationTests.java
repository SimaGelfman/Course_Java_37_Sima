package com.gelfman.courseJava.adressbook.tests;

import com.gelfman.courseJava.adressbook.model.ContactData;
import org.testng.annotations.Test;

/**
 * Created by Sima.Gelfman on 2/14/2017.
 */
public class ContactModificationTests extends TestBased {
	@Test
	public void testContactModification(){
		app.getContactHelper ().selectSomeContact ();
		app.getContactHelper ().initContactModification ();
		app.getContactHelper ().fillContactForm ( new ContactData ( "aa", "bbb", "ccc", null),false );
		app.getContactHelper ().submitContactModification ();
		app.getContactHelper ().returnToHomePage ();
	}
}
