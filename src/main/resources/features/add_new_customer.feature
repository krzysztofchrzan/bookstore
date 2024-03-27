Feature: Add new customer to the bookstore


  @API
  Scenario: Create a new customer
    When I make a POST request to customer
    Then I verify that response has status "201"

  @API
  Scenario: Get information about existing customer
    When I make a GET request to customer
    Then I verify that response has status "200"
    And I verify that response has customer