package hw2;

// TODO Не используемые иморты удалить
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.*;
import  static org.junit.Assert.assertEquals;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;






// TODO форматирование (CTRL + ALT + L)
    public class AddProject  {



    @Test
    // TODO Имя теста должно отражать его суть.
    public void loginTest() {
        System.setProperty("webdriver.chrome.driver",
                "src/test/resources/webdriver.chrome/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();


        // открываем и проверяем страницу
        driver.get("http://khda91.fvds.ru/mantisbt/");
        assertThat(driver.getTitle(), equalTo("MantisBT"));

        //ввод и проверка логина-пароля
        driver.findElement(By.id("username")).sendKeys("administrator");
        driver.findElement(By.xpath("//input[@value='Login']")).click();
        driver.findElement(By.id("password")).sendKeys("root");
        driver.findElement(By.xpath("//input[@value='Login']")).click();
        assertEquals("administrator", driver.findElement(By.className("user-info")).getText());

        //проверка наличия меню слева
        // TODO В каих целях было оспользованно данное приведение ((ChromeDriver) driver)
        // TODO findElementByCssSelector - почему был выбран данный метод?
        Assert.assertTrue(((ChromeDriver) driver).findElementByCssSelector(".nav-list").isEnabled());

        //переход и проверка на страницу Manage
        driver.findElement(By.xpath("//a[contains(@href, 'manage_overview_page')]")).click();
        assertThat(driver.getTitle(), equalTo("Manage - MantisBT"));

        //переход и проверка на страницу Manage Projects
        driver.findElement(By.xpath("//a[contains(@href, 'manage_proj_page')]")).click();
        assertThat(driver.getTitle(), equalTo("Manage Projects - MantisBT"));

        //проверка наличия кнопки Create new project
        // TODO В каих целях было оспользованно данное приведение ((ChromeDriver) driver)
        // TODO findElementByCssSelector - почему был выбран данный метод?
        Assert.assertTrue(((ChromeDriver) driver).findElementByCssSelector(".btn.btn-primary.btn-white.btn-round")
                .isEnabled());

        //клик и проверка перехода на страницу  add projects
        driver.findElement(By.cssSelector(".btn.btn-primary.btn-white.btn-round")).click();
        Assert.assertEquals("http://khda91.fvds.ru/mantisbt/manage_proj_create_page.php",
                driver.getCurrentUrl());

        //проверка наличия полей
        // TODO В каих целях было оспользованно данное приведение ((ChromeDriver) driver)
        // TODO findElementById - почему был выбран данный метод?
        // TODO findElementByCssSelector - почему был выбран данный метод?
        Assert.assertTrue(((ChromeDriver) driver).findElementById("project-name").isEnabled());
        Assert.assertTrue(((ChromeDriver) driver).findElementById("project-status").isEnabled());
        Assert.assertTrue(((ChromeDriver) driver).findElementByCssSelector(".lbl").isEnabled());
        Assert.assertTrue(((ChromeDriver) driver).findElementById("project-view-state").isEnabled());
        Assert.assertTrue(((ChromeDriver) driver).findElementById("project-description").isEnabled());

        //заполнение формы
        String projectsName = RandomStringUtils.randomAlphabetic(10);
        driver.findElement(By.id("project-name")).sendKeys(projectsName);
        Select dropdown = new Select(driver.findElement(By.id("project-status")));
        dropdown.selectByVisibleText("development");

        WebElement checkBox;
        checkBox = driver.findElement(By.cssSelector(".lbl"));
        if (!checkBox.isSelected()) {
            checkBox.click();
        }

        Select dropdown2 = new Select(driver.findElement(By.id("project-view-state")));
        dropdown2.selectByVisibleText("public");
        driver.findElement(By.id("project-description")).sendKeys("This is a cute cartoon for children");

        //добавляем проект
        driver.findElement(By.cssSelector(".btn.btn-primary.btn-white.btn-round")).click();

        //проверка на заполнение полей
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        List<WebElement> projectTableNameColumnValues = driver.findElements(By.xpath
                ("//div[@class='table-responsive']//td//a"));
        List<String> actualNameValues = new ArrayList<>();
        for (WebElement projectTableNameColumnValue : projectTableNameColumnValues) {
            actualNameValues.add(projectTableNameColumnValue.getText());

        }
        assertThat(actualNameValues, hasItem(projectsName));

        //logout
        driver.findElement(By.className("user-info")).click();
        driver.findElement(By.xpath("//a[contains(@href, 'logout_page')]")).click();


        //закрываем окно браузера
        driver.close();

    }


}
