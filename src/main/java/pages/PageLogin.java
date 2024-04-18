package pages;

import io.cucumber.java.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PageLogin {
    private String page_url;
    private WebDriver driver;
    WebElement elementTitle;

    PageLogin(WebDriver driver){
        this.driver = driver;
    }

//    @Given("Do something")
//    public void doSomething(){
//        System.out.println("cucumber works");
//    }

    public String getPageUrl() {
        return page_url;
    }

    public WebDriver getDriver() {
        return driver;
    }


    public void openWebPage() {


        elementTitle = driver.findElement(By.tagName("title"));
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

    public boolean isPageTitleCorrect(){
        System.out.println(elementTitle.getText());
        return driver.getTitle().equals(elementTitle.getText());
    }

    //@After(value = "@GUI")
    public void closePage() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
