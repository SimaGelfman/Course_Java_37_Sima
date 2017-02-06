package com.gelfman.courseJava.adressbook;

import org.testng.annotations.Test;


public class GroupCreationTests extends TestBased {

	@Test
	public void testGroupCreation () {
		goToGroupPage ();
		initGroupCreation ();
		fillGroupForm ( new GroupData ( "test1", "header-test1", "footer-test1" ) );
		submitGroupCreation ();
		returnToGroupPage ();
	}

}
