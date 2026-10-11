package transformers;

import io.cucumber.java.DataTableType;
import pojos.BillingAddress;

import java.util.Map;

public class DataTableTransformers {

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
}
