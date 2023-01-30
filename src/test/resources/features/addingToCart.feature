Feature: Adding items to cart

  Background:
    Given the user navigates to "https://www.demoblaze.com/"

  Scenario Outline: Add items to cart

    Given the user is adding item called "<item>" to cart
    Then the user checks if the item "<item>" is in the cart
    Examples:
      | item              |
      | Samsung galaxy s6 |
      | Nokia lumia 1520  |


