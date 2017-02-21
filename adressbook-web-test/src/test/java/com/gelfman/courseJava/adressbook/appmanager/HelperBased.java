package com.gelfman.courseJava.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Sima.Gelfman on 2/12/2017.
 */
public class HelperBased {
	protected WebDriver wd;

	public HelperBased ( WebDriver wd ) {
		this.wd = wd;
	}

	protected void click ( By locator ) {
		wd.findElement( locator ).click();
	}

	protected void type ( By locator, String text ) {
		click ( locator );
		if(text != null) {
			String existingText = wd.findElement ( locator ).getAttribute ( "value" );
			if (!existingText.equals ( text )) {
				wd.findElement ( locator ).clear ();
				wd.findElement ( locator ).sendKeys ( text );
			}
		}
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

	public boolean isElementPresent(By lacator){
		try{
			wd.findElement(lacator);
			return true;
		}
		catch (NoSuchElementException e){
			return false;
		}
	}
}
