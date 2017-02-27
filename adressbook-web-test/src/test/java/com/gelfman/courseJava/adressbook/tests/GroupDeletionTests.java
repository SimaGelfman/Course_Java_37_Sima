package com.gelfman.courseJava.adressbook.tests;

import com.gelfman.courseJava.adressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBased {

	@Test
	public void testGroupDeletion () {
		app.getNavigationMamager ().goToGroupPage ();
		if (!app.getGroupHelper ().isThereAGroup ()) {
			app.getGroupHelper ().createGroup ( new GroupData ( "test1", null, "footer-test1" ) );
		}
		int before = app.getGroupHelper ().getGroupCount ();
		app.getGroupHelper ().selectGroup (0);
		app.getGroupHelper ().deleteSelectedGroups ();
		app.getGroupHelper ().returnToGroupPage ();
		int after = app.getGroupHelper ().getGroupCount ();
		Assert.assertEquals ( after, before - 1 );
	}

}
