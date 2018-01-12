package com.epam.pages;

import com.epam1.core.MyWebDriver;
import com.epam1.pages.CartPage;
import com.epam1.pages.DniproHomePage;
import com.epam1.pages.HomePage;
import com.epam1.pages.SearchPage;
import org.testng.Assert;
import org.testng.annotations.*;

public class FirstTest {

    private static final String SITE_URL = "https://pn.com.ua/";
    private static final String EXPECTED_TITLE = "Все цены Харькова (Прайс Навигатор): " +
            "товары и услуги, магазины в Харькове";
    private static final String SEARCH_QUERY = "Gorenje NRK 6201 GHW";
    private static final String CART_TITLE = "Прайс навигатор. Харьков: Покупки";
    private static final String CART_PAGE_NAME_FOR_CHECK = "Планирование покупок";
    private HomePage homePage;
    private SearchPage searchPage;
    private CartPage cartPage;

    @BeforeClass
    public void init() {
        MyWebDriver.get().manage().window().maximize();
        MyWebDriver.setUpTimeouts();
        MyWebDriver.get().get(SITE_URL);
    }

    @AfterClass
    public void tearDownClass() {
        MyWebDriver.get().manage().deleteAllCookies();
        MyWebDriver.get().close();
    }

    @BeforeMethod
    public void initMethod() {
        MyWebDriver.get().navigate().to(SITE_URL);
        homePage = new HomePage();
    }

    @Test(description = "Check that correct page is opened")
    public void loadPageTest() {
        String pageUrl = MyWebDriver.get().getCurrentUrl();
        String actualTitle = MyWebDriver.get().getTitle();
        Assert.assertEquals(pageUrl, SITE_URL, "Site URL is not actual!\n");
        Assert.assertEquals(actualTitle, EXPECTED_TITLE, "Title of actual page is not as expected:\n");
    }

    @Test(description = "Check that correct page opens after searching the product")
    public void searchTest() {
        searchPage = homePage.search(SEARCH_QUERY);
        Assert.assertEquals(searchPage.getOnlyProductNameTextFromNode(), SEARCH_QUERY, "Find results are not same! \n");
    }

    @Test(description = "Clicking on Cart link should forward to Cart page")
    public void verifyThatCartPageOpens() {
        CartPage cartPage = homePage.cartButtonClick();
        String cartTitle = MyWebDriver.get().getTitle();
        String cartTextOnPage = cartPage.getTextFromNode();
        Assert.assertEquals(cartTitle, CART_TITLE, "title is not equals!\n");
        Assert.assertEquals(cartTextOnPage, CART_PAGE_NAME_FOR_CHECK, "this is not cart!\n");
    }

    @Test(description = "Change city to Dnipro")
    public void changeToDnipro() {
        DniproHomePage dniproHomePage = homePage.changeCityToDnipro();
        String cityName = dniproHomePage.getCityName();
        Assert.assertEquals(cityName, "Днепр");
        Assert.assertEquals(MyWebDriver.get().getCurrentUrl(), "https://dp.vseceni.ua/");

    }

    @Test(description = "Login to site with valid user")
    public void loginValidUser(){
        homePage.loginToSite("jeka.fisun@gmail.com","qwert123");
        String userName=homePage.getUserName();
        Assert.assertEquals(userName,"Жека Фисун");
    }

//    @Test(description = "Deleting item from Cart by clicking red cross icon")
//    public void verifyThatItemCanBeDeletedFromCart() {
//        cartPage = homePage.cartButtonClick();
//    }
}