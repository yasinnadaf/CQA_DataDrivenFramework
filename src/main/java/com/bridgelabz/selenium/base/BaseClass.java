package com.bridgelabz.selenium.base;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BaseClass {
    public static WebDriver driver;
//    public static ExtentReports reports;
    public static ExtentReports reports;
    public static ExtentTest test;
    public void initialization(String browserName){
        reports = new ExtentReports("C:\\CQADataDrivenFramework\\ExtentReport.html");
        test = reports.startTest("Extent report started recording steps");
        if (browserName.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver= new ChromeDriver();
            driver.manage().window().maximize();

            driver.get("https://www.linkedin.com/");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        }else if(browserName.equalsIgnoreCase("edge")){
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            driver.manage().window().maximize();
            driver.get("https://www.linkedin.com/");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        }
    }
    public void tearDown(){
        driver.close();
        reports.endTest(test);
        reports.flush();
    }


    public static void takesScreenshot(String methodN) throws IOException {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File src = screenshot.getScreenshotAs(OutputType.FILE);
        File file = new File("C:\\CQADataDrivenFramework\\screenshot\\"+methodN+".png");
        FileUtils.copyFile(src, file);
    }

}

