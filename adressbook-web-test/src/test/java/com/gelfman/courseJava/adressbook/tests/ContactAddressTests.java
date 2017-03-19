package com.gelfman.courseJava.adressbook.tests;

import com.gelfman.courseJava.adressbook.model.ContactData;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

/**
 * Created by Sima.Gelfman on 3/18/2017.
 */
public class ContactAddressTests extends TestBased {

	@BeforeMethod
	public void ensurePrecondition () {
		app.goTo ().homePage ();
		if (app.contact ().all ().size () == 0) {
			app.contact ().create ( new ContactData ()
							.withFirstName ( "Petor" ).withMiddlename ( "Ilich" ).withLastName ( "Sergeev" )
							.withGroup ( "test1" )
							.withAddress ( "Rushian, Novosibirsk Town, Kirovo avenue,13, Apt 39, 656709" )
							.withHomePhone ( "+7 975 00 99" ).withMobilePhone ( "05412345678" ).withWorkPhone ( "+ 675 - 987 - 1234" ) );
		}
	}

	@Test
	public void testContactAddress() {
		app.goTo ().homePage ();
		ContactData	contact = app.contact ().all().iterator ().next ();
		ContactData infoFromEditForm = app.contact ().infoFromEditForm ( contact );
		assertThat ( contact.getAddress (), equalTo ( infoFromEditForm.getAddress () ) );
	}
}
