package hw6;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.levelup.daria.khekalo.qa.hw6.HomePage;
import ru.levelup.daria.khekalo.qa.hw6.LoginPageObj;
import ru.levelup.daria.khekalo.qa.hw6.ManagePageObj;
import ru.levelup.daria.khekalo.qa.hw6.ManageProjectsAddNew;
import ru.levelup.daria.khekalo.qa.hw6.base.BasePage;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import static org.testng.AssertJUnit.assertEquals;


    public class AddProject extends BaseTest {

        private HomePage homePage;
        private ManageProjectsAddNew manageProjectsAddNew;
        private ManagePageObj managePageObj;



        @BeforeMethod(alwaysRun = true)
    @Override
        public void setUpTest() {
        super.setUpTest();
        new LoginPageObj(driver).login("administrator","root");
        homePage = new HomePage(driver);
        managePageObj = new ManagePageObj(driver);
        manageProjectsAddNew = new ManageProjectsAddNew(driver);



            }


    @Test
    public void createNewProject() {

        assertEquals("administrator", driver.findElement(By.className("user-info")).getText());


        //переход и проверка на страницу Manage
        homePage.selectMenu("Manage");
        assertThat(homePage.getPageTitle() , equalTo("Manage - MantisBT"));


        //переход на ManageProjects
        managePageObj.clickManagePageObj();
        assertThat(driver.getTitle(), equalTo("Manage Projects - MantisBT"));


        //клик и проверка перехода на страницу  add projects
        manageProjectsAddNew.CreateNewProjectButtonClick();
        Assert.assertEquals("http://khda91.fvds.ru/mantisbt/manage_proj_create_page.php",
                driver.getCurrentUrl());


        //заполнение формы
        String projectName = RandomStringUtils.randomAlphabetic(10);
       // String projectDescription = RandomStringUtils.randomAlphabetic(20);
       // manageProjectsAddNew.CreateNewProjectButtonClick();
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

