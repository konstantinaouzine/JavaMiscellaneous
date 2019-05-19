<<<<<<< HEAD
package ShufersalProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestClassShufersal {
    WebDriver driver;
    ShufersalLoginPage shufersalLoginPage;
    ShufersalHomePage shufersalHomePage;
    AmericanOutletsPage americanOutletsPage;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ayzin\\Desktop\\Selenium\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        System.out.println("Going to use POM with PageFactory");
    }

    @AfterClass
    public void tearDown(){
        if (driver!=null){
            driver.quit();
            driver = null;
        }
    }

    @Test
    public void mainTestShufersal(){
        driver.get("https://www.shufersal.co.il/online/he/");

        shufersalLoginPage = new ShufersalLoginPage(driver);
        shufersalLoginPage.performLogin("ayzink@gmail.com", "******");

        shufersalHomePage = new ShufersalHomePage(driver);
        shufersalHomePage.goToAmericanOutlets();

        americanOutletsPage = new AmericanOutletsPage(driver);
        americanOutletsPage.goToAdidasShoes();
        americanOutletsPage.filterAdidasShoesByTypeAndColor();
        americanOutletsPage.purchaseShoesAndComparePrices();
    }
=======
package ShufersalProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestClassShufersal {
    WebDriver driver;
    ShufersalLoginPage shufersalLoginPage;
    ShufersalHomePage shufersalHomePage;
    AmericanOutletsPage americanOutletsPage;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ayzin\\Desktop\\Selenium\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        System.out.println("Going to use POM with PageFactory");
    }

    @AfterClass
    public void tearDown(){
        if (driver!=null){
            driver.quit();
            driver = null;
        }
    }

    @Test
    public void mainTestShufersal(){
        driver.get("https://www.shufersal.co.il/online/he/");

        shufersalLoginPage = new ShufersalLoginPage(driver);
        shufersalLoginPage.performLogin("ayzink@gmail.com", "******");

        shufersalHomePage = new ShufersalHomePage(driver);
        shufersalHomePage.goToAmericanOutlets();

        americanOutletsPage = new AmericanOutletsPage(driver);
        americanOutletsPage.goToAdidasShoes();
        americanOutletsPage.filterAdidasShoesByTypeAndColor();
        americanOutletsPage.purchaseShowsAndComparePrices();
    }
>>>>>>> e3a171b99660a989c65076a4210821a72bfad195
}