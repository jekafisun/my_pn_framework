package com.epam.blocks;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Link;

@Name("Block of links in header")
@FindBy(className = "links")
public class HeaderLinksBlock extends HtmlElement {
    private ShareBlock shareBlock;
    private LoginAndSettingsBlock loginAndSettingsBlock;

    @FindBy(className = "share-info")
    private Link shareLink;

    @FindBy(xpath = ".//span[@class='user-purchase']/a")
    private Link cartLink;

    @FindBy(xpath = ".//span[@class='user-info']/a")
    private Link enterAndOptionsLink;

    public void clickShare(){
        shareLink.click();
    }

    public void openCart(){
        cartLink.click();
    }

    public void clickLogonAndOptions(){
        enterAndOptionsLink.click();
    }

}
