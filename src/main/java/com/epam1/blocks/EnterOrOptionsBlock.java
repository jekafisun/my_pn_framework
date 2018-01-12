package com.epam1.blocks;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Link;

@Name("Form that appears after clicking link enter/options ")
@FindBy(id = "userSettings")
public class EnterOrOptionsBlock extends HtmlElement {
    @Name("Login to system link")
    @FindBy(xpath = ".//li[last()]/a")
    private Link enterToSite;

    public LoginBlock loadLoginForm(){
        enterToSite.click();
        return new LoginBlock();
    }
}
