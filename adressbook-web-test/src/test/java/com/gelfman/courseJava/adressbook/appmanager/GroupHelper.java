package com.gelfman.courseJava.adressbook.appmanager;

import com.gelfman.courseJava.adressbook.model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Sima.Gelfman on 2/9/2017.
 */
public class GroupHelper extends HelperBased {

	public GroupHelper ( FirefoxDriver wd ) {
		super ( wd );
	}

	public void returnToGroupPage () {
		click ( By.linkText("group page") );
	}

	public void submitGroupCreation () {
		click ( By.name ( "submit" ) );
	}

	public void fillGroupForm ( GroupData groupData ) {
		type ( By.name ( "group_name" ), groupData.getGroupName () );
		type ( By.name("group_header"), groupData.getHeader () );
		type ( By.name("group_footer"), groupData.getFooter () );
	}

	public void initGroupCreation () {
		click ( By.name("new") );
	}

	public void deleteSelectedGroups () {
		click ( By.xpath("//div[@id='content']/form/input[5]") );
	}

	public void selectGroup () {
		click ( By.name("selected[]") );
	}
}
