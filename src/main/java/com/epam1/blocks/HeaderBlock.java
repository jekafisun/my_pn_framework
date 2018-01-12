package com.epam1.blocks;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.*;

@Name("Header block")
@FindBy(className = "header")
public class HeaderBlock extends HtmlElement{
    private EnterOrOptionsBlock enterOrOptionsBlock;

    @Name("Search request input")
    @FindBy(xpath = ".//input[@type='text']")
    private TextInput searchField;

    @Name("Search button")
    @FindBy(xpath = ".//input[@type='submit']")
    private Button searchButton;

    @Name("City popup select box")
    @FindBy(className = "logo-city")
    private Select citySelect;

    @Name("City Name")
    @FindBy(xpath = ".//span[@class='logo-city']")
    private TextBlock cityName;

    @Name("City link")
    @FindBy(xpath = ".//div[@class='city-popup-row']/descendant::a[contains(text(),'Днепр')]")
    private Link dniproCity;

    public void changeCityToDnipro(){
        dniproCity.click();
    }

    public void search(String request){
        searchField.clear();
        searchField.sendKeys(request);
        searchButton.submit();
    }

    public void changeCity(){
        citySelect.click();
        changeCityToDnipro();
    }

    public String getCityName(){
        return cityName.getText();
    }

    public LoginBlock getLoginForm(){
        return enterOrOptionsBlock.loadLoginForm();
    }
}
