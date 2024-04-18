package pages;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


public class PageLoginTest {
    private PageLogin pageLogin;
    private WebDriver driver;
    private String page_url;


    @Before(value = "@GUI")
    public void setupGUI() throws IOException {
        Properties properties = new Properties();
        properties.load(new FileReader("src\\main\\resources\\config.properties"));
        page_url = properties.getProperty("GUI_URL");

        System.setProperty("webdriver.chrome.driver","C:\\chromedriver\\chromedriver123.exe");
        driver = new ChromeDriver();

    }

    @Given("Do something")
    public void doSomething(){
        System.out.println("cucumber works");
     }

    @Given("I open a login webpage")
    public void openWebPage() {
        driver.get(page_url);
        pageLogin = new PageLogin(driver);

        System.setProperty("webdriver.chrome.driver","C:\\chromedriver\\chromedriver123.exe");
        driver = new ChromeDriver();
        driver.get(pageLogin.getPageUrl());
    }

    @Then("I check whether page title is correct")
    public void testSuccessfulLoginAndAccessBackoffice() {
        Assertions.assertTrue(pageLogin.isPageTitleCorrect());// Verify login and access to BO
    }

}
