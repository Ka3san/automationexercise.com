Feature: User register procedure

  Scenario Outline: Successful user registration
    Given Launch browser
    And Navigate to url http://automationexercise.com
    When Verify that home page is visible successfully
    And Click on Signup | Login button
    And Verify 'New User Signup!' is visible
    And Enter '<name>' and '<email>'
    And Click 'Signup' button
    And Verify that 'ENTER ACCOUNT INFORMATION' is visible
    And Fill details: '<title>', '<name>', '<email>', '<password>', '<date of birth>'
    And Select checkbox 'Sign up for our newsletter!'
    And Select checkbox 'Receive special offers from our partners!'
    And Fill details: '<first name>', '<last name>', '<company>', '<address>', '<address2>', '<country>', '<state>', '<city>', '<zipcode>', '<mobile number>'
    And Click 'Create Account button'
    Then Verify that 'ACCOUNT CREATED!' is visible
    And Click 'Continue' button
    And Verify that 'Logged in as username' is visible

    Examples:
      | name   | email            | title | password | date of birth | first name | last name | company     | address           | address2 | country   | state   | city   | zipcode | mobile number |
      | Stefan | St9fan@gmail.com | Mr.   | Pass123  | 2012-12-12    | Stefan     | Telefan   | Voodoo Inc. | 197 Sesame Street | Bronx    | Singapore | Montana | Berlin | 00-666  | 265340657     |
