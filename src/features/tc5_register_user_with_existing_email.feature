Feature: User register procedure

  Scenario Outline: Successful user registration
    Given Launch browser
    And Navigate to url http://automationexercise.com
    When Verify that home page is visible successfully
    And Click on Signup | Login button
    And Verify 'New User Signup!' is visible
    And Enter '<name>' and '<email>'
    Then Click 'Signup' button
    And Verify error 'Email Address already exist!' is visible

    Examples:
      | name   | email            |
      | Stefan | St7fan@gmail.com |
