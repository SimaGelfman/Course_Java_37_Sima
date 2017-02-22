package com.gelfman.courseJava.adressbook.tests;

import com.gelfman.courseJava.adressbook.appmanager.ApplicationManager;
import com.gelfman.courseJava.adressbook.model.ContactData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;

public class ContactCreationTests extends TestBased{

    @Test
    public void ContactCreationTests() {
        app.getNavigationMamager ().goToHomePage ();
        app.getContactHelper ().createContact (  new ContactData ( "Alexandr", "Petrovich", "Kozlov","test1") );
    }


}
