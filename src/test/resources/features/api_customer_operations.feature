@API
Feature: Customer registration in a REST API Bookstore service
# TODO: Create a token in beforeAll method

  Scenario Outline: Perform POST operation - register a customer
    When I make a GET request to customer with key "surname" and value "<surname>"
    #TODO: create a datatable for GET
    Then I verify that response has empty list
    When I make a POST request to customer service
      | name   | surname   | age   |
      | <name> | <surname> | <age> |
    Then I verify that response has status "201"
    When I make a GET request to customer with key "surname" and value "<surname>"
    #TODO: create a datatable for GET
    Then I verify that response has status "200"
    And I verify that response has records
      | name   | surname   | age   |
      | <name> | <surname> | <age> |
    Examples:
      | name      | surname | age |
      | Krzysztof | Chrzan  | 42  |

  Scenario: Perform POST operation - register many customers
    When I make a POST request to customer service
      | name   | surname | age |
      | Szymon | Chrzan  | 6   |
      | Hanna  | Chrzan  | 11  |
    Then I verify that response has status "201"

    # TODO: create PUT scenario
    # TODO: create DELETE scenario


  @IGNORE
  Scenario: Database customer record verification
    When I make connection to the database
    Then I verify that in Customer table there is 1 record with conditions
    # TODO: continue a database verification scenario
