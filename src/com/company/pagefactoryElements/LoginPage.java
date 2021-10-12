package com.company.pagefactoryElements;

import com.company.configuration.Driver;
import jdk.jfr.Enabled;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage  {

    private ThreadLocal <Driver> driver = new ThreadLocal<Driver>();
    private WebDriverWait wait;

    protected Driver getDriver(){
        return driver.get();
    }

    @FindBy(id="defaultLoginFormUsername")
    private WebElement usernameField;
    @FindBy(id="defaultLoginFormPassword")
    private WebElement passwordField;
    @FindBy(linkText ="Register")
    private WebElement registerLinkLoc;
    @FindBy(id="sign-in-button")
    private WebElement signinButton;
    @FindBy(xpath = "//p[contains(text(),'Sign in')]")
    private WebElement signInHeader;

    @FindBy(id="nav-link-login")
    private WebElement loginBtn;

    public LoginPage(Driver driver){
       wait = new WebDriverWait(driver, 5);
       PageFactory.initElements( driver,this);
    }
    public void fillUsername(String username){
        wait.until(ExpectedConditions.visibilityOf(usernameField));
        usernameField.sendKeys(username);
    }
    public void fillPassword(String password){
        passwordField.sendKeys(password);
    }
    public void clickLoginBtn(){
        loginBtn.click();
    }

    public WebElement getSignInButton(){
        wait.until(ExpectedConditions.visibilityOf(signinButton));
        return signinButton;
    }




}
