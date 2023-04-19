package com.bridgelabz.selenium.test;

import com.bridgelabz.selenium.base.BaseClass;
import com.bridgelabz.selenium.base.testnglisteners.ITestListeners;
import com.relevantcodes.extentreports.LogStatus;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.Dashboard;
import pages.LoginPage;
import pages.SignUpPage;
import readexcel.DataProviderLogic;

@Listeners (ITestListeners.class)
public class LinkedInTest extends BaseClass {
    LoginPage loginPage;
    Dashboard dashboard;
    SignUpPage signUp;
    @BeforeMethod
    @Parameters("browserName")
    public void setUp(@Optional ("chrome") String browser){
        initialization(browser);
        loginPage = new LoginPage(driver);
        dashboard = new Dashboard(driver);
        signUp = new SignUpPage(driver);
        test.log(LogStatus.PASS, "setUp");
    }

    @Test(description = "Login to linkedin" ,dataProvider = "testData", dataProviderClass = DataProviderLogic.class)
    @Severity(SeverityLevel.CRITICAL)
    @Epic("functional testing scenario")
    @Story("Login")
    public void loginToLinkedin(String userName, String Password) throws InterruptedException {
        String loginPageTitle = loginPage.loginToInsta(userName,Password);
        if (loginPageTitle.equalsIgnoreCase("(15) Feed | LinkedIn")){
            test.log(LogStatus.PASS, "loginToLinkedin");
        }
        else {
            test.log(LogStatus.FAIL, "loginToLinkedin");
        }
        Assert.assertEquals("LinkedIn",loginPageTitle);
        test.log(LogStatus.PASS, "setUp");
    }
    @Test
    public void registrationToLinkedin(){
        signUp.gotoSignUp();
    }

    @AfterMethod
    public void browserClose(){
        test.log(LogStatus.PASS, "setUp");
        tearDown();
    }
}


