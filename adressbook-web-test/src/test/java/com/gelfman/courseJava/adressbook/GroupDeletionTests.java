package com.gelfman.courseJava.adressbook;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;

public class GroupDeletionTests extends TestBased {

	@Test
	public void testGroupDeletion () {
		goToGroupPage ();
		selectGroup ();
		deleteSelectedGroups ();
		returnToGroupPage ();
	}

}
