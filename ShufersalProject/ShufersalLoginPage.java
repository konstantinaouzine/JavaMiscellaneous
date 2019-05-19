package ShufersalProject;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ShufersalLoginPage {
    private WebDriver driver;

    @FindBy (css = "#loginDropdownContainer > button")
    private WebElement startLoginButton;

    @FindBy (id = "j_username")
    private WebElement userNameField;

    @FindBy (id = "j_password")
    private WebElement passwordField;

    @FindBy (css = "#loginForm > div.bottomSide > button")
    private WebElement loginButton;

    @FindBy (linkText = "התנתק")
    private WebElement disconnectButton;


    //Constructor
    ShufersalLoginPage(WebDriver webDriver){
        this.driver = webDriver;
        PageFactory.initElements(driver, this);
    }

    public void performLogin(String username, String password){
        try {
            startLoginButton.click();

            userNameField.clear();
            userNameField.sendKeys(username);

            passwordField.clear();
            passwordField.sendKeys(password);

            loginButton.click();
            //If button displayed then we successfully logged in
            boolean isDisconnectButtonDisplayed = disconnectButton.isDisplayed();
            if (!isDisconnectButtonDisplayed){
                System.out.println("We failed to login");
                Assert.assertTrue(false);
            }
            else
                System.out.println("Successfully logged in");
        }catch(NoSuchElementException e){
            System.out.println("We failed to login");
            Assert.assertTrue(false);
        }
    }
}
