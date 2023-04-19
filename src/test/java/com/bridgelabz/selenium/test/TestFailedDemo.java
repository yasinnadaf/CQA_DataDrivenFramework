package com.bridgelabz.selenium.test;

import com.bridgelabz.selenium.base.BaseClass;
import com.bridgelabz.selenium.base.testnglisteners.ITestListeners;
import org.testng.Assert;
import org.testng.annotations.*;

@Listeners(ITestListeners.class)
public class TestFailedDemo extends BaseClass {
    @BeforeMethod
    @Parameters("browserName")
    public void setUp(@Optional("chrome") String browser) {     // for taking Screen shot
        initialization(browser);
    }

    @Test
    public void testPassed(){
        Assert.assertTrue(true);
    }

    @Test
    public void testFailed(){
        Assert.assertTrue(false);
    }

    @Test(dependsOnMethods = "testPassed")
    public void testDepends(){
        Assert.assertTrue(true);

    }

}
