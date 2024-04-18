Feature: Webpage verification

  @GUI
  Scenario: Checking UI customer
    Given I open a login webpage
    Then I check whether page title is correct
    And I enter username and password