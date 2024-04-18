package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.PageLogin;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


public class PageLoginSteps {
    private PageLogin pageLogin;
    private WebDriver driver;
    private String path;



    @Before(value = "@GUI")
    public void setupGUI() throws IOException {
        Properties properties = new Properties();
        properties.load(new FileReader("src\\main\\resources\\config.properties"));
        path = properties.getProperty("GUI_PATH");
        System.setProperty("webdriver.chrome.driver","C:\\chromedriver\\chromedriver123.exe");
        driver = new ChromeDriver();
    }

    @Given("I open a login webpage")
    public void openWebPage() {
        pageLogin = new PageLogin(driver);
        driver.get(path + pageLogin.getPageName());
    }

    @Then("Page title should be {string}")
    public void assertPageTitle(String expectedPageTitle) {
        pageLogin.setExpectedPageTitle(expectedPageTitle);
        Assertions.assertTrue(pageLogin.isPageTitleCorrect());
    }

    @And("I enter username and password")
    public void enterUsernameAndPassword(){
        pageLogin.enterUsername();
        pageLogin.enterPassword();
    }

    @And("I click submit")
    public void clickLogin(){
        pageLogin.clickSubmit();
    }

    @After(value = "@GUI")
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }

}
