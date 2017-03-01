package com.gelfman.courseJava.adressbook.tests;

import com.gelfman.courseJava.adressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.zip.Inflater;


public class GroupCreationTests extends TestBased {

	@Test
	public void testGroupCreation () {
		app.getNavigationMamager ().goToGroupPage ();
		List<GroupData> before = app.getGroupHelper ().getGroupList();
		GroupData group = new GroupData ( "test4", null, "footer-test1" );
		app.getGroupHelper ().createGroup ( group );
		List<GroupData> after = app.getGroupHelper ().getGroupList();
		Assert.assertEquals ( after.size (), before.size () + 1 );

		before.add(group);
		Comparator<? super GroupData> byId = (g1,g2) -> Integer.compare ( g1.getId (), g2.getId () );
		before.sort ( byId );
		after.sort ( byId );
		Assert.assertEquals (before,after);
	}

}
