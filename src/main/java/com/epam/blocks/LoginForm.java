package com.epam.blocks;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;

@Name("Logon form")
@FindBy(id = "login-form")
public class LoginForm extends HtmlElement{
    @FindBy(id = "login-form-login")
    private TextInput emailField;

    @FindBy(id = "login-form-password")
    private TextInput passField;

    @FindBy(id = "loginButton")
    private Button loginButton;

    public void login(String email, String pass){
        emailField.sendKeys(email);
        passField.sendKeys(pass);
        loginButton.submit();
    }
}
