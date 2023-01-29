Feature: Login to Demo Blaze

  Background:
    Given the user navigates to "https://www.demoblaze.com/"

  Scenario: Login with correct credentials

    Given the user is doing a login with the username "existingUser" and password "password"
    Then the user has logged in successfully


  Scenario Outline: Try to login with user that doesn't exist, no user and pass, no user, no pass

    Given the user is doing a login with the username "<username>" and password "<password>"
    Then the login failed with error "<msg>"
    Examples:
      | username      | password | msg                                    |
      | doesn't exist | password | User does not exist.                   |
      |               |          | Please fill out Username and Password. |
      |               | password | Please fill out Username and Password. |
      | existingUser  |          | Please fill out Username and Password. |