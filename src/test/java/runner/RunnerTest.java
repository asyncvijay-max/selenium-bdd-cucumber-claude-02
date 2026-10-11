package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"hooks","steps","transformers"},
        tags =  "@searchproduct",
       // tags =  "@searchproduct or @guestorder",
        plugin = {
                "pretty",
                "html:target/cucumber-reports.html"
        },
        monochrome = true
)
public class RunnerTest extends AbstractTestNGCucumberTests {

        //Code to run scenarios in parallel
        @Override
        @DataProvider(parallel = true)
        public Object[][] scenarios() {
                return super.scenarios();
}
}
