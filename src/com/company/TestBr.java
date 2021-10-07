package com.company;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class TestBr {

    WebDriver driver = null;

    @BeforeTest
    @Parameters("browser")
    public void setUp(String browser){
        System.out.println("Before Test");
        String url = "http://training.skillo-bg.com:4300/posts/all";

        if(browser.equalsIgnoreCase("chrome")){
            System.out.println("We are using Chrome browser");
            System.setProperty("webdriver.chrome.driver","C:\\Users\\Kris\\Documents\\Selenium\\chromedriver.exe");
            driver  = new ChromeDriver();
        }else if (browser.equalsIgnoreCase("firefox")){
            System.out.println("We are using Firefox");
            System.setProperty("webdriver.gecko.driver","C:\\Users\\Kris\\Documents\\Selenium\\geckodriver.exe");
            driver = new FirefoxDriver();
       }else if (browser.equalsIgnoreCase("edge")){
            System.out.println("We are using Edge");
            System.setProperty("webdriver.edge.driver","C:\\Users\\Kris\\Documents\\Selenium\\msedgedriver.exe");
            driver = new EdgeDriver();
       }else if (browser.equalsIgnoreCase("chromium")){
            System.out.println("We are using Chromium Headless");
            System.setProperty("webdriver.chrome.driver","C:\\Users\\Kris\\Documents\\Selenium\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            driver = new ChromeDriver(options);
       }

        driver.get(url);
    }

    @Test
    public void test1(){
        System.out.println("Test1");
    }
    @AfterTest
    public void cleanUp(){
        driver.close();
    }
    @AfterSuite
    public void cleanUpSuit(){
        // Quiting the Driers - Specifically for Firefox in order to quit and close.
     if (driver ==null){
         driver.quit();
     }
     }
}
