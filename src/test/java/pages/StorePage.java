package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StorePage extends BasePage {

    private static final Logger log = LoggerFactory.getLogger(StorePage.class);

    public StorePage(WebDriver driver) {
        super(driver);
    }

    private final By searchTextBox = By.id("woocommerce-product-search-field-0");
    private final By searchButton = By.cssSelector("[value='Search']");
    private final By searchResults = By.cssSelector("#main h1");

    // add product to cart button
    private final By addProductToCart = By.cssSelector("[aria-label='Add “Blue Shoes” to your cart']");

     //View cart Link
    private final By viewCartLink = By.cssSelector("[title='View cart']");



    public void searchForTheProduct(String product)
    {
        log.info("Searching for product: {}", product);
      driver.findElement(searchTextBox).sendKeys(product);

        log.info("clicking on the search button");
      driver.findElement(searchButton).click();
    }

    public String searchResultsText()
    {
        return driver.findElement(searchResults).getText();
    }

    public void addTheProductToTheCart(String productName)  {
        // We are dynamically selecting the locator based on product name
         By addProductToCart = By.cssSelector("[aria-label='Add “"+productName+"” to your cart']");

        log.info("clicking on the add to product button");
        driver.findElement(addProductToCart).click();

        //slight delay for view cart link to appear
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void clickOnViewCartLink()
    {
        log.info("click on View Cart Link");
        driver.findElement(viewCartLink).click();
        //This takes us to Cart Page
    }




}
