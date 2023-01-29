Feature: Sign up to Demo Blaze

  Scenario: Sign up with a username and password to Demo Blaze
    Given the user navigates to "https://www.demoblaze.com/"
    And the user is signing up with the user "<username>" and password "<password>"
    Then the sign up was successful