package hw5;

// TODO Не используемые иморты удалить

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;




// TODO форматирование (CTRL + ALT + L)
public class AddUser {

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


        //переход и проверка на страницу Manage Users
        // TODO Так как это ссылка можно использовать By.partialLinkText or By.linkText
        driver.findElement(By.xpath("//a[text()='Manage Users']")).click();
        assertThat(driver.getTitle(), equalTo("Manage Users - MantisBT"));

        //проверка наличия меню
        // TODO В каих целях было оспользованно данное приведение ((ChromeDriver) driver)
        // TODO findElementByXPath - почему был выбран данный метод?
        Assert.assertTrue(((ChromeDriver) driver).findElementByXPath("//a[text()='Create New Account']").isEnabled());


        //кликнуть "новый аккаунт", открылась страница для создания
        driver.findElement(By.xpath("//a[text()='Create New Account' ]")).click();

        //проверка наличия полей
        // TODO В каих целях было оспользованно данное приведение ((ChromeDriver) driver)
        // TODO findElementById - почему был выбран данный метод?
        // TODO findElementByCssSelector - почему был выбран данный метод?
        Assert.assertTrue(((ChromeDriver) driver).findElementById("user-username").isEnabled());
        Assert.assertTrue(((ChromeDriver) driver).findElementById("user-realname").isEnabled());
        Assert.assertTrue(((ChromeDriver) driver).findElementById("email-field").isEnabled());
        Assert.assertTrue(((ChromeDriver) driver).findElementById("user-password").isEnabled());
        Assert.assertTrue(((ChromeDriver) driver).findElementById("user-verify-password").isEnabled());
        Assert.assertTrue(((ChromeDriver) driver).findElementById("user-access-level").isEnabled());
        Assert.assertTrue(((ChromeDriver) driver).findElementByCssSelector(".lbl").isEnabled());
        Assert.assertTrue(((ChromeDriver) driver).findElementByCssSelector(".lbl").isEnabled());

        //заполнение полей
        driver.findElement(By.id("user-username")).sendKeys("dktest");
        driver.findElement(By.id("user-realname")).sendKeys("Daria");
        driver.findElement(By.id("email-field")).sendKeys("trololo@trololo.ru");
        driver.findElement(By.id("user-password")).sendKeys("dktest");
        driver.findElement(By.id("user-verify-password")).sendKeys("dktest");

        //сохранение
        driver.findElement(By.xpath("//input[@value='Create User']")).click();


        //logout
        driver.findElement(By.className("user-info")).click();
        driver.findElement(By.xpath("//a[contains(@href, 'logout_page')]")).click();

        //закрываем окно браузера
        driver.close();
    }
}

