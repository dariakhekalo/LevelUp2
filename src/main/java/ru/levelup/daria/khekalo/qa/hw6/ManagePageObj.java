package ru.levelup.daria.khekalo.qa.hw6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.levelup.daria.khekalo.qa.hw6.base.BasePage;
import ru.levelup.daria.khekalo.qa.hw6.base.BaseWebComponent;

public class ManagePageObj extends BasePage {
    // TODO А для каких целей поле драйвера?
    private WebDriver driver;

    public ManagePageObj(WebDriver driver){
        super(driver);
    }


}
