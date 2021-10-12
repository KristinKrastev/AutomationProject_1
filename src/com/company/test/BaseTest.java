package com.company.test;

import com.company.configuration.Configuration;
import com.company.configuration.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;

public class BaseTest {

    private ThreadLocal <Driver> baseDriver = new ThreadLocal<Driver>();
    protected String username;
    protected String password;

    protected Driver getBaseDriver(){
        return baseDriver.get();
    }


    @BeforeMethod
    @Parameters("browser")
    void beforeMethod(String browser) {
               baseDriver.set(new Driver(browser));
        getBaseDriver().loadBaseUrl();
    }

    @BeforeClass
    void beforeClass() throws IOException {
        username = Configuration.readUsername();
        password = Configuration.readPass();

    }
    @BeforeTest
    void beforeTest() throws IOException {
        Configuration.loadConfigurations();
    }

    @AfterMethod
    void cleanUp(ITestResult result) throws IOException {
       /* if(ITestResult.FAILURE==result.getStatus()){
            FileHelpers.takeScreenshot(getDriver().getWebDriver(), result);
        }*/
        getBaseDriver().killDriverSession();
    }
    @AfterSuite
    public void cleanUpSuit(){
        // Quiting the Driers - Specifically for Firefox in order to quit and close.
        if (getBaseDriver() ==null){
            getBaseDriver().quit();
        }
    }
}
