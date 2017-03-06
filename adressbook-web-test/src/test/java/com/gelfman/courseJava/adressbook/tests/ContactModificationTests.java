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
		List<ContactData> before = app.contact ().list ();
		int index = 0;
		ContactData contact = new ContactData ()
						.withId ( before.get ( index ).getId () ).withFirstName ( "Vladik" ).withMiddlename ( "Alexanrovich" ).withLastName ( "Loverov" );
		app.contact ().modify ( index, contact );
		List<ContactData> after = app.contact ().list ();
		Assert.assertEquals ( before.size (), after.size () );

		before.remove ( index );
		before.add ( contact );
		Comparator<? super ContactData> byId = ( c1, c2 ) -> Integer.compare ( c1.getId (), c2.getId () );
		before.sort ( byId );
		after.sort ( byId );
		Assert.assertEquals ( before, after );
	}


}
