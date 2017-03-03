package com.gelfman.courseJava.adressbook.tests;

import com.gelfman.courseJava.adressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBased {

	@Test(enabled = true)
	public void ContactCreationTests () {
		app.goTo ().homePage ();
		List<ContactData> before = app.contact ().list ();
		ContactData contact = new ContactData ( )
						.withFirstName ( "Dron").withMiddlename (  "Antonovch").withLastName (  "Tarabarov").withGroup (  "test1" );
		app.contact ().create ( contact );
		List<ContactData> after = app.contact ().list ();
		Assert.assertEquals ( after.size (), before.size() + 1 );
		before.add ( contact );
		Comparator<? super ContactData> byId = ( c1, c2) -> Integer.compare ( c1.getId (), c2.getId () );
		before.sort ( byId );
		after.sort ( byId );
		Assert.assertEquals ( before, after);
	}
}
