Feature: Products Page & Cart Page

  Scenario Outline: Remove products from cart
    Given Launch browser
    And Navigate to url http://automationexercise.com
    When Verify that home page is visible successfully
    And Add products to cart
    And Click 'Cart' button
    And Verify that cart page is displayed
    Then Click 'X' button corresponding to particular '<product>'
    And Verify that '<product>' is removed from the cart
#    And Quit browser for better performance

    Examples:
      | product |
      | Tshirt     |
    # type product to delete: "Dress", "Tshirt" or "Top" (for now :))