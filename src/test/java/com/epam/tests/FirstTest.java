package com.epam.tests;

import com.epam.core.DriverFactory;
import com.epam.pages.CartPage;
import com.epam.pages.HomePage;
import com.epam.pages.SearchResultsPage;
import com.epam.utils.ConfigProperties;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstTest extends BaseTest {
    private static final String EXPECTED_TITLE = "Все цены Харькова (Прайс Навигатор): " +
            "товары и услуги, магазины в Харькове";
    private static final String SEARCH_QUERY = "Gorenje NRK 6201 GHW";
    private static final String CART_TITLE = "Прайс навигатор. Харьков: Покупки";
    private static final String CART_PAGE_NAME_FOR_CHECK = "Планирование покупок";

    private HomePage homePage = new HomePage();

    @Test(description = "Check that correct page is opened")
    public void loadPageTest() {
        String pageUrl = DriverFactory.get().getCurrentUrl();
        String actualTitle = DriverFactory.get().getTitle();
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
        String cartTitle = DriverFactory.get().getTitle();
        String cartTextOnPage = cartPage.getTextFromNode();
        Assert.assertEquals(cartTitle, CART_TITLE, "title is not equals!\n");
        Assert.assertEquals(cartTextOnPage, CART_PAGE_NAME_FOR_CHECK, "this is not cart!\n");
    }

    @Test(description = "Change city to Dnipro")
    public void changeToDnipro() {
        homePage = homePage.changeCity();
        String cityName = homePage.getCityName();
        Assert.assertEquals(cityName, "Днепр");
        Assert.assertEquals(DriverFactory.get().getCurrentUrl(), "https://dp.vseceni.ua/");
    }

    @Test(description = "Login to site with valid user")
    public void loginValidUser() {
        homePage.loginUser(ConfigProperties.getProperty("user.email"), ConfigProperties.getProperty("user.pass"));
//        String user = homePage.getUserName("Жека Фисун");
//        Assert.assertEquals(user, "Жека Фисун");
    }
}