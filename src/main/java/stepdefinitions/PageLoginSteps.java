package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.PageLogin;


public class PageLoginSteps {
    private PageLogin pageLogin;

    @Given("I open a login webpage")
    public void openWebPage() {
        WebDriver webDriver = CommonConfig.webDriver;
        String basePath = CommonConfig.basePath;

        pageLogin = new PageLogin(webDriver);
        webDriver.get(basePath + pageLogin.getPageName());
    }

    @Then("Page title should be {string}")
    public void assertPageTitle(String expectedPageTitle) {
        pageLogin.setExpectedPageTitle(expectedPageTitle);
        Assert.assertTrue(pageLogin.isPageTitleCorrect());
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
}
