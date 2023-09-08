Feature: Products Category

  Scenario Outline: View category products
    Given Launch browser
    And Navigate to url http://automationexercise.com
    When Verify that categories are visible on left side bar
    And Click on 'Women' category
    And Click on '<woman category>' link under 'Women' category
#    And Verify that category page is displayed and confirm text 'WOMEN - '<category>' PRODUCTS'
    And Verify that category page is displayed and confirm text 'WOMEN - TOPS PRODUCTS'
    Then On left side bar, click on '<men category>' sub-category link of 'Men' category
    And Verify that user is navigated to that '<men category>' page
#    And Quit browser for better performance

    Examples:
      | woman category | men category |
      | Saree          | Tshirts      |
#    type women category: "Dress", "Tops" or "Saree" | type men category: "Tshirts" or "Jeans"