package Selenium_Facebook_POM_PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FacebookUserHomePage {
    private WebDriver driver;

    public FacebookUserHomePage(WebDriver driver) {
        this.driver = driver;
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
        PageFactory.initElements(factory, this);
    }

    @FindBy (id = "userNavigationLabel")
    private WebElement userNavigationLabel;


    public String getNavigationLabel(){
        return userNavigationLabel.getText();
    }

    public void logOut(){
        userNavigationLabel.click();
        WebDriverWait wait = new WebDriverWait(driver, 8);
        WebElement logOut = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Выйти")));
        logOut.click();
    }
}
