package com.gelfman.courseJava.adressbook.tests;

import com.gelfman.courseJava.adressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

/**
 * Created by Sima.Gelfman on 2/14/2017.
 */
public class ContactDeletionTests extends TestBased {

	@BeforeMethod
	public void ensurePrecondition () {
		app.goTo ().homePage ();
		if (app.contact ().list ().size () == 0) {
			app.contact ().create ( new ContactData ()
							.withFirstName ( "Petor" ).withMiddlename ( "Ilich" ).withLastName ( "Sergeev" ).withGroup ( "test1" ) );
		}
	}

	@Test(enabled = true)
	public void testContactDeletion () {
		List<ContactData> before = app.contact ().list ();
		int index = before.size () - 1;
		app.contact ().delete ( before, index );
		List<ContactData> after = app.contact ().list ();
		Assert.assertEquals ( before.size () - 1, after.size () );
		before.remove ( index );
		Comparator<? super ContactData> byId = ( c1, c2 ) -> Integer.compare ( c1.getId (), c2.getId () );
		before.sort ( byId );
		after.sort ( byId );
		Assert.assertEquals ( before, after );
	}

}
