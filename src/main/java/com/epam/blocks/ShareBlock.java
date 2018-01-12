package com.epam.blocks;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Link;

@Name("Share block that appears after clicking Share link")
@FindBy(id = "socnets")
public class ShareBlock extends HtmlElement{
    @FindBy(linkText = "Facebook")
    private Link facebook;

    @FindBy(linkText = "Twitter")
    private Link twitter;

    @FindBy(linkText = "Google+")
    private Link google;

    public void shareViaFacebook(){
        facebook.click();
    }

    public void shareViaTwitter(){
        twitter.click();
    }

    public void shareViaGoogle(){
        google.click();
    }
}
