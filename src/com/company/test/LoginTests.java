package com.company.test;

import com.company.configuration.Driver;
import com.company.pagefactoryElements.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {



    @Test
    void test1(){

        LoginPage loginPage = new LoginPage(getBaseDriver());
        loginPage.clickLoginBtn();
        loginPage.fillUsername(username);
        loginPage.fillPassword(password);

        Assert.assertFalse(loginPage.getSignInButton().isDisplayed());
        System.out.println("Test 1");


    }
}
