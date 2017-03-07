package com.gelfman.courseJava.adressbook.tests;

import com.gelfman.courseJava.adressbook.model.ContactData;
import com.gelfman.courseJava.adressbook.model.Contacts;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.testng.Assert.assertEquals;

/**
 * Created by Sima.Gelfman on 2/14/2017.
 */
public class ContactDeletionTests extends TestBased {

	@BeforeMethod
	public void ensurePrecondition () {
		app.goTo ().homePage ();
		if (app.contact ().all ().size () == 0) {
			app.contact ().create ( new ContactData ()
							.withFirstName ( "Petor" ).withMiddlename ( "Ilich" ).withLastName ( "Sergeev" ).withGroup ( "test1" ) );
		}
	}

	@Test(enabled = true)
	public void testContactDeletion () {
		Contacts before = app.contact ().all ();
		ContactData deletedContact = before.iterator ().next ();
		app.contact ().delete ( deletedContact );
		Contacts after = app.contact ().all ();
		assertEquals ( before.size () - 1, after.size () );
		assertThat ( after, equalTo ( before.without ( deletedContact ) ) );
	}

}
