package com.epam.pages;

import com.epam.core.MyWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {
    private static final String SITE_URL = "https://pn.com.ua/";

    @BeforeClass
    public void init() {
        MyWebDriver.get().manage().window().maximize();
        MyWebDriver.setUpTimeouts();
        MyWebDriver.get().get(SITE_URL);
    }

    @AfterClass
    public void tearDownClass() {
        MyWebDriver.get().manage().deleteAllCookies();
        MyWebDriver.get().close();
    }

    @BeforeMethod
    public void initMethod() {
        MyWebDriver.get().navigate().to(SITE_URL);
    }
}
