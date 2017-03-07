package com.gelfman.courseJava.adressbook.tests;

import com.gelfman.courseJava.adressbook.model.GroupData;
import com.gelfman.courseJava.adressbook.model.Groups;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class GroupCreationTests extends TestBased {

	@Test
	public void testGroupCreation () {
		app.goTo ().groupPage ();
		Groups before = app.group ().all ();
		GroupData group = new GroupData ().withName ( "test4" ).withFooter ( "footer-test1" );
		app.group ().create ( group );
		Groups after = app.group ().all ();
		assertThat ( after.size (), equalTo ( before.size () + 1 ) );
		assertThat ( after, equalTo
						( before.withAdded ( group.withId ( after.stream ().mapToInt ( ( g ) -> g.getId () ).max ().getAsInt () ) ) ) );
	}

}
