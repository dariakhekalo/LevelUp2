package homework_5;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import  static org.junit.Assert.assertEquals;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;
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

        driver.findElement(By.cssSelector(".btn.btn-primary.btn-white.btn-round")).click();
        





        //закрываем окно браузера
        driver.close();

    }
}
