package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageCustomerRegistration {
    private final WebDriver driver;
    private String basePath;

    private final By firstName = By.id("first-name");
    private final By lastName = By.id("last-name");
    private final By email = By.id("email");
    private final By phoneNumber = By.id("phone-number");
    private final By dateOfBirth = By.id("date-of-birth");
    private final By genderMale = By.xpath("//p/label[text()=\"Male\"]");
    private final By genderMale2 = By.id("gender-malex");
    private final By genderFemale = By.id("gender-female");
    private final By addressLine = By.id("address-line");
    private final By state = By.id("state");
    private final By zipCode = By.id("zip-code");
    private final By city = By.id("city");
    private final By country = By.id("country");
    private final By occupation = By.id("occupation");
    private final By residenceStatus = By.id("residence-status");



    public PageCustomerRegistration(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageName() {
        return "bookstore_registration.html";
    }

    public void enterFirstName(String firstNameValue) {
        driver.findElement(firstName).sendKeys(firstNameValue);
    }

    public void enterlastName(String lastNameValue) {
        driver.findElement(lastName).sendKeys(lastNameValue);
    }

    public void enterEmail(String emailValue) {
        driver.findElement(email).sendKeys(emailValue);
    }

    public void enterPhoneNumber(String phoneNumberValue) {
        driver.findElement(phoneNumber).sendKeys(phoneNumberValue);
    }

    public void enterDateOfBirth(String dateOfBirthValue) {
        driver.findElement(dateOfBirth).sendKeys(dateOfBirthValue);
    }

    public void enterGender(String genderValue) {
        if (genderValue.equalsIgnoreCase("male"))
        driver.findElement(genderMale).click();
        else if (genderValue.equalsIgnoreCase("female"))
        driver.findElement(genderFemale).click();
    }

    public void enterAddressLine(String addressLineValue) {
        driver.findElement(addressLine).sendKeys(addressLineValue);
    }

    public void enterState(String stateValue) {
        driver.findElement(state).sendKeys(stateValue);
    }

    public void enterZipCode(String zipCodeValue) {
      driver.findElement(zipCode).sendKeys(zipCodeValue);
    }

    public void enterCity(String cityValue) {
        driver.findElement(city).sendKeys(cityValue);
    }

    public void enterCountry(String countryValue) {
        driver.findElement(country).sendKeys(countryValue);
    }

    public void enterOccupation(String occupationValue) {
        driver.findElement(occupation).sendKeys(occupationValue);
    }

    public void enterResidenceStatus(String residenceStatusValue) {
        //driver.findElement(residenceStatus).sendKeys(residenceStatusValue);
    }
}
