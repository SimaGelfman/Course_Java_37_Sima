package com.gelfman.courseJava.adressbook.tests;

import com.gelfman.courseJava.adressbook.appmanager.ApplicationManager;
import com.gelfman.courseJava.adressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;

public class ContactCreationTests extends TestBased {

	@Test
	public void ContactCreationTests () {
		app.getNavigationMamager ().goToHomePage ();
		List<ContactData> before = app.getContactHelper ().getContactList ();
		ContactData contact = new ContactData ( "Alexandr", "Petrovich", "Kozlov", "test1" );
		app.getContactHelper ().createContact ( contact );
		List<ContactData> after = app.getContactHelper ().getContactList ();

		Assert.assertEquals ( after.size (), before.size () + 1 );

		before.add ( contact );
		Comparator<? super ContactData> byId = ( c1, c2) -> Integer.compare ( c1.getId (), c2.getId () );
		before.sort ( byId );
		after.sort ( byId );
		Assert.assertEquals ( after, before );
	}
}
