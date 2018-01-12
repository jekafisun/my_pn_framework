package com.epam1.blocks;

import com.epam1.pages.HomePage;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;

@Name("Login form")
@FindBy(id = "login-form-container")
public class LoginBlock extends HtmlElement {
    @Name("Email input field")
    @FindBy(id = "login-form-login")
    private TextInput emailField;

    @Name("Password input field")
    @FindBy(id = "login-form-password")
    private TextInput passwordField;

    @Name("Login button")
    @FindBy(id = "loginButton")
    private Button loginButton;

    public HomePage login(String email, String pass){
//        emailField.clear();
        emailField.sendKeys(email);
//        passwordField.clear();
        passwordField.sendKeys(pass);

        loginButton.submit();
        return new HomePage();
    }

}
