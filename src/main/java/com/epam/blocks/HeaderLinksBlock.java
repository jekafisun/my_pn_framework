package com.epam.blocks;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.element.TextBlock;

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

    @FindBy(className = "user-info")
    private TextBlock userName;

    private void clickShare() {
        shareLink.click();
    }

    public void openCart() {
        cartLink.click();
    }

    private void clickLoginAndOptions() {
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

    public void getLoginForm() {
        clickLoginAndOptions();
        loginAndSettingsBlock.getLoginForm();
    }

    public void changeLangUkr() {
        clickLoginAndOptions();
        loginAndSettingsBlock.setUkrLang();
    }

    public void changeLangRus() {
        clickLoginAndOptions();
        loginAndSettingsBlock.setRussianLang();
    }

    public String getUserName() {
        return userName.getText();
    }

}
