Feature: User logout procedure

  Scenario Outline: Successful user logout
    Given Launch browser
    And Navigate to url http://automationexercise.com
    When Verify that home page is visible successfully
    And Click on Signup | Login button
    And Verify 'Login to your account' is visible
    And Enter correct '<email address>' and '<password>'
    And Click 'login' button
    And Verify that 'Logged in as '<name>'' is visible
    Then Click 'Logout' button
    And Verify that user is navigated to login page


    Examples:
      | email address    | password | name   |
      | St7fan@gmail.com | Pass123  | Stefan |