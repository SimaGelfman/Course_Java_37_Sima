package com.gelfman.courseJava.adressbook.appmanager;

import com.gelfman.courseJava.adressbook.model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sima.Gelfman on 2/12/2017.
 */
public class ContactHelper extends HelperBased{


	public ContactHelper ( WebDriver wd ) {
		super ( wd );
	}

	public void returnToHomePage () {
		click( By.linkText("home"));
	}

	public void submitContactCreation () {
		click( By.xpath("//div[@id='content']/form/input[21]"));
	}

	public void fillContactForm ( ContactData contact, boolean creation ) {
		type(By.name("firstname"), contact.getFirstName () );
		type(By.name("middlename"), contact.getMiddlename () );
		type(By.name("lastname"), contact.getLastName () );
		if(creation) {
			new Select ( wd.findElement ( By.name ( "new_group" ) ) ).selectByVisibleText ( contact.getGroup () );
		}else{
			Assert.assertFalse ( isElementPresent (By.name ( "new_group" )) );
		}
	}

	public void initContactCreation () {
		click( By.linkText("add new"));
	}

	public void selectSomeContact (int index) {
		wd.findElements ( By.xpath ( "//table[@id='maintable']/tbody/tr/td[1]/input" ) ).get ( index ).click ( );
	}

	public void deleteSelectedContact () {
		click ( By.xpath ( "//div[@id='content']/form[2]/div[2]/input" ) );
		closeAlertWindow ();
	}

	public void initContactModification (int index) {
		wd.findElements ( By.xpath ( "//table[@id='maintable']/tbody/tr/td[8]/a/img" ) ).get ( index ).click ();
	}

	public void submitContactModification(){
		click(By.xpath ( "//input[@type = 'submit']" ));
	}

	public void createContact ( ContactData contact ) {
		initContactCreation ();
		fillContactForm ( contact , true);
		submitContactCreation ();
		returnToHomePage ();
	}

	public void modifyContact ( int index, ContactData contact ) {
		initContactModification ( index );
		fillContactForm ( contact, false );
		submitContactModification ();
		returnToHomePage ();
	}


	public void deleteContact ( List<ContactData> before, int index ) {
		selectSomeContact (index);
		deleteSelectedContact ();
		returnToHomePage ();
	}



	public boolean isThereAContact () {
		return isElementPresent(By.name ( "selected[]" ));
	}

	public int getContactCount () {
		return wd.findElements ( By.xpath ( "//table[@id='maintable']/tbody/tr/td[1]/input" ) ).size ();
	}

	public List<ContactData> getContactList () {
		List<ContactData> contacts = new ArrayList<ContactData> ();
		List<WebElement> rowContact = wd.findElements ( By.xpath ( "//table[@id='maintable']//tr[td]" ) );
		for(WebElement element: rowContact){
			String lastname = element.findElement ( By.xpath ( "./td[2]" ) ).getText ();
			String firstname = element.findElement ( By.xpath ( "./td[3]" ) ).getText ();
			int id = Integer.parseInt ( element.findElement ( By.tagName ( "input" ) ).getAttribute ( "value" ));
			contacts.add(new ContactData ( id, firstname, null, lastname, null ));
		}
		return contacts;
	}
}
