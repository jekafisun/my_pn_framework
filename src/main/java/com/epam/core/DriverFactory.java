package com.epam.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static com.epam.utils.ConfigProperties.getProperty;

public class DriverFactory {

    private static WebDriver driver;

    private DriverFactory() {
    }

    static {
        String browser = System.getProperty("browserType");
        if ("firefox".equalsIgnoreCase(browser)) {
            System.setProperty("webdriver.gecko.driver", getProperty("geckodriver"));
            driver = new FirefoxDriver();
        } else {
            System.setProperty("webdriver.chrome.driver", getProperty("chromedriver"));
            driver = new ChromeDriver();
        }
    }

    public static WebDriver get() {
        return driver;
    }
}
