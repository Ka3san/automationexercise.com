Feature: Products Category

  Scenario Outline: Search Products and Verify Cart After Login
    Given Launch browser
    And Navigate to url http://automationexercise.com
    When Click on 'Products' button
    And Verify user is navigated to ALL PRODUCTS page successfully
    And Enter '<product name>' in search input and click search button
    And Verify 'SEARCHED PRODUCTS' is visible
    And Verify all the products related to search are visible
    And Add those products to cart
    Then Click 'Cart' button and verify that products are visible in cart
    And Click Signup | Login button and submit login details: '<email>' and '<password>'
    And Again, go to Cart page
    And Verify that those products are visible in cart after login as well
#    And Quit browser for better performance

    Examples:
      | product name | email            | password |
      | Jeans        | Stefa2@gmail.com | Pass123  |

