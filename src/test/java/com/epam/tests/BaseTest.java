package com.epam.tests;

import com.epam.core.DriverFactory;
import com.epam.core.WaiterWrapper;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import static com.epam.utils.ConfigProperties.getProperty;

public abstract class BaseTest {
    @BeforeTest
    public void init() {
        DriverFactory.get().manage().window().maximize();
        WaiterWrapper.setUpTimeouts();
        DriverFactory.get().get(getProperty("url"));
    }

    @AfterTest
    public void tearDownClass() {
        DriverFactory.get().manage().deleteAllCookies();
        DriverFactory.get().close();
    }

    @BeforeMethod
    public void initMethod() {
        DriverFactory.get().navigate().to(getProperty("url"));
    }
}
