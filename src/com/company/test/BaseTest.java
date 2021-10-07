package com.company.test;

import com.company.configuration.Configuration;
import com.company.configuration.Driver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;

public class BaseTest {
    private ThreadLocal <Driver> driver = new ThreadLocal<Driver>();

    protected Driver getDriver(){
        return driver.get();
    }

    protected String username;
    protected String password;
    protected String scrDirectory;

    @BeforeTest
    void beforeTest() throws IOException {
        Configuration.loadConfigurations();
    }

    @BeforeClass
    void beforeClass() throws IOException {
        username = Configuration.readUsername();
        password = Configuration.readPass();

    }
    @BeforeMethod
    @Parameters("browser")
    void setup(String browser) {
        driver.set(new Driver("browser"));
        driver.get().loadBaseUrl();
    }

    @AfterMethod
    void cleanUp(ITestResult result) throws IOException {
       /* if(ITestResult.FAILURE==result.getStatus()){
            FileHelpers.takeScreenshot(getDriver().getWebDriver(), result);
        }*/
        getDriver().killDriverSession();
    }
}
