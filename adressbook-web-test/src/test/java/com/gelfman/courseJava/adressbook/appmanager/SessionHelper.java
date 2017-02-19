package com.gelfman.courseJava.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Sima.Gelfman on 2/9/2017.
 */
public class SessionHelper extends HelperBased{
	private WebDriver wd;

	public SessionHelper ( WebDriver wd ) {
		super(wd);
	}

	public void login(String username, String password){
		type( By.name("user"),username);
		type( By.name("pass"),password);
		click ( By.xpath ( "//form[@id='LoginForm']/input[3] ") );

	}
}
