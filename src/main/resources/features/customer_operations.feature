Feature: Perform operations on customer in a bookstore


  @API
  Scenario: Perform POST operation - register a customer
    When I make a POST request to customer
      | name      | surname | age |
      | Krzysztof | Chrzan  | 40  |
    Then I verify that response has status "201"
    When I make a GET request to customer with key "surname" and value "Chrzan"
    #Then I verify that response has status "200"


  Scenario: Perform POST operation - register many customers
    When I make a POST request to customer
      | Name      | Surname | Age |
      | Krzysztof | Chrzan  | 40  |
      | Hanna     | Chrzan  | 11  |
    Then I verify that response has status "200"

