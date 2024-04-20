package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageCustomerRegistration {
    private final WebDriver driver;
    private String expectedPageTitle = "";


    private final By firstName = By.id("first_name");


    public PageCustomerRegistration(WebDriver driver){
        this.driver = driver;
    }

    public String getPageName() {
        return "bookstore_login_page.html";
    }

    public void setExpectedPageTitle(String expectedPageTitle) {
        this.expectedPageTitle = expectedPageTitle;
    }


    public boolean isPageTitleCorrect(){
        return driver.getTitle().equals(expectedPageTitle);
    }

    public void enterFirstName(){
        driver.findElement(firstName).sendKeys("Krzysztof");
    }
}
