package com.epam.tests;

import com.epam.core.MyWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import static com.epam.utils.ConfigProperties.getProperty;

public abstract class BaseTest {
    @BeforeTest
    public void init() {
        MyWebDriver.get().manage().window().maximize();
        MyWebDriver.setUpTimeouts();
        MyWebDriver.get().get(getProperty("url"));
    }

    @AfterTest
    public void tearDownClass() {
        MyWebDriver.get().manage().deleteAllCookies();
        MyWebDriver.get().close();
    }

    @BeforeMethod
    public void initMethod() {
        MyWebDriver.get().navigate().to(getProperty("url"));
    }
}
