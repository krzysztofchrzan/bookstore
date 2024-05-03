
Feature: Bookstore webpage verification

  @GUI
  Scenario: User log in verification
    Given I open a login webpage
    Then Page title should be "Bookstore Login Page"
    And I enter username and password
    When I click submit
    Then Page title should be "Customer Registration Form"

  @GUI
  Scenario: Customer registration form test
    Given I open a Customer Registration form
    # TODO: common Then Page title should be "Customer Registration Form"
    When On Customer Registration Form I enter first name "Krzysztof"
    And On Customer Registration Form I enter last name "Chrzan"
    And On Customer Registration Form I enter email "krzysiek.chrzan@gmail.com"
    And On Customer Registration Form I enter phone number "567456321"
    And On Customer Registration Form I enter date of birth "23081983"
    And On Customer Registration Form I choose gender "male"
    And On Customer Registration Form I enter address "ul.Obrońców Helu 2/41"
    And On Customer Registration Form I enter state "Mazowieckie"
    And On Customer Registration Form I enter zip code "02-495"
    And On Customer Registration Form I enter city "Warszawa"
    And On Customer Registration Form I enter country "Poland"
    And On Customer Registration Form I enter occupation "Automation Tester"
    And On Customer Registration Form I choose occupation role "Employee"
    And On Customer Registration Form I click register

