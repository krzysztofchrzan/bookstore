Feature: Webpage verification

  @GUI
  Scenario: Checking webpage
    Given I open a login webpage
    Then Page title should be "Bookstore Login Page"
    And I enter username and password
    And I click submit