package com.gelfman.courseJava.adressbook.tests;

import org.testng.annotations.Test;

/**
 * Created by Sima.Gelfman on 2/14/2017.
 */
public class ContactDeletionTests extends TestBased {

	@Test
	public void testContactDeletion(){
		app.getContactHelper ().selectSomeContact();
		app.getContactHelper ().deleteSelectedContact ();
	}

}
