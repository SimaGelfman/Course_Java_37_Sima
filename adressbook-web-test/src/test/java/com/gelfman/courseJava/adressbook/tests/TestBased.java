package com.gelfman.courseJava.adressbook.tests;

import com.gelfman.courseJava.adressbook.appmanager.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 * Created by Sima.Gelfman on 2/6/2017.
 */
public class TestBased {

	protected final ApplicationManager app = new ApplicationManager ( BrowserType.IE);

	@BeforeMethod
	public void setUp () throws Exception {
		app.init ();
	}

	@AfterMethod
	public void tearDown () {
		app.stop ();
	}

	public ApplicationManager getApp () {
		return app;
	}
}
