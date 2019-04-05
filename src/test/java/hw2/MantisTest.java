package hw2;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import  static org.junit.Assert.assertEquals;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class MantisTest {

    @Test
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
        Assert.assertTrue(((ChromeDriver) driver).findElementByCssSelector(".nav-list").isEnabled());

        //переход и проверка на страницу Manage
        driver.findElement(By.xpath("//a[contains(@href, 'manage_overview_page')]")).click();
        assertThat(driver.getTitle(), equalTo("Manage - MantisBT"));

        //переход и проверка на страницу Manage Projects
        driver.findElement(By.xpath("//a[contains(@href, 'manage_proj_page')]")).click();
        assertThat(driver.getTitle(), equalTo("Manage Projects - MantisBT"));

        //проверка наличия кнопки Create new project
        Assert.assertTrue(((ChromeDriver) driver).findElementByCssSelector(".btn.btn-primary.btn-white.btn-round")
                .isEnabled());

        //клик и проверка перехода на страницу  add projects
        driver.findElement(By.cssSelector(".btn.btn-primary.btn-white.btn-round")).click();
                Assert.assertEquals("http://khda91.fvds.ru/mantisbt/manage_proj_create_page.php",
                driver.getCurrentUrl());

        //проверка наличия полей
        Assert.assertTrue(((ChromeDriver) driver).findElementById("project-name").isEnabled());
        Assert.assertTrue(((ChromeDriver) driver).findElementById("project-status").isEnabled());
        Assert.assertTrue(((ChromeDriver) driver).findElementByCssSelector(".lbl").isEnabled());
        Assert.assertTrue(((ChromeDriver) driver).findElementById("project-view-state").isEnabled());
        Assert.assertTrue(((ChromeDriver) driver).findElementById("project-description").isEnabled());

        //заполнение формы
        driver.findElement(By.id("project-name")).sendKeys("Kitten Gav-Gav 2");
        Select dropdown = new Select(driver.findElement(By.id("project-status")));
        dropdown.selectByVisibleText("development");

        WebElement checkBox;
        checkBox = driver.findElement(By.cssSelector(".lbl"));
        if(!checkBox.isSelected()){
            checkBox.click();
                    }

        Select dropdown2 = new Select(driver.findElement(By.id("project-view-state")));
        dropdown2.selectByVisibleText("public");
        driver.findElement(By.id("project-description")).sendKeys("This is a cute cartoon for children");

        //добавляем проект
        driver.findElement(By.cssSelector(".btn.btn-primary.btn-white.btn-round")).click();

        //проверка на заполнение полей
        assertEquals("Kitten Gav-Gav 2", driver.findElement(By.id("project-name")).getText());
       // assertTrue(driver.findElement(By.id("project-name")).getText().equals("Kitten Gav-Gav"));





        //logout
        driver.findElement(By.className("user-info")).click();
        driver.findElement(By.xpath("//a[contains(@href, 'logout_page')]")).click();

        //закрываем окно браузера
        driver.close();

    }
}