package com.gelfman.courseJava.adressbook.tests;

import com.gelfman.courseJava.adressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class ContactCreationTests extends TestBased {

	@Test(enabled = true)
	public void contactCreationTests () {
		app.goTo ().homePage ();
		Set<ContactData> before = app.contact ().all ();
		ContactData contact = new ContactData ()
						.withFirstName ( "Dron" ).withMiddlename ( "Antonovch" ).withLastName ( "Tarabarov" ).withGroup ( "test1" );
		app.contact ().create ( contact );
		Set<ContactData> after = app.contact ().all ();
		Assert.assertEquals ( after.size (), before.size () + 1 );
		contact.withId ( after.stream ().mapToInt ( (c) ->  c.getId ()).max ().getAsInt () );
		before.add ( contact );
		Assert.assertEquals ( before, after );
	}
}
