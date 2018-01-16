package com.epam.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CategoryPage extends BasePage {
    @FindBy(xpath = ".//div[@class='breadcrumbs']//li[last()]//span")
    private WebElement categoryName;

    public String getCategoryName() {
        String text = categoryName.getText();
        for (WebElement child : categoryName.findElements(By.xpath(".//*"))) {
            text = text.replaceFirst(child.getText(), "");
        }
        text = text.trim();
        return text;
    }
}
