package com.gelfman.courseJava.adressbook.tests;

import com.gelfman.courseJava.adressbook.model.GroupData;
import org.testng.annotations.Test;

/**
 * Created by Sima.Gelfman on 2/14/2017.
 */
public class GroupModificationTests extends TestBased{

	@Test
	public void testGroupModification(){
		app.getNavigationMamager ().goToGroupPage ();
		if(!app.getGroupHelper ().isThereAGroup ()){
			app.getGroupHelper ().createGroup ( new GroupData("test1", "test1", "test3" ));
		}
		app.getGroupHelper ().selectGroup ();
		app.getGroupHelper ().initGroupModification();
		app.getGroupHelper ().fillGroupForm (new GroupData ( "test1", "testChange1", "testChange2") );
		app.getGroupHelper ().submitGroupModification ();
		app.getGroupHelper ().returnToGroupPage ();
	}
}
