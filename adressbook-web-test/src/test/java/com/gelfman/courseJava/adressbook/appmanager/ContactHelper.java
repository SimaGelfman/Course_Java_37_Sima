package com.gelfman.courseJava.adressbook.appmanager;

import com.gelfman.courseJava.adressbook.model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

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

	public void fillContactForm ( ContactData contactData ) {
		click( By.name("firstname"));
		type(By.name("firstname"), contactData.getFirstName () );
		click(By.name("middlename"));
		type(By.name("middlename"), contactData.getMiddlename () );
		click(By.name("lastname"));
		type(By.name("lastname"), contactData.getLastName () );
		click(By.name("nickname"));
		type(By.name("nickname"), contactData.getNickName () );
		click(By.name("title"));
		type(By.name("title"),contactData.getTitle () );
		click(By.name("company"));
		type(By.name("company"),contactData.getCompany () );
		click(By.name("address"));
		type(By.name("address"), contactData.getCompanAddress () );
		click(By.name("home"));
		type(By.name("home"),contactData.getHomePhone () );
		click(By.name("mobile"));
		type(By.name("mobile"), contactData.getMobilePhone () );
		click(By.name("work"));
		type(By.name("work"), contactData.getWorkPhone () );
		click(By.name("fax"));
		type(By.name("fax"),contactData.getFaxPhone () );
		click(By.name("email"));
		type(By.name("email"),contactData.getEmail1 () );
		click(By.name("address2"));
		type(By.name("address2"),contactData.getAdress2 () );
		click(By.name("phone2"));
		type(By.name("phone2"),contactData.getHomeNumber () );
		click(By.name("notes"));
		type(By.name("notes"),contactData.getNote () );
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
