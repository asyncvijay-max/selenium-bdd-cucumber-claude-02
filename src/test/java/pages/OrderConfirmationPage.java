package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OrderConfirmationPage extends BasePage{
    public OrderConfirmationPage(WebDriver driver) {
        super(driver);
    }

    By orderConfirmationMsg =  By.cssSelector(".woocommerce-thankyou-order-received");

    public Boolean checkTextOrderConfirmationMsg()
    {
        //  The text can contain partial match also here. it is more like contains.
        return wait.until(ExpectedConditions.textToBePresentInElementLocated(orderConfirmationMsg,"Thank you. Your order has been received."));
    }

}
