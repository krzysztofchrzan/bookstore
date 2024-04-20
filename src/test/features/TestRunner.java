package features;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/features/api_customer_operations.feature",glue={"src/main/java/stepdefinitions"}
        ,plugin = {"json:target/cucumber.json"}
)

public class TestRunner {

}