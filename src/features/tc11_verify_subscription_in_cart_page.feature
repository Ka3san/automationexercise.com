Feature: Subscription verification

  Scenario Outline: Verify Subscription in Cart page
    Given Launch browser
    And Navigate to url http://automationexercise.com
    When Verify that home page is visible successfully
    And Click 'Cart' button
    And Scroll down to footer
    And Verify text 'SUBSCRIPTION'
    And Enter '<email address>' in input and click arrow button
    And Verify success message 'You have been successfully subscribed!' is visible
#    And Quit browser for better performance

    Examples:
      | email address |
      | e@mail.com    |
