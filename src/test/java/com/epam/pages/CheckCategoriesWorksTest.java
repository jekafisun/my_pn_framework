package com.epam.pages;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckCategoriesWorksTest extends BaseTest {
    private HomePage homePage = new HomePage();
    private CategoryPage categoryPage;

    @Test(description = "check that computer link opens computer page")
    public void computerLinkTest() {
        categoryPage = homePage.openComputerCategory();
        String catName = categoryPage.getCategoryName();
        Assert.assertEquals(catName, "Компьютеры");
    }

    @Test(description = "check that electronics link opens electronics page")
    public void electronicsLinkTest() {
        categoryPage = homePage.openElectronicsCategory();
        String catName = categoryPage.getCategoryName();
        Assert.assertEquals(catName, "Электроника");
    }

    @Test(description = "check that home appliances link opens appliances page")
    public void appliancesLinkTest() {
        categoryPage = homePage.openAppliancesCategory();
        String catName = categoryPage.getCategoryName();
        Assert.assertEquals(catName, "Бытовая техника");
    }

    @Test(description = "check that for home link opens for home page")
    public void forHomeLinkTest() {
        categoryPage = homePage.openForHomeCategory();
        String catName = categoryPage.getCategoryName();
        Assert.assertEquals(catName, "Все для дома");
    }

    @Test(description = "check that furniture link opens furniture page")
    public void furnitureTest() {
        categoryPage = homePage.openFurnitureCategory();
        String catName = categoryPage.getCategoryName();
        Assert.assertEquals(catName, "Мебель");
    }
}
