package com.epam.pages;

import com.epam.blocks.HeaderCityBlock;
import com.epam.blocks.HeaderLinksBlock;
import com.epam.blocks.HeaderSearchBlock;
import com.epam.blocks.LoginForm;
import com.epam.core.MyWebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    private HeaderCityBlock headerCityBlock;
    private HeaderLinksBlock headerLinksBlock;
    private HeaderSearchBlock headerSearchBlock;
    private LoginForm loginForm;

    @FindBy(className = "user-info")
    private WebElement userName;

    public SearchPage doSearch(String searchQuery) {
        headerSearchBlock.search(searchQuery);
        return new SearchPage();
    }

    public CartPage openCart() {
        headerLinksBlock.openCart();
        return new CartPage();
    }

    public HomePage changeCity() {
        headerCityBlock.changeCity();
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
        return headerCityBlock.getCityName();
    }

    public String getUserName(String text) {
        MyWebDriver.waitForTextInElement(userName, text);
        return userName.getText();
    }
}
