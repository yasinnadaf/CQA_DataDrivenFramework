package com.bridgelabz.selenium.test;

import com.bridgelabz.selenium.base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.Dashboard;
import pages.LoginPage;
import readexcel.DataProviderLogic;


public class LinkedInTest extends BaseClass {
    LoginPage loginPage;
    Dashboard dashboard;
    @BeforeMethod
    @Parameters("browserName")
    public void setUp(@Optional ("chrome") String browser){
        initialization(browser);
        loginPage = new LoginPage(driver);
        dashboard = new Dashboard(driver);
    }

    @Test(dataProvider = "testData", dataProviderClass = DataProviderLogic.class)
    public void loginToInstagram(String userName, String Password) throws InterruptedException {
        String loginPageTitle = loginPage.loginToInsta(userName,Password);
        Assert.assertEquals("(9) Feed | LinkedIn",loginPageTitle);
    }
    @AfterMethod
    public void browserClose(){
        tearDown();
    }
}


