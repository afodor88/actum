Feature: Sign up to Demo Blaze

  Background:
    Given the user navigates to "https://www.demoblaze.com/"

  Scenario: Sign up with a username and password to Demo Blaze

    Given the user is signing up with a random username and password
    Then the sign up was successful


  Scenario Outline: Sign up with an existing user, no user or password

    Given the user is signing up with the user "<username>" and password "<password>"
    Then the sign up failed with error "<msg>"
    Examples:
      | username     | password | msg                                    |
      | existingUser | password | This user already exist.               |
      |              |          | Please fill out Username and Password. |