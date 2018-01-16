package com.epam.pages;

import com.epam.blocks.*;
import com.epam.core.MyWebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    private HeaderLinksBlock headerLinksBlock;
    private LoginForm loginForm;
    private Header header;

    @FindBy(className = "user-info")
    private WebElement userName;

    public SearchResultsPage doSearch(String searchQuery) {
        header.search(searchQuery);
        return new SearchResultsPage();
    }

    public CartPage openCart() {
        headerLinksBlock.openCart();
        return new CartPage();
    }

    public HomePage changeCity() {
        header.changeCity();
        return new HomePage();
    }

    public HomePage loginUser(String email, String pass) {
        headerLinksBlock.getLoginForm();
        loginForm.login(email, pass);
        return new HomePage();
    }

    public HomePage changeLangToUkr() {
        headerLinksBlock.changeLangUkr();
        return new HomePage();
    }

    public HomePage changeLangToRus() {
        headerLinksBlock.changeLangRus();
        return new HomePage();
    }

    public String getCityName() {
        return header.getCityName();
    }

    public String getUserName(String text) {
        MyWebDriver.waitForTextInElement(userName, text);
        return userName.getText();
    }
}
