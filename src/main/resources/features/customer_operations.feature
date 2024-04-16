Feature: Customer registration API in a bookstore

  @API
  Scenario Outline: Perform POST operation - register a customer
    When I make a GET request to customer with key "surname" and value "Chrzan"
    Then I verify that response has empty list
    When I make a POST request to customer service
      | name   | surname   | age   |
      | <name> | <surname> | <age> |
    Then I verify that response has status "201"
    When I make a GET request to customer with key "surname" and value "Chrzan"
    Then I verify that response has status "200"
    And I verify that response has records
      | name   | surname   | age   |
      | <name> | <surname> | <age> |
    Examples:
      | name      | surname | age |
      | Krzysztof | Chrzan  | 42  |

  @API
  Scenario: Perform POST operation - register many customers
    When I make a POST request to customer service
      | name      | surname | age |
      | Krzysztof | Chrzan  | 40  |
      | Hanna     | Chrzan  | 11  |
    Then I verify that response has status "201"

    # TODO: create PUT scenario
