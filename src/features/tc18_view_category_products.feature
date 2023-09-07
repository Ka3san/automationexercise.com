Feature: Products Page & Cart Page

  Scenario Outline: Remove products from cart
    Given Launch browser
    And Navigate to url http://automationexercise.com
    When Verify that categories are visible on left side bar
    And Click on 'Women' category
    And Click on '<category>' link under 'Women' category
    And Verify that category page is displayed and confirm text 'WOMEN - TOPS PRODUCTS'
#    Then On left side bar, click on any sub-category link of 'Men' category
#    And Verify that user is navigated to that category page
#    And Quit browser for better performance

    Examples:
      | category |
      | Saree    |
#    type category: "Dress", "Tops" or "Saree"