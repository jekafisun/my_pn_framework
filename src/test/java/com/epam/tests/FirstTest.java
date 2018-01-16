package com.epam.tests;

import com.epam.core.MyWebDriver;
import com.epam.pages.CartPage;
import com.epam.pages.HomePage;
import com.epam.pages.SearchResultsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstTest extends BaseTest{
    private static final String SITE_URL = "https://pn.com.ua/";
    private static final String EXPECTED_TITLE = "Все цены Харькова (Прайс Навигатор): " +
            "товары и услуги, магазины в Харькове";
    private static final String SEARCH_QUERY = "Gorenje NRK 6201 GHW";
    private static final String CART_TITLE = "Прайс навигатор. Харьков: Покупки";
    private static final String CART_PAGE_NAME_FOR_CHECK = "Планирование покупок";
    private HomePage homePage=new HomePage();

    @Test(description = "Check that correct page is opened")
    public void loadPageTest() {
        String pageUrl = MyWebDriver.get().getCurrentUrl();
        String actualTitle = MyWebDriver.get().getTitle();
        Assert.assertEquals(pageUrl, SITE_URL, "Site URL is not actual!\n");
        Assert.assertEquals(actualTitle, EXPECTED_TITLE, "Title of actual page is not as expected:\n");
    }

    @Test(description = "Check that correct page opens after searching the product")
    public void searchTest() {
        SearchResultsPage searchResultsPage = homePage.doSearch(SEARCH_QUERY);
        Assert.assertEquals(searchResultsPage.getOnlyProductNameTextFromNode(), SEARCH_QUERY, "Find results are not same! \n");
    }

    @Test(description = "Clicking on Cart link should forward to Cart page")
    public void verifyThatCartPageOpens() {
        CartPage cartPage = homePage.openCart();
        String cartTitle = MyWebDriver.get().getTitle();
        String cartTextOnPage = cartPage.getTextFromNode();
        Assert.assertEquals(cartTitle, CART_TITLE, "title is not equals!\n");
        Assert.assertEquals(cartTextOnPage, CART_PAGE_NAME_FOR_CHECK, "this is not cart!\n");
    }

    @Test(description = "Change city to Dnipro")
    public void changeToDnipro() {
        homePage = homePage.changeCity();
        String cityName = homePage.getCityName();
        Assert.assertEquals(cityName, "Днепр");
        Assert.assertEquals(MyWebDriver.get().getCurrentUrl(), "https://dp.vseceni.ua/");
    }

    @Test(description = "Login to site with valid user")
    public void loginValidUser() {
        homePage.loginUser("jeka.fisun@gmail.com", "qwert123");
        String user = homePage.getUserName("Жека Фисун");
        Assert.assertEquals(user, "Жека Фисун");
    }
}