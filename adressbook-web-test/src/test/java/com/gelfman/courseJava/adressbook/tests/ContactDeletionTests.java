package com.gelfman.courseJava.adressbook.tests;

import com.gelfman.courseJava.adressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

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
		List<ContactData> before = app.getContactHelper ().getContactList();
		app.getContactHelper ().selectSomeContact (0);
		app.getContactHelper ().deleteSelectedContact ();
		app.getNavigationMamager ().goToHomePage ();
		List<ContactData> after = app.getContactHelper ().getContactList();
		Assert.assertEquals ( before.size() - 1, after.size () );
	}


}
