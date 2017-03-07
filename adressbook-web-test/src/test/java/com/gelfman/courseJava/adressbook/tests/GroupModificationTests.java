package com.gelfman.courseJava.adressbook.tests;

import com.gelfman.courseJava.adressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

/**
 * Created by Sima.Gelfman on 2/14/2017.
 */
public class GroupModificationTests extends TestBased {

	@BeforeMethod
	public void ensurePreconditions () {
		app.goTo ().groupPage ();
		if (app.group ().list ().size () == 0) {
			app.group ().create ( new GroupData ().withName ( "test1" ).withHeader ( "test1" ).withFooter ( "test3" ) );
		}
	}

	@Test
	public void testGroupModification () {
		Set<GroupData> before = app.group ().all ();
		GroupData modifyGroup = before.iterator ().next ();
		GroupData group = new GroupData ()
						.withId ( modifyGroup.getId () ).withName ( "chtest1" ).withHeader ( "testChange1" ).withFooter ( "testChange2" );
		app.group ().modify ( group );
		Set<GroupData> after = app.group ().all ();
		Assert.assertEquals ( after.size (), before.size () );
		before.remove ( modifyGroup);
		before.add ( group );
		Assert.assertEquals ( before, after );
	}


}
