package com.gelfman.courseJava.adressbook.tests;

import com.gelfman.courseJava.adressbook.model.GroupData;
import org.testng.annotations.Test;


public class GroupCreationTests extends TestBased {

	@Test
	public void testGroupCreation () {
		app.getNavigationMamager ().goToGroupPage ();
		app.getGroupHelper ().initGroupCreation ();
		app.getGroupHelper ().fillGroupForm ( new GroupData ( "test1", "header-test1", "footer-test1" ) );
		app.getGroupHelper ().submitGroupCreation ();
		app.getGroupHelper ().returnToGroupPage ();
	}

}
