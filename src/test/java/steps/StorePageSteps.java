package steps;

import context.TestContext;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pojos.ShoeColor;

public class StorePageSteps {

    private final TestContext context;

    public StorePageSteps(TestContext context)
    {
        this.context = context;

    }


    @ParameterType("\"([^\"]*)\"")
   public ShoeColor shoecolor(String color)
   {
       return new ShoeColor(color);
   }

    @When("Guest search for {shoecolor}")
    public void guest_search_for(ShoeColor color) throws InterruptedException {
    context.getPageManager().getStorePage().searchForTheProduct(color.getShoeColor());
        Thread.sleep(2000);

    }

//    @When("Guest search for {string}")
//    public void guest_search_for(String pname) throws InterruptedException {
//        context.getPageManager().getStorePage().searchForTheProduct(pname);
//        Thread.sleep(2000);
//
//    }

    @Then("Guest is able to search successfully")
    public void guest_is_able_to_search_successfully() throws InterruptedException {
        String searchResult = context.getPageManager().getStorePage().searchResultsText();
        Thread.sleep(2000);
        Assert.assertTrue(searchResult.contains("Search results:"));
    }

    @And("Guest adds {string} in the cart")
    public void guest_adds_shoes_in_the_cart(String prodName)
    {
        //This adds the product to the Cart From Store Page
        context.getPageManager().getStorePage().addTheProductToTheCart(prodName);

        //This click view cart link from Store Page. This takes us to Cart Page.
        context.getPageManager().getStorePage().clickOnViewCartLink();

    }

}
