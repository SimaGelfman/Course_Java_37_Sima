package com.gelfman.courseJava.adressbook.appmanager;

import com.gelfman.courseJava.adressbook.model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

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

	public void fillContactForm ( ContactData contactData, boolean creation ) {
		type(By.name("firstname"), contactData.getFirstName () );
		type(By.name("middlename"), contactData.getMiddlename () );
		type(By.name("lastname"), contactData.getLastName () );
		if(creation) {
			new Select ( wd.findElement ( By.name ( "new_group" ) ) ).selectByVisibleText ( contactData.getGroup () );
		}else{
			Assert.assertFalse ( isElementPresent (By.name ( "new_group" )) );
		}
	}

	public void initContactCreation () {
		click( By.linkText("add new"));
	}

	public void selectSomeContact () {
		click ( By.name ( "selected[]" ) );
	}

	public void deleteSelectedContact () {
		click ( By.xpath ( "//div[@id='content']/form[2]/div[2]/input" ) );
		closeAlertWindow ();
	}

	public void initContactModification () {
		click ( By.xpath ( "//table[@id='maintable']/tbody/tr[2]/td[8]/a/img" ) );
	}

	public void submitContactModification(){
		click(By.xpath ( "//input[@type = 'submit']" ));
	}
}
