import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue={"stepdefinitions"},
        plugin = {"json:target/cucumber.json","pretty", "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm"}
)

public class TestRunner extends AbstractTestNGCucumberTests {

}