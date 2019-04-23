package ru.levelup.daria.khekalo.qa.hw6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.levelup.daria.khekalo.qa.hw6.base.BasePage;

public class ManageProjectsAddNew  extends BasePage {

    private WebDriver driver;

    @FindBy(css = ".btn.btn-primary.btn-white.btn-round")
    private WebElement createNewProjectButton;


    @FindBy(id = "project-name")
    private WebElement projectNameField;


    @FindBy(id = "project-description")
    private WebElement projectDescriptionField;

    @FindBy(css = ".btn.btn-primary.btn-white.btn-round")
    private WebElement addProjectButton;

    public ManageProjectsAddNew (WebDriver driver){
       super(driver);
    }

    public void CreateNewProjectButtonClick(){
        createNewProjectButton.click();
    }


    public void  setProjectNameField(String projectName){
        projectNameField.sendKeys(projectName);
    }

    public void setProjectDescriptionField(String projectDescription){
        projectDescriptionField.sendKeys(projectDescription);
    }

    public void addProjectButtonClick(){
        addProjectButton.click();
    }


}
