package com.gelfman.courseJava.adressbook.appmanager;

import com.gelfman.courseJava.adressbook.model.GroupData;
import com.gelfman.courseJava.adressbook.model.Groups;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by Sima.Gelfman on 2/9/2017.
 */
public class GroupHelper extends HelperBased {

	public GroupHelper ( WebDriver wd ) {
		super ( wd );
	}

	private Groups groupsCash = null;

	public void returnToGroupPage () {
		click ( By.linkText ( "group page" ) );
	}

	public void submitGroupCreation () {
		click ( By.name ( "submit" ) );
	}

	public void fillGroupForm ( GroupData groupData ) {
		type ( By.name ( "group_name" ), groupData.getGroupName () );
		type ( By.name ( "group_header" ), groupData.getHeader () );
		type ( By.name ( "group_footer" ), groupData.getFooter () );
	}

	public void initGroupCreation () {
		click ( By.name ( "new" ) );
	}

	public void deleteSelectedGroups () {
		click ( By.xpath ( "//div[@id='content']/form/input[5]" ) );
	}

	public void selectGroup ( int index ) {
		wd.findElements ( By.name ( "selected[]" ) ).get ( index ).click ();
	}

	public void initGroupModification () {
		click ( By.name ( "edit" ) );
	}

	public void submitGroupModification () {
		click ( By.name ( "update" ) );
	}

	public void create ( GroupData group ) {
		initGroupCreation ();
		fillGroupForm ( group );
		submitGroupCreation ();
		groupsCash = null;
		returnToGroupPage ();
	}

	public void delete ( GroupData group ) {
		selectGroupById ( group.getId () );
		deleteSelectedGroups ();
		groupsCash = null;
		returnToGroupPage ();
	}

	public void modify (  GroupData group ) {
		selectGroupById (group.getId () );
		initGroupModification ();
		fillGroupForm ( group );
		submitGroupModification ();
		groupsCash = null;
		returnToGroupPage ();
	}

	public boolean isThereAGroup () {
		return isElementPresent ( By.name ( "selected[]" ) );
	}

	public int count () {
		return wd.findElements ( By.name ( "selected[]" ) ).size ();
	}

	public Groups all () {
		if (groupsCash != null){
			return new Groups ( groupsCash );
		}
		groupsCash = new Groups ();
		List<WebElement> elements = wd.findElements ( By.cssSelector ( "span.group" ) );
		for (WebElement element : elements) {
			String name = element.getText ();
			int id = Integer.parseInt ( element.findElement ( By.tagName ( "input" ) ).getAttribute ( "value" ) );
			groupsCash.add ( new GroupData ().withId ( id ).withName ( name ) );
		}
		return new Groups ( groupsCash );
	}


	private void selectGroupById ( int id ) {
		wd.findElement ( By.cssSelector ( "input[value='" + id + "']" ) ).click ();
	}
}
