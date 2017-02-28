package com.gelfman.courseJava.adressbook.tests;

import com.gelfman.courseJava.adressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class GroupCreationTests extends TestBased {

	@Test
	public void testGroupCreation () {
		app.getNavigationMamager ().goToGroupPage ();
		List<GroupData> before = app.getGroupHelper ().getGroupList();
		app.getGroupHelper ().createGroup ( new GroupData ( "test1", null, "footer-test1" )  );
		List<GroupData> after = app.getGroupHelper ().getGroupList();
		Assert.assertEquals ( after.size (), before.size () + 1 );
	}

}
