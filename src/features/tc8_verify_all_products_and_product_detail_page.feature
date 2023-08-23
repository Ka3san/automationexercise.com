Feature: All Products Page

  Scenario: Verify All Products and product detail page
    Given Launch browser
    And Navigate to url http://automationexercise.com
    When Verify that home page is visible successfully
    And Click on 'Products' button
    And Verify user is navigated to ALL PRODUCTS page successfully
    And The products list is visible
    And Click on 'View Product' of first product
    Then User is landed to product detail page
    And Verify that detail detail is visible: product name, category, price, availability, condition, brand
#    And Quit browser for better performance
