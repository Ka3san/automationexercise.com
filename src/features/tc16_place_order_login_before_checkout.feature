Feature: Products Page & Cart Page

  Scenario Outline: Place order and login before checkout
    Given Launch browser
    And Navigate to url http://automationexercise.com
    When Verify that home page is visible successfully
    And Click on Signup | Login button
    And Fill '<email>', '<password>' and click 'Login' button
    And Verify ' Logged in as '<name>'' at top
    And Add products to cart
    And Click 'Cart' button
    And Verify that cart page is displayed
    And Click Proceed To Checkout
    And Verify '<address details>' and Review Your Order
    And Enter '<description>' in comment text area and click 'Place Order'
    And Enter payment details: '<Name on Card>', '<Card Number>', '<CVC>', '<Expiration date>'
    And Click 'Pay and Confirm Order' button
    Then Verify success message 'Your order has been placed successfully!'
    And Click 'Delete Account' button
    And Verify 'ACCOUNT DELETED!' and click 'Continue' button
#    And Quit browser for better performance

    Examples:
      | description                    | name   | email            | password | address details                                                         | Name on Card   | Card Number | CVC | Expiration date |
      | add a comment about your order | Stefan | Stefa2@gmail.com | Pass123  | 265340657 666 Berlin Montana Singapore 197 Sesame Street Telefan Stefan | Stefan Telefan | 98856799879 | 086 | 11/2029         |
