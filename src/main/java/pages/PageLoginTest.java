package pages;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


public class PageLoginTest {
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
        driver.get(path + pageLogin.getPageUrl());
    }

    public void openWebPage3() {
        WebElement elementTitle = driver.findElement(By.tagName("title"));
        try {
            elementTitle = driver.findElement(By.tagName("title"));
//            WebDriverWait wait = new WebDriverWait(driver, 5);
//            wait.until(ExpectedConditions.visibilityOf(elementTable));

            //System.out.println(elementTable.getText());
        } catch (NoSuchElementException e) {
            System.out.println("not found element");
        }

//        List<WebElement> elementsList = driver.findElements(By.xpath("//table/tbody/tr[3]"));
//        System.out.println(elementsList.size());

        //String webPageTitle = driver.getTitle();
        //Assertions.assertEquals();


    }

    @Then("I check whether page title is correct")
    public void assertPageTitle() {
        Assertions.assertTrue(pageLogin.isPageTitleCorrect());
    }

    @And("I enter username and password")
    public void enterUsernameAndPassword(){

    }

    @After(value = "@GUI")
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

}
