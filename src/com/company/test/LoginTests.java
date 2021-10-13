package com.company.test;

import com.company.configuration.Driver;
import com.company.pagefactoryElements.Header;
import com.company.pagefactoryElements.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {



    @Test
    void loginTest1(){

        Header header = new Header(getBaseDriver());
        LoginPage loginPage = header.clickLogin();
        loginPage.fillUsername(username);
        loginPage.fillPassword(password);
        loginPage.clickSignInButton();

        Assert.assertTrue(header.getProfileLink().isDisplayed());
        System.out.println("Test 1");

    }
    @Test
    void loginTest2(){

        Header header = new Header(getBaseDriver());
        LoginPage loginPage = header.clickLogin();
        loginPage.fillUsername(username);
        loginPage.fillPassword(password);
        loginPage.clickSignInButton();

        Assert.assertFalse(header.getProfileLink().isDisplayed());
        System.out.println("Test 1");

    }
}
