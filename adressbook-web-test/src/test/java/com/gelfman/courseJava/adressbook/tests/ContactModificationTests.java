package com.gelfman.courseJava.adressbook.tests;

import com.gelfman.courseJava.adressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

/**
 * Created by Sima.Gelfman on 2/14/2017.
 */
public class ContactModificationTests extends TestBased {
	@BeforeMethod
	public void ensurePrecondition () {
		app.goTo ().homePage ();
		if (app.contact ().list ().size () == 0) {
			app.contact ().create ( new ContactData ()
							.withFirstName ( "Petor" ).withMiddlename ( "Ilich" ).withLastName ( "Sergeev" ).withGroup ( "test1" ) );
		}
	}

	@Test(enabled = true)
	public void testContactModification () {
		Set<ContactData> before = app.contact ().all ();
		ContactData modifyContact = before.iterator ().next ();
		ContactData contact = new ContactData ()
						.withId ( modifyContact.getId () ).withFirstName ( "Vladik" ).withMiddlename ( "Alexanrovich" ).withLastName ( "Loverov" );
		app.contact ().modify ( contact );
		Set<ContactData> after = app.contact ().all ();
		Assert.assertEquals ( before.size (), after.size () );

		before.remove ( modifyContact );
		before.add ( contact );
		Assert.assertEquals ( before, after );
	}


}
