package com.gelfman.courseJava.adressbook.tests;

import com.gelfman.courseJava.adressbook.model.GroupData;
import com.gelfman.courseJava.adressbook.model.Groups;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.testng.Assert.*;

/**
 * Created by Sima.Gelfman on 2/14/2017.
 */
public class GroupModificationTests extends TestBased {

	@BeforeMethod
	public void ensurePreconditions () {
		app.goTo ().groupPage ();
		if (app.group ().all ().size () == 0) {
			app.group ().create ( new GroupData ().withName ( "test1" ).withHeader ( "test1" ).withFooter ( "test3" ) );
		}
	}

	@Test
	public void testGroupModification () {
		Groups before = app.group ().all ();
		GroupData modifyGroup = before.iterator ().next ();
		GroupData group = new GroupData ()
						.withId ( modifyGroup.getId () ).withName ( "chtest1" ).withHeader ( "testChange1" ).withFooter ( "testChange2" );
		app.group ().modify ( group );
		assertEquals ( app.group ().count (), before.size () );
		Groups after = app.group ().all ();
		assertThat ( after, equalTo ( before.without ( modifyGroup ).withAdded ( group ) ) );

	}


}
