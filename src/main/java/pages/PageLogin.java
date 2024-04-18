package pages;

import org.openqa.selenium.*;

public class PageLogin {
    private WebDriver driver;
    private String pageURL = "bookstore_login_page.html";
    private String expectedPageTitle = "Bookstore Login Page";


    // 1. locators
    private By username = By.name("username");
    private By password = By.name("password");
    private By submit = By.xpath("//input[@type=\"submit\"]");

    // 2. constructor
    public PageLogin(WebDriver driver){
        this.driver = driver;
    }

    public String getPageUrl() {
        return pageURL;
    }

    // 3. page actions
    public boolean isPageTitleCorrect(){
        return driver.getTitle().equals(expectedPageTitle);
    }

    public void enterUsername(){
        driver.findElement(username).sendKeys("admin");
    }

    public void enterPassword(){
        driver.findElement(password).sendKeys("pass1");
    }

    public void clickSubmit(){
        driver.findElement(submit).click();
    }

}
