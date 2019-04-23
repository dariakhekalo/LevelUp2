package ru.levelup.daria.khekalo.qa.hw6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import ru.levelup.daria.khekalo.qa.hw6.base.BaseWebComponent;


public class LoginPageObj extends BaseWebComponent {
    private WebDriver driver;

    @FindBy(id = "username")
    private WebElement userField;

    @FindBy(id = "password")
    private  WebElement passwordField;

    @FindBy(xpath = "//input[@value='Login']")
    private WebElement loginButton;


    public LoginPageObj(WebDriver driver){
       super(driver);
    }

    //ввод и проверка логина-пароля
    public void login(final String username,final String password) {

        userField.sendKeys(username);
        loginButton.click();

        passwordField.sendKeys(password);
        loginButton.click();




    }
}
