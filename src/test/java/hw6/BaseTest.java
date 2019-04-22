package hw6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.AssertJUnit.assertEquals;

public class BaseTest {

    protected WebDriver driver;
    private ChromeOptions options;

    @BeforeSuite
    public void setUpSuite() {
        WebDriverManager.chromedriver().setup();

        System.setProperty("webdriver.chrome.driver",
                "src/test/resources/webdriver.chrome/chromedriver.exe");
    }

    @BeforeClass
    public void setUpClassTest() {
        options = new ChromeOptions();
    }

    @BeforeMethod
    public void setUpTest() {
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        driver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);
        driver.manage().timeouts().setScriptTimeout(15000, TimeUnit.MILLISECONDS);
        driver.manage().window().maximize();
        // открываем и проверяем страницу
        driver.get("http://khda91.fvds.ru/mantisbt/");
        assertThat(driver.getTitle(), equalTo("MantisBT"));


    }

    @AfterMethod
    //закрываем окно браузера
    public void closeBrowser() {
        driver.close();
    }

}