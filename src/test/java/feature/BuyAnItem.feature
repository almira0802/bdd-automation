Feature: Buy an item

  @Regression
  Scenario Outline: Buy an item with valid credit card info
    Given The user lauches the application
    When The user searches an item "<items>"
    Then The user closes the browser

    Examples: 
      | items  |
      | wallet |
      | iphone |

  #add different scenarios
  @Smoke
  Scenario: Buy an item with valid credit card information
    Given The user lauches the application
    Then The user closes the browser
