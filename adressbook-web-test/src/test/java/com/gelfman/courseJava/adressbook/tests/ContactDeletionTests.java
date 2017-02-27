package com.gelfman.courseJava.adressbook.tests;

import com.gelfman.courseJava.adressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Sima.Gelfman on 2/14/2017.
 */
public class ContactDeletionTests extends TestBased {

	@Test
	public void testContactDeletion () {
		app.getNavigationMamager ().goToHomePage ();
		if (!app.getContactHelper ().isThereAContact ()) {
			app.getContactHelper ().createContact ( new ContactData ( "Petor", "Ilich", "Sergeev", "test1" ) );
		}
		int before = app.getContactHelper ().getContactCount ();
		app.getContactHelper ().selectSomeContact (0);
		app.getContactHelper ().deleteSelectedContact ();
		app.getNavigationMamager ().goToHomePage ();
		int after = app.getContactHelper ().getContactCount ();
		Assert.assertEquals ( before - 1, after );
	}


}
