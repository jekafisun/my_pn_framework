package com.epam.pages;

import com.epam.core.DriverFactory;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

public abstract class BasePage {
    public BasePage() {
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(DriverFactory.get())) ,this);
    }
}
