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

    public void clickShare() {
        shareLink.click();
    }

    public void openCart() {
        cartLink.click();
    }

    public void clickLoginAndOptions() {
        enterAndOptionsLink.click();
    }

    public void shareViaFacebook() {
        clickShare();
        shareBlock.shareViaFacebook();
    }

    public void shareViaTwitter() {
        clickShare();
        shareBlock.shareViaTwitter();
    }

    public void shareViaGoogle() {
        clickShare();
        shareBlock.shareViaGoogle();
    }

    public void login(String email, String pass){
        clickLoginAndOptions();
        loginAndSettingsBlock.login(email, pass);
    }

    public void changeLangUkr(){
        clickLoginAndOptions();
        loginAndSettingsBlock.setUkrLang();
    }

    public void changeLangRus(){
        clickLoginAndOptions();
        loginAndSettingsBlock.setRussianLang();
    }

    public String getUserName(){
        return enterAndOptionsLink.getText();
    }

}
