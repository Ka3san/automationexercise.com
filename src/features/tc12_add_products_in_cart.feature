Feature: Products Page & Cart Page

  Scenario Outline: Add Products in Cart
    Given Launch browser
    And Navigate to url http://automationexercise.com
    When Verify that home page is visible successfully
    And Click on 'Products' button
    And Hover over first product and click 'Add to cart'
#    And Click 'Continue Shopping' button
#    And Hover over second product and click 'Add to cart'
#    And Click 'View Cart' button
#    And Verify both products are added to Cart
#    And Verify their prices, quantity and total price
#    And Quit browser for better performance

    Examples:
      | product name |
      | Top          |
