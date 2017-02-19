package com.gelfman.courseJava.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Sima.Gelfman on 2/9/2017.
 */
public class NavigationMamager extends HelperBased{
	private WebDriver wd;

	public NavigationMamager ( WebDriver wd ) {
		super(wd);;
	}

	public void goToGroupPage () {
	    click ( By.linkText("groups"));
	}

	public void goToHomePage () {
		click( By.linkText("home"));
	}

}
