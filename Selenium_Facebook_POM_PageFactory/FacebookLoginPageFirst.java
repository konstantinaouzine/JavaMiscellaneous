package Selenium_Facebook_POM_PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class FacebookLoginPageFirst {
    private WebDriver driver;

    public FacebookLoginPageFirst(WebDriver driver){
        this.driver = driver;
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 30);
        PageFactory.initElements(factory, this);
    }

    //@FindBy (name = "email")
    @FindBy (xpath = "/html/body/div/div[2]/div/div/div/div/div[2]/form/table/tbody/tr[2]/td/input")
    private WebElement emailField;

    //@FindBy (id = "pass")
    @FindBy (xpath = "/html/body/div/div[2]/div/div/div/div/div[2]/form/table/tbody/tr[2]/td[2]/input")
    private WebElement passField;

    @FindBy (name = "websubmit")
    private WebElement registerButton;

    @FindBy (id = "loginbutton")
    private WebElement loginButton;

    public String getRegisterButtonName(){
        return registerButton.getText();
    }

    private void enterEmail(String emailAddress){
        emailField.sendKeys(emailAddress);
    }

    private void enterPass(String password){
        passField.sendKeys(password);
    }

    private void logIn(){
        loginButton.click();
    }

    public void performLogin(String email, String pass){
        enterEmail(email);
        enterPass(pass);
        logIn();
    }
}
