package com.company.configuration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.Set;

public class Driver implements WebDriver {

    //WebDriver driver = null;
    ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    //Driver Constructor
    public Driver (String browser){
        if(browser.equalsIgnoreCase("chrome")){
            System.out.println("This is inside Driver Class - Chrome");
            System.setProperty("webdriver.chrome.driver","C:\\Users\\Kris\\Documents\\Selenium\\chromedriver.exe");
            driver.set(new ChromeDriver());
        }else if (browser.equalsIgnoreCase("firefox")){
            System.out.println("This is inside Driver Class - Firefox");
            System.setProperty("webdriver.gecko.driver","C:\\Users\\Kris\\Documents\\Selenium\\geckodriver.exe");
            driver.set(new FirefoxDriver()); ;
        }else if (browser.equalsIgnoreCase("edge")){
            System.out.println("This is inside Driver Class - Edge");
            System.setProperty("webdriver.edge.driver","C:\\Users\\Kris\\Documents\\Selenium\\msedgedriver.exe");
            driver.set(new EdgeDriver());
        }else if (browser.equalsIgnoreCase("chromium")){
            System.out.println("This is inside Driver Class - Headless Chrome");
            System.setProperty("webdriver.chrome.driver","C:\\Users\\Kris\\Documents\\Selenium\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            driver.set(new ChromeDriver(options));
        }
        driver.get().manage().window().maximize();

    }

    public WebDriver getWebDriver(){

        return driver.get();
    }
    public void loadBaseUrl(){
        String url = Configuration.readBaseUrl();
        get(url);
    }
    public void killDriverSession(){
        close();
        quit();
        driver = null;
    }

    @Override
    public void get(String url) {
        getWebDriver().get(url);
    }

    @Override
    public String getCurrentUrl() {
        return getWebDriver().getCurrentUrl();
    }

    @Override
    public String getTitle() {
        return getWebDriver().getTitle();
    }

    @Override
    public List<WebElement> findElements(By by) {
        return getWebDriver().findElements(by);
    }

    @Override
    public WebElement findElement(By by) {
        return getWebDriver().findElement(by);
    }

    @Override
    public String getPageSource() {
        return getWebDriver().getPageSource();
    }

    @Override
    public void close() {
        getWebDriver().close();
    }

    @Override
    public void quit() {
        getWebDriver().quit();
    }

    @Override
    public Set<String> getWindowHandles() {
        return getWebDriver().getWindowHandles();
    }

    @Override
    public String getWindowHandle() {
        return getWebDriver().getWindowHandle();
    }

    @Override
    public TargetLocator switchTo() {
        return getWebDriver().switchTo();
    }

    @Override
    public Navigation navigate() {
        return getWebDriver().navigate();
    }

    @Override
    public Options manage() {
        return getWebDriver().manage();
    }
}
