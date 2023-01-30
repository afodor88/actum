Feature: Adding items to cart, placing order

  Background:
    Given the user navigates to "https://www.demoblaze.com/"

  Scenario Outline: Add items to cart

    Given the user is adding item called "<item>" to cart
    Then the user checks if the item "<item>" is in the cart
    Examples:
      | item              |
      | Samsung galaxy s6 |
      | Nokia lumia 1520  |

  Scenario Outline: Placing an order
    Given the user is adding item called "<item>" to cart
    Then the user checks if the item "<item>" is in the cart
    Then the user is placing an order with the required fields "<name>", "<country>", "<city>", "<creditCard>", <month> and <year>
    Examples:
      | item              | name      | country | city   | creditCard               | month | year |
      | Samsung galaxy s6 | Vlastimil | Spain   | Madrid | 1111 1111 1111 1111      | 01    | 2023 |
      | Nokia lumia 1520  | Richard   | Italy   | Rome   | 2222 2222 2222 2222 2222 | 02    | 2024 |