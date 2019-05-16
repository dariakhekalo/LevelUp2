package hw6;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.levelup.daria.khekalo.qa.hw6.*;
import ru.levelup.daria.khekalo.qa.hw6.base.BasePage;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.testng.AssertJUnit.assertEquals;


    public class AddProject extends BaseTest {

        private HomePage homePage;
        private ManageProjectsAddNew manageProjectsAddNew;
        private ManagePageObj managePageObj;
        private TabElementsPage tabElementsPage;
        private LoginPageObj loginPageObj;




    @Test
    public void createNewProjectTest() {
        // TODO инициализацию страниц лучше выносить в Before hook
        loginPageObj = new LoginPageObj(driver);
        homePage = new HomePage(driver);
        manageProjectsAddNew = new ManageProjectsAddNew(driver);
        tabElementsPage = new TabElementsPage(driver);
        managePageObj = new ManagePageObj(driver);


        assertEquals("administrator", driver.findElement(By.className("user-info")).getText());


        //переход и проверка на страницу Manage
        homePage.clickSelectMenu(LeftSideMenu.MANAGE.getValue());
        driver.findElement(By.xpath("//a[contains(@href, 'manage_overview_page')]")).click();
       assertThat(homePage.getPageTitle() , equalTo(HomePage.PAGE_TITLE));


        //переход на ManageProjects
        tabElementsPage.clickTabByName("Manage Projects");
        assertThat(homePage.getPageTitle(), equalTo(HomePage.PAGE_TITLE_PROJECTS));



        //клик и проверка перехода на страницу  add projects
        manageProjectsAddNew.CreateNewProjectButtonClick();
        Assert.assertEquals("http://khda91.fvds.ru/mantisbt/manage_proj_create_page.php",
                driver.getCurrentUrl());


        //заполнение формы
        String projectName = RandomStringUtils.randomAlphabetic(10);
              manageProjectsAddNew.setProjectNameField(projectName);
        manageProjectsAddNew.setProjectDescriptionField("This is a cute cartoon for children");
        manageProjectsAddNew.addProjectButtonClick();


        //проверка на заполнение полей
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        List<WebElement> projectTableNameColumnValues = driver.findElements(By.xpath
                ("//div[@class='table-responsive']//td//a"));
        List<String> actualNameValues = new ArrayList<>();
        for (WebElement projectTableNameColumnValue : projectTableNameColumnValues) {
            actualNameValues.add(projectTableNameColumnValue.getText());

        }
        assertThat(actualNameValues, hasItem(projectName));

        managePageObj.logout();

    }

    }

