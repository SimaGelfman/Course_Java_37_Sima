package com.gelfman.courseJava.adressbook.tests;

import com.gelfman.courseJava.adressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Sima.Gelfman on 2/14/2017.
 */
public class ContactModificationTests extends TestBased {
	@Test
	public void testContactModification () {
		app.getNavigationMamager ().goToHomePage ();
		if (!app.getContactHelper ().isThereAContact ()) {
			app.getContactHelper ().createContact ( new ContactData ( "Petor", "Ilich", "Sergeev", "test1" ) );
		}
		int before = app.getContactHelper ().getContactCount ();
		app.getContactHelper ().initContactModification (0);
		app.getContactHelper ().fillContactForm ( new ContactData ( "aca", "bbb", "ccc", null ), false );
		app.getContactHelper ().submitContactModification ();
		app.getContactHelper ().returnToHomePage ();
		int after = app.getContactHelper ().getContactCount ();
		Assert.assertEquals ( before, after );
	}
}
