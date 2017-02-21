package com.gelfman.courseJava.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

/**
 * Created by Sima.Gelfman on 2/8/2017.
 */
public class ApplicationManager {

	WebDriver wd;

	private NavigationMamager navigationMamager;
	private GroupHelper groupHelper;
	private SessionHelper sessionHelper;
	private ContactHelper contactHelper;
  private String browser;

	public ApplicationManager(String browser){
		this.browser = browser;
	}


	public void init () {
		if(browser.equals (  BrowserType.FIREFOX))  {
			wd = new FirefoxDriver (  );
		}else if(browser.equals ( BrowserType.CHROME)){
			wd = new ChromeDriver (  );
		}else  if(browser.equals ( BrowserType.IE)){
			wd = new InternetExplorerDriver (  );
		}
	//	wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
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
