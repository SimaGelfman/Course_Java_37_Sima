package com.gelfman.courseJava.adressbook.tests;

import com.gelfman.courseJava.adressbook.model.ContactData;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by Sima.Gelfman on 3/19/2017.
 */
public class ContactEmailsTests extends TestBased {

	@BeforeMethod
	public void ensurePrecondition () {
		app.goTo ().homePage ();
		if (app.contact ().all ().size () == 0) {
			app.contact ().create ( new ContactData ()
							.withFirstName ( "Petor" ).withMiddlename ( "Ilich" ).withLastName ( "Sergeev" )
							.withGroup ( "test1" )
							.withAddress ( "Rushian, Novosibirsk Town, Kirovo avenue,13, Apt 39, 656709" )
							.withHomePhone ( "+7 975 00 99" ).withMobilePhone ( "05412345678" ).withWorkPhone ( "+ 675 - 987 - 1234" )
							.withEmail1 ( "email1@yandex.ru" ).withEmail2 ( "email-email1.email1@gmail.com" ).withEmail3 ( "   Email1334@gmail.com" ) );
		}
	}

	@Test
	public void testContactEmails () {
		app.goTo ().homePage ();
		ContactData contact = app.contact ().all ().iterator ().next ();
		ContactData infoFromEditForm = app.contact ().infoFromEditForm ( contact );
		MatcherAssert.assertThat ( contact.getAllEmails (), CoreMatchers.equalTo ( mergeEmails(infoFromEditForm)) );

	}

	private String mergeEmails ( ContactData contact ) {
		return Arrays.asList (contact.getEmail1 (),contact.getEmail2 (), contact.getEmail3 ())
						.stream().filter ( (c) -> ! c.equals ( "" ) )
						.map(ContactEmailsTests::clean)
						.collect ( Collectors.joining ( "\n" ) );
	}

	public  static String clean(String str){
		return  str.replaceAll ("\\s", "" );
	}

}