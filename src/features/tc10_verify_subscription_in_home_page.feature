Feature: All Products Page

  Scenario Outline: Verify All Products and product detail page
    Given Launch browser
    And Navigate to url http://automationexercise.com
    When Verify that home page is visible successfully
    And Scroll down to footer
    And Verify text 'SUBSCRIPTION'
    And Enter '<email address>' in input and click arrow button
    And Verify success message 'You have been successfully subscribed!' is visible
#    And Quit browser for better performance

    Examples:
      | email address |
      | e@mail.com    |
