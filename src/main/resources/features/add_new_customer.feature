Feature: Add new customer to the bookstore


  @API
  Scenario: Create a new customer
    When I make a POST request to customer
      | Name | Surname  | Age |
      | Jan  | Kovalski | 41  |
    Then I verify that response has status "201"
    When I make a GET request to customer
    Then I verify that response has status "200"
    Then I make a GET request for all customers

