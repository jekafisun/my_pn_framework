package com.epam.blocks;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.*;

@Name("Header block")
@FindBy(className = "header")
public class Header extends HtmlElement {
    @Name("City popup select box")
    @FindBy(className = "logo-city")
    private TextBlock citySelect;

    @Name("City link")
    @FindBy(xpath = ".//div[@class='city-popup-row']/descendant::a[contains(text(),'Днепр')]")
    private Link dniproCity;

    @FindBy(xpath = ".//input[@type='text']")
    private TextInput searchField;

    @FindBy(xpath = ".//input[@type='submit']")
    private Button searchButton;


    public void search(String searchQuery){
        searchField.clear();
        searchField.sendKeys(searchQuery);
        searchButton.submit();
    }

    public void changeCity(){
        citySelect.click();
        dniproCity.click();
    }

    public String getCityName(){
        return citySelect.getText();
    }
}
