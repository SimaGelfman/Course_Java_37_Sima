package com.gelfman.courseJava.adressbook.tests;

import com.gelfman.courseJava.adressbook.appmanager.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

/**
 * Created by Sima.Gelfman on 2/6/2017.
 */
public class TestBased {

	protected static final ApplicationManager app = new ApplicationManager ( BrowserType.FIREFOX );

	@BeforeSuite
	public void setUp () throws Exception {
		app.init ();
	}

	@AfterSuite
	public void tearDown () {
		app.stop ();
	}

	public ApplicationManager getApp () {
		return app;
	}
}
