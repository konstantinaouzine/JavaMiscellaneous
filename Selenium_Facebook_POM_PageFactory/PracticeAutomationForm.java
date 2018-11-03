import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.firefox.FirefoxProfile;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxOptions;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class PracticeAutomationForm {
    public static void testPracticeAutomationForm() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ayzin\\Desktop\\Selenium\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(options);
        //Create FireFox Profile object
        /*FirefoxProfile profile = new FirefoxProfile();

        //Set Location to store files after downloading.
        profile.setPreference("browser.download.dir", "C:\\Users\\ayzin\\Desktop\\Selenium");
        profile.setPreference("browser.download.folderList", 2);

        //Set Preference to not show file download confirmation dialogue using MIME types Of different file extension types.
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/zip;");
        *//*profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
                "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;");*//*
        profile.setPreference( "browser.download.manager.showWhenStarting", false );
        profile.setPreference( "pdfjs.disabled", true );
        FirefoxOptions options = new FirefoxOptions();
        options.setProfile(profile);
        FirefoxDriver driver = new FirefoxDriver(options);
*/
        driver.get("http://toolsqa.com/automation-practice-form/");
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //Silent download file by pressing download link in FireFox
        /*driver.findElement(By.linkText("Selenium Automation Hybrid Framework")).click();
        Thread.sleep(5000);*/

        /*//Partial link test
        driver.findElement(By.partialLinkText("Test")).click();
        //Browser go 1 step back
        driver.navigate().back();
        //Link text test
        driver.findElement(By.linkText("Link Test")).click();
        //Browser go 1 step back
        driver.navigate().back();*/
        //Scroll down
        //js.executeScript("window.scrollBy(0,500)", "");
        //Locate by name
        driver.findElement(By.name("firstname")).clear();
        driver.findElement(By.name("firstname")).sendKeys("Kosta");
        driver.findElement(By.name("lastname")).clear();
        driver.findElement(By.name("lastname")).sendKeys("Aouzine");
        //Locate by CSS Selector + Radio buttons
        driver.findElement(By.cssSelector("input[name='sex'][value='Male']")).click();
        driver.findElement(By.cssSelector("input[name='exp'][value='5']")).click();
        //js.executeScript("window.scrollBy(0,500)", "");
        //Locate by id
        driver.findElement(By.id("datepicker")).sendKeys("30/06/2018");
        WebElement webElement = driver.findElement(By.cssSelector("input[type='checkbox'][value='Automation Tester']"));
        js.executeScript("arguments[0].scrollIntoView(true);", webElement);
        Thread.sleep(2000);
        webElement.click();
        //Locate by className
        driver.findElement(By.className("input-file")).sendKeys("C:\\Users\\ayzin\\Desktop\\Selenium\\pic for upload.jpg");
        //Select multiple checkboxes
        driver.findElement(By.cssSelector("input[type='checkbox'][value='QTP']")).click();
        driver.findElement(By.cssSelector("input[type='checkbox'][value='Selenium Webdriver']")).click();

        //Select from DropDown list
        Select continentsSelect = new Select(driver.findElement(By.id("continents")));
        List<WebElement> continentsElems = continentsSelect.getOptions();
        for (WebElement webElement1 : continentsElems)
        {
            if (webElement1.getText().equals("Europe")) {
                continentsSelect.selectByVisibleText("Europe");
            }
        }
        Select multipleSelectCommands = new Select(driver.findElement(By.id("selenium_commands")));
        for (int i=0; i<multipleSelectCommands.getOptions().size(); i++)
        {
            if (i%2==0)
                multipleSelectCommands.selectByIndex(i);
        }
        //driver.findElement(By.id("submit")).click();
        Thread.sleep(10000);
        driver.quit();
    }

}
