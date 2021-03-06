package com.epam.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultsPage extends BasePage {
    @FindBy(xpath = ".//div[@class='breadcrumbs']//li[last()]//span")
    private WebElement productName;

    public String getOnlyProductNameTextFromNode() {
        String text = productName.getText();
        for (WebElement child : productName.findElements(By.xpath(".//*"))) {
            text = text.replaceFirst(child.getText(), "");
        }
        text = text.trim();
        return text;
    }
}
