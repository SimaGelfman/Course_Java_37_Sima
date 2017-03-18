package com.gelfman.courseJava.adressbook.tests;

import com.gelfman.courseJava.adressbook.model.ContactData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;

import java.util.stream.Collectors;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Sima.Gelfman on 3/16/2017.
 */
public class ContactPhonesTests extends TestBased{

	@BeforeMethod
	public void ensurePrecondition () {
		app.goTo ().homePage ();
		if (app.contact ().all ().size () == 0) {
			app.contact ().create ( new ContactData ()
							.withFirstName ( "Petor" ).withMiddlename ( "Ilich" ).withLastName ( "Sergeev" ).withHomePhone ( "+7 975 00 99" )
							.withMobilePhone ( "05412345678" ).withWorkPhone ( "+ 675 - 987 - 1234" ) );
		}
	}

	@Test
	public void testContactsPhones(){

		app.goTo ().homePage ();
		ContactData contact = app.contact ().all ().iterator ().next ();
		ContactData infoFromEditForm = app.contact ().infoFromEditForm ( contact );
		assertThat(contact.getAllPhones (), equalTo ( mergePhones ( infoFromEditForm ) ));
	}

	public  static String clean(String str){
		return  str.replaceAll ("\\s", "" ).replaceAll ( "-()", "" );
	}

	public String mergePhones(ContactData contact){
		return Arrays.asList (contact.getHomePhone (), contact.getMobilePhone (), contact.getWorkPhone ())
						.stream().filter ( (c) -> ! c.equals ( "" ) )
						.map(ContactPhonesTests::clean)
						.collect( Collectors.joining ("\n"));
	}

}
