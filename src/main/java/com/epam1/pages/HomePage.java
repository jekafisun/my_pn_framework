package com.epam1.pages;

import com.epam1.blocks.HeaderBlock;
import com.epam1.blocks.LoginBlock;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    private HeaderBlock headerBlock;
    private LoginBlock loginBlock;

    @FindBy(className = "user-purchase")
    private WebElement cartLink;

    @FindBy(xpath = ".//div[@class='pc-block']/a[contains(@href,'computer')]")
    private WebElement computerCategory;

    @FindBy(partialLinkText = "Жесткие диски")
    private WebElement linkHardDisks;

    @FindBy(className = "user-info")
    private WebElement enterOrOptionsLink;

    public SearchPage search(String request) {
        headerBlock.search(request);
        return new SearchPage();
    }

    public CartPage cartButtonClick() {
        cartLink.click();
        return new CartPage();
    }

    public DniproHomePage changeCityToDnipro() {
        headerBlock.changeCity();
        return new DniproHomePage();
    }

    public HomePage loginToSite(String email, String pass) {
        enterOrOptionsLink.click();
        loginBlock=headerBlock.getLoginForm();
        return loginBlock.login(email, pass);
    }

    public String getUserName(){
        return enterOrOptionsLink.getText();
    }
}
