package com.epam1.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {
    @FindBy(xpath = ".//div[@class='breadcrumbs']//li[last()]//span")
    private WebElement pageName;

    public String getTextFromNode() {
        return pageName.getText();
    }
}
