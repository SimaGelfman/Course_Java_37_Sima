package com.gelfman.courseJava.adressbook.tests;

import com.gelfman.courseJava.adressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

/**
 * Created by Sima.Gelfman on 2/14/2017.
 */
public class GroupModificationTests extends TestBased {

	@BeforeMethod
	public void ensurePreconditions () {
		app.goTo ().groupPage ();
		if (app.group ().list ().size () == 0) {
			app.group ().create ( new GroupData ( "test1", "test1", "test3" ) );
		}
	}

	@Test
	public void testGroupModification () {
		List<GroupData> before = app.group ().list ();
		int index = before.size () - 1;
		GroupData group = new GroupData ( before.get ( index ).getId (),"test1", "testChange1", "testChange2");
		app.group ().modify ( index, group );
		List<GroupData> after = app.group ().list ();
		Assert.assertEquals ( after.size (), before.size() );
		before.remove( index );
		before.add(group);

		Comparator<? super GroupData> byId = (g1,g2) -> Integer.compare ( g1.getId (), g2.getId () );
		before.sort ( byId );
		after.sort ( byId );
		Assert.assertEquals ( before, after );
	}




}
