package com.gelfman.courseJava.adressbook.tests;

import com.gelfman.courseJava.adressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
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
		GroupData group = new GroupData ( before.get ( before.size() - 1 ).getId (),"test1", "testChange1", "testChange2");
		app.getGroupHelper ().fillGroupForm (group );
		app.getGroupHelper ().submitGroupModification ();
		app.getGroupHelper ().returnToGroupPage ();
		List<GroupData> after = app.getGroupHelper ().getGroupList();
		Assert.assertEquals ( after.size (), before.size() );
		before.remove(before.size () - 1);
		before.add(group);
		Assert.assertEquals ( new HashSet<Object> ( before ), new HashSet<Object> ( after ) );
	}
}
