package com.gelfman.courseJava.adressbook.appmanager;

import com.gelfman.courseJava.adressbook.model.ContactData;
import com.gelfman.courseJava.adressbook.model.Contacts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Sima.Gelfman on 2/12/2017.
 */
public class ContactHelper extends HelperBased {

	private Contacts contactsCash = null;

	public ContactHelper ( WebDriver wd ) {
		super ( wd );
	}

	public void returnToHomePage () {
		click ( By.linkText ( "home" ) );
	}

	public int count(){
   return wd.findElements ( By.xpath ( "//td/input" ) ).size ();
	}

	public void submitContactCreation () {
		click ( By.xpath ( "//div[@id='content']/form/input[21]" ) );
	}

	public void fillContactForm ( ContactData contact, boolean creation ) {
		type ( By.name ( "firstname" ), contact.getFirstName () );
		type ( By.name ( "middlename" ), contact.getMiddlename () );
		type ( By.name ( "lastname" ), contact.getLastName () );
		if (creation) {
			new Select ( wd.findElement ( By.name ( "new_group" ) ) ).selectByVisibleText ( contact.getGroup () );
		} else {
			Assert.assertFalse ( isElementPresent ( By.name ( "new_group" ) ) );
		}
	}

	public void initContactCreation () {
		click ( By.linkText ( "add new" ) );
	}

	public void selectSomeContactById ( int id ) {
		wd.findElement ( By.xpath ( "//table[@id='maintable']/tbody/tr/td[1]/input[@id='" + id + "']" ) ).click ();
	}

	public void deleteSelectedContact () {
		click ( By.xpath ( "//div[@id='content']/form[2]/div[2]/input" ) );
		closeAlertWindow ();
	}

	public void initContactModificationById ( int id ) {
		wd.findElement ( By.xpath ( "//table[@id='maintable']/tbody/tr/td[8]/a[contains(@href, '"+ id + "')]" ) ).click ();
	}

	public void submitContactModification () {
		click ( By.xpath ( "//input[@type = 'submit']" ) );
	}

	public void create ( ContactData contact ) {
		initContactCreation ();
		fillContactForm ( contact, true );
		submitContactCreation ();
		contactsCash = null;
		returnToHomePage ();
	}

	public void modify (  ContactData contact ) {
		initContactModificationById ( contact.getId () );
		fillContactForm ( contact, false );
		submitContactModification ();
		contactsCash = null;
		returnToHomePage ();
	}


	public void delete ( ContactData contact) {
		selectSomeContactById ( contact.getId () );
		deleteSelectedContact ();
		contactsCash = null;
		returnToHomePage ();
	}


	public Contacts all () {
		if(contactsCash != null){
			return new Contacts ( contactsCash );
		}
		contactsCash = new Contacts ();
		List<WebElement> rowContact = wd.findElements ( By.xpath ( "//table[@id='maintable']//tr[td]" ) );
		for (WebElement element : rowContact) {
			String lastname = element.findElement ( By.xpath ( "./td[2]" ) ).getText ();
			String firstname = element.findElement ( By.xpath ( "./td[3]" ) ).getText ();
			int id = Integer.parseInt ( element.findElement ( By.tagName ( "input" ) ).getAttribute ( "value" ) );
			contactsCash.add ( new ContactData ().withId ( id ).withFirstName ( firstname ).withLastName ( lastname ) );
		}
		return contactsCash;
	}
}
