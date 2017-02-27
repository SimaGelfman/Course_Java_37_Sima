package com.gelfman.courseJava.adressbook.tests;

import com.gelfman.courseJava.adressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

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
		int before = app.getGroupHelper ().getGroupCount ();
		app.getGroupHelper ().selectGroup (before - 1);
		app.getGroupHelper ().initGroupModification ();
		app.getGroupHelper ().fillGroupForm ( new GroupData ( "test1", "testChange1", "testChange2" ) );
		app.getGroupHelper ().submitGroupModification ();
		app.getGroupHelper ().returnToGroupPage ();
		int after = app.getGroupHelper ().getGroupCount ();
		Assert.assertEquals ( after, before );
	}
}
