package ru.levelup.daria.khekalo.qa.hw6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.levelup.daria.khekalo.qa.hw6.base.BasePage;


import java.util.List;

public class TabElementsPage extends BasePage {


    @FindBy(xpath = "//ul[contains(@class, 'nav-tabs')]//a")
    private List<WebElement> tabItems;

    public  TabElementsPage(WebDriver driver){
        super(driver);
    }
    public void clickTabByName(String tabName) {
        for (WebElement tabItem : tabItems) {
            if (tabItem.getText().trim().equals(tabName)) {
                tabItem.click();
                break;
            }
        }
    }
}
