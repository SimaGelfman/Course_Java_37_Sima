package com.gelfman.courseJava.adressbook;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;

public class GroupCreationTests {
    FirefoxDriver wd;
    
    @BeforeMethod
    public void setUp() throws Exception {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }
    
    @Test
    public void GroupCreationTests() {
        wd.get("http://localhost/addressbook/");
        login ( "admin", "secret" );
        goToGroupPage ();
        initGroupCreation ();
        fillGroupForm ( new GroupData ( "test1", "header-test1", "footer-test1" ) );
        submitGroupCreation ();
        returnToGroupPage ();
    }

    private void returnToGroupPage () {
        wd.findElement( By.linkText("group page")).click();
    }

    private void submitGroupCreation () {
        wd.findElement( By.name("submit")).click();
    }

    private void fillGroupForm ( GroupData groupData ) {
        wd.findElement( By.name("group_name")).click();
        wd.findElement(By.name("group_name")).clear();
        wd.findElement(By.name("group_name")).sendKeys( groupData.getGroupName () );
        wd.findElement(By.name("group_header")).click();
        wd.findElement(By.name("group_header")).clear();
        wd.findElement(By.name("group_header")).sendKeys( groupData.getHeader () );
        wd.findElement(By.name("group_footer")).click();
        wd.findElement(By.name("group_footer")).clear();
        wd.findElement(By.name("group_footer")).sendKeys( groupData.getFooter () );
    }

    private void initGroupCreation () {
        wd.findElement( By.name("new")).click();
    }

    private void goToGroupPage () {
        wd.findElement( By.linkText("groups")).click();
    }

    private void login ( String userName, String password ) {
        wd.findElement( By.name("user")).click();
        wd.findElement(By.name("user")).clear();
        wd.findElement(By.name("user")).sendKeys( userName );
        wd.findElement(By.name("pass")).click();
        wd.findElement(By.name("pass")).clear();
        wd.findElement(By.name("pass")).sendKeys( password );
        wd.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();

    }

    @AfterMethod
    public void tearDown() {
        wd.quit();
    }
    
    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}