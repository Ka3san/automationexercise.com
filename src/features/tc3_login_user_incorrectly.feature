Feature: User login procedure with incorrect email and password

  Scenario Outline: Unsuccessful user login

    Given Launch browser
    And Navigate to url http://automationexercise.com
    When Verify that home page is visible successfully
    And Click on Signup | Login button
    And Verify 'Login to your account' is visible
    And Enter correct '<email address>' and '<password>'
    Then Click 'login' button
    And Verify error 'Your email or password is incorrect!' is visible

    Examples:
      | email address    | password |
      | St7fan@gmail.com | Pass321  |