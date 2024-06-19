package org.example;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.File;

public class BaseTests {
    WebDriver driver;

    @BeforeMethod
    @Parameters("baseurl")
    public void setup(String baseurl ){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\ravis\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(baseurl);
    }

    @AfterMethod
    public void cleanup(ITestResult result){
        if (result.getStatus()==ITestResult.FAILURE){
            System.out.println("Test Failed");
                File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(f,
                        new File("https://www.saucedemo.com//test.png"+result.getTestName()));
            }catch (Exception ex){
                System.out.println("exception " +ex.getMessage());
            }

        }
        driver.close();
        driver.quit();

    }
}