package com.gelfman.courseJava.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Sima.Gelfman on 2/9/2017.
 */
public class NavigationMamager extends HelperBased{
	private FirefoxDriver wd;

	public NavigationMamager ( FirefoxDriver wd ) {
		super(wd);;
	}

	public void goToGroupPage () {
	    click ( By.linkText("groups"));
	}

	public void goToHomePage () {
		click( By.linkText("home"));
	}

}
