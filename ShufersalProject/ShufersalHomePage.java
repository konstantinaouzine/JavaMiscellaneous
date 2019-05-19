package ShufersalProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ShufersalHomePage {
    private WebDriver driver;

    @FindBy(css = "#categoryMenu > li:nth-child(5) > a > span")
    private WebElement americanOutletsButton;

    ShufersalHomePage(WebDriver webDriver){
        this.driver = webDriver;
        PageFactory.initElements(driver, this);
    }

    public void goToAmericanOutlets(){
        String windowHandle = driver.getWindowHandle();
        americanOutletsButton.click();
        for (String _windowHandle : driver.getWindowHandles())
        {
            if (!windowHandle.equalsIgnoreCase(_windowHandle))
                driver.switchTo().window(_windowHandle);
        }
        if (driver.getTitle().contains("American Outlets"))
            System.out.println("Entered American Outlets");
        else {
            System.out.println("Something went wrong - failed to enter American Outlets");
            Assert.assertTrue(false);
        }
    }

}
