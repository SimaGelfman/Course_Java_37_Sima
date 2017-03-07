package com.gelfman.courseJava.adressbook.tests;

import com.gelfman.courseJava.adressbook.model.GroupData;
import com.gelfman.courseJava.adressbook.model.Groups;
import org.hamcrest.CoreMatchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class GroupDeletionTests extends TestBased {

	@BeforeMethod
	public void ensurePreconditions () {
		app.goTo ().groupPage ();
		if (app.group ().all ().size () == 0) {
			app.group ().create ( new GroupData ().withName ( "test1" ).withHeader ( "test1" ).withFooter ( "test3" ) );
		}
	}


	@Test
	public void testGroupDeletion () {
		Groups before = app.group ().all ();
		GroupData deletedGroup = before.iterator ().next ();
		app.group ().delete ( deletedGroup );
		Groups after = app.group ().all ();
		assertEquals ( after.size (), before.size () - 1 );
		assertThat ( after, CoreMatchers.equalTo ( before.without ( deletedGroup ) ) );
	}


}
