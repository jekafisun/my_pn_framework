package com.epam.blocks;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.element.Select;
import ru.yandex.qatools.htmlelements.element.TextBlock;

@Name("Logo and cities block in left side of header")
@FindBy(xpath = ".//div[@class='td-block'][1]")
public class HeaderCityBlock extends HtmlElement{
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
        citySelect.selectByVisibleText("Днепр");
    }
}
