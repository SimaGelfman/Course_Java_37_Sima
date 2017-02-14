package com.gelfman.courseJava.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Sima.Gelfman on 2/12/2017.
 */
public class HelperBased {
	protected FirefoxDriver wd;

	public HelperBased ( FirefoxDriver wd ) {
		this.wd = wd;
	}

	protected void click ( By locator ) {
		wd.findElement( locator ).click();
	}

	protected void type ( By locator, String text ) {
		click ( locator );
		wd.findElement(locator).clear();
		wd.findElement(locator).sendKeys( text );
	}

	protected void closeAlertWindow(){
		wd.switchTo().alert().accept();
	}

	public  boolean isAlertPresent() {
		try {
			wd.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}
}
