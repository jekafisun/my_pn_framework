package com.epam.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CategoryPage extends BasePage {
    private static final String LAST_BREADCRUMB_XPATH = ".//div[@class='breadcrumbs']//li[last()]//span";

    @FindBy(xpath = LAST_BREADCRUMB_XPATH)
    private WebElement categoryName;

    @FindBy(xpath = LAST_BREADCRUMB_XPATH + ".//*")
    private WebElement inCity;


    public String getCategoryName() {
        String text = categoryName.getText();
        for (WebElement child : categoryName.findElements(By.xpath(".//*"))) {
            text = text.replaceFirst(child.getText(), "");
        }
        text = text.trim();
        return text;
    }
}
