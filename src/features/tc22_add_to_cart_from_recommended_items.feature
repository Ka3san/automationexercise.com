Feature: Products Category

  Scenario: Add to cart from Recommended items
    Given Launch browser
    And Navigate to url http://automationexercise.com
    When Scroll to bottom of page
    And Verify RECOMMENDED ITEMS are visible
    And Click on Add To Cart on Recommended product
    Then Click on View Cart button
    And Verify that product is displayed in cart page
#    And Quit browser for better performance