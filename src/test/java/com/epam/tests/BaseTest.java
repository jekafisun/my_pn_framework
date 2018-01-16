package com.epam.tests;

import com.epam.core.MyWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public abstract class BaseTest {
    private static final String SITE_URL = "https://pn.com.ua/";

    @BeforeTest
    public void init() {
        MyWebDriver.get().manage().window().maximize();
        MyWebDriver.setUpTimeouts();
        MyWebDriver.get().get(SITE_URL);
    }

    @AfterTest
    public void tearDownClass() {
        MyWebDriver.get().manage().deleteAllCookies();
        MyWebDriver.get().close();
    }

    @BeforeMethod
    public void initMethod() {
        MyWebDriver.get().navigate().to(SITE_URL);
    }
}
