package steps;

import context.TestContext;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import pages.CheckOutPage;
import pojos.BillingAddress;

import java.util.List;
import java.util.Map;

public class CheckOutPageSteps {

    private final TestContext context;

    public CheckOutPageSteps(TestContext context)
    {
        this.context = context;
    }


    @DataTableType
    public BillingAddress billingEntry(Map<String,String> billingDetails)
    {
        return new BillingAddress(billingDetails.get("firstName"),
                billingDetails.get("lastName"),
                billingDetails.get("street"),
                billingDetails.get("city"),
                billingDetails.get("zip"),
                billingDetails.get("email")
                );
    }


    @And("Guest fills the billing address")
    public void guest_fills_the_billing_address(BillingAddress billing)
    {
        //Map<String, String> billing = rows.get(0);
        String firstName = billing.getFirstName();
        String lastName  = billing.getLastName();
        String street    = billing.getStreet();
        String city      = billing.getCity();
        String zip       = billing.getZip();
        String email     = billing.getEmail();
        context.getPageManager()
                .getCheckOutPage()
                .enterUserDetails(firstName, lastName, street, city, zip, email);
    }



    //@And("Guest fills the billing address")
//    public void guest_fills_the_billing_address(List<Map<String, String>> rows)
//    {
//        Map<String, String> billing = rows.get(0);
//        String firstName = billing.get("firstName");
//        String lastName  = billing.get("lastName");
//        String street    = billing.get("street");
//        String city      = billing.get("city");
//        String zip       = billing.get("zip");
//        String email     = billing.get("email");
//        context.getPageManager()
//                .getCheckOutPage()
//                .enterUserDetails(firstName, lastName, street, city, zip, email);
//    }

    @And("Guest submits the Order")
    public void guest_submits_the_order()
    {
      context.getPageManager().getCheckOutPage().placeOrder();
    }




}
