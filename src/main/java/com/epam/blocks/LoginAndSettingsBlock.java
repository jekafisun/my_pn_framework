package com.epam.blocks;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Link;

@Name("Login and settings block that appears after clicking Logon/Settings link")
@FindBy(id = "userSettings")
public class LoginAndSettingsBlock extends HtmlElement{
    @FindBy(linkText = "Рус")
    private Link russianLang;

    @FindBy(linkText = "Укр")
    private Link ukrLang;

    @FindBy(xpath = ".//li[last()]/a")
    private Link loginLink;

    public void getLoginForm(){
         loginLink.click();
    }

    public void setRussianLang(){
        russianLang.click();
    }

    public void setUkrLang(){
        ukrLang.click();
    }
}
