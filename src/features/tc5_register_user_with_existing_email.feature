Feature: User register with existing email

  Scenario Outline: Register User with existing email
    Given Launch browser
    And Navigate to url http://automationexercise.com
    When Verify that home page is visible successfully
    And Click on Signup | Login button
    And Verify 'New User Signup!' is visible
    And Enter '<name>' and '<email>'
    Then Click 'Signup' button
    And Verify error 'Email Address already exist!' is visible
#    And Quit browser for better performance

    Examples:
      | name   | email            |
      | Stefan | Stefa3@gmail.com |
