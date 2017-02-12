package com.gelfman.courseJava.adressbook.tests;

import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBased {

	@Test
	public void testGroupDeletion () {
		app.getNavigationMamager ().goToGroupPage ();
		app.getGroupHelper ().selectGroup ();
		app.getGroupHelper ().deleteSelectedGroups ();
		app.getGroupHelper ().returnToGroupPage ();
	}

}
