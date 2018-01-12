package com.epam.blocks;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;

@Name("Search block in header")
@FindBy(className = "search")
public class HeaderSearchBlock extends HtmlElement {
    @FindBy(xpath = ".//input[@type='text']")
    private TextInput searchField;

    @FindBy(xpath = ".//input[@type='submit']")
    private Button searchButton;


    public void search(String searchQuery){
        searchField.clear();
        searchField.sendKeys(searchQuery);
        searchButton.submit();
    }

}
