Feature: All Products Page

  Scenario Outline: Verify All Products and product detail page
    Given Launch browser
    And Navigate to url http://automationexercise.com
    When Verify that home page is visible successfully
    And Click on 'Products' button
    And Verify user is navigated to ALL PRODUCTS page successfully
    And Enter '<product name>' in search input and click search button
    And Verify 'SEARCHED PRODUCTS' is visible
    And Verify all the products related to search are visible
#    And Quit browser for better performance

    Examples:
      | product name |
      | Top          |
