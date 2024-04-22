package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageCustomerRegistration {
    private final WebDriver driver;

    private final By firstName = By.xpath("//form/p[1]/input");
    private final By lastName = By.id("last-name");
    private final By email = By.cssSelector("input#email");
    private final By phoneNumber = By.id("phone-number");
    private final By dateOfBirth = By.name("dob");
    private final By genderMale = By.xpath("//p/label[text()=\"Male\"] | //p/input[@id=\"gender-male\"]");
    private final By genderFemale = By.xpath("//p/label[text()=\"Female\"] | //p/input[@id=\"gender-female\"]");
    private final By addressLine = By.id("address-line");
    private final By state = By.id("state");
    private final By zipCode = By.id("zip-code");
    private final By city = By.id("city");
    private final By country = By.id("country");
    private final By occupation = By.id("occupation");
    private final By occupationRole = By.cssSelector("select#occupation-role");

    private final By register = By.name("register");



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

    public void enterOccupationRole(String occupationRoleValue) {
        WebElement webElement = driver.findElement(occupationRole);//.sendKeys(occupationRoleValue);
        Select select = new Select(webElement);
        select.selectByVisibleText(occupationRoleValue);
    }

    public void submitRegister() {
        driver.findElement(register).click();
    }
}
