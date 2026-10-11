package steps;

import context.TestContext;
import io.cucumber.java.en.Then;

public class OrderConfirmationSteps {

    private TestContext context;

    public OrderConfirmationSteps(TestContext context)
    {
        this.context = context;
    }

    @Then("Guest sees the order successfully")
    public void guest_sees_the_order() throws InterruptedException {

        Thread.sleep(2000);
        //Assertion to see the msg "Thank you. Your order has been received." once order submitted
    context.getPageManager().getOrderConfirmationPage().checkTextOrderConfirmationMsg();
    }

}
