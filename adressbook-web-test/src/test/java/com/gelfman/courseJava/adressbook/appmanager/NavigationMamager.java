package com.gelfman.courseJava.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Sima.Gelfman on 2/9/2017.
 */
public class NavigationMamager extends HelperBased {

	public NavigationMamager ( WebDriver wd ) {
		super ( wd );
	}

	public void groupPage () {
		if (isElementPresent ( By.tagName ( "h1" ) ) && wd.findElement ( By.tagName ( "h1" ) ).getText ().equals ( "Groups" )
						&& isElementPresent ( By.name ( "new" ) )) {
			return;
		} else {
			click ( By.linkText ( "groups" ) );
		}
	}

	public void homePage () {
		if (isElementPresent ( By.id ( "maintable" ) )) {
			return;
		} else {
			click ( By.linkText ( "home" ) );
		}
	}

}
