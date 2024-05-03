package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageCustomerRegistration {
    private final WebDriver webDriver;
    private final By firstName = By.xpath("//form/p[1]/input");
    private final By lastName = By.id("last-name");
    private final By email = By.cssSelector("input#email");
    private final By phoneNumber = By.id("phone-number");
    private final By dateOfBirth = By.name("date-of-birth");
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
        this.webDriver = driver;
    }

    public String getPageName() {
        return "bookstore_registration.html";
    }

    public void enterFirstName(String firstNameValue) {
        webDriver.findElement(firstName).sendKeys(firstNameValue);
    }

    public void enterlastName(String lastNameValue) {
        webDriver.findElement(lastName).sendKeys(lastNameValue);
    }

    public void enterEmail(String emailValue) {
        webDriver.findElement(email).sendKeys(emailValue);
    }

    public void enterPhoneNumber(String phoneNumberValue) {
        webDriver.findElement(phoneNumber).sendKeys(phoneNumberValue);
    }

    public void enterDateOfBirth(String dateOfBirthValue) {
        webDriver.findElement(dateOfBirth).sendKeys(dateOfBirthValue);
    }

    public void enterGender(String genderValue) {
        if (genderValue.equalsIgnoreCase("male"))
        webDriver.findElement(genderMale).click();
        else if (genderValue.equalsIgnoreCase("female"))
        webDriver.findElement(genderFemale).click();
    }

    public void enterAddressLine(String addressLineValue) {
        webDriver.findElement(addressLine).sendKeys(addressLineValue);
    }

    public void enterState(String stateValue) {
        webDriver.findElement(state).sendKeys(stateValue);
    }

    public void enterZipCode(String zipCodeValue) {
      webDriver.findElement(zipCode).sendKeys(zipCodeValue);
    }

    public void enterCity(String cityValue) {
        webDriver.findElement(city).sendKeys(cityValue);
    }

    public void enterCountry(String countryValue) {
        webDriver.findElement(country).sendKeys(countryValue);
    }

    public void enterOccupation(String occupationValue) {
        webDriver.findElement(occupation).sendKeys(occupationValue);
    }

    public void enterOccupationRole(String occupationRoleValue) {
        WebElement webElement = webDriver.findElement(occupationRole);//.sendKeys(occupationRoleValue);
        Select select = new Select(webElement);
        select.selectByVisibleText(occupationRoleValue);
    }

    public void submitRegister() {
        webDriver.findElement(register).click();
    }
}
