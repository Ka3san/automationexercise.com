Feature: Checkout page address details

  Scenario Outline: Verify address details in checkout page
    Given Launch browser
    And Navigate to url http://automationexercise.com
    When Verify that home page is visible successfully
    And Click on Signup | Login button
    And Fill '<name>', '<email>', '<password>', '<first name>', '<last name>', '<address>', '<country>', '<state>', '<city>', '<zipcode>', '<mobile number>' in Signup and create account
    And Verify 'ACCOUNT CREATED!' and click 'Continue' button
    And Verify ' Logged in as username' at top
    And Add products to cart
    And Click 'Cart' button
    And Verify that cart page is displayed
    And Click Proceed To Checkout
    And Verify that the delivery address is same address filled at the time registration of account
    And Verify that the billing address is same address filled at the time registration of account
    Then Click 'Delete Account' button
    And Verify 'ACCOUNT DELETED!' and click 'Continue' button
#    And Quit browser for better performance

    Examples:
      | name   | email              | password | first name | last name | address           | country   | state   | city   | zipcode | mobile number |
      | Stefan | telefan1@gmail.com | Pass123  | Stefan     | Telefan   | 197 Sesame Street | Singapore | Montana | Berlin | 00-666  | 265340657     |
