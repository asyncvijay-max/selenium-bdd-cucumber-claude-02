package hooks;

import io.cucumber.java.Scenario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import context.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class Hooks {

    private static final Logger log = LoggerFactory.getLogger(Hooks.class);

    private final TestContext context;


    public Hooks(TestContext context)
    {
        System.out.println("..Hooks constructor called....");
        log.info("Hooks Constructor called ");

        this.context = context;
    }

    @Before
    public void setup(Scenario scenario)
    {
        log.info("=== Starting scenario: {} ===", scenario.getName());
        System.out.println("inside SETUP of before hook..");

        context.initialDriver();

    }


    @After
    public void teardown(Scenario scenario)
    {
        log.info("=== Finished scenario: {} - {} ===", scenario.getName(), scenario.getStatus());
        System.out.println("inside TEAR DOWN of after hook..");

        if(context.getDriver() != null) {

            context.getDriver().quit();
        }
    }
}
