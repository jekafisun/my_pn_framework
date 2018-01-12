package com.epam.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class MyWebDriver {
    private static WebDriver driver;

    private MyWebDriver() {
    }

    static {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/libs/chromedriver.exe");
        driver = new ChromeDriver();
    }

    public static void setUpTimeouts() {
        WebDriver.Timeouts timeouts = driver.manage().timeouts();
        timeouts.implicitlyWait(5, TimeUnit.SECONDS);
    }

    public static WebDriver get() {
        return driver;
    }
}
