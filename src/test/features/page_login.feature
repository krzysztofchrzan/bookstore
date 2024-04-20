Feature: Webpage verification

  @GUI
  Scenario: Checking if user can log in
    Given I open a login webpage
    Then Page title should be "Bookstore Login Page"
    And I enter username and password
    When I click submit
    Then Page title should be "Customer Registration Form"

  Scenario: Customer registration
    Given I open a customer registration webpage
    When In Customer Registration Form I enter "first name"
