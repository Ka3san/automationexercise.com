Feature: Products Page & Cart Page

  Scenario Outline: Add Products in Cart
    Given Launch browser
    And Navigate to url http://automationexercise.com
    When Verify that home page is visible successfully
    And Click 'View Product' for any product on home page
    And Verify product detail is opened
    And Increase quantity to '<pcs>'
    And Click 'Add to cart' button
    And Click 'View Cart' button
    And Verify that product is displayed in cart page with exact quantity
#    And Quit browser for better performance

    Examples:
      | pcs |
      | 4   |
