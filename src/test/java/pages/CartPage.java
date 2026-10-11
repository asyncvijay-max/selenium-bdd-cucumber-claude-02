package pages;

import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CartPage extends BasePage{

    private static final Logger log = LoggerFactory.getLogger(CartPage.class);

    public CartPage(WebDriver driver) {
        super(driver);
    }

    //This is a td in the row which shows the product added into Cart Page
    //You can extract text and then do assertion
    private final By productNameInTheCart = By.cssSelector("td.product-name > a");

    //check out button
    private final By checkOutBtn = By.cssSelector(".checkout-button");


    //ACTIONS
    public void clickOnCheckOutButton()
    {

        log.info("click on the CheckOut Button");
        wait.until(ExpectedConditions.elementToBeClickable(checkOutBtn)).click();
    }

    public String getTextProductInTheCart()
    {
        log.info("Extracting Product Text ,added in the Cart for Assertion");
        return driver.findElement(productNameInTheCart).getText();
    }

}
