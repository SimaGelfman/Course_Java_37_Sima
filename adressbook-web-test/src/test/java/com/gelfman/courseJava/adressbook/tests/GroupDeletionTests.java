package com.gelfman.courseJava.adressbook.tests;

import com.gelfman.courseJava.adressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class GroupDeletionTests extends TestBased {

	@Test
	public void testGroupDeletion () {
		app.getNavigationMamager ().goToGroupPage ();
		if (!app.getGroupHelper ().isThereAGroup ()) {
			app.getGroupHelper ().createGroup ( new GroupData ( "test1", null, "footer-test1" ) );
		}
		List<GroupData> before = app.getGroupHelper ().getGroupList();
		app.getGroupHelper ().selectGroup (before.size() - 1);
		app.getGroupHelper ().deleteSelectedGroups ();
		app.getGroupHelper ().returnToGroupPage ();
		List<GroupData> after = app.getGroupHelper ().getGroupList();
		Assert.assertEquals ( after.size (), before.size() - 1 );
		before.remove ( before.size () - 1 );
		Assert.assertEquals ( before, after );
	}

}
