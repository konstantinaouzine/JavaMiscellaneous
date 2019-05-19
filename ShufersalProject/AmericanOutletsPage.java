package ShufersalProject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class AmericanOutletsPage {
    private WebDriver driver;
    WebDriverWait wait;
    //Constructor
    public AmericanOutletsPage(WebDriver webdriver){
        this.driver = webdriver;
        wait=new WebDriverWait(driver, 5);
        PageFactory.initElements(driver, this);
    }

    @FindBy (css = "#ui-id-4 > span")
    private WebElement shoes;

    @FindBy (linkText = "Adidas")
    private WebElement adidasShoes;

    @FindBy (className = "filter-options-title")
    private List<WebElement> openTypeFilterGroup;

    @FindBy (css = "#ui-id-3 > div > div > ol > li:nth-child(5) > a > label")
    private WebElement selectBasketBallShoesInFilter;

    @FindBy (className = "filter-options-title")
    private List<WebElement> openColorFilterGroup;

    @FindBy (css = "#ui-id-5 > div > div > ol > li:nth-child(7) > a > label")
    private WebElement selectGreyColorInFilter;

    @FindBy (css = "#ui-id-5 > div > a")
    private WebElement submitButtonInColorSelection;

    @FindBy (xpath = "//span[contains(text(), 'Adidas Mens Rise Up 2 Cloudfoam Athletic Basketball Shoes')]")
    private WebElement adidasSpecificShoes;

    @FindBy (xpath = "//span[contains(text(), 'Adidas Mens Rise Up 2 Cloudfoam Athletic Basketball Shoes')]/../../../div[@class='price-box price-final_price']/span/span/span[2]")
    private WebElement lookForPrice;

    //Stupid selector because everytime product will be added or deleted the child(ID) will change and another product will be added to cart :)
    @FindBy (xpath = "//span[contains(text(), 'Adidas Mens Rise Up 2 Cloudfoam Athletic Basketball Shoes')]/../../../div[@class='hidden']/div[2]/div/form/button")
    private WebElement addToCartButton;

    @FindBy (css = "#minicart-content-wrapper > div.block-content > div.actions-bottom > div > a")
    private WebElement cartElement;

    @FindBy (css = "#cart-totals > div > table > tbody > tr.totals.sub > td > span")
    private WebElement elementInCart;

    public void goToAdidasShoes(){
        shoes.click();
        adidasShoes.click();
        if(driver.getTitle().contains("adidas"))
            System.out.println("Entered Adidas shoes category");
        else {
            System.out.println("Something went wrong - we failed to enter Adidas shoes category");
            Assert.assertTrue(false);
        }

    }

    public void filterAdidasShoesByTypeAndColor(){
        selectShoesType();
        selectShoesColorAndSubmit();
    }

    private void selectShoesType(){
        for (WebElement element : openTypeFilterGroup){
            if(element.getText().equalsIgnoreCase("סגנון"))
                element.click();
        }
        selectBasketBallShoesInFilter.click();
    }

    private void selectShoesColorAndSubmit(){
        for (WebElement element : openColorFilterGroup){
            if (element.getText().equalsIgnoreCase("צבע"))
                element.click();
        }
        selectGreyColorInFilter = wait.until(ExpectedConditions.elementToBeClickable(selectGreyColorInFilter));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", selectGreyColorInFilter);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        selectGreyColorInFilter.click();
        System.out.println("Color selected");
        submitButtonInColorSelection = wait.until(ExpectedConditions.elementToBeClickable(submitButtonInColorSelection));
        submitButtonInColorSelection.click();
        System.out.println("Submit button pressed");

        boolean areShowsShown = adidasSpecificShoes.isDisplayed();
        if (!areShowsShown)
            Assert.assertTrue(false, "Specific shows not displayed");

    }

    public void purchaseShowsAndComparePrices(){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", adidasSpecificShoes);
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -450);");

        Actions action = new Actions(driver);
        action.moveToElement(adidasSpecificShoes).perform();

        String priceInGalleryAsString = lookForPrice.getAttribute("data-price-amount");
        Double priceInGallery = Double.valueOf(priceInGalleryAsString);
        System.out.println("Price of shows in gallery: " + priceInGallery);

        addToCartButton.click();
        //not found other way to click properly on cart button
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        cartElement.click();
        System.out.println("Cart opened");
        String[] priceArr = elementInCart.getText().split(" ");
        double priceInCart = Double.valueOf(priceArr[0]);
        System.out.println("Price of shows in cart: " + priceInCart);
        Assert.assertTrue(priceInGallery==priceInCart);
    }

}
