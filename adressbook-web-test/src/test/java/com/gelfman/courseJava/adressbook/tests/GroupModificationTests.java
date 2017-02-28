package com.gelfman.courseJava.adressbook.tests;

import com.gelfman.courseJava.adressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by Sima.Gelfman on 2/14/2017.
 */
public class GroupModificationTests extends TestBased {

	@Test
	public void testGroupModification () {
		app.getNavigationMamager ().goToGroupPage ();
		if (!app.getGroupHelper ().isThereAGroup ()) {
			app.getGroupHelper ().createGroup ( new GroupData ( "test1", "test1", "test3" ) );
		}
		List<GroupData> before = app.getGroupHelper ().getGroupList();
		app.getGroupHelper ().selectGroup (before.size() - 1);
		app.getGroupHelper ().initGroupModification ();
		app.getGroupHelper ().fillGroupForm ( new GroupData ( "test1", "testChange1", "testChange2" ) );
		app.getGroupHelper ().submitGroupModification ();
		app.getGroupHelper ().returnToGroupPage ();
		List<GroupData> after = app.getGroupHelper ().getGroupList();
		Assert.assertEquals ( after.size (), before.size() );
	}
}
