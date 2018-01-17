package com.epam.core;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WaiterWrapper {
    private static final int DEFAULT_PAGE_LOAD_SEC = 10;
    private static final int TIME_OUT_IN_SECONDS = 2;

    private WaiterWrapper() {
    }

    public static void setUpTimeouts() {
        DriverFactory.get().manage().timeouts().implicitlyWait(DEFAULT_PAGE_LOAD_SEC, TimeUnit.SECONDS);
    }

    public static void waitForTextInElement(WebElement element, String text) {
        new WebDriverWait(DriverFactory.get(), TIME_OUT_IN_SECONDS)
                .until(ExpectedConditions.textToBePresentInElement(element, text));
    }


}
