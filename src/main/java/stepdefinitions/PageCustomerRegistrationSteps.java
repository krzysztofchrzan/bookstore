package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.PageCustomerRegistration;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PageCustomerRegistrationSteps {
    private WebDriver webDriver;
    private String basePath;
    private PageCustomerRegistration pageCustomerRegistration;


    @Given("I open a Customer Registration form")
    public void i_open_a_customer_registration_form() {
        webDriver = CommonConfig.webDriver;
        basePath = CommonConfig.basePath;

        pageCustomerRegistration = new PageCustomerRegistration(webDriver);
        webDriver.get(basePath + pageCustomerRegistration.getPageName());
    }

    @When("On Customer Registration Form I enter first name {string}")
    public void on_customer_registration_form_i_enter(String firstName) {
        pageCustomerRegistration.enterFirstName(firstName);
    }

    @When("On Customer Registration Form I enter last name {string}")
    public void enterLastName(String lastNameValue) {
        pageCustomerRegistration.enterlastName(lastNameValue);
    }

    @When("On Customer Registration Form I enter email {string}")
    public void on_customer_registration_form_i_enter_email(String emailValue) {
        pageCustomerRegistration.enterEmail(emailValue);
    }

    @When("On Customer Registration Form I enter phone number {string}")
    public void on_customer_registration_form_i_enter_phone_number(String phoneNumberValue) {
        pageCustomerRegistration.enterPhoneNumber(phoneNumberValue);
    }

    @When("On Customer Registration Form I enter date of birth {string}")
    public void on_customer_registration_form_i_enter_date_of_birth(String dateOfBirthValue) {
        pageCustomerRegistration.enterDateOfBirth(dateOfBirthValue);
    }

    @When("On Customer Registration Form I choose gender {string}")
    public void on_customer_registration_form_i_choose_gender(String genderValue) {
        pageCustomerRegistration.enterGender(genderValue);
    }

    @When("On Customer Registration Form I enter address {string}")
    public void on_customer_registration_form_i_enter_address(String addressLineValue) {
        pageCustomerRegistration.enterAddressLine(addressLineValue);
    }

    @When("On Customer Registration Form I enter state {string}")
    public void on_customer_registration_form_i_enter_state(String stateValue) {
        pageCustomerRegistration.enterState(stateValue);
    }

    @When("On Customer Registration Form I enter zip code {string}")
    public void on_customer_registration_form_i_enter_zip_code(String zipCodeValue) {
        pageCustomerRegistration.enterZipCode(zipCodeValue);
    }

    @When("On Customer Registration Form I enter city {string}")
    public void on_customer_registration_form_i_enter_city(String cityValue) {
        pageCustomerRegistration.enterCity(cityValue);
    }

    @When("On Customer Registration Form I enter country {string}")
    public void on_customer_registration_form_i_enter_country(String countryValue) {
        pageCustomerRegistration.enterCountry(countryValue);
    }

    @When("On Customer Registration Form I enter occupation {string}")
    public void on_customer_registration_form_i_enter_occupation(String occupationValue) {
        pageCustomerRegistration.enterOccupation(occupationValue);
    }

    @When("On Customer Registration Form I choose occupation role {string}")
    public void on_customer_registration_form_i_choose_residence_status(String occupationRoleValue) {
        pageCustomerRegistration.enterOccupationRole(occupationRoleValue);
    }

    @When("On Customer Registration Form I click register")
    public void on_customer_registration_form_i_choose_register() {
        pageCustomerRegistration.submitRegister();
    }

//    public void tearDown() throws InterruptedException {
//        Thread.sleep(3000);
//        webDriver.quit();
//    }

}
