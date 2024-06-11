Feature: Checking for records in the database tables

#  @IGNORE
  Scenario: Database customer record verification
    When I make connection to the database
    Then I verify that in Customer table there is 1 record with conditions
      | firstname | Krzysztof |
      | lastname  | Chrzan    |
    # TODO: continue a database verification scenario
