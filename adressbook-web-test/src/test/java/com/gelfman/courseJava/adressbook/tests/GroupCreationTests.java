package com.gelfman.courseJava.adressbook.tests;

import com.gelfman.courseJava.adressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;


public class GroupCreationTests extends TestBased {

	@Test
	public void testGroupCreation () {
		app.getNavigationMamager ().goToGroupPage ();
		int before = app.getGroupHelper ().getGroupCount();
		app.getGroupHelper ().createGroup ( new GroupData ( "test1", null, "footer-test1" )  );
		int after = app.getGroupHelper ().getGroupCount();
		Assert.assertEquals ( after, before + 1 );
	}

}
