package ru.levelup.daria.khekalo.qa.hw6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.levelup.daria.khekalo.qa.hw6.base.BasePage;
import ru.levelup.daria.khekalo.qa.hw6.base.BaseWebComponent;

public class HomePage extends BasePage {
    private WebDriver driver;


  //  @FindBy(partialLinkText = "Manage")
  //  private WebElement manageLink;






    public HomePage(WebDriver driver){
       super(driver);
    }

  //  public void clickManageLink(){
    //    manageLink.click();
    //}

}
