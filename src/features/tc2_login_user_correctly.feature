Feature: User login procedure with correct email and password

  Scenario Outline: Successful user login
    Given Launch browser
    And Navigate to url http://automationexercise.com
    When Verify that home page is visible successfully
    And Click on Signup | Login button
    And Verify 'Login to your account' is visible
    And Enter correct '<email address>' and '<password>'
    And Click 'login' button
    And Verify that 'Logged in as '<name>'' is visible
    Then Click 'Delete Account' button
    And Verify that 'ACCOUNT DELETED!' is visible


    Examples:
      | email address    | password | name   |
      | Stefa1@gmail.com | Pass123  | Stefan |