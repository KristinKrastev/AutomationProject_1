package com.company.test;

import com.company.configuration.Driver;
import com.company.pagefactoryElements.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTests {
    private ThreadLocal <Driver> driver = new ThreadLocal<Driver>();



    @Test
    void test1(){
    LoginPage login = new LoginPage(driver.get());
    login.clickLoginBtn();

    }
}
