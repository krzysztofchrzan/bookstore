package pages;

import io.cucumber.java.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PageLogin {
    private WebDriver driver;
    private String pageURL = "bookstore_login_page.html";
    private String expectedPageTitle = "Bookstore Login Page";


    // 1. locators
    private By title = By.tagName("title");
    private By username = By.name("username");
    private By password = By.name("password");
    private By submit = By.xpath("//input[type='submit'");

    // 2. constructor
    PageLogin(WebDriver driver){
        this.driver = driver;
    }

    public String getPageUrl() {
        return pageURL;
    }

    // 3. page actions
    public boolean isPageTitleCorrect(){
        //System.out.println(elementTitle.getText());
        return driver.getTitle().equals(expectedPageTitle);
    }

    public void enterUsername(){
        driver.findElement(username).sendKeys("admin");
    }

    public void enterPassword(){
        driver.findElement(password).sendKeys("pass1");
    }

    public void clickSubmit(){

    }

}
