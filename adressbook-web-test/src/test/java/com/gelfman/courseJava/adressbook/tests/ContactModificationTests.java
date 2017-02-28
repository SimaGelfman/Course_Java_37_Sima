package com.gelfman.courseJava.adressbook.tests;

import com.gelfman.courseJava.adressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

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
		List<ContactData> before = app.getContactHelper ().getContactList();
		app.getContactHelper ().initContactModification (0);
		app.getContactHelper ().fillContactForm ( new ContactData ( "aca", "bbb", "ccc", null ), false );
		app.getContactHelper ().submitContactModification ();
		app.getContactHelper ().returnToHomePage ();
		List<ContactData> after = app.getContactHelper ().getContactList();
		Assert.assertEquals ( before.size (), after.size () );
	}
}
