package com.epam.pages;

import com.epam.blocks.HeaderCityBlock;
import com.epam.blocks.HeaderLinksBlock;
import com.epam.blocks.HeaderSearchBlock;
import com.epam.blocks.LoginForm;

public class HomePage extends BasePage {
    private HeaderCityBlock headerCityBlock;
    private HeaderLinksBlock headerLinksBlock;
    private HeaderSearchBlock headerSearchBlock;
    private LoginForm loginForm;

    public SearchPage doSearch(String searchQuery){
        headerSearchBlock.search(searchQuery);
        return new SearchPage();
    }

    public CartPage openCart(){
        headerLinksBlock.openCart();
        return new CartPage();
    }

    public HomePage changeCity(){
        headerCityBlock.changeCity();
        return new HomePage();
    }

    public void loginUser(String email, String pass){
        headerLinksBlock.getLoginForm();
        loginForm.login(email, pass);
//        return this;
    }

    public HomePage changeLangToUkr(){
        headerLinksBlock.changeLangUkr();
        return new HomePage();
    }

    public HomePage changeLangToRus(){
        headerLinksBlock.changeLangRus();
        return new HomePage();
    }

    public String getCityName(){
        return headerCityBlock.getCityName();
    }

    public String getUserName(){
        return headerLinksBlock.getUserName();
    }


}
