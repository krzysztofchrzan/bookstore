Feature: Webpage verification

  @GUI
  Scenario: Checking webpage
    Given I open a login webpage
    Then I check whether page title is correct
    And I enter username and password
    And I click submit