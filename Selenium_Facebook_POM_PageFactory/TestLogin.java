package Selenium_Facebook_POM_PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestLogin {
    private WebDriver driver;
    private FacebookLoginPageFirst facebookLoginPageFirst;
    private FacebookUserHomePage facebookUserHomePage;


    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ayzin\\Desktop\\Selenium\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        System.out.println("Going to use POM with PageFactory");
    }

    @Test (priority = 0)
    public void verifyLoginPageOpening(){
        driver.get("http://facebook.com");
        facebookLoginPageFirst = new FacebookLoginPageFirst(driver);
        String regButtonName = facebookLoginPageFirst.getRegisterButtonName();
        Assert.assertEquals(regButtonName.toLowerCase(), "Sign up".toLowerCase());
    }

    @Test (priority = 1, dependsOnMethods = {"verifyLoginPageOpening"})
    public void verifySuccessfulLogin(){
        facebookLoginPageFirst.performLogin("ayzink@gmail.com", "Gsdnv1987");
        facebookUserHomePage = new FacebookUserHomePage(driver);
        Assert.assertEquals(facebookUserHomePage.getNavigationLabel(), "Настройки аккаунта");
    }

    @Test (priority = 2, dependsOnMethods = {"verifySuccessfulLogin"})
    public void verifyCorrectLogout(){
        facebookUserHomePage.logOut();
        String regButtonName = facebookLoginPageFirst.getRegisterButtonName();
        Assert.assertEquals(regButtonName, "Регистрация");
    }

    @AfterClass
    public void tearDown(){
        if (driver!=null){
            driver.quit();
            driver = null;
        }
        System.out.println("Login test finished, exiting");
    }
}
