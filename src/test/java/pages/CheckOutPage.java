package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CheckOutPage extends BasePage{

    private static final Logger log = LoggerFactory.getLogger(CheckOutPage.class);

    public CheckOutPage(WebDriver driver) {
        super(driver);
    }


    //LOCATORS
    private static final By firstNameTxt =  By.id("billing_first_name");

    private static final By lastNameTxt =  By.id("billing_last_name");

    private static final By billingAddressTxt =  By.id("billing_address_1");

    private static final By billingCityTxt =  By.id("billing_city");

    private static final By postCodeTxt =  By.id("billing_postcode");

    private static final By emailTxt =  By.id("billing_email");

    private static final By placeOrderBtn =  By.id("place_order");

    //ACTIONS


    public void enterFirstName(String fname)
    {
        log.info("Entering First name..");
        //driver.findElement(firstNameTxt).sendKeys(fname);
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameTxt)).sendKeys(fname);
    }

    public void enterLastName(String lname)
    {
        log.info("Entering Last name..");
        //driver.findElement(lastNameTxt).sendKeys(lname);
        wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameTxt)).sendKeys(lname);
    }
    public void enterbillingAddress(String billAddress)
    {
        log.info("Entering Street details..");
        //driver.findElement(billingAddressTxt).sendKeys(billAddress);
       WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(billingAddressTxt));
       e.clear();
       e.sendKeys(billAddress);
    }

    public void enterbillingCity(String city)
    {
        log.info("Entering billing city..");
        //driver.findElement(billingCityTxt).sendKeys(city);
        WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(billingCityTxt));
        e.clear();
        e.sendKeys(city);
    }
    public void enterPostalCode(String zipcode)
    {

        log.info("Entering Postal Code..");
        //driver.findElement(postCodeTxt).sendKeys(zipcode);

        WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(postCodeTxt));
        e.clear();
        e.sendKeys(zipcode);

    }
    public void enterEmail(String email)
    {
        log.info("Entering Email..");

        //driver.findElement(emailTxt).sendKeys(email);

        WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(emailTxt));
        e.clear();
        e.sendKeys(email);


    }

    public void enterUserDetails(String fname,String lname,String bAddress,String city,String zipcode,String email)
    {
        enterFirstName(fname);
        enterLastName(lname);
        enterbillingAddress(bAddress);
        enterbillingCity(city);
        enterPostalCode(zipcode);
        enterEmail(email);
    }


    public void placeOrder()
    {

        log.info("click on Place Order Button..");
        //driver.findElement(placeOrderBtn).click();
         wait.until(ExpectedConditions.elementToBeClickable(placeOrderBtn)).click();

    }
}
