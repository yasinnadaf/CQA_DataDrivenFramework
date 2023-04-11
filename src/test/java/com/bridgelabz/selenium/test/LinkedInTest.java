package com.bridgelabz.selenium.test;

import com.bridgelabz.selenium.base.BaseClass;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
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

    @Test(description = "Login to linkedin" ,dataProvider = "testData", dataProviderClass = DataProviderLogic.class)
    @Severity(SeverityLevel.CRITICAL)
    @Epic("functional testing scenario")
    @Story("Login")
    public void loginToInstagram(String userName, String Password) throws InterruptedException {
        String loginPageTitle = loginPage.loginToInsta(userName,Password);
        Assert.assertEquals("(15) Feed | LinkedIn",loginPageTitle);
    }
    @AfterMethod
    public void browserClose(){
        tearDown();
    }
}


