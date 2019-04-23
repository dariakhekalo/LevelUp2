package hw6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import ru.levelup.daria.khekalo.qa.hw6.LoginPageObj;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.AssertJUnit.assertEquals;

public class BaseTest {

    protected WebDriver driver;
    private ChromeOptions options;
    private LoginPageObj loginPageObj;

    private Properties properties;

    @BeforeSuite(alwaysRun = true)
    public void setUpSuite() {

        System.setProperty("webdriver.chrome.driver",
            "src/test/resources/webdriver.chrome/chromedriver.exe");
// driver = new ChromeDriver();
 //loginPageObj = new LoginPageObj(driver);
 //properties = new Properties();
 //options = new ChromeOptions();



        WebDriverManager.chromedriver().setup();

      //  LoginPageObj loginPageObj = new LoginPageObj(driver);
       Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(new File("src/test/resources/hw6/login.properties")));
        } catch (IOException e){
            e.printStackTrace();
        }

       // driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        //driver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);
        //driver.manage().timeouts().setScriptTimeout(15000, TimeUnit.MILLISECONDS);
        //driver.manage().window().maximize();

        //driver.get("http://khda91.fvds.ru/mantisbt/");
     //   assertThat(driver.getTitle(), equalTo("MantisBT"));

      //  loginPageObj.login(properties.getProperty("admin.username"),properties.getProperty("admin.password"));
       // Long.parseLong(properties.getProperty("browser.implicitly.timeout.ms"));
    }

    @BeforeClass(alwaysRun = true)
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
       //  открываем и проверяем страницу
        driver.get("http://khda91.fvds.ru/mantisbt/");
        assertThat(driver.getTitle(), equalTo("MantisBT"));


    }

    @AfterTest
    //закрываем окно браузера
    public void closeBrowser() {
        driver.close();
    }

}