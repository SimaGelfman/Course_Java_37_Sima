package com.gelfman.courseJava.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Sima.Gelfman on 2/8/2017.
 */
public class ApplicationManager {

	FirefoxDriver wd;

	private NavigationMamager navigationMamager;
	private GroupHelper groupHelper;
	private SessionHelper sessionHelper;
	private ContactHelper contactHelper;

	public void init () {
		wd = new FirefoxDriver ();
		wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		wd.get("http://localhost/addressbook/");
		groupHelper = new GroupHelper ( wd );
		navigationMamager = new NavigationMamager (wd);
		contactHelper = new ContactHelper ( wd );
		sessionHelper = new SessionHelper (wd);
		sessionHelper.login ( "admin", "secret" );
	}


	public void stop () {
		wd.quit();
	}

	public GroupHelper getGroupHelper () {
		return groupHelper;
	}

	public NavigationMamager getNavigationMamager () {
		return navigationMamager;
	}

	public ContactHelper getContactHelper(){
		return contactHelper; }
}
