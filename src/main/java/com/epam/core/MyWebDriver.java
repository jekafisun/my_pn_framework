package com.epam.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
        timeouts.implicitlyWait(10, TimeUnit.SECONDS);
    }

    public static WebDriver get() {
        return driver;
    }

    public static void waitForTextInElement(WebElement element, String text) {
        WebDriverWait wait = new WebDriverWait(driver, 1);
        wait.until(ExpectedConditions.textToBePresentInElement(element, text));
    }


}
