package com.company.pagefactoryElements;

import com.company.configuration.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Header {

    private Driver driver ;
    private WebDriverWait wait;

   /* protected Driver getDriver(){
        return driver.get();
    }*/

    @FindBy (id = "homeIcon")
    private WebElement homeIcon;
    @FindBy (id = "nav-link-home")
    private WebElement homeLink;
    @FindBy (id = "nav-link-login")
    private WebElement loginLink;
    @FindBy (id = "nav-link-profile")
    private WebElement profileLink;
    @FindBy (id = "nav-link-new-post")
    private WebElement newPostLink;
    @FindBy (id ="search-bar")
    private WebElement searchBar;
    @FindBy (xpath = "//*[@class='fas fa-sign-out-alt fa-lg']")
    private WebElement logoutButton;

    public Header(Driver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
        PageFactory.initElements( driver,this);
    }

    public LoginPage clickLogin(){

        loginLink.click();
        return new LoginPage(driver);
    }

    public void clickHomeIcon(){
        homeIcon.click();
    }
    public void clickHomeLink(){
        homeLink.click();
    }
    public void clickLoginLink(){
        loginLink.click();
    }
    public WebElement getProfileLink(){
        wait.until(ExpectedConditions.visibilityOf(profileLink));
        return profileLink;
    }
}
