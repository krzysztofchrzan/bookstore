package pages;

import org.openqa.selenium.*;

public class PageLogin {
    private final WebDriver driver;
    private String expectedPageTitle = "";


    // 1. locators
    private final By username = By.name("username");
    private final By password = By.name("password");
    private final By submit = By.xpath("//input[@type=\"submit\"]");

    // 2. constructor
    public PageLogin(WebDriver driver){
        this.driver = driver;
    }

    public String getPageName() {
        return "bookstore_login_page.html";
    }

    public void setExpectedPageTitle(String expectedPageTitle) {
        this.expectedPageTitle = expectedPageTitle;
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
