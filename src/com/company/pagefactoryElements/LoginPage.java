package com.company.pagefactoryElements;

import com.company.configuration.Driver;
import com.company.test.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseTest {

    private ThreadLocal <Driver> driver = new ThreadLocal<Driver>();
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
    @FindBy(id="nav-link-login")
    private WebElement loginBtn;

    public LoginPage(Driver driver){
        //this.getDriver();
        PageFactory.initElements(driver,this);
    }
    public void fillUsername(String username){
        usernameField.sendKeys(username);
    }
    public void fillPassword(String password){
        passwordField.sendKeys(password);
    }
    public void clickLoginBtn(){
        loginBtn.click();
    }
}
