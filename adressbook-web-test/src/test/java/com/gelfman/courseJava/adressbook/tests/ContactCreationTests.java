package com.gelfman.courseJava.adressbook.tests;

import com.gelfman.courseJava.adressbook.model.ContactData;
import com.gelfman.courseJava.adressbook.model.Contacts;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactCreationTests extends TestBased {

	@Test(enabled = true)
	public void contactCreationTests () {
		app.goTo ().homePage ();
		Contacts before = app.contact ().all ();
		ContactData contact = new ContactData ()
						.withFirstName ( "Dron" ).withMiddlename ( "Antonovch" ).withLastName ( "Tarabarov" ).withGroup ( "test1" );
		app.contact ().create ( contact );
		Contacts after = app.contact ().all ();
		assertEquals ( after.size (), before.size () + 1 );
		contact.withId ( after.stream ().mapToInt ( ( c ) -> c.getId () ).max ().getAsInt () );
		assertThat ( after, equalTo
						( before.withAdded ( contact.withId ( after.stream ().mapToInt ( ( c ) -> c.getId () ).max ().getAsInt () ) ) ) );
	}
}
